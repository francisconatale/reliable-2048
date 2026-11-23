# Informe OASIs: `Subject.slideLeft`

- Modelo: `openrouter:nvidia/nemotron-3-ultra-550b-a55b:free`
- Precondición: `row != null && Subject.validTiles(row)`
- Aserción original: `result.length == row.length && Arrays.stream(result).sum() == Arrays.stream(old_row).sum() && Subject.compacted(result) && (Subject.nonzero(result) < Subject.nonzero(old_row) || !Subject.hasMergeablePair(old_row))`

La decisión de refinar la aserción es del usuario: este informe solo aporta evidencia.

### Falsos negativos (aserción demasiado débil)

Aserción analizada: `result.length == row.length && Arrays.stream(result).sum() == Arrays.stream(old_row).sum() && Subject.compacted(result) && (Subject.nonzero(result) < Subject.nonzero(old_row) || !Subject.hasMergeablePair(old_row))`

Se generaron 22 mutantes (0 descartados por no compilar) y se ejecutaron 18 entradas.

| Resultado | Cantidad |
|---|---|
| Muertos por la aserción | 10 |
| **Sobreviven y su comportamiento difiere del original** | 9 |
| Lanzan excepción o se cuelgan donde el original no (los detecta cualquier prueba; no es un problema de la aserción) | 2 |
| Sobreviven sin entrada que los distinga (posibles equivalentes) | 1 |

**Mutantes que la aserción no puede matar** (cada uno es un comportamiento incorrecto que la aserción acepta):

| Mutante | Entrada que lo distingue | Original | Mutante |
|---|---|---|---|
| M1: [LLM] Right-to-left merge: compact left, merge adjacent equal pairs scanning from right to left, then compact left again. | `(new int[]{2,2,2,0})` | `[4, 2, 0, 0]` | `[2, 4, 0, 0]` |
| M2: [LLM] First-pair-only merge: compact left, merge only the leftmost adjacent equal pair, then compact left. | `(new int[]{2,2,2,2})` | `[4, 4, 0, 0]` | `[4, 2, 2, 0]` |
| M3: [LLM] Chain merge: repeatedly compact left and merge leftmost adjacent equal pair until no adjacent equal pairs remain. | `(new int[]{2,2,2,2})` | `[4, 4, 0, 0]` | `[8, 0, 0, 0]` |
| M5: [LLM] Sort ascending before merge: extract non-zero tiles, sort ascending, merge left-to-right, then pad with zeros. | `(new int[]{2, 4, 2, 0})` | `[2, 4, 2, 0]` | `[4, 4, 0, 0]` |
| M6: [LLM] Sort descending before merge: extract non-zero tiles, sort descending, merge left-to-right, then pad with zeros. | `(new int[]{2,0,4,0})` | `[2, 4, 0, 0]` | `[4, 2, 0, 0]` |
| M7: [LLM] SlideRight then reverse: implement slideLeft by compacting right, merging right-to-left, compacting right, then reversing the array. | `(new int[]{2,0,4,0})` | `[2, 4, 0, 0]` | `[4, 2, 0, 0]` |
| M8: [LLM] Reverse non-zero tiles before merge: extract non-zero tiles, reverse their order, merge left-to-right, then pad with zeros. | `(new int[]{2,0,4,0})` | `[2, 4, 0, 0]` | `[4, 2, 0, 0]` |
| M9: [LLM] Two-pass merge: compact left, then perform two passes of simultaneous non-overlapping left-to-right merges with compaction between passes. | `(new int[]{2,2,2,2})` | `[4, 4, 0, 0]` | `[8, 0, 0, 0]` |
| M10: [LLM] Sum all equal tiles globally: sum all tiles of each distinct value into a single tile, then place them left-compacted. | `(new int[]{2,2,2,0})` | `[4, 2, 0, 0]` | `[6, 0, 0, 0]` |

**Sugerencia del LLM (orientativa):** `result.length == row.length && Arrays.stream(result).sum() == Arrays.stream(old_row).sum() && Subject.compacted(result) && Subject.validTiles(result) && (Subject.nonzero(result) < Subject.nonzero(old_row) || !Subject.hasMergeablePair(old_row)) && Subject.nonzero(result) >= (Subject.nonzero(old_row) + 1) / 2`

The strengthened assertion adds two conditions: (1) `Subject.validTiles(result)` ensures the output contains only zeros or powers of two, which holds for the original and all mutants but is a necessary safety check. (2) `Subject.nonzero(result) >= (Subject.nonzero(old_row) + 1) / 2` enforces a lower bound on the number of non-zero tiles after the move. Since each merge reduces the non-zero count by one and a tile can merge at most once per move, the maximum number of merges is floor(nz_old/2), so the minimum possible non-zero count is ceil(nz_old/2). This catches the chain-merge and two-pass mutants (e.g., on [2,2,2,2] they produce 1 non-zero tile, below the minimum of 2).

However, the remaining mutants (right-to-left, first-pair-only, sort ascending/descending, slideRight reverse, reverse non-zero) cannot be distinguished using only the four provided helpers because they preserve length, sum, compactedness, validTiles, non-zero count, and the hasMergeablePair boolean on both input and output. To catch them, a new helper is needed that captures the order of non-zero tiles, e.g., `Subject.nonZeroSequence(int[] row)` returning an `int[]` of the non-zero tiles in order, or `Subject.mergedLeftToRight(int[] row)` returning the correct slideLeft result. With such a helper, the assertion could compare the non-zero sequence of the result against the expected left-to-right merge of the input's non-zero sequence.

Comprobación: la aserción sugerida se cumple en el original para todas las entradas probadas.
Mutantes que pasarían a morir: M3, M9, M10; siguen vivos: M1, M2, M5, M6, M7, M8, M21.

