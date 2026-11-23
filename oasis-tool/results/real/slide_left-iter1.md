# Informe OASIs: `Subject.slideLeft`

- Modelo: `openrouter:nvidia/nemotron-3-ultra-550b-a55b:free`
- Precondición: `row != null && Subject.validTiles(row)`
- Aserción original: `result.length == row.length`

La decisión de refinar la aserción es del usuario: este informe solo aporta evidencia.

### Falsos negativos (aserción demasiado débil)

Aserción analizada: `result.length == row.length`

Se generaron 22 mutantes (0 descartados por no compilar) y se ejecutaron 15 entradas.

| Resultado | Cantidad |
|---|---|
| Muertos por la aserción | 0 |
| **Sobreviven y su comportamiento difiere del original** | 19 |
| Lanzan excepción o se cuelgan donde el original no (los detecta cualquier prueba; no es un problema de la aserción) | 2 |
| Sobreviven sin entrada que los distinga (posibles equivalentes) | 1 |

**Mutantes que la aserción no puede matar** (cada uno es un comportamiento incorrecto que la aserción acepta):

| Mutante | Entrada que lo distingue | Original | Mutante |
|---|---|---|---|
| M1: [LLM] After merging, prev is set to the merged value instead of 0, allowing a tile to merge multiple times. | `(new int[]{2,2,2,0})` | `[4, 2, 0, 0]` | `[4, 0, 0, 0]` |
| M2: [LLM] Merged tile is placed at the next position (pos) instead of the previous (pos-1), effectively not merging in place. | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[2, 4, 0, 0]` |
| M3: [LLM] In the non-merge branch, pos is not incremented, causing subsequent tiles to overwrite the same position. | `(new int[]{2,4,8,16})` | `[2, 4, 8, 16]` | `[16, 0, 0, 0]` |
| M4: [LLM] In the non-merge branch, prev is set to 0 instead of the tile value, preventing a merge with the next equal tile. | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[2, 2, 0, 0]` |
| M5: [LLM] Merge does not double the value; it just keeps the same value. | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[2, 0, 0, 0]` |
| M6: [LLM] The loop iterates from right to left, implementing slideRight instead of slideLeft. | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[0, 0, 0, 4]` |
| M7: [LLM] The loop starts at index 1, skipping the first tile. | `(new int[]{2})` | `[2]` | `[0]` |
| M8: [LLM] The output array is initialized as a clone of the input instead of a zero-filled array, leaving stray values. | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[4, 2, 0, 0]` |
| M9: [LLM] After the loop, the result array is reversed, turning a left slide into a right slide. | `(new int[]{2,4,8,16})` | `[2, 4, 8, 16]` | `[16, 8, 4, 2]` |
| M10: [LLM] The method returns the input array instead of the computed output array. | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[2, 2, 0, 0]` |
| M11: [operador] constante 0 -> 1 (línea 8 del método) | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[0, 0, 0, 0]` |
| M12: [operador] constante 2 -> 3 (línea 12 del método) | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[6, 0, 0, 0]` |
| M14: [operador] == -> != (línea 8 del método) | `(new int[]{2})` | `[2]` | `[0]` |
| M15: [operador] constante 0 -> 1 (línea 6 del método) | `(new int[]{2})` | `[2]` | `[0]` |
| M17: [operador] - -> + (línea 12 del método) | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[2, 0, 4, 0]` |
| M18: [operador] constante 1 -> 0 (línea 12 del método) | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[2, 4, 0, 0]` |
| M19: [operador] constante 2 -> 1 (línea 12 del método) | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[2, 0, 0, 0]` |
| M20: [operador] constante 0 -> 1 (línea 4 del método) | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[0, 4, 0, 0]` |
| M22: [operador] * -> / (línea 12 del método) | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[1, 0, 0, 0]` |

**Sugerencia del LLM (orientativa):** `result.length == old_row.length && Subject.validTiles(result) && Subject.compacted(result) && Arrays.stream(result).sum() == Arrays.stream(old_row).sum() && (Subject.hasMergeablePair(Arrays.stream(old_row).filter(x -> x != 0).toArray()) ? Subject.nonzero(result) < Subject.nonzero(old_row) : Subject.nonzero(result) == Subject.nonzero(old_row))`

The assertion combines five conditions:
1. `result.length == old_row.length` ensures the output array has the same length as the input.
2. `Subject.validTiles(result)` guarantees every tile in the result is 0 or a power of two.
3. `Subject.compacted(result)` forces all non-zero tiles to be left-aligned with zeros on the right.
4. `Arrays.stream(result).sum() == Arrays.stream(old_row).sum()` enforces that the total sum of tiles is preserved (merging two equal tiles v+v into 2v does not change the sum).
5. The ternary condition uses `Subject.hasMergeablePair` on the compacted non-zero sequence of the input (obtained by filtering out zeros). If that compacted sequence contains an adjacent equal pair, at least one merge must occur, so the number of non-zero tiles in the result must be strictly less than in the input (`Subject.nonzero(result) < Subject.nonzero(old_row)`). Otherwise, no merges happen and the non-zero count must stay the same (`Subject.nonzero(result) == Subject.nonzero(old_row)`).

Together these conditions capture the core invariants of a correct 2048 left slide: length, tile validity, compaction, sum preservation, and the exact effect of merging on the non-zero tile count. All eight mutants violate at least one of these conditions on their distinguishing inputs, while the original implementation satisfies them for every valid input.

Comprobación: la aserción sugerida se cumple en el original para todas las entradas probadas.
Mutantes que pasarían a morir: M1, M2, M3, M4, M5, M6, M7, M8, M9, M10, M11, M12, M14, M15, M17, M18, M19, M20, M22; siguen vivos: M21.

