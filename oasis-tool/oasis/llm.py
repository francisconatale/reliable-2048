"""Clientes de LLM.

- OpenAICompatLLM: cualquier API compatible con /chat/completions (OpenRouter, NVIDIA build, ...).
- ReplayLLM: devuelve respuestas guionadas desde un JSON (para pruebas sin red; NO es un LLM).
- CachedLLM: guarda en disco cada respuesta real para poder reproducir una corrida y dejarla como evidencia.
"""
import hashlib
import json
import os
import time
import urllib.error
import urllib.request

PROVIDERS = {
    # nombre: (base_url, variable de entorno con la API key, modelo por defecto)
    # Los modelos gratuitos cambian con el tiempo: se puede pasar --model o la variable OASIS_MODEL.
    "openrouter": ("https://openrouter.ai/api/v1", "OPENROUTER_API_KEY", "meta-llama/llama-3.3-70b-instruct:free"),
    "nvidia": ("https://integrate.api.nvidia.com/v1", "NVIDIA_API_KEY", "meta/llama-3.3-70b-instruct"),
}


class LLMError(Exception):
    pass


class OpenAICompatLLM:
    def __init__(self, provider="openrouter", model=None, api_key=None, base_url=None,
                 temperature=0.4, timeout=180, max_retries=4):
        if provider not in PROVIDERS:
            raise LLMError(f"proveedor desconocido: {provider} (opciones: {', '.join(PROVIDERS)})")
        url, env, default_model = PROVIDERS[provider]
        self.base_url = (base_url or url).rstrip("/")
        self.api_key = api_key or os.environ.get(env)
        if not self.api_key:
            raise LLMError(f"falta la API key: definí la variable de entorno {env}")
        self.model = model or os.environ.get("OASIS_MODEL") or default_model
        self.temperature = temperature
        self.timeout = timeout
        self.max_retries = max_retries
        self.name = f"{provider}:{self.model}"

    def chat(self, task, system, user):
        body = json.dumps({
            "model": self.model,
            "temperature": self.temperature,
            "messages": [{"role": "system", "content": system}, {"role": "user", "content": user}],
        }).encode()
        req = urllib.request.Request(
            self.base_url + "/chat/completions", data=body, method="POST",
            headers={"Authorization": f"Bearer {self.api_key}", "Content-Type": "application/json"})
        last = None
        for attempt in range(self.max_retries):
            try:
                with urllib.request.urlopen(req, timeout=self.timeout) as r:
                    data = json.loads(r.read().decode())
                return data["choices"][0]["message"]["content"] or ""
            except urllib.error.HTTPError as e:
                last = f"HTTP {e.code}: {e.read().decode(errors='replace')[:300]}"
                e.close()
                if e.code not in (408, 429, 500, 502, 503, 504):
                    break
            except (urllib.error.URLError, TimeoutError, KeyError, json.JSONDecodeError) as e:
                last = repr(e)
            time.sleep(2 ** attempt * 2)
        raise LLMError(f"falló la consulta al LLM ({self.name}): {last}")


class ReplayLLM:
    """Respuestas guionadas por tarea: {"fp_tests": [resp1, resp2], "fn_mutants": [resp], ...}.

    Cada llamada de una tarea consume la siguiente respuesta; al agotarse repite la última.
    Sirve para probar el flujo completo sin red. No es un modelo: las respuestas las escribe una persona.
    """

    def __init__(self, path):
        with open(path, encoding="utf-8") as f:
            self.script = json.load(f)
        self.pos = {}
        self.name = f"replay:{os.path.basename(path)}"

    def chat(self, task, system, user):
        items = self.script.get(task)
        if not items:
            raise LLMError(f"el guion no tiene respuestas para la tarea '{task}'")
        i = self.pos.get(task, 0)
        self.pos[task] = i + 1
        item = items[min(i, len(items) - 1)]
        return item if isinstance(item, str) else json.dumps(item, ensure_ascii=False)


class CachedLLM:
    def __init__(self, inner, cache_dir):
        self.inner = inner
        self.cache_dir = cache_dir
        self.name = inner.name
        os.makedirs(cache_dir, exist_ok=True)

    def chat(self, task, system, user):
        key = hashlib.sha256(json.dumps([self.name, task, system, user]).encode()).hexdigest()[:24]
        path = os.path.join(self.cache_dir, f"{task}-{key}.json")
        if os.path.exists(path):
            with open(path, encoding="utf-8") as f:
                return json.load(f)["response"]
        resp = self.inner.chat(task, system, user)
        with open(path, "w", encoding="utf-8") as f:
            json.dump({"model": self.name, "task": task, "system": system, "user": user, "response": resp},
                      f, ensure_ascii=False, indent=1)
        return resp


def extract_json(text):
    """Extrae el primer valor JSON de una respuesta (con o sin bloque ```)."""
    text = text.strip()
    try:
        return json.loads(text)
    except json.JSONDecodeError:
        pass
    dec = json.JSONDecoder()
    for i, ch in enumerate(text):
        if ch in "{[":
            try:
                return dec.raw_decode(text[i:])[0]
            except json.JSONDecodeError:
                continue
    raise ValueError("la respuesta no contiene JSON válido")


def ask_json(llm, task, system, user, retries=1):
    """Consulta al LLM y devuelve el JSON; si la respuesta no es JSON, reintenta pidiéndolo explícitamente."""
    prompt = user
    for attempt in range(retries + 1):
        raw = llm.chat(task, system, prompt)
        try:
            return extract_json(raw)
        except ValueError:
            prompt = user + "\n\nYour previous answer was not valid JSON. Reply ONLY with the JSON object, no prose."
    raise LLMError(f"la tarea '{task}' no devolvió JSON válido tras {retries + 1} intentos")
