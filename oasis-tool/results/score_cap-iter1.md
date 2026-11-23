# Informe OASIs: `Subject.scoreOfLeftMove`

- Modelo: `replay:score_cap.replay.json`
- Precondición: `row != null && Subject.validTiles(row)`
- Aserción original: `result <= 2048`

La decisión de refinar la aserción es del usuario: este informe solo aporta evidencia.

### Falsos positivos (aserción demasiado fuerte)

Aserción analizada: `result <= 2048`

Se probaron 7 entradas válidas en 2 ronda(s) (0 propuestas descartadas por no compilar).

**Resultado:** 3 entrada(s) válidas violan la aserción al ejecutar el programa real. Si el comportamiento del programa en esas entradas es correcto, la aserción es demasiado fuerte y conviene debilitarla; si es incorrecto, el defecto está en el programa.

| Entrada | Resultado del programa | Estado tras la llamada |
|---|---|---|
| `(new int[]{2048, 2048})` | `4096` | `[2048, 2048]` |
| `(new int[]{4096, 4096, 2048, 2048})` | `12288` | `[4096, 4096, 2048, 2048]` |
| `(new int[]{65536, 65536})` | `131072` | `[65536, 65536]` |

**Valoración del LLM (orientativa):** `assertion_too_strong`. The program adds 2*v for each merge, so merging two 2048 tiles scores 4096; the score is a sum of created tile values and is not bounded by the winning value 2048. The behavior is correct for the 2048 rules.

Aserción sugerida `result % 4 == 0 && result >= 0`: se cumple en las 7 entradas probadas (incluidas las que violaban la original).

