# Informe OASIs: `Subject.slideLeft`

- Modelo: `replay:slide_left.replay.json`
- Precondición: `row != null && Subject.validTiles(row)`
- Aserción original: `result.length == row.length`

La decisión de refinar la aserción es del usuario: este informe solo aporta evidencia.

### Falsos negativos (aserción demasiado débil)

Aserción analizada: `result.length == row.length`

Se generaron 18 mutantes (0 descartados por no compilar) y se ejecutaron 14 entradas.

| Resultado | Cantidad |
|---|---|
| Muertos por la aserción | 0 |
| **Sobreviven y su comportamiento difiere del original** | 14 |
| Lanzan excepción o se cuelgan donde el original no (los detecta cualquier prueba; no es un problema de la aserción) | 2 |
| Sobreviven sin entrada que los distinga (posibles equivalentes) | 2 |

**Mutantes que la aserción no puede matar** (cada uno es un comportamiento incorrecto que la aserción acepta):

| Mutante | Entrada que lo distingue | Original | Mutante |
|---|---|---|---|
| M1: [LLM] only compacts tiles to the left, never merges | `(new int[]{2, 2, 0, 0})` | `[4, 0, 0, 0]` | `[2, 2, 0, 0]` |
| M2: [LLM] after a merge prev is not reset, so a tile can merge again | `(new int[]{2, 2, 2, 2})` | `[4, 4, 0, 0]` | `[4, 0, 0, 0]` |
| M3: [LLM] merges equal neighbors in place without compacting zeros | `(new int[]{0, 2, 0, 2})` | `[4, 0, 0, 0]` | `[0, 2, 0, 2]` |
| M4: [LLM] a merge keeps the tile value instead of doubling it | `(new int[]{2, 2, 0, 0})` | `[4, 0, 0, 0]` | `[2, 0, 0, 0]` |
| M5: [LLM] returns the input array unchanged | `(new int[]{2, 2, 0, 0})` | `[4, 0, 0, 0]` | `[2, 2, 0, 0]` |
| M7: [operador] constante 0 -> 1 (línea 8 del método) | `(new int[]{2, 2, 0, 0})` | `[4, 0, 0, 0]` | `[0, 0, 0, 0]` |
| M8: [operador] constante 2 -> 3 (línea 12 del método) | `(new int[]{2, 2, 0, 0})` | `[4, 0, 0, 0]` | `[6, 0, 0, 0]` |
| M10: [operador] == -> != (línea 8 del método) | `(new int[]{2, 2, 2, 2})` | `[4, 4, 0, 0]` | `[0, 0, 0, 0]` |
| M11: [operador] constante 0 -> 1 (línea 6 del método) | `(new int[]{2, 2, 0, 0})` | `[4, 0, 0, 0]` | `[2, 0, 0, 0]` |
| M13: [operador] - -> + (línea 12 del método) | `(new int[]{2, 2, 0, 0})` | `[4, 0, 0, 0]` | `[2, 0, 4, 0]` |
| M14: [operador] constante 1 -> 0 (línea 12 del método) | `(new int[]{2, 2, 0, 0})` | `[4, 0, 0, 0]` | `[2, 4, 0, 0]` |
| M15: [operador] constante 2 -> 1 (línea 12 del método) | `(new int[]{2, 2, 0, 0})` | `[4, 0, 0, 0]` | `[2, 0, 0, 0]` |
| M16: [operador] constante 0 -> 1 (línea 4 del método) | `(new int[]{2, 2, 0, 0})` | `[4, 0, 0, 0]` | `[0, 4, 0, 0]` |
| M18: [operador] * -> / (línea 12 del método) | `(new int[]{2, 2, 0, 0})` | `[4, 0, 0, 0]` | `[1, 0, 0, 0]` |

**Sugerencia del LLM (orientativa):** `result.length == row.length && Arrays.stream(result).sum() == Arrays.stream(old_row).sum() && Subject.compacted(result)`

Merging never creates or destroys value, so the sum of the tiles is preserved; and after sliding left there is no zero before a non-zero tile.

Comprobación: la aserción sugerida se cumple en el original para todas las entradas probadas.
Mutantes que pasarían a morir: M2, M3, M4, M5, M7, M8, M10, M11, M13, M14, M15, M16, M18; siguen vivos: M1, M6, M17.

