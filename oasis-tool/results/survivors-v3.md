# Informe OASIs: `Subject.slideLeft`

- Modelo: `replay:slide_left_survivors.replay.json`
- Precondición: `row != null && Subject.validTiles(row)`
- Aserción original: `Arrays.equals(result, Subject.expectedSlideLeft(old_row))`

La decisión de refinar la aserción es del usuario: este informe solo aporta evidencia.

### Falsos negativos (aserción demasiado débil)

Aserción analizada: `Arrays.equals(result, Subject.expectedSlideLeft(old_row))`

Se generaron 18 mutantes (0 descartados por no compilar) y se ejecutaron 12 entradas.

| Resultado | Cantidad |
|---|---|
| Muertos por la aserción | 15 |
| **Sobreviven y su comportamiento difiere del original** | 0 |
| Lanzan excepción o se cuelgan donde el original no (los detecta cualquier prueba; no es un problema de la aserción) | 2 |
| Sobreviven sin entrada que los distinga (posibles equivalentes) | 1 |

**Resultado:** ningún mutante no equivalente sobrevivió con las entradas generadas: no hay evidencia de que la aserción sea demasiado débil frente a estos mutantes.

