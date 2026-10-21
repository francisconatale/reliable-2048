# Tareas pendientes

## 1. Correcciones de código en `Board`

- [ ] **Copia defensiva en `getGrid()`**
  - Especificación: no retornar la referencia interna de `grid`. Construir y devolver una copia `Cell[size][size]` para evitar modificaciones externas del estado interno.

- [ ] **Validación de no negatividad en `setScore(int value)`**
  - Especificación: lanzar `IllegalArgumentException` si `value < 0` antes de delegar en `score.setScore(value)`.

- [ ] **Validación explícita de límites en `getCell` y `setCell`**
  - Especificación: verificar `row < 0 || row >= size || col < 0 || col >= size` y lanzar `IndexOutOfBoundsException` descriptiva en ambos métodos antes de indexar la matriz. En `setCell`, mantener la guarda de `cell == null` (`IllegalArgumentException`).

- [ ] **Evitar aliasing de `Random` en `Board(Board other)`**
  - Especificación: asegurar que la copia no comparta la instancia física del generador de números aleatorios si se requiere independencia estocástica entre tableros.

## 2. Casos de prueba para eliminar invariantes espurias en Daikon

- [ ] **Llenado de tablero en modo determinista (`isFull`)**
  - Causa: Daikon infirió `(return == true) ==> (determinist == false)` porque solo se llenaron tableros con generación aleatoria.
  - Especificación: agregar un test donde un tablero determinista (`new Board(size, true)`) se llene completamente de fichas y verificar `board.isFull() == true`.

- [ ] **Derrota en tableros de tamaño no estándar (`isLosingBoard`)**
  - Causa: Daikon infirió `(return == true) <=> (DEFAULT_SIZE == size)` porque las derrotas se probaron solo en 4x4.
  - Especificación: agregar un test con un tablero de dimensión distinta (por ejemplo, 2x2) bloqueado y sin movimientos posibles, verificando `board.isLosingBoard() == true`.

- [ ] **Victoria y llenado en tamaños distintos a 4x4 (`isWinningBoard` y `isFull`)**
  - Causa: Daikon asumió que ganar o llenar la grilla implica `DEFAULT_SIZE == size`.
  - Especificación: agregar un test que alcance una celda 2048 en un tablero 3x3 o 5x5 (`isWinningBoard() == true`), y que llene completamente tableros de esas dimensiones.

- [ ] **Puntajes acumulados mayores a `DEFAULT_SIZE` (`getScore`)**
  - Causa: Daikon acotó `return <= DEFAULT_SIZE && return in {0, 4}` por falta de partidas con fusiones continuas.
  - Especificación: agregar un test que ejecute fusiones de fichas de mayor orden (por ejemplo, $4+4 \rightarrow 8$, $8+8 \rightarrow 16$) para registrar en las trazas puntajes acumulados superiores a 4.
