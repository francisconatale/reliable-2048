# Informe OASIs: `Subject.slideLeft`

- Modelo: `replay:slide_left.replay.json`
- Precondición: `row != null && Subject.validTiles(row)`
- Aserción original: `result.length == row.length && Arrays.stream(result).sum() == Arrays.stream(old_row).sum() && Subject.compacted(result) && (Subject.nonzero(result) < Subject.nonzero(old_row) || !Subject.hasMergeablePair(old_row))`

La decisión de refinar la aserción es del usuario: este informe solo aporta evidencia.

### Falsos negativos (aserción demasiado débil)

Aserción analizada: `result.length == row.length && Arrays.stream(result).sum() == Arrays.stream(old_row).sum() && Subject.compacted(result) && (Subject.nonzero(result) < Subject.nonzero(old_row) || !Subject.hasMergeablePair(old_row))`

Se generaron 18 mutantes (0 descartados por no compilar) y se ejecutaron 14 entradas.

| Resultado | Cantidad |
|---|---|
| Muertos por la aserción | 14 |
| **Sobreviven y su comportamiento difiere del original** | 0 |
| Lanzan excepción o se cuelgan donde el original no (los detecta cualquier prueba; no es un problema de la aserción) | 2 |
| Sobreviven sin entrada que los distinga (posibles equivalentes) | 2 |

**Resultado:** ningún mutante no equivalente sobrevivió con las entradas generadas: no hay evidencia de que la aserción sea demasiado débil frente a estos mutantes.

