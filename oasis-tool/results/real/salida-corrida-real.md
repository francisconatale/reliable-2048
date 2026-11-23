<!-- Salida de la corrida real (modelo nvidia/nemotron-3-ultra-550b-a55b:free vía OpenRouter), tal como la pegó el usuario, sin los comandos iniciales (que incluían la API key).
     Los informes aparecen en este orden: score_cap iter1 (prueba corta, --rounds 1), score_cap iter1 (run_case_studies), score_cap iter2, slide_left iter1, slide_left iter2.
     ATENCIÓN: las líneas 'Comprobación' de los dos informes de slide_left se generaron con una versión de la herramienta que descartaba en silencio todas las pruebas cuando la aserción sugerida no compilaba; no son válidas. Ver informe-oasis.md. -->

# Informe OASIs: `Subject.scoreOfLeftMove`

- Modelo: `openrouter:nvidia/nemotron-3-ultra-550b-a55b:free`
- Precondición: `row != null && Subject.validTiles(row)`
- Aserción original: `result <= 2048`

La decisión de refinar la aserción es del usuario: este informe solo aporta evidencia.

### Falsos positivos (aserción demasiado fuerte)

Aserción analizada: `result <= 2048`

Se probaron 10 entradas válidas en 1 ronda(s) (0 propuestas descartadas por no compilar).

**Resultado:** 9 entrada(s) válidas violan la aserción al ejecutar el programa real. Si el comportamiento del programa en esas entradas es correcto, la aserción es demasiado fuerte y conviene debilitarla; si es incorrecto, el defecto está en el programa.

| Entrada | Resultado del programa | Estado tras la llamada |
|---|---|---|
| `(new int[]{2048, 2048, 0, 0})` | `4096` | `[2048, 2048, 0, 0]` |
| `(new int[]{2048, 2048, 2048, 2048})` | `8192` | `[2048, 2048, 2048, 2048]` |
| `(new int[]{1024, 1024, 1024, 1024})` | `4096` | `[1024, 1024, 1024, 1024]` |
| `(new int[]{2048, 2048, 2048, 0})` | `4096` | `[2048, 2048, 2048, 0]` |
| `(new int[]{4096, 4096, 0, 0})` | `8192` | `[4096, 4096, 0, 0]` |
| `(new int[]{2048, 0, 2048, 0})` | `4096` | `[2048, 0, 2048, 0]` |
| `(new int[]{2048, 2048, 1024, 1024})` | `6144` | `[2048, 2048, 1024, 1024]` |
| `(new int[]{2048, 2048, 2048, 2048, 0, 0})` | `8192` | `[2048, 2048, 2048, 2048, 0, 0]` |
| `(new int[]{2048, 2048, 2048, 2048, 2048, 2048})` | `12288` | `[2048, 2048, 2048, 2048, 2048, 2048]` |

**Valoración del LLM (orientativa):** `assertion_too_strong`. The method correctly implements the 2048 left‑move scoring: it merges adjacent equal non‑zero tiles and adds the merged tile’s value (2 × v) to the score. The precondition only requires that the row contains powers of two (or zero), with no upper bound on tile values. Therefore, merging two 2048 tiles yields a score of 4096, merging four 2048 tiles yields 8192, etc. All provided failing inputs are valid and the computed results match the expected game rules. The assertion `result <= 2048` incorrectly assumes a maximum tile value of 2048 and is therefore too strong.

Aserción sugerida `result <= Arrays.stream(row).sum()`: se cumple en las 10 entradas probadas (incluidas las que violaban la original).

# Informe OASIs: `Subject.scoreOfLeftMove`

- Modelo: `openrouter:nvidia/nemotron-3-ultra-550b-a55b:free`
- Precondición: `row != null && Subject.validTiles(row)`
- Aserción original: `result <= 2048`

La decisión de refinar la aserción es del usuario: este informe solo aporta evidencia.

### Falsos positivos (aserción demasiado fuerte)

Aserción analizada: `result <= 2048`

Se probaron 10 entradas válidas en 1 ronda(s) (0 propuestas descartadas por no compilar).

**Resultado:** 9 entrada(s) válidas violan la aserción al ejecutar el programa real. Si el comportamiento del programa en esas entradas es correcto, la aserción es demasiado fuerte y conviene debilitarla; si es incorrecto, el defecto está en el programa.

| Entrada | Resultado del programa | Estado tras la llamada |
|---|---|---|
| `(new int[]{2048, 2048, 0, 0})` | `4096` | `[2048, 2048, 0, 0]` |
| `(new int[]{2048, 2048, 2048, 2048})` | `8192` | `[2048, 2048, 2048, 2048]` |
| `(new int[]{1024, 1024, 1024, 1024})` | `4096` | `[1024, 1024, 1024, 1024]` |
| `(new int[]{2048, 2048, 2048, 0})` | `4096` | `[2048, 2048, 2048, 0]` |
| `(new int[]{4096, 4096, 0, 0})` | `8192` | `[4096, 4096, 0, 0]` |
| `(new int[]{2048, 0, 2048, 0})` | `4096` | `[2048, 0, 2048, 0]` |
| `(new int[]{2048, 2048, 1024, 1024})` | `6144` | `[2048, 2048, 1024, 1024]` |
| `(new int[]{2048, 2048, 2048, 2048, 0, 0})` | `8192` | `[2048, 2048, 2048, 2048, 0, 0]` |
| `(new int[]{2048, 2048, 2048, 2048, 2048, 2048})` | `12288` | `[2048, 2048, 2048, 2048, 2048, 2048]` |

**Valoración del LLM (orientativa):** `assertion_too_strong`. The method correctly implements the 2048 left‑move scoring: it merges adjacent equal non‑zero tiles and adds the merged tile’s value (2 × v) to the score. The precondition only requires that the row contains powers of two (or zero), with no upper bound on tile values. Therefore, merging two 2048 tiles yields a score of 4096, merging four 2048 tiles yields 8192, etc. All provided failing inputs are valid and the computed results match the expected game rules. The assertion `result <= 2048` incorrectly assumes a maximum tile value of 2048 and is therefore too strong.

Aserción sugerida `result <= Arrays.stream(row).sum()`: se cumple en las 10 entradas probadas (incluidas las que violaban la original).

# Informe OASIs: `Subject.scoreOfLeftMove`

- Modelo: `openrouter:nvidia/nemotron-3-ultra-550b-a55b:free`
- Precondición: `row != null && Subject.validTiles(row)`
- Aserción original: `result % 4 == 0 && result >= 0`

La decisión de refinar la aserción es del usuario: este informe solo aporta evidencia.

### Falsos positivos (aserción demasiado fuerte)

Aserción analizada: `result % 4 == 0 && result >= 0`

Se probaron 10 entradas válidas en 2 ronda(s) (0 propuestas descartadas por no compilar).

**Resultado:** el LLM no logró producir ninguna entrada válida que viole la aserción. Esto no demuestra que sea correcta, solo que no se encontró evidencia de que sea demasiado fuerte.

# Informe OASIs: `Subject.slideLeft`

- Modelo: `openrouter:nvidia/nemotron-3-ultra-550b-a55b:free`
- Precondición: `row != null && Subject.validTiles(row)`
- Aserción original: `result.length == row.length`

La decisión de refinar la aserción es del usuario: este informe solo aporta evidencia.

### Falsos negativos (aserción demasiado débil)

Aserción analizada: `result.length == row.length`

Se generaron 21 mutantes (0 descartados por no compilar) y se ejecutaron 14 entradas.

| Resultado | Cantidad |
|---|---|
| Muertos por la aserción | 0 |
| **Sobreviven y su comportamiento difiere del original** | 18 |
| Lanzan excepción o se cuelgan donde el original no (los detecta cualquier prueba; no es un problema de la aserción) | 2 |
| Sobreviven sin entrada que los distinga (posibles equivalentes) | 1 |

**Mutantes que la aserción no puede matar** (cada uno es un comportamiento incorrecto que la aserción acepta):

| Mutante | Entrada que lo distingue | Original | Mutante |
|---|---|---|---|
| M1: [LLM] Forget to reset prev after a merge, causing a tile to merge again with the next equal tile (double merge). | `(new int[]{2,2,2,2})` | `[4, 4, 0, 0]` | `[4, 0, 0, 0]` |
| M2: [LLM] Increment pos before writing in the else branch, leaving the first slot zero. | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[4, 2, 0, 0]` |
| M3: [LLM] Write merged value to the wrong position (pos instead of pos-1), shifting merged tile right. | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[2, 4, 0, 0]` |
| M4: [LLM] Remove zero-skipping, causing zeros to be treated as tiles and potentially merge with each other. | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[0, 0, 0, 0]` |
| M5: [LLM] Set prev to 0 in the else branch, preventing a tile from merging with the next equal tile. | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[2, 2, 0, 0]` |
| M6: [LLM] Increment pos in the merge branch, leaving a gap (zero) between merged tile and next tile. | `(new int[]{2,2,4,4})` | `[4, 8, 0, 0]` | `[4, 0, 8, 0]` |
| M7: [LLM] Initialize pos to 1, causing the first tile to be placed at index 1 and leaving index 0 as zero. | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[0, 4, 0, 0]` |
| M8: [LLM] Write the merged value as v instead of 2*v, effectively not merging. | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[2, 0, 0, 0]` |
| M9: [LLM] Treat merge as a new tile by writing to out[pos] and incrementing pos, shifting merged tile right. | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[2, 4, 0, 0]` |
| M10: [operador] constante 0 -> 1 (línea 8 del método) | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[0, 0, 0, 0]` |
| M11: [operador] constante 2 -> 3 (línea 12 del método) | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[6, 0, 0, 0]` |
| M13: [operador] == -> != (línea 8 del método) | `(new int[]{2})` | `[2]` | `[0]` |
| M14: [operador] constante 0 -> 1 (línea 6 del método) | `(new int[]{2})` | `[2]` | `[0]` |
| M16: [operador] - -> + (línea 12 del método) | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[2, 0, 4, 0]` |
| M17: [operador] constante 1 -> 0 (línea 12 del método) | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[2, 4, 0, 0]` |
| M18: [operador] constante 2 -> 1 (línea 12 del método) | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[2, 0, 0, 0]` |
| M19: [operador] constante 0 -> 1 (línea 4 del método) | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[0, 4, 0, 0]` |
| M21: [operador] * -> / (línea 12 del método) | `(new int[]{2,2,0,0})` | `[4, 0, 0, 0]` | `[1, 0, 0, 0]` |

**Sugerencia del LLM (orientativa):** `Arrays.equals(result, ((java.util.function.Function<int[], int[]>) row -> { java.util.List<Integer> nonZero = java.util.Arrays.stream(row).filter(x -> x != 0).boxed().collect(java.util.stream.Collectors.toList()); java.util.List<Integer> merged = new java.util.ArrayList<>(); for (int i = 0; i < nonZero.size(); ) { if (i + 1 < nonZero.size() && nonZero.get(i).equals(nonZero.get(i+1))) { merged.add(2 * nonZero.get(i)); i += 2; } else { merged.add(nonZero.get(i)); i += 1; } } int[] expected = new int[row.length]; for (int i = 0; i < merged.size(); i++) expected[i] = merged.get(i); return expected; }).apply(old_row))`

The assertion replaces the weak length check with a full functional equivalence check against a reference implementation of the 2048 left-slide algorithm. It computes the expected result by: (1) filtering out zeros from the input (old_row), (2) performing a single left-to-right pass merging adjacent equal tiles once (pairwise merge), and (3) padding the merged list with zeros to the original length. This captures all required properties: correct length, preservation of tile sum, compaction of non-zero tiles to the left, correct merging of adjacent equal tiles (once per tile), and zeros only at the end. All listed mutants violate at least one of these properties, causing the equality to fail.

Comprobación: la aserción sugerida se cumple en el original para todas las entradas probadas.
Mutantes que pasarían a morir: ninguno; siguen vivos: M1, M2, M3, M4, M5, M6, M7, M8, M9, M10, M11, M13, M14, M16, M17, M18, M19, M20, M21.

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
| M1: [LLM] GlobalMergeMutant: merges all tiles of the same value into a single tile (value * count), writes tiles in ascending order of value. Preserves sum, reduces non-zero count, result compacted. | `(new int[]{2, 2, 2, 0})` | `[4, 2, 0, 0]` | `[6, 0, 0, 0]` |
| M2: [LLM] FirstPairOnlyMutant: performs standard slide left but merges only the first adjacent equal pair encountered; subsequent pairs are not merged. | `(new int[]{2, 2, 4, 4})` | `[4, 8, 0, 0]` | `[4, 4, 4, 0]` |
| M3: [LLM] SortAscendingMergeMutant: collects non-zero tiles, sorts them ascending, then merges adjacent equal tiles once. | `(new int[]{2, 4, 2, 0})` | `[2, 4, 2, 0]` | `[4, 4, 0, 0]` |
| M4: [LLM] SortDescendingMergeMutant: collects non-zero tiles, sorts them descending, then merges adjacent equal tiles once. | `(new int[]{2, 4, 0, 0})` | `[2, 4, 0, 0]` | `[4, 2, 0, 0]` |
| M5: [LLM] RepeatedMergeMutant: repeatedly merges adjacent equal tiles in the compacted list until no merges remain (allows multiple merges per tile in one move). | `(new int[]{2, 2, 2, 2})` | `[4, 4, 0, 0]` | `[8, 0, 0, 0]` |
| M6: [LLM] RightToLeftMergeMutant: compacts non-zero tiles, then merges adjacent equal tiles from right to left, finally reverses to left-compacted order. | `(new int[]{2, 2, 2, 0})` | `[4, 2, 0, 0]` | `[2, 4, 0, 0]` |
| M7: [LLM] MergeByValueMutant: merges all tiles of the same value into one tile (value * count), preserving order of first appearance. | `(new int[]{2, 2, 2, 0})` | `[4, 2, 0, 0]` | `[6, 0, 0, 0]` |
| M9: [LLM] DoubleMergeMutant: forgets to reset prev to 0 after a merge, setting prev to the merged value instead, allowing a tile to potentially merge again. | `(new int[]{2, 2, 4, 4})` | `[4, 8, 0, 0]` | `[8, 4, 0, 0]` |
| M10: [LLM] MergeCompatibleMutant: merges adjacent tiles if they are equal or one is double the other (summing them), which preserves sum but may produce non-powers-of-two. | `(new int[]{2, 4, 0, 0})` | `[2, 4, 0, 0]` | `[6, 0, 0, 0]` |

**Sugerencia del LLM (orientativa):** `result.length == row.length && Arrays.stream(result).sum() == Arrays.stream(old_row).sum() && Subject.compacted(result) && Arrays.equals(Subject.correctMergedNonZero(old_row), Arrays.stream(result).filter(x -> x != 0).toArray())`

The new condition `Arrays.equals(Subject.correctMergedNonZero(old_row), Arrays.stream(result).filter(x -> x != 0).toArray())` compares the non-zero tiles of the result against a reference implementation of the 2048 left-merge algorithm. The helper method `Subject.correctMergedNonZero(int[])` (to be added to Subject) extracts non-zero tiles from the input, then performs a single left-to-right pass merging adjacent equal tiles exactly once per tile (setting a 'canMerge' flag to false after a merge). This captures the exact merge semantics: order of non-zero tiles is preserved except for merges, each tile merges at most once, and merges only happen between immediate neighbors in the compacted input. All surviving mutants violate this precise sequence: they either merge non-adjacent tiles, merge repeatedly, merge in wrong order, or sort tiles before merging.

Comprobación: la aserción sugerida se cumple en el original para todas las entradas probadas.
Mutantes que pasarían a morir: ninguno; siguen vivos: M1, M2, M3, M4, M5, M6, M7, M9, M10, M21.
