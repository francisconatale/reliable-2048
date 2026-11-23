# OASIs simplificado: refinamiento de oráculos con LLM

Herramienta en Python 3 (sin dependencias externas; necesita `javac`/`java` 11 o superior) que, dado un método Java
estático y una aserción, consulta a un LLM y **entrega feedback para que el usuario decida si refinar la aserción**.

- **Falso positivo (aserción demasiado fuerte):** el LLM propone entradas válidas que la violen; se ejecutan sobre el programa
  real y se informan las que de verdad la violan.
- **Falso negativo (aserción demasiado débil):** mutantes del LLM más mutantes por operadores; se informan los que la aserción
  no mata, con la entrada que los distingue y una aserción más fuerte sugerida y comprobada.

## Uso

```bash
export OPENROUTER_API_KEY=...            # o NVIDIA_API_KEY con --provider nvidia
export OASIS_MODEL=<id de un modelo gratuito vigente>
python3 -m oasis fp   --spec cases/score_cap/spec.json            # buscar entradas que violan la aserción
python3 -m oasis fn   --spec cases/slide_left/spec.json           # buscar mutantes que sobreviven
python3 -m oasis both --spec cases/slide_left/spec.json --assertion 'result.length == row.length' --out informe.md
```

Opciones útiles: `--model` (o `OASIS_MODEL`), `--provider openrouter|nvidia`, `--rounds`, `--tests`, `--mutants`,
`--no-operators`, `--assertion` (probar un refinamiento sin tocar el spec), `--json` (detalle completo).
Cada respuesta del LLM se guarda en `.oasis_cache/` (la clave de caché incluye el prompt: si cambia el prompt o la aserción,
se vuelve a consultar). Los modelos gratuitos cambian: si el modelo por defecto no existe, pasá `--model` con uno vigente.

## Casos incluidos (`cases/`)

- `score_cap`: falso positivo (`scoreOfLeftMove`, aserción `result <= 2048`).
- `slide_left`: falso negativo (`slideLeft`, aserción `result.length == row.length`).
- `slide_left_ref`: igual que `slide_left` más el auxiliar `expectedSlideLeft`, para la iteración 3 (aserción con implementación de referencia).

## spec.json

```json
{ "source": "Subject.java", "method": "slideLeft",
  "pre": "row != null && Subject.validTiles(row)",
  "assertion": "result.length == row.length",
  "description": "texto libre que se le pasa al LLM" }
```

- `method`: método **estático** de la clase de `source` (un solo archivo `.java`).
- La aserción y la precondición son expresiones Java booleanas. En la aserción se pueden usar los parámetros
  (valores **después** de la llamada), `result` y `old_<param>` (copia profunda tomada **antes** de la llamada).
- Se pueden llamar métodos estáticos auxiliares de la misma clase (`Subject.compacted(result)`); la herramienta se los
  informa al LLM para que no invente otros.
- No declares lambdas ni variables con el nombre de un parámetro (`row`, `result`, `old_row`): no compilan en el arnés.

## Cómo funciona

1. **Arnés** (`javarun.py`): genera `OasisRunner.java`, que para cada entrada evalúa la precondición, llama al método,
   evalúa la aserción y devuelve `PASS`, `FAIL`, `SKIP` (precondición falsa), `EXC` (excepción), `ASSERT_ERR` o `TIMEOUT`.
   Antes de ejecutar comprueba, con una entrada ficticia, que la **precondición y la aserción compilan**; si no, informa el
   error en vez de descartar pruebas. Las entradas propuestas por el LLM que no compilan se descartan y se cuentan.
2. **Falsos positivos** (`fp.py`): hasta `--rounds` rondas; en cada una el LLM ve las entradas que ya no violaron la aserción
   y propone otras distintas. Si hay violaciones, el LLM las explica y sugiere una aserción más débil, que se comprueba
   contra todas las entradas probadas.
3. **Falsos negativos** (`fn.py`): mutantes del LLM (método completo reemplazado) + mutantes por operadores (`mutate.py`).
   Cada mutante se clasifica en: *muerto* (la aserción falla), *sobreviviente* (la aserción se cumple pero el resultado
   difiere del original), *cuelga/excepción* (lo detecta cualquier prueba), *equivalente hasta ahora* y *no compila*.
   Para los equivalentes se pide al LLM entradas que los distingan. Luego el LLM sugiere una aserción más fuerte; se comprueba
   que compile, que el original la cumpla y qué mutantes pasarían a morir.
4. **Informe** (`report.py`): Markdown en español.

## Pruebas

```bash
python3 -m unittest discover -s tests -v      # 16 pruebas; no necesitan red ni API key (~40 s)
```

Las pruebas usan `ReplayLLM` (`--replay`): respuestas **escritas a mano** en `fixtures/` para validar el flujo sin red.
No son salida de un modelo. Los resultados con un LLM real se generan con `./run_case_studies.sh`; la corrida real ya hecha
está en `results/real/` (ver `informe-oasis.md`). `scripts/verify_exhaustive.py` reverifica esos resultados con 539 entradas exhaustivas.

## Limitaciones

Solo métodos estáticos de un archivo; los resultados dependen del modelo; "equivalente hasta ahora" no prueba equivalencia;
una aserción basada en una implementación de referencia es tan fiable como esa referencia.