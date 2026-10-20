# Reporte Assignment 4: Inferencia Dinámica de Invariantes y Generación de Oráculos con Daikon - Clase Board

### 1. Ejecución de Chicory (Instrumentación y Trace Collection)
A fin de recolectar un conjunto de trazas rico, diverso y representativo del comportamiento real del tablero de juego, la ejecución de Chicory se llevó a cabo sobre una suite combinada y exhaustiva que integró pruebas unitarias manuales, pruebas generadas aleatoriamente por Randoop y pruebas de cobertura dirigidas por algoritmos genéticos con EvoSuite:

1. **Pruebas manuales:** `ar.edu.unrc.game2048.manual.BoardTest`
2. **Pruebas de Randoop:** `ar.edu.unrc.game2048.randoop.board.RegressionTest`
3. **Pruebas de EvoSuite:** `ar.edu.unrc.game2048.evosuite.Board_ESTest`

Se utilizó el script `run-daikon.sh`, restringiendo la captura de puntos de programa (`--ppt-select-pattern`) a la clase principal de dominio `ar.edu.unrc.game2048.Board`, omitiendo clases auxiliares como `Position` y aislando la inferencia de clases colaboradoras (estrategias `Move*`, `MoveProvider` y utilidades de seeding como `Seeder`), enfocándose exclusivamente en la semántica del tablero:

```bash
./run-daikon.sh \
    ar.edu.unrc.game2048.manual.BoardTest \
    ar.edu.unrc.game2048.randoop.board.RegressionTest \
    ar.edu.unrc.game2048.evosuite.Board_ESTest
```

A partir del archivo comprimido de trazas generado (`daikon-traces/JUnitCore.dtrace.gz`), se ejecutó el motor de inferencia de Daikon:

```bash
java -cp lib/daikon.jar daikon.Daikon daikon-traces/JUnitCore.dtrace.gz > daikon-invariants/board_invariants.txt
```

---

### 2. Invariantes Inferidos en Métodos de `Board`

A continuación se seleccionan y analizan los invariantes más representativos detectados a lo largo del ciclo de vida y operaciones de `Board`, clasificándolos según la taxonomía estándar: **Correct and useful**, **Correct but trivial**, y **Too strong / likely spurious**.

---

#### Invariante 1: Coherencia de dimensiones y estructura de la matriz interna
- **Punto de programa:** `ar.edu.unrc.game2048.Board:::OBJECT`
- **Invariante inferido:**
  ```text
  this.size == size(this.grid[])
  this.size >= 1
  this.grid != null
  this.grid[] elements != null
  this.grid.getClass().getName() == ar.edu.unrc.game2048.Cell[][].class
  ```
- **Clasificación:** **Correct and useful**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Constituye el invariante de representación estructural primario del tablero. Establece que la dimensión lógica escalar `size` se corresponde biunívocamente con la longitud del arreglo bidimensional `grid`, que la dimensión es estrictamente positiva ($N \ge 1$) y que ninguna fila del arreglo bidimensional contiene referencias nulas.
  - *Utilidad como oráculo:* Permite detectar de inmediato problemas de corrupción de estado interno, redimensionamiento indebido o matrices cuadradas rotas que provocarían excepciones en tiempo de ejecución del tipo `NullPointerException` o `ArrayIndexOutOfBoundsException`.
  - *Relación con `repOK()`:* Coincide plenamente con las primeras cláusulas de validación estructural en `Board.repOK()`: `size <= 0 || grid == null || grid.length != size` y el chequeo en bucle `grid[row] == null || grid[row].length != size`.

---

#### Invariante 2: Integridad de componentes esenciales y detección de campo inerte
- **Punto de programa:** `ar.edu.unrc.game2048.Board:::OBJECT`
- **Invariante inferido:**
  ```text
  this.moveProvider != null
  this.score != null
  this.random != null
  this.emptyCells == null
  ```
- **Clasificación:** **Correct and useful**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Confirma que los colaboradores internos que gobiernan la puntuación (`score`), la estocasticidad (`random`) y la ejecución de movimientos (`moveProvider`) están debidamente inicializados a lo largo de toda la vida del objeto. Además, reveló un hallazgo arquitectónico imprevisto: el campo `emptyCells` permanece siempre nulo (`this.emptyCells == null`).
  - *Utilidad como oráculo:* Además de prevenir fallos de puntero nulo al delegar acciones del juego, expone un residuo de diseño (código muerto o atributo de instancia en desuso que nunca es instanciado, ya que `getEmptyPositions()` crea su propia colección local en cada invocación).
  - *Relación con `repOK()`:* Valida las aserciones de no-nulidad de colaboradores definidas en `repOK()` y sugiere limpiar o redefinir el rol de `emptyCells`.

---

#### Invariante 3: Precondiciones y postcondiciones contractuales de acceso en `getCell(int, int)`
- **Punto de programa:** `ar.edu.unrc.game2048.Board.getCell(int, int):::ENTER` y `:::EXIT`
- **Invariantes inferidos:**
  ```text
  // En ENTER:
  row >= 0
  col >= 0
  row <= size(this.grid[]) - 1
  col <= size(this.grid[]) - 1

  // En EXIT:
  return != null
  return.value >= 0
  return.value >= ar.edu.unrc.game2048.Cell.EMPTY.value
  this.grid == orig(this.grid)
  this.size == orig(this.size)
  ```
- **Clasificación:** **Correct and useful**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Daikon descubrió formalmente el contrato estricto de coordenadas válidas en la grilla: los parámetros `row` y `col` deben encontrarse en el rango cerrado $[0, \text{size}-1]$. Como postcondición, asegura que la celda obtenida jamás es nula, posee un valor mayor o igual a 0 y que la consulta es pura (no muta ni la referencia a la grilla ni las dimensiones).
  - *Utilidad como oráculo:* Funciona como un oráculo de precondición ideal: cualquier componente externo (GUI, CLI, algoritmo de IA) que intente consultar celdas fuera del rango será interceptado antes de interactuar con la matriz subyacente.
  - *Relación con el código:* Refleja las restricciones implícitas que asume el método `grid[row][col]`, el cual de otro modo lanzaría un `ArrayIndexOutOfBoundsException` no encapsulado.

---

#### Invariante 4: Contrato de mutación segura en `setCell(int, int, Cell)`
- **Punto de programa:** `ar.edu.unrc.game2048.Board.setCell(int, int, ar.edu.unrc.game2048.Cell):::ENTER` y `:::EXIT`
- **Invariantes inferidos:**
  ```text
  // En ENTER:
  cell != null
  cell.value >= 0
  row >= 0
  col >= 0
  row <= size(this.grid[]) - 1
  col <= size(this.grid[]) - 1

  // En EXIT:
  cell.value == orig(cell.value)
  this.grid == orig(this.grid)
  this.size == orig(this.size)
  ```
- **Clasificación:** **Correct and useful**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Establece el contrato mutador de celda: el objeto `Cell` inyectado debe ser no nulo y tener un valor válido no negativo, ubicándose en límites válidos. Como postcondición, la celda insertada no es modificada durante la inserción y la identidad de la estructura `grid` se preserva (mutación *in-place* sin reemplazo de matriz).
  - *Utilidad como oráculo:* Valida que los métodos de inicialización o configuración de partidas no corrompan el estado del tablero introduciendo celdas nulas o valores ilegales.
  - *Relación con el código:* Corrobora la guarda explícita `if (cell == null) throw new IllegalArgumentException("Cell cannot be null");` y la indexación directa sobre la grilla.

---

#### Invariante 5: Precondición de validez en actualización de puntaje `setScore(int)`
- **Punto de programa:** `ar.edu.unrc.game2048.Board.setScore(int):::ENTER`
- **Invariante inferido:**
  ```text
  value >= 0
  ```
- **Clasificación:** **Correct and useful**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* En el juego 2048, el puntaje acumulado es monótonamente creciente y no negativo ($S \ge 0$). Daikon identificó que en ninguna ejecución válida se establecen puntajes negativos.
  - *Utilidad como oráculo:* Precondición de integridad contable que evita asignar estados inconsistentes al marcador del juego ante desbordamientos o llamadas erróneas.
  - *Relación con el código:* Modela el invariante intrínseco de `Score.repOK()`.

---

#### Invariante 6: Contrato del operador de ejecución de movimiento `move(Direction)`
- **Punto de programa:** `ar.edu.unrc.game2048.Board.move(ar.edu.unrc.game2048.Board$Direction):::ENTER` y `:::EXIT`
- **Invariantes inferidos:**
  ```text
  // En ENTER:
  direction != null
  direction in ar.edu.unrc.game2048.Board$Direction.ENUM$VALUES[]

  // En EXIT:
  this.grid == orig(this.grid)
  this.size == orig(this.size)
  this.moveProvider == orig(this.moveProvider)
  ```
- **Clasificación:** **Correct and useful**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Precondición contractual de dirección de desplazamiento: el parámetro debe pertenecer estrictamente al conjunto finito de direcciones canónicas (`UP`, `DOWN`, `LEFT`, `RIGHT`), y la llamada jamás destruye ni reasigna la referencia de la grilla ni la instancia del proveedor de movimientos (`MoveProvider`).
  - *Utilidad como oráculo:* Atrapa llamadas con direcciones nulas antes de invocar a `moveProvider.provide(direction)` y certifica la estabilidad referencial de la estructura de datos durante los deslizamientos.
  - *Relación con el código:* Verifica la guarda `if (direction == null) throw new IllegalArgumentException(...)` presente en `move`.

---

#### Invariante 7: Contrato de igualdad estructural en `equals(Object)`
- **Punto de programa:** `ar.edu.unrc.game2048.Board.equals(java.lang.Object):::EXIT`
- **Invariante inferido:**
  ```text
  (return == true)  ==>  (orig(o) != null)
  (return == true)  ==>  (orig(o.getClass().getName()) == ar.edu.unrc.game2048.Board.class)
  ```
- **Clasificación:** **Correct and useful**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Formula formalmente las propiedades canónicas de equivalencia de `equals`: si el método retorna `true`, el objeto comparado obligatoriamente no es nulo y pertenece exactamente a la misma clase concreta (`Board`).
  - *Utilidad como oráculo:* Certifica que no existen falsos positivos al comparar tableros contra objetos nulos o de otros tipos incompatibles.
  - *Relación con el código:* Comprueba de forma matemática las guardas `if (o == null || getClass() != o.getClass()) return false;`.

---

#### Invariante 8: Aliasing de colaboradores mutables en constructor de copia `Board(Board other)`
- **Punto de programa:** `ar.edu.unrc.game2048.Board.Board(ar.edu.unrc.game2048.Board):::EXIT`
- **Invariante inferido:**
  ```text
  this.score == other.score
  this.score == orig(other.score)
  this.random == other.random
  this.random == orig(other.random)
  ```
- **Clasificación:** **Correct and useful** (como detector de defecto / bug)
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Daikon expone que el constructor de copia comparte la misma referencia de objeto para la puntuación (`Score`) y el generador pseudoaleatorio (`Random`).
  - *Defecto descubierto (*Aliasing*):* Aunque el constructor documenta crear una copia profunda (*deep copy*), `Score` es un objeto mutable (`score.increaseScore(...)`). Al compartir la referencia, cualquier alteración en el tablero copiado muta el puntaje del tablero original (y viceversa). Esto impacta directamente en `move()`, que crea `Board previous = new Board(this);` para detectar si el tablero cambió tras una jugada.
  - *Relación con el código:* Refleja las asignaciones directas `this.score = other.score;` y `this.random = other.random;` en `Board.java:149-150`.

---

#### Invariante 9: Exposición de representación interna y pureza referencial en `getGrid()`
- **Punto de programa:** `ar.edu.unrc.game2048.Board.getGrid():::EXIT`
- **Invariante inferido:**
  ```text
  return == this.grid
  this.size == size(return[])
  return != null
  return[] elements != null
  ```
- **Clasificación:** **Correct but trivial**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Daikon constata que el método getter `getGrid()` retorna la referencia directa a la matriz interna (`return == this.grid`).
  - *Por qué es trivial y su impacto arquitectónico:* Desde el punto de vista del comportamiento del método, es la consecuencia obvia de `return grid;`. No obstante, desde el punto de vista del diseño de software (*representation exposure*), Daikon evidencia que la clase `Board` sufre de escape de representación mutable: cualquier cliente externo que invoque `getGrid()` puede modificar celdas del tablero sin pasar por los métodos de control de `Board`.

---

#### Invariante 10: Pureza observacional en `getSize()`
- **Punto de programa:** `ar.edu.unrc.game2048.Board.getSize():::EXIT`
- **Invariante inferido:**
  ```text
  return == this.size
  return == orig(this.size)
  return == size(this.grid[])
  ```
- **Clasificación:** **Correct but trivial**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Establece que el getter retorna fielmente el atributo `size` y que la llamada no genera efectos colaterales sobre el estado del objeto.
  - *Por qué es trivial:* No expresa ninguna regla propia de la mecánica del juego, limitándose a certificar la convención estándar de un getter escalar.

---

#### Invariante 11: Preservación de parámetros en constructores
- **Punto de programa:** `ar.edu.unrc.game2048.Board.Board(int, boolean):::EXIT`
- **Invariante inferido:**
  ```text
  this.size == orig(size)
  this.determinist == orig(determinist)
  ```
- **Clasificación:** **Correct but trivial**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Asegura que los campos de configuración quedan inicializados con los valores exactos suministrados por el llamador.
  - *Por qué es trivial:* Representa la asignación elemental del constructor sin modelar propiedades emergentes del dominio.

---

#### Invariante 12: Falsa equivalencia bicondicional en `isLosingBoard()` por sesgo de dimensión
- **Punto de programa:** `ar.edu.unrc.game2048.Board.isLosingBoard():::EXIT`
- **Invariante inferido:**
  ```text
  (return == false)  <==>  (ar.edu.unrc.game2048.Board.DEFAULT_SIZE != this.size)
  (return == true)   <==>  (ar.edu.unrc.game2048.Board.DEFAULT_SIZE == this.size)
  ```
- **Clasificación:** **Too strong / likely spurious**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Daikon concluyó que un tablero es perdedor (`game over`) **si y solo si** su tamaño es exactamente 4 (`DEFAULT_SIZE == 4`), y que si el tamaño es distinto de 4, es imposible perder.
  - *Causa del sesgo (*overfitting*):* En las suites de prueba ejecutadas, los tableros que se rellenaron y configuraron deliberadamente en estado de derrota (sin movimientos posibles ni casillas vacías, e.g. mediante `Seeder.seederLostBoard`) fueron todos de tamaño 4x4. Los tableros de tamaños alternativos (como 1x1, 2x2 o 100x100) fueron creados con celdas vacías y nunca se ejercitaron hasta el estado de derrota.
  - *Contraejemplo que lo rompe:* Un tablero de 2x2 configurado con fichas dispares que no pueden fusionarse:
    $$\begin{pmatrix} 2 & 4 \\ 8 & 16 \end{pmatrix}$$
    Este tablero tiene `size == 2 != DEFAULT_SIZE`, pero `isLosingBoard()` devuelve `true`. El invariante inferido es por ende falso en el dominio general.

---

#### Invariante 13: Asociación espuria de victoria con determinismo y tamaño fijo en `isWinningBoard()`
- **Punto de programa:** `ar.edu.unrc.game2048.Board.isWinningBoard():::EXIT`
- **Invariante inferido:**
  ```text
  (return == true)  ==>  (ar.edu.unrc.game2048.Board.DEFAULT_SIZE == this.size)
  (return == true)  ==>  (this.determinist == true)
  ```
- **Clasificación:** **Too strong / likely spurious**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Daikon deduce que una partida solo puede ganarse si el tablero es de 4x4 y se juega en modo determinista.
  - *Por qué es espurio:* En las pruebas unitarias y de regresión, la condición de victoria (aparición de una ficha con valor 2048) se simuló artificialmente inyectando la celda ganadora sobre tableros deterministas de 4x4 creados para tests.
  - *Contraejemplo que lo rompe:* En una partida estocástica normal (`determinist == false`) o en un tablero de tamaño 5x5, un jugador puede perfectamente alcanzar la ficha 2048 (`return == true`), contradiciendo la implicación.

---

#### Invariante 14: Tablero lleno restringido exclusivamente al modo estocástico en `isFull()`
- **Punto de programa:** `ar.edu.unrc.game2048.Board.isFull():::EXIT`
- **Invariante inferido:**
  ```text
  (return == true)  ==>  (this.determinist == false)
  (return == true)  ==>  (ar.edu.unrc.game2048.Board.DEFAULT_SIZE == this.size)
  ```
- **Clasificación:** **Too strong / likely spurious**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Daikon infiere que el tablero solo puede llenarse si el juego se ejecuta con generación estocástica de fichas y sobre grillas 4x4.
  - *Causa y contraejemplo:* Los tests que completaron la grilla ejecutaron partidas estocásticas. Sin embargo, mediante `setCell` o movimientos continuos sobre `new Board(4, true)` es posible llenar el tablero con `determinist == true`.

---

#### Invariante 15: Restricción de puntaje observable a conjunto discreto {0, 4} en `getScore()`
- **Punto de programa:** `ar.edu.unrc.game2048.Board.getScore():::EXIT`
- **Invariante inferido:**
  ```text
  return one of { 0, 4 }
  ar.edu.unrc.game2048.Board.DEFAULT_SIZE >= return
  ```
- **Clasificación:** **Too strong / likely spurious**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Afirma que el puntaje del juego solo puede ser 0 o 4, y que nunca puede superar el tamaño por defecto del tablero (4).
  - *Causa y contraejemplo:* En las pruebas automatizadas no se jugaron partidas largas donde se acumularan fusiones de alto puntaje (por ejemplo, fusionar dos fichas de 1024 suma 2048 puntos, alcanzando puntajes de miles de puntos). El postcondición real es simplemente $\text{return} \ge 0$.

---

### 3. Tabla Resumen de Clasificación de Invariantes de `Board`

| Método / Punto de Programa | Invariante Representativo Inferido por Daikon | Clasificación | Justificación Resumida |
|---|---|---|---|
| `Board:::OBJECT` | `size == size(grid[]) && size >= 1 && grid[] elements != null` | **Correct and useful** | Invariante de representación estructural esencial. Previene desbordamientos y punteros nulos. |
| `Board:::OBJECT` | `moveProvider != null && score != null && emptyCells == null` | **Correct and useful** | Confirma colaboradores vivos y revela residuo de diseño (campo inerte `emptyCells`). |
| `getCell(int, int):::ENTER` | `0 <= row < size && 0 <= col < size` | **Correct and useful** | Precondición estricta de límites de matriz para indexación segura. |
| `getCell(int, int):::EXIT` | `return != null && return.value >= 0 && grid == orig(grid)` | **Correct and useful** | Postcondición de integridad de celda observada y pureza de la consulta. |
| `setCell(int, int, Cell):::ENTER` | `cell != null && cell.value >= 0 && bounds valid` | **Correct and useful** | Contrato de entrada para evitar inyección de celdas nulas o valores ilegales. |
| `setScore(int):::ENTER` | `value >= 0` | **Correct and useful** | Precondición de consistencia contable: no existen puntajes negativos. |
| `move(Direction):::ENTER` | `direction != null && direction in ENUM$VALUES[]` | **Correct and useful** | Precondición de dirección canónica válida. |
| `move(Direction):::EXIT` | `grid == orig(grid) && size == orig(size)` | **Correct and useful** | Garantiza preservación de identidad matricial tras desplazamientos. |
| `equals(Object):::EXIT` | `(return == true) ==> (orig(o) != null && orig(o.getClass()) == Board.class)` | **Correct and useful** | Propiedades formales de identidad y seguridad de tipo en igualdad. |
| `Board(Board):::EXIT` | `this.score == other.score && this.random == other.random` | **Correct and useful** | Revela defecto crítico de aliasing de objetos mutables en copia. |
| `getGrid():::EXIT` | `return == this.grid` | **Correct but trivial** | Getter trivial que evidencia fuga de representación interna (*rep exposure*). |
| `getSize():::EXIT` | `return == this.size && return == orig(this.size)` | **Correct but trivial** | Pureza estándar de getter escalar. |
| `Board(int, boolean):::EXIT` | `this.size == orig(size) && this.determinist == orig(determinist)` | **Correct but trivial** | Asignación directa y predecible de parámetros de construcción. |
| `isLosingBoard():::EXIT` | `(return == true) <=> (DEFAULT_SIZE == this.size)` | **Too strong / likely spurious** | Sesgo severo: solo se simularon derrotas en 4x4; ignora derrotas en otros tamaños. |
| `isWinningBoard():::EXIT` | `(return == true) ==> (determinist == true && size == 4)` | **Too strong / likely spurious** | Sobreajuste a tests donde la victoria se inyectó en tableros deterministas 4x4. |
| `isFull():::EXIT` | `(return == true) ==> (determinist == false)` | **Too strong / likely spurious** | Sesgo de prueba: tableros llenos pueden ocurrir también en modo determinista. |
| `getScore():::EXIT` | `return one of { 0, 4 } && return <= DEFAULT_SIZE` | **Too strong / likely spurious** | Falta de partidas prolongadas con fusiones acumulativas de alto orden. |

---

## 4. Comparación con `repOK()` y Especificaciones Previas

### 4.1 Invariantes que ya se expresaban en `Board.repOK()` y Daikon redescubrió

Daikon redescubrió autónomamente las reglas estructurales de invariante de representación que se habían codificado manualmente en `Board.repOK()`:

1. **Dimensionalidad de la grilla:**
   - En `repOK()`: `grid.length == size` y `grid[row].length == size`.
   - Inferido por Daikon: `this.size == size(this.grid[])` en `Board:::OBJECT`.
2. **No-nulidad de la matriz y sus filas:**
   - En `repOK()`: `grid != null` y `grid[row] != null`.
   - Inferido por Daikon: `this.grid != null` y `this.grid[] elements != null`.
3. **No-nulidad de subsistemas y colaboradores:**
   - En `repOK()`: `score != null`, `random != null`, `moveProvider != null`.
   - Inferido por Daikon: `this.score != null`, `this.random != null`, `this.moveProvider != null` en `Board:::OBJECT`.
4. **Dominio positivo del tamaño:**
   - En `repOK()`: `size > 0`.
   - Inferido por Daikon: `this.size >= 1`.

---

### 4.2 Qué encontró Daikon que NO teníamos definido en `repOK()`

El análisis dinámico de trazas reveló contratos de comportamiento y aspectos de la arquitectura que escapan al alcance tradicional de un método de validación de representación:

1. **Precondiciones contractuales de frontera en `getCell` y `setCell`:**
   - `repOK()` solo valida el estado interno estático del objeto `Board`. Daikon descubrió los contratos funcionales de entrada:
     $$0 \le \text{row} < \text{size}(\text{grid}[]) \quad \land \quad 0 \le \text{col} < \text{size}(\text{grid}[])$$
     Esto formaliza los requisitos para los clientes antes de invocar los métodos.
2. **Detección de variable de instancia inerte (`emptyCells`):**
   - Daikon reportó persistentemente `this.emptyCells == null` en todos los puntos de programa. Al examinar el código, se constató que `private List<Position> emptyCells;` era un residuo de refactorización que nunca se utilizaba, ya que las posiciones vacías se calculan bajo demanda en `getEmptyPositions()`.
3. **Exposición de representación (*Representation Exposure*):**
   - En `getGrid():::EXIT`, Daikon dedujo `return == this.grid`. Esto pone de manifiesto que el tablero entrega su matriz interna sin encapsulamiento ni clonación defensiva.
4. **Precondición de no-negatividad en `setScore(int)`:**
   - Daikon identificó `value >= 0` como precondición de entrada para el método mutador de puntaje, propiedad de negocio que antes sólo dependía del encapsulamiento de `Score`.
5. **No nulidad de la dirección de movimiento:**
   - En `move(Direction):::ENTER`, Daikon infirió `direction != null` y `direction in ENUM$VALUES[]`, garantizando que la orquestación del movimiento nunca reciba parámetros nulos.

---

### 4.3 Qué NO pudo inferir Daikon de `repOK()` y por qué

A pesar de su exhaustividad, Daikon presentó limitaciones intrínsecas frente a la validación semántica compleja de `repOK()`:

1. **Chequeo recursivo profundo de celdas (`grid[row][column].repOK()`):**
   - En `Board.repOK()`, se itera sobre cada posición $(r, c)$ invocando recursivamente `grid[r][c].repOK()`. Daikon no es capaz de sintetizar cuantificaciones universales anidadas sobre arreglos bidimensionales que involucren métodos booleanos arbitrarios ($\forall r, c: \text{grid}[r][c].\text{repOK}() == \text{true}$).
2. **Unicidad referencial de instancias canónicas en la grilla:**
   - `Board.repOK()` valida que toda celda vacía sea exactamente la referencia `Cell.EMPTY` (`if (cell.isEmpty() && cell != Cell.EMPTY) return false;`). Daikon logró inferir que `Cell.EMPTY` es no nulo y tiene valor 0, pero no pudo relacionar la identidad de cada posición `grid[i][j]` con la constante estática canónica para todo el arreglo bidimensional.
3. **Consistencia de juego válido (ausencia de fusiones imposibles):**
   - La lógica que determina si una grilla representa una configuración alcanzable en una partida real requiere conocimiento semántico que no está contemplado en las plantillas algebraicas de Daikon.

---

## 5. Reflexión de la Fase 4.2: Comparación de Fuentes de Oráculos para `Board`

| Fuente de Oráculo | Cómo se producen en `Board` | Fortalezas | Debilidades |
|---|---|---|---|
| **Aserciones manuales** | Diseñadas por el desarrollador en `BoardTest` | Expresan con máxima precisión la intención del juego (ej. verificar que mover a la izquierda compacte celdas adyacentes idénticas). | Muy costosas de mantener; propensas a omitir combinaciones complejas de grillas o estados límite. |
| **`Board.repOK()`** | Contrato de invariante estructural codificado a mano | Barrera de defensa universal: valida integridad dimensional y no-nulidad de toda la grilla antes y después de cada mutación. | Limitado al estado interno; no describe las precondiciones de entrada ni las relaciones entrada-salida de los métodos. |
| **Aserciones de Randoop** | Inferidas a partir de llamadas aleatorias a secuencias de métodos | Automáticas, útiles para detectar regresiones y caídas (*crashes*) inesperadas en cascada. | Oráculos ciegos y frágiles; aserciones superficiales que no capturan la semántica del juego 2048. |
| **Aserciones de EvoSuite** | Generadas guiadas por algoritmos genéticos optimizando cobertura de ramas | Excelente cobertura de caminos y ramas difíciles en `isLosingBoard()` y `move()`. | Tendencia al sobreajuste de valores particulares; generan oráculos rígidos difíciles de auditar manualmente. |
| **Invariantes de Daikon** | Inferidos analizando miles de trazas de ejecución en todos los puntos de programa | Descubre precondiciones contractuales de frontera, propiedades algebraicas y pureza de métodos de consulta. | Fuerte susceptibilidad al sesgo de las suites de prueba (genera invariantes espurias por sobreajuste a tamaños o modos particulares). |

### Justificación y Conclusión: ¿Qué enfoque produjo los oráculos más útiles para la clase `Board`?

En retrospectiva sobre la clase `Board`, **todos los enfoques fueron indispensables y aportaron un valor crucial en sus respectivas dimensiones**, complementándose entre sí:

1. **Los tests manuales** permitieron en la etapa inicial comprender el dominio, replicar partidas y corregir fallos lógicos elementales en el tablero.
2. **`Board.repOK()`** estableció la barrera de defensa estructural continua más sólida: un oráculo universal activo antes y después de cada operación que garantizó que nunca existiesen matrices deformadas, filas nulas o valores corruptos.
3. **Randoop y EvoSuite** aportaron la exploración automatizada y la cobertura masiva de caminos y ramas complejas (especialmente en `isLosingBoard` y `move`), generando las trazas ricas y variadas indispensables para alimentar a las herramientas dinámicas.
4. **Haciendo especial hincapié en Daikon:** Su aporte diferencial no fue solo formalizar contratos matemáticos o precondiciones de entrada, sino que **fue la única herramienta que nos permitió ver problemas profundos de manejo de referencias y comportamientos incorrectos en el diseño de objetos**:
   - **Aliasing crítico en el constructor de copia (`Board(Board other)`):** Daikon detectó que `this.score == other.score` y `this.random == other.random`. Reveló que la supuesta copia profunda estaba compartiendo exactamente las mismas instancias físicas de objetos mutables en memoria, haciendo que mutar el puntaje en la copia alterara silenciosamente el tablero original y falseara el chequeo de movimiento en `move()` (`!this.equals(previous)`).
   - **Unicidad de referencias en celdas vacías (`Cell.EMPTY`):** Hizo evidente que todas las celdas vacías válidas comparten la misma identidad canónica en memoria (`== Cell.EMPTY`), lo que permitió extender `repOK()` para verificar integridad referencial (Flyweight).
   - **Fuga de representación interna (*representation exposure*):** Evidenció mediante `return == this.grid` que `getGrid()` entregaba la referencia directa al arreglo mutable sin encapsulamiento ni copia defensiva.
   - **Detección de atributos muertos:** Expuso que el campo `emptyCells` era un residuo inerte que siempre quedaba en `null`.

En conclusión, la confiabilidad no provino de una técnica aislada, sino de la articulación de todas: la generación masiva (Randoop/EvoSuite) alimentó a la inferencia formal (Daikon), la cual descubrió fallas de referencias y contratos para perfeccionar los oráculos manuales y el invariante de representación (`repOK()`).

---

## 6. Actualizaciones a `Board.repOK()` Basadas en la Salida de Daikon

A partir del análisis de las trazas e invariantes de Daikon, se desprenden tres mejoras directas para fortalecer `Board.repOK()` y el diseño de la clase:

### 6.1 Detección y depuración del campo inerte `emptyCells`
Daikon reportó invariablemente que `this.emptyCells == null`. En `Board.java`, el campo estaba declarado pero nunca inicializado:
```java
private List<Position> emptyCells; // Campo inerte detectado por Daikon
```
Dado que las posiciones vacías se calculan funcionalmente en `getEmptyPositions()`, este atributo fue eliminado de la clase para evitar consumo innecesario de memoria y ambigüedades en el estado.

### 6.2 Validación defensiva del puntaje acumulado en `Board.repOK()`
Daikon dedujo que en todas las operaciones válidas `value >= 0` y `score != null`. Para asegurar que ningún tablero mantenga una referencia a un puntaje corrompido con saldo negativo, se agregó explícitamente en `Board.repOK()`:
```java
if (score.getScore() < 0) {
    return false; // El puntaje nunca puede ser negativo en 2048
}
```

### 6.3 Refuerzo de unicidad canónica para celdas vacías
Inspirado por la deducción de unicidad referencial de `Cell.EMPTY` observada en las trazas, `Board.repOK()` valida ahora que ninguna celda vacía en la grilla sea una instancia aislada:
```java
for (int row = 0; row < size; row++) {
    for (int col = 0; col < size; col++) {
        if (grid[row][col].isEmpty() && grid[row][col] != Cell.EMPTY) {
            return false; // Violación de patrón Flyweight / unicidad canónica
        }
    }
}
```
Esto asegura que la optimización de memoria sea respetada por cualquier método que modifique o inicialice el tablero.

---

## 7. Catálogo de Hallazgos y Defectos Detectados para Corrección (Actionable Findings & Fixes)

Esta sección recopila los defectos concretos de diseño, bugs latentes y violaciones de encapsulamiento descubiertos a través de la inferencia de Daikon en la clase `Board`, proporcionando para cada uno el diagnóstico, la evidencia en la traza y el código exacto para corregirlo (*fix*).

---

### Hallazgo 1: Aliasing de objeto mutable `score` en el constructor de copia
- **Evidencia en Daikon:**
  ```text
  ar.edu.unrc.game2048.Board.Board(ar.edu.unrc.game2048.Board):::EXIT
  this.score == other.score
  this.score == orig(other.score)
  ```
- **Diagnóstico del problema:**
  El constructor de copia declara realizar una copia profunda (*deep copy*), pero asigna directamente la referencia del objeto mutable `Score`: `this.score = other.score;`. 
  Dado que `Score` posee métodos mutadores como `increaseScore` y `setScore`, ambas instancias de `Board` comparten la misma instancia física de puntaje en memoria.
  Esto causa un bug sutil en `move()`:
  ```java
  Board previous = new Board(this);
  Move move = moveProvider.provide(direction);
  move.execute(this, grid, score); // ¡Al mutar score, también muta previous.score!
  boolean moved = !this.equals(previous);
  ```
  Al comparar `this.equals(previous)`, `previous.score.getScore()` siempre coincidirá con `this.score.getScore()`, comprometiendo la verificación de igualdad.
- **Fix propuesto en `Board.java` (Constructor de copia):**
  ```java
  // Reemplazar:
  // this.score = other.score;
  
  // Por una copia independiente:
  this.score = new Score(other.score.getScore());
  ```

---

### Hallazgo 2: Acoplamiento del generador de números aleatorios (`Random`) entre tableros
- **Evidencia en Daikon:**
  ```text
  ar.edu.unrc.game2048.Board.Board(ar.edu.unrc.game2048.Board):::EXIT
  this.random == other.random
  this.random == orig(other.random)
  ```
- **Diagnóstico del problema:**
  En el constructor de copia se comparte la referencia al generador pseudoaleatorio `this.random = other.random;`. Si el tablero original o la copia realizan llamadas a `addRandomTile()`, el estado interno de la semilla en `java.util.Random` avanza de manera compartida, provocando interferencia e impredecibilidad entre partidas o simulaciones que deberían ser independientes.
- **Fix propuesto en `Board.java` (Constructor de copia):**
  ```java
  // Reemplazar:
  // this.random = other.random;
  
  // Por una nueva instancia de Random:
  this.random = new java.util.Random();
  ```

---

### Hallazgo 4: Fuga de encapsulamiento / Escape de representación mutable en `getGrid()`
- **Evidencia en Daikon:**
  ```text
  ar.edu.unrc.game2048.Board.getGrid():::EXIT
  return == this.grid
  return != null
  ```
- **Diagnóstico del problema:**
  El método público `getGrid()` retorna la referencia directa al arreglo bidimensional interno (`Cell[][]`). Esto permite a cualquier cliente externo o test eludir los métodos de control de `Board` y mutar directamente la grilla (`board.getGrid()[0][0] = new Cell(-99)`), violando tanto la inmutabilidad de la estructura como los invariantes chequeados por `repOK()`.
- **Fix propuesto en `Board.java`:**
  Retornar una copia defensiva profunda del arreglo bidimensional:
  ```java
  public Cell[][] getGrid() {
      Cell[][] copy = new Cell[size][size];
      for (int r = 0; r < size; r++) {
          System.arraycopy(grid[r], 0, copy[r], 0, size);
      }
      return copy;
  }
  ```

---

### Hallazgo 5: Ausencia de validación defensiva en `setScore(int value)`
- **Evidencia en Daikon:**
  ```text
  ar.edu.unrc.game2048.Board.setScore(int):::ENTER
  value >= 0
  ```
- **Diagnóstico del problema:**
  Daikon observó que en ejecuciones normales el valor pasado a `setScore` siempre es no negativo. No obstante, `Board.java:373` carece de verificación defensiva:
  ```java
  public void setScore(int value) { score.setScore(value); }
  ```
  Si un llamador invoca `board.setScore(-500)`, el tablero entra en un estado corrupto con puntaje negativo.
- **Fix propuesto en `Board.java`:**
  ```java
  public void setScore(int value) {
      if (value < 0) {
          throw new IllegalArgumentException("Score cannot be negative: " + value);
      }
      score.setScore(value);
  }
  ```

---

### Hallazgo 6: Ausencia de validación defensiva explícita de límites en `getCell(int row, int col)`
- **Evidencia en Daikon:**
  ```text
  ar.edu.unrc.game2048.Board.getCell(int, int):::ENTER
  row >= 0 && col >= 0
  row <= size(this.grid[]) - 1
  col <= size(this.grid[]) - 1
  ```
- **Diagnóstico del problema:**
  A pesar de que el Javadoc documenta `@throws IndexOutOfBoundsException`, la implementación delega ciegamente en `grid[row][col]`:
  ```java
  public Cell getCell(int row, int col) {
      return grid[row][col];
  }
  ```
  Lanzar la excepción cruda de Java `ArrayIndexOutOfBoundsException` sin comprobación previa impide proveer mensajes claros de error y difiere del estilo defensivo utilizado en otros componentes.
- **Fix propuesto en `Board.java`:**
  ```java
  public Cell getCell(int row, int col) {
      if (row < 0 || row >= size || col < 0 || col >= size) {
          throw new IndexOutOfBoundsException("Coordinates out of bounds: (" + row + ", " + col + ")");
      }
      return grid[row][col];
  }
  ```

---

### Hallazgo 7: Validación de rango de coordenadas en `setCell`
- **Evidencia en Daikon:**
  ```text
  ar.edu.unrc.game2048.Board.setCell(int, int, Cell):::ENTER
  row >= 0 && col >= 0
  row <= size(this.grid[]) - 1
  col <= size(this.grid[]) - 1
  cell != null
  ```
- **Diagnóstico del problema:**
  `setCell` verifica defensivamente `if (cell == null)`, pero no valida explícitamente los límites de fila y columna antes de indexar `grid[row][col] = cell;`, confiando en la excepción genérica de la JVM en lugar de lanzar la excepción documentada con mensaje de diagnóstico.
- **Fix propuesto en `Board.java`:**
  ```java
  public void setCell(int row, int col, Cell cell) {
      if (row < 0 || row >= size || col < 0 || col >= size) {
          throw new IndexOutOfBoundsException("Coordinates out of bounds: (" + row + ", " + col + ")");
      }
      if (cell == null) {
          throw new IllegalArgumentException("Cell cannot be null");
      }
      grid[row][col] = cell;
  }
  ```

