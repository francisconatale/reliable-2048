# Informe OASIs: `Subject.scoreOfLeftMove`

- Modelo: `openrouter:nvidia/nemotron-3-ultra-550b-a55b:free`
- Precondición: `row != null && Subject.validTiles(row)`
- Aserción original: `result >= 0 && result % 4 == 0 && result <= Arrays.stream(row).sum()`

La decisión de refinar la aserción es del usuario: este informe solo aporta evidencia.

### Falsos positivos (aserción demasiado fuerte)

Aserción analizada: `result >= 0 && result % 4 == 0 && result <= Arrays.stream(row).sum()`

Se probaron 11 entradas válidas en 2 ronda(s) (0 propuestas descartadas por no compilar).

**Resultado:** el LLM no logró producir ninguna entrada válida que viole la aserción. Esto no demuestra que sea correcta, solo que no se encontró evidencia de que sea demasiado fuerte.

