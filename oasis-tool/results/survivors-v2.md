# Informe OASIs: `Subject.slideLeft`

- Modelo: `replay:slide_left_survivors.replay.json`
- Precondición: `row != null && Subject.validTiles(row)`
- Aserción original: `result.length == row.length && Arrays.stream(result).sum() == Arrays.stream(old_row).sum() && Subject.compacted(result) && (Subject.nonzero(result) < Subject.nonzero(old_row) || !Subject.hasMergeablePair(old_row))`

La decisión de refinar la aserción es del usuario: este informe solo aporta evidencia.

### Falsos negativos (aserción demasiado débil)

Aserción analizada: `result.length == row.length && Arrays.stream(result).sum() == Arrays.stream(old_row).sum() && Subject.compacted(result) && (Subject.nonzero(result) < Subject.nonzero(old_row) || !Subject.hasMergeablePair(old_row))`

Se generaron 18 mutantes (0 descartados por no compilar) y se ejecutaron 12 entradas.

| Resultado | Cantidad |
|---|---|
| Muertos por la aserción | 9 |
| **Sobreviven y su comportamiento difiere del original** | 6 |
| Lanzan excepción o se cuelgan donde el original no (los detecta cualquier prueba; no es un problema de la aserción) | 2 |
| Sobreviven sin entrada que los distinga (posibles equivalentes) | 1 |

**Mutantes que la aserción no puede matar** (cada uno es un comportamiento incorrecto que la aserción acepta):

| Mutante | Entrada que lo distingue | Original | Mutante |
|---|---|---|---|
| M1: [LLM] FirstPairOnly: merges only the first adjacent equal pair | `(new int[]{2, 2, 4, 4})` | `[4, 8, 0, 0]` | `[4, 4, 4, 0]` |
| M2: [LLM] SortAscendingMerge: sorts the non-zero tiles ascending, then merges adjacent equals once | `(new int[]{2, 4, 2, 0})` | `[2, 4, 2, 0]` | `[4, 4, 0, 0]` |
| M3: [LLM] SortDescendingMerge: sorts the non-zero tiles descending, then merges adjacent equals once | `(new int[]{2, 2, 4, 4})` | `[4, 8, 0, 0]` | `[8, 4, 0, 0]` |
| M4: [LLM] MergeByValue: merges all tiles of the same value into one tile (value * count) | `(new int[]{2, 2, 2, 0})` | `[4, 2, 0, 0]` | `[6, 0, 0, 0]` |
| M5: [LLM] RepeatedMerge: keeps merging adjacent equal tiles until none remain | `(new int[]{2, 2, 4, 4})` | `[4, 8, 0, 0]` | `[8, 4, 0, 0]` |
| M6: [LLM] MergeCompatible: merges adjacent tiles if equal or one is double the other (sum) | `(new int[]{2, 4, 2, 0})` | `[2, 4, 2, 0]` | `[6, 2, 0, 0]` |

**Sugerencia del LLM (orientativa):** `true`

(sin uso)

Comprobación: la aserción sugerida se cumple en el original para todas las entradas probadas.
Mutantes que pasarían a morir: ninguno; siguen vivos: M1, M2, M3, M4, M5, M6, M17.

