# Informe: herramienta OASIs simplificada

## 1. Herramienta

Implementación en Python sin dependencias (`oasis-tool/`). Dado un método Java estático, una precondición y una aserción (expresión
Javasobre los parámetros, `result` y `old_<param>`), consulta a un LLM por API (OpenRouter o NVIDIA) y genera un informe de feedback.

- **Falso positivo (aserción demasiado fuerte):** el LLM propone entradas válidas que la violen; se compilan y se ejecutan
  sobre el programa real, y solo se informan las que realmente la violan. El LLM valora si la aserción es fuerte o hay un
  defecto y sugiere una más débil, que se comprueba.
- **Falso negativo (aserción demasiado débil):** mutantes del LLM más mutantes por operadores, ejecutados con entradas del
  LLM. Se informan los que la aserción no mata, con la entrada que los distingue. El LLM sugiere una aserción más fuerte y la
  herramienta comprueba que compile, que el original la cumpla y qué mutantes mataría.
- **Cómo funciona:** un arnés Java generado (`javac`/`java`) evalúa por cada entrada la precondición, el método y la aserción.
  Cada mutante se clasifica en muerto, sobreviviente (la aserción se cumple pero el resultado difiere del original), con
  excepción, posiblemente equivalente o no compila. Para los posibles equivalentes se piden al LLM entradas que los distingan.
- **Uso:** `python3 -m oasis fp|fn|both --spec <spec.json> [--assertion ...]`, con la clave en `OPENROUTER_API_KEY` (o
  `NVIDIA_API_KEY`) y el modelo en `OASIS_MODEL`. Cada respuesta del LLM queda guardada en `.oasis_cache/`. Los casos y la
  corrida real se reproducen con `./run_case_studies.sh`.

## 2. Prueba

Modelo real: `nvidia/nemotron-3-ultra-550b-a55b:free` (OpenRouter), una corrida por configuración. La primera corrida reveló
un defecto de la herramienta, ya corregido: si la aserción sugerida no compilaba, se descartaban todas las pruebas en silencio
y la comprobación decía "ninguno muere". Los resultados de abajo son de la segunda corrida con la herramienta corregida y se
reverificaron aparte con 539 entradas exhaustivas (`scripts/verify_exhaustive.py`). Los resultados varían entre corridas
porque el modelo no es determinista.

## 3. Caso 1, falso positivo: `scoreOfLeftMove`

Puntaje de una fila de 2048 (suma de las fichas creadas por fusiones), modelando el invariante espurio de Daikon
`getScore: WINNING_VALUE >= return`. Precondición: celdas 0 o potencias de dos entre 2 y 131072. Aserción: `result <= 2048`.

- Las 5 entradas propuestas la violan; por ejemplo `{2048, 2048, 0, 0}` da 4096 y `{2048, 2048, 2048, 2048}` da 8192.
- Valoración del modelo: aserción demasiado fuerte, porque la precondición no acota las fichas.
- **Decisión:** reemplazarla por `result >= 0 && result % 4 == 0 && result <= Arrays.stream(row).sum()` (la cota de suma la
  sugirió el modelo). El modelo probó 11 entradas en 2 rondas y no encontró violaciones.

## 4. Caso 2, falso negativo: `slideLeft`

Desliza y fusiona una fila de 2048 a la izquierda y devuelve una fila nueva; misma precondición. Aserción débil:
`result.length == row.length`. Cada iteración usa 22 mutantes (10 del LLM y 12 por operadores).

| Iteración | Aserción | Muertos | Sobreviven | Equivalentes / excepción |
|---|---|---|---|---|
| 1 | Débil | 0 | 19 | 1 / 2 |
| 2 | Suma preservada + compactada + "si hay par fusionable, menos fichas" (refinada a mano) | 10 | 9 | 1 / 2 |
| 3 | `Arrays.equals(result, Subject.expectedSlideLeft(old_row))` | 16 | 1 | 1 / 4 |
| Final (solo reverificación, ver abajo) | Iteración 3 `&& Arrays.equals(row, old_row) && result != row` | | 0 | |

- **Iteración 2:** mi aserción, que creía suficiente, dejó pasar 9 mutantes del modelo que cambian el orden o qué fichas se
  fusionan (ordenar antes de fusionar, solo el primer par, fusión en cadena, etc.). El modelo indicó que con los auxiliares
  disponibles no se podían distinguir y propuso comparar con una implementación de referencia.
- **Iteración 3:** la referencia mata todos los mutantes de orden. Sobrevive uno distinto: modifica la fila de entrada y la
  devuelve (resultado correcto, entrada alterada). El modelo sugirió las condiciones de marco `Arrays.equals(row, old_row) &&
  result != row`.
- **Reverificación exhaustiva** (42 mutantes, 539 entradas; el original cumple todas las aserciones):

| Aserción | Muertos | Sobreviven |
|---|---|---|
| Débil | 1 | 38 |
| Sugerida por el modelo, iteración 1 | 30 | 9 |
| Refinada a mano, iteración 2 | 27 | 12 |
| Referencia (iteración 3) | 38 | 1 |
| Referencia + marco (final) | 39 | 0 |

## 5. Conclusiones

- La herramienta aporta evidencia ejecutable (entrada o mutante concretos) y el usuario decide; el ciclo funcionó en ambos casos.
- Con un modelo real los mutantes fueron más variados que los escritos a mano y mostraron que una aserción considerada fuerte
  no lo era.
- Las propiedades parciales se agotan: capturar el orden exige una referencia, y luego aparece el hueco de los efectos sobre
  los parámetros.
- "Mata todos los mutantes generados" es una cota, no una prueba de fortaleza: la aserción de la iteración 1 mata todos los
  generados en su corrida y deja pasar 9 de las otras.
- Límites: solo métodos estáticos; los resultados dependen del modelo y de las entradas generadas; una aserción basada en una
  referencia es tan fiable como esa referencia.