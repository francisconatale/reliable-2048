"""Informe en Markdown con el feedback para el usuario."""


def _args(a):
    return "`(" + ", ".join(a) + ")`"


def _compile_msg(c):
    first = (c.get("error") or "").split("\n")
    detail = next((ln for ln in first[1:] if "error:" in ln), first[0] if first else "")
    return (f"Aserción sugerida `{c['assertion']}`: **no compila**, por lo que no se pudo evaluar "
            f"(`{detail.strip()[:200]}`).")


def fp_section(spec, log):
    L = ["### Falsos positivos (aserción demasiado fuerte)", "",
         f"Aserción analizada: `{log['assertion']}`", ""]
    n = len(log["violations"])
    tried = sum(r["valid"] for r in log["rounds"])
    L.append(f"Se probaron {tried} entradas válidas en {len(log['rounds'])} ronda(s) "
             f"({len(log['rejected_tests'])} propuestas descartadas por no compilar).")
    L.append("")
    if not n:
        L += ["**Resultado:** el LLM no logró producir ninguna entrada válida que viole la aserción. "
              "Esto no demuestra que sea correcta, solo que no se encontró evidencia de que sea demasiado fuerte.", ""]
    else:
        L += [f"**Resultado:** {n} entrada(s) válidas violan la aserción al ejecutar el programa real. "
              "Si el comportamiento del programa en esas entradas es correcto, la aserción es demasiado fuerte "
              "y conviene debilitarla; si es incorrecto, el defecto está en el programa.", "",
              "| Entrada | Resultado del programa | Estado tras la llamada |", "|---|---|---|"]
        for v in log["violations"]:
            L.append(f"| {_args(v['args'])} | `{v['result']}` | `{v['post']}` |")
        L.append("")
        e = log.get("explanation")
        if e:
            L += [f"**Valoración del LLM (orientativa):** `{e.get('verdict', '?')}`. {e.get('explanation', '')}", ""]
            c = log.get("suggestion_check")
            if c:
                if not c["compiles"]:
                    L.append(_compile_msg(c))
                elif c["violated_on"]:
                    L.append(f"Aserción sugerida `{c['assertion']}`: **sigue violándose** en {len(c['violated_on'])} "
                             f"de {c['checked']} entradas probadas, por ejemplo {_args(c['violated_on'][0]['args'])}.")
                else:
                    L.append(f"Aserción sugerida `{c['assertion']}`: se cumple en las {c['checked']} entradas probadas "
                             "(incluidas las que violaban la original).")
                L.append("")
    if log["crashes"]:
        L += ["**Entradas que provocaron excepción o cuelgue en el original** (posibles defectos, ajenos a la aserción):", ""]
        for v in log["crashes"][:5]:
            L.append(f"- {_args(v['args'])}: {v['status']} {v['detail']}")
        L.append("")
    return "\n".join(L)


def fn_section(spec, log):
    ms = log["mutants"]
    cnt = {k: sum(1 for m in ms if m["cls"] == k) for k in ("killed", "survived", "crashed", "equivalent_so_far", "invalid")}
    L = ["### Falsos negativos (aserción demasiado débil)", "",
         f"Aserción analizada: `{log['assertion']}`", "",
         f"Se generaron {len(ms)} mutantes ({cnt['invalid']} descartados por no compilar) y se ejecutaron {log['tests']} entradas.", "",
         "| Resultado | Cantidad |", "|---|---|",
         f"| Muertos por la aserción | {cnt['killed']} |",
         f"| **Sobreviven y su comportamiento difiere del original** | {cnt['survived']} |",
         f"| Lanzan excepción o se cuelgan donde el original no (los detecta cualquier prueba; no es un problema de la aserción) | {cnt['crashed']} |",
         f"| Sobreviven sin entrada que los distinga (posibles equivalentes) | {cnt['equivalent_so_far']} |", ""]
    surv = [m for m in ms if m["cls"] == "survived"]
    if surv:
        L += ["**Mutantes que la aserción no puede matar** (cada uno es un comportamiento incorrecto que la aserción acepta):", "",
              "| Mutante | Entrada que lo distingue | Original | Mutante |", "|---|---|---|---|"]
        for m in surv:
            w = m["witness"]
            L.append(f"| {m['id']}: {m['description']} | {_args(w['args'])} | `{w['orig_result']}` | `{w['mut_result']}` |")
        L.append("")
        s = log.get("suggestion")
        if s:
            L += [f"**Sugerencia del LLM (orientativa):** `{s.get('assertion', '')}`", "", s.get("explanation", ""), ""]
            c = log.get("suggestion_check")
            if c:
                if not c["compiles"]:
                    L.append("Comprobación: " + _compile_msg(c).replace(f"Aserción sugerida `{c['assertion']}`: ", "la aserción sugerida "))
                else:
                    if c["violated_by_original_on"]:
                        L.append(f"Comprobación: **la aserción sugerida falla en el programa original** en "
                                 f"{len(c['violated_by_original_on'])} entrada(s), por ejemplo "
                                 f"{_args(c['violated_by_original_on'][0]['args'])} → `{c['violated_by_original_on'][0]['result']}`. "
                                 "Sería demasiado fuerte.")
                    else:
                        L.append("Comprobación: la aserción sugerida se cumple en el original para todas las entradas probadas.")
                    L.append(f"Mutantes que pasarían a morir: {', '.join(c['now_killed']) or 'ninguno'}; "
                             f"siguen vivos: {', '.join(c['still_surviving']) or 'ninguno'}.")
                L.append("")
    else:
        L += ["**Resultado:** ningún mutante no equivalente sobrevivió con las entradas generadas: "
              "no hay evidencia de que la aserción sea demasiado débil frente a estos mutantes.", ""]
    return "\n".join(L)


def full_report(spec, model, fp=None, fn=None):
    L = [f"# Informe OASIs: `{spec.class_name}.{spec.method}`", "",
         f"- Modelo: `{model}`", f"- Precondición: `{spec.pre}`", f"- Aserción original: `{spec.assertion}`", "",
         "La decisión de refinar la aserción es del usuario: este informe solo aporta evidencia.", ""]
    if fp:
        L += [fp_section(spec, fp)]
    if fn:
        L += [fn_section(spec, fn)]
    return "\n".join(L)
