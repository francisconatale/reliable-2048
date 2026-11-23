# Informe OASIs: `Subject.scoreOfLeftMove`

- Modelo: `replay:score_cap.replay.json`
- Precondición: `row != null && Subject.validTiles(row)`
- Aserción original: `result % 4 == 0 && result >= 0`

La decisión de refinar la aserción es del usuario: este informe solo aporta evidencia.

### Falsos positivos (aserción demasiado fuerte)

Aserción analizada: `result % 4 == 0 && result >= 0`

Se probaron 7 entradas válidas en 2 ronda(s) (0 propuestas descartadas por no compilar).

**Resultado:** el LLM no logró producir ninguna entrada válida que viole la aserción. Esto no demuestra que sea correcta, solo que no se encontró evidencia de que sea demasiado fuerte.

