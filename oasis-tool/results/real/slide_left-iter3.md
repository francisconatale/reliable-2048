# Informe OASIs: `Subject.slideLeft`

- Modelo: `openrouter:nvidia/nemotron-3-ultra-550b-a55b:free`
- Precondición: `row != null && Subject.validTiles(row)`
- Aserción original: `Arrays.equals(result, Subject.expectedSlideLeft(old_row))`

La decisión de refinar la aserción es del usuario: este informe solo aporta evidencia.

### Falsos negativos (aserción demasiado débil)

Aserción analizada: `Arrays.equals(result, Subject.expectedSlideLeft(old_row))`

Se generaron 22 mutantes (0 descartados por no compilar) y se ejecutaron 14 entradas.

| Resultado | Cantidad |
|---|---|
| Muertos por la aserción | 16 |
| **Sobreviven y su comportamiento difiere del original** | 1 |
| Lanzan excepción o se cuelgan donde el original no (los detecta cualquier prueba; no es un problema de la aserción) | 4 |
| Sobreviven sin entrada que los distinga (posibles equivalentes) | 1 |

**Mutantes que la aserción no puede matar** (cada uno es un comportamiento incorrecto que la aserción acepta):

| Mutante | Entrada que lo distingue | Original | Mutante |
|---|---|---|---|
| M3: [LLM] Mutates the input array instead of creating a new array, violating the specification. | `(new int[]{2,2})` | `[4, 0]` | `[4, 0]` |

**Sugerencia del LLM (orientativa):** `Arrays.equals(result, Subject.expectedSlideLeft(old_row)) && Arrays.equals(row, old_row) && result != row`

The original assertion only verifies that the returned array has the correct content. The surviving mutant mutates the input array in place and returns it, which produces the same result content but violates the specification that the input must remain unchanged and a new array must be returned. The added condition `Arrays.equals(row, old_row)` ensures the input array is not mutated by comparing it to the pre-call deep copy `old_row`. The condition `result != row` ensures the returned array is a distinct object from the input (reference inequality). Both conditions hold for the original implementation (which creates a fresh array and leaves the input untouched) but fail for the mutant.

Comprobación: la aserción sugerida se cumple en el original para todas las entradas probadas.
Mutantes que pasarían a morir: M3; siguen vivos: M21.

