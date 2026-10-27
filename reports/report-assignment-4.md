# Reporte assignment 4: inferencia dinámica de invariantes y generación de oráculos con Daikon

## 1. Preparación y recolección de trazas

### 1.0 Preparación del entorno

- JDK 21 en el `PATH` (Daikon 5.9.0 exige Java 11 o superior; con Java 8 falla con `UnsupportedClassVersionError`).
- `lib/daikon.jar` (el jar completo de https://plse.cs.washington.edu/daikon/download/). Se verificó con `java -cp lib/daikon.jar daikon.Daikon`, que imprime `Daikon version 5.9.0` (la opción `--version` del enunciado no existe en esta versión).
- Proyecto compilado con información de depuración (`mvn clean test-compile`) y pruebas en JUnit 4, requisito de Chicory.

### 1.1 Corrida inicial (línea base)

Para la primera corrida combinamos las pruebas manuales, las suites generadas por Randoop y las suites generadas por EvoSuite. El script `run-daikon.sh` instrumentó únicamente las clases del modelo (`Board` y `Cell`), omitiendo clases auxiliares como `Position`:

```bash
./run-daikon.sh \
    ar.edu.unrc.game2048.manual.BoardTest \
    ar.edu.unrc.game2048.manual.CellTest \
    ar.edu.unrc.game2048.randoop.board.RegressionTest \
    ar.edu.unrc.game2048.randoop.cell.RegressionTest \
    ar.edu.unrc.game2048.evosuite.Board_ESTest \
    ar.edu.unrc.game2048.evosuite.Cell_ESTest
```

La salida de esta corrida se conserva en `daikon-invariants/daikon-output.txt` y es la línea base de la sección 3.4.

### 1.2 Corrida ampliada (Fase 3.3)

Después de clasificar los invariantes (sección 3) y corregir `Board` (sección 6), se agregaron pruebas para ampliar la diversidad de la traza y se volvió a ejecutar Chicory sobre las pruebas manuales `BoardTest` y `CellTest`:

```bash
./run-daikon.sh \
    ar.edu.unrc.game2048.manual.BoardTest \
    ar.edu.unrc.game2048.manual.CellTest
```

El script instrumenta con:

```text
--ppt-select-pattern='^ar\.edu\.unrc\.game2048\.(Board|Cell)([.$]|:)'
--ppt-omit-pattern='.*Position.*'
--sample-start=500
```

El patrón anterior (`ar.edu.unrc.game2048.Board|ar.edu.unrc.game2048.Cell`, sin anclar) también capturaba métodos de otras clases que reciben un `Board` o un `Cell` como parámetro (`Move*.execute`, `Seeder`, `BoardTest.fillCheckerboard`). Con el patrón anclado la salida pasó de 167 a 133 puntos de programa, todos de `Board` y `Cell`.

## 2. Inferencia de invariantes con Daikon

Una vez obtenidas las trazas con Chicory, ejecutamos Daikon para contrastar los valores registrados contra su catálogo de plantillas de invariantes, guardando además el archivo binario `.inv`:

```bash
java -cp lib/daikon.jar daikon.Daikon \
     -o daikon-traces/JUnitCore.inv.gz \
     daikon-traces/JUnitCore.dtrace.gz > daikon-output.txt
```

(En Daikon 5.9.0 la opción para guardar el `.inv` es `-o`; `--save_inv_to` del enunciado ya no existe.) Evidencia entregada: `daikon-traces/JUnitCore.dtrace.gz`, `daikon-traces/JUnitCore.inv.gz` y `daikon-output.txt`.

## 3. Discusión y clasificación de invariantes inferidos

Cada invariante inferido se clasificó según las cuatro categorías de la actividad:
1. Correct and useful (correcta y útil): refleja una regla del programa y sirve como oráculo ante fallos reales.
2. Correct but trivial (correcta pero trivial): se cumple siempre, pero describe propiedades obvias (pureza en getters, no nulidad de constantes) sin aportar reglas nuevas del juego.
3. Too strong / likely spurious (demasiado fuerte o espuria): surge por sobreajuste ante un conjunto limitado de pruebas y se rompe con una ejecución válida del programa.
4. Incorrect (incorrecta): contradice la especificación o refleja un defecto del código que Daikon asumió como comportamiento normal.

### 3.1 Invariantes de `Cell`

#### Invariante 1: No negatividad del valor de celda
- Punto de programa: `ar.edu.unrc.game2048.Cell:::OBJECT`
- Invariante inferido:
  ```text
  this.value >= 0
  this.value >= ar.edu.unrc.game2048.Cell.EMPTY.value
  ```
- Clasificación: Correct and useful
- Justificación:
  - Dominio: modela el invariante de representación de `Cell`. En 2048, una celda está vacía (`value == 0`) o tiene una ficha positiva ($2, 4, 8, \dots$). No hay fichas con valores negativos.
  - Utilidad como oráculo: detecta estados inválidos producidos por errores aritméticos o desbordamientos.
  - Relación con `repOK()`: coincide con la primera guarda evaluada en `Cell.repOK()` (`if (value < 0) return false;`).

#### Invariante 2: Las celdas operables son potencias de dos
- Punto de programa: `ar.edu.unrc.game2048.Cell.canMergeWith(Cell):::ENTER`
- Invariante inferido:
  ```text
  this.value is a power of 2
  other.value is a power of 2
  this.value >= 2
  other.value >= 2
  ```
- Clasificación: Correct and useful
- Justificación:
  - Dominio: indica que en la ejecución del tablero, `canMergeWith` solo se invoca entre fichas activas ($2, 4, 8, \dots$), excluyendo celdas vacías (`0`).
  - Utilidad como oráculo: funciona como contrato de precondición. Si un invocador pasa celdas vacías o valores no válidos (como 3 o 5), este invariante detecta la violación antes de procesar la lógica.
  - Relación con `repOK()`: coincide con la propiedad `Integer.bitCount(value) == 1` exigida en `Cell.repOK()`.

#### Invariante 3: Regla bicondicional de fusión
- Punto de programa: `ar.edu.unrc.game2048.Cell.canMergeWith(Cell):::EXIT`
- Invariante inferido:
  ```text
  (return == false)  <==>  (this.value != other.value)
  ```
- Clasificación: Correct and useful
- Justificación:
  - Dominio: dos fichas activas pueden fusionarse si y solo si sus valores numéricos son iguales.
  - Utilidad como oráculo: define la postcondición del método y sirve como oráculo funcional de `canMergeWith`.
  - Relación con el código: valida la instrucción `return this.value == other.value;`.

#### Invariante 4: Pureza de `getValue()`
- Punto de programa: `ar.edu.unrc.game2048.Cell.getValue():::EXIT`
- Invariante inferido:
  ```text
  this.value == return
  return == orig(this.value)
  return >= 0
  ```
- Clasificación: Correct but trivial
- Justificación:
  - Dominio: constata que el método devuelve el valor interno sin alterar el objeto (`orig(this.value) == this.value`).
  - Por qué es trivial: describe el comportamiento estándar de lectura de un atributo inmutable, sin agregar reglas propias del juego.

#### Invariante 5: Restricción de fusión a valores $2 + 2 \rightarrow 4$
- Punto de programa: `ar.edu.unrc.game2048.Cell.mergeWith(Cell):::EXIT`
- Invariante inferido:
  ```text
  this.value == 2
  other.value == 2
  return.value == 4
  ```
- Clasificación: Too strong / likely spurious
- Justificación:
  - Dominio: falso invariante producido por sobreajuste (*overfitting*). Apareció porque las pruebas iniciales solo ejercitaron fusiones entre fichas de valor 2.
  - Contraejemplo: cualquier partida con fichas mayores (por ejemplo, $4 + 4 \rightarrow 8$) incumple esta regla. La postcondición general es `return.value == orig(this.value) * 2`.
  - Corrección: agregamos pruebas parametrizadas con combinaciones variadas para que Daikon deduzca la regla general de duplicación.

### 3.2 Invariantes de `Board`

#### Invariante 1: Coherencia de dimensiones de la grilla
- Punto de programa: `ar.edu.unrc.game2048.Board:::OBJECT`
- Invariante inferido:
  ```text
  this.size == size(this.grid[])
  this.size >= 1
  ```
- Clasificación: Correct and useful
- Justificación:
  - Dominio: garantiza que la dimensión lógica (`size`) coincida con la cantidad de filas de la matriz interna `grid`.
  - Utilidad como oráculo: previene estados inconsistentes y excepciones de tipo `ArrayIndexOutOfBoundsException` al recorrer posiciones.
  - Relación con `repOK()`: corresponde a la comprobación `grid.length == size` en `Board.repOK()`.

#### Invariante 2: Integridad de las filas de la grilla
- Punto de programa: `ar.edu.unrc.game2048.Board:::OBJECT`
- Invariante inferido:
  ```text
  this.grid != null
  this.grid[] elements != null
  ```
- Clasificación: Correct and useful
- Justificación:
  - Dominio: garantiza que la matriz y cada una de sus filas estén instanciadas.
  - Utilidad como oráculo: evita fallos por `NullPointerException` durante el acceso a celdas.
  - Relación con `repOK()`: corresponde al bucle de `Board.repOK()` que valida `grid[i] != null` para todo índice válido.

#### Invariante 3: Límites válidos en el acceso a celdas
- Punto de programa: `ar.edu.unrc.game2048.Board.getCell(int, int):::ENTER`
- Invariante inferido:
  ```text
  row >= 0
  col >= 0
  row <= size(this.grid[]) - 1
  col <= size(this.grid[]) - 1
  ```
- Clasificación: Correct and useful
- Justificación:
  - Dominio: define el rango de coordenadas válidas $[0, \text{size}-1]$ para acceder a cualquier celda del tablero.
  - Utilidad como oráculo: detecta intentos de acceso fuera de rango provenientes de la interfaz o de la lógica de juego antes de indexar la matriz.
  - Relación con el código: coincide con la validación de límites presente en `Board.java`.

#### Invariante 4: Pureza de `getSize()`
- Punto de programa: `ar.edu.unrc.game2048.Board.getSize():::EXIT`
- Invariante inferido:
  ```text
  return == this.size
  this.size == orig(this.size)
  ```
- Clasificación: Correct but trivial
- Justificación:
  - Dominio: constata que el método retorna el atributo `size` sin modificar el tablero.
  - Por qué es trivial: es la lectura habitual de un getter elemental y no modela ninguna regla específica de 2048.

#### Invariante 5: Restricción del tablero lleno al modo no determinista
- Punto de programa: `ar.edu.unrc.game2048.Board.isFull():::EXIT` (rama `return == true`)
- Invariante inferido:
  ```text
  (return == true)  ==>  (this.determinist == false)
  ```
- Clasificación: Too strong / likely spurious
- Justificación:
  - Dominio: Daikon infiere que el tablero solo se llena si el juego corre en modo no determinista (`determinist == false`).
  - Causa: en la suite ejecutada, los casos que llegaron a llenar el tablero usaban generación aleatoria de fichas.
  - Contraejemplo: una partida en modo determinista (`new Board(4, true)`) puede recibir movimientos continuos hasta ocupar todas las celdas, con `return == true` y `determinist == true`.

#### Invariante 6: Aliasing de colaboradores mutables en el constructor de copia
- Punto de programa: `ar.edu.unrc.game2048.Board.Board(ar.edu.unrc.game2048.Board):::EXIT`
- Invariante inferido:
  ```text
  this.score == other.score
  this.score == orig(other.score)
  this.random == other.random
  this.random == orig(other.random)
  ```
- Clasificación: Incorrect (defecto de diseño por aliasing)
- Justificación:
  - Dominio: el constructor de copia comparte las referencias de `Score` y `Random` entre el tablero original y la copia.
  - Defecto detectado: la clase documenta una copia profunda (*deep copy*), pero `Score` es mutable. Al compartir la referencia, modificar el puntaje en la copia altera el original. Esto afecta a `move()`, que crea `Board previous = new Board(this);` y compara `!this.equals(previous)` para verificar si hubo cambios.
  - Relación con el código: proviene de las asignaciones `this.score = other.score;` y `this.random = other.random;` en `Board.java`.

#### Invariante 7: Escape de representación mutable en `getGrid()`
- Punto de programa: `ar.edu.unrc.game2048.Board.getGrid():::EXIT`
- Invariante inferido:
  ```text
  return == this.grid
  this.size == size(return[])
  return != null
  ```
- Clasificación: Incorrect (fuga de encapsulamiento)
- Justificación:
  - Dominio: el método devuelve la referencia directa a la matriz interna `Cell[][]`.
  - Defecto detectado: un cliente externo puede modificar la grilla directamente (`board.getGrid()[0][0] = new Cell(-1)`), eludiendo los métodos de `Board` y violando los invariantes de `repOK()`. El método debería retornar una copia defensiva.

#### Invariante 8: Campo de posiciones vacías no inicializado (código muerto)
- Punto de programa: `ar.edu.unrc.game2048.Board:::OBJECT`
- Invariante inferido:
  ```text
  this.emptyCells == null
  ```
- Clasificación: Incorrect (código muerto)
- Justificación:
  - Dominio: el campo `emptyCells` permanece siempre en `null`.
  - Defecto detectado: el atributo `private List<Position> emptyCells;` no se inicializa ni se usa, ya que las posiciones vacías se calculan localmente cuando se necesitan.

#### Invariante 9: Precondición de no negatividad en `setScore(int)`
- Punto de programa: `ar.edu.unrc.game2048.Board.setScore(int):::ENTER`
- Invariante inferido:
  ```text
  value >= 0
  ```
- Clasificación: Correct and useful (omisión de validación defensiva)
- Justificación:
  - Dominio: en partidas válidas el puntaje siempre es no negativo ($S \ge 0$).
  - Defecto detectado: `setScore` no incluye una guarda que rechace valores negativos (`value < 0`), lo que permite que una llamada externa corrompa el puntaje.

#### Invariante 10: Falsa dependencia entre fin de partida y `DEFAULT_SIZE`
- Punto de programa: `ar.edu.unrc.game2048.Board.isLosingBoard():::EXIT`
- Invariante inferido:
  ```text
  (return == false)  <==>  (ar.edu.unrc.game2048.Board.DEFAULT_SIZE != this.size)
  (return == true)   <==>  (ar.edu.unrc.game2048.Board.DEFAULT_SIZE == this.size)
  ```
- Clasificación: Too strong / likely spurious
- Justificación:
  - Dominio: Daikon deduce que un tablero pierde si y solo si su tamaño es 4 (`DEFAULT_SIZE == 4`).
  - Causa: en las pruebas ejecutadas, los tableros en estado de derrota eran siempre de 4x4. Los tableros de otros tamaños se probaron únicamente con celdas libres.
  - Contraejemplo: un tablero de 2x2 bloqueado tiene `size == 2 != DEFAULT_SIZE`, pero `isLosingBoard()` devuelve `true`.

#### Invariante 11: Restricción espuria a `DEFAULT_SIZE` para ganar y llenar el tablero
- Punto de programa: `ar.edu.unrc.game2048.Board.isWinningBoard():::EXIT` y `isFull():::EXIT`
- Invariante inferido:
  ```text
  // En isWinningBoard():::EXIT:
  (return == true)  ==>  (ar.edu.unrc.game2048.Board.DEFAULT_SIZE == this.size)

  // En isFull():::EXIT:
  (return == true)  ==>  (ar.edu.unrc.game2048.Board.DEFAULT_SIZE == this.size)
  ```
- Clasificación: Too strong / likely spurious
- Justificación:
  - Dominio: Daikon asume que solo se puede ganar o llenar el tablero en dimensiones de 4x4.
  - Causa: los casos de prueba que alcanzaban la ficha 2048 o llenaban la grilla usaban exclusivamente tableros estándar.
  - Contraejemplo: en un tablero de 3x3 o 5x5 es posible ganar o llenar las posiciones, lo que contradice la implicación.

#### Invariante 12: Cota espuria del puntaje ligada a `DEFAULT_SIZE` en `getScore()`
- Punto de programa: `ar.edu.unrc.game2048.Board.getScore():::EXIT`
- Invariante inferido:
  ```text
  return one of { 0, 4 }
  ar.edu.unrc.game2048.Board.DEFAULT_SIZE >= return
  ```
- Clasificación: Too strong / likely spurious
- Justificación:
  - Dominio: Daikon deduce que el puntaje nunca supera el tamaño por defecto (`return <= DEFAULT_SIZE`, es decir $\le 4$).
  - Causa: las trazas iniciales no incluyeron partidas largas con múltiples fusiones acumulativas.
  - Contraejemplo: una sola fusión de fichas de 4 otorga 8 puntos ($8 > 4$), superando la cota inferida.

### 3.3 Tabla resumen de clasificación

| Clase | Punto de programa | Invariante representativo | Clasificación |
|---|---|---|---|
| `Cell` | `Cell:::OBJECT` | `this.value >= 0` | Correct and useful |
| `Cell` | `Cell.canMergeWith:::ENTER` | `this.value is a power of 2` | Correct and useful |
| `Cell` | `Cell.canMergeWith:::EXIT` | `(return == false) <=> (this.value != other.value)` | Correct and useful |
| `Cell` | `Cell.getValue:::EXIT` | `return == orig(this.value)` | Correct but trivial |
| `Cell` | `Cell.mergeWith:::EXIT` | `this.value == 2 && return.value == 4` | Too strong / likely spurious |
| `Board` | `Board:::OBJECT` | `this.size == size(this.grid[])` | Correct and useful |
| `Board` | `Board:::OBJECT` | `this.grid[] elements != null` | Correct and useful |
| `Board` | `Board:::OBJECT` | `this.emptyCells == null` | Incorrect (código muerto) |
| `Board` | `Board.getCell:::ENTER` | `0 <= row < size && 0 <= col < size` | Correct and useful |
| `Board` | `Board.getGrid:::EXIT` | `return == this.grid` | Incorrect (fuga de encapsulamiento) |
| `Board` | `Board.setScore:::ENTER` | `value >= 0` | Correct and useful (omisión de validación defensiva) |
| `Board` | `Board.Board(Board):::EXIT` | `this.score == other.score && this.random == other.random` | Incorrect (aliasing en copia) |
| `Board` | `Board.getSize:::EXIT` | `return == this.size` | Correct but trivial |
| `Board` | `Board.isFull:::EXIT` | `(return == true) ==> (this.determinist == false)` | Too strong / likely spurious |
| `Board` | `Board.isLosingBoard:::EXIT` | `(return == true) <=> (DEFAULT_SIZE == this.size)` | Too strong / likely spurious |
| `Board` | `Board.isWinningBoard:::EXIT` | `(return == true) ==> (DEFAULT_SIZE == this.size)` | Too strong / likely spurious |
| `Board` | `Board.getScore:::EXIT` | `DEFAULT_SIZE >= return && return one of {0, 4}` | Too strong / likely spurious |

### 3.4 Ampliación de la traza y nueva ejecución (Fase 3.3)

Luego de este análisis, agregamos casos de prueba adicionales para eliminar las invariantes espurias originadas por falta de diversidad en las trazas (tableros de tamaño 2, 3, 5 y 6; tableros deterministas y no deterministas llenos, ganadores y perdedores; fusiones encadenadas con puntajes mayores a 4; movimientos sin efecto en las cuatro direcciones) y corregimos los defectos señalados por las invariantes 6, 7 y 9 (sección 6.3). Volvimos a correr Chicory y Daikon (sección 1.2) y comparamos con la línea base (`daikon-invariants/daikon-output.txt`, 1686 líneas, contra la nueva `daikon-output.txt`).

| Invariante de la línea base | Línea base | Corrida ampliada | Qué lo cambió |
|---|---|---|---|
| `isFull`: `(return == true) ==> (this.determinist == false)` | Presente | Ausente | Tableros deterministas llenos (`deterministicBoardCanBeFullTest`) |
| `isFull`/`isWinningBoard`: `(return == true) ==> (DEFAULT_SIZE == this.size)` | Presente | Ausente | Tableros llenos y ganadores de 2, 3 y 5 de lado |
| `isLosingBoard`: `(return == true) <==> (DEFAULT_SIZE == this.size)` | Presente | Ausente en el punto `EXIT` general | Derrotas en 2x2, 3x3, 5x5 y 6x6 |
| `getScore`: `return one of { 0, 4 }`, `DEFAULT_SIZE >= return` | Presente | Ausente | Fusiones encadenadas (puntajes 8, 24, 56) |
| `Cell.repOK:::ENTER`: `this.value one of { 0, 2, 2048 }` | Presente | Ausente (ahora `one of { 0, 2, 4 }` solo en puntos de `canMergeWith`) | Más valores de celda |
| `this.size one of { 4, 100 }` en `setScore:::ENTER` y `this.size one of {...}` en otros 25 puntos | 26 apariciones | 9 apariciones, con `{ 2, 4 }` y `{ 2, 3, 5 }` | Tableros de varios tamaños |
| Constructor de copia: `this.random == other.random` | Presente | Ausente | Corrección de `Board(Board)` |
| `getGrid:::EXIT`: `this.grid == return`, `return == orig(this.grid)` | Presente | Ausente | Copia defensiva en `getGrid()` |
| `Board:::OBJECT`: `this.emptyCells == null` (40 apariciones) | Presente | Ausente | El campo ya no existe en `Board.java` |

Lo que la ampliación no eliminó o cambió de forma inesperada:

- **`this.determinist == true` sigue apareciendo en 16 puntos de programa** (`getScore`, `getGrid`, `hashCode`, `toString`, `setScore`, `repOK`, entre otros). Casi todas las pruebas manuales usan tableros deterministas; solo los tests nuevos de `move`, `isFull` y victoria/derrota usan tableros no deterministas.
- **`Board.isLosingBoard():::EXIT296` conserva `DEFAULT_SIZE == this.size` y `this.determinist == return`.** Ese punto (retorno anticipado cuando hay celdas vacías) tiene una única muestra en la traza, que Daikon reporta con invariantes del estilo `has only one value`. Es un artefacto de tener una sola observación, no una propiedad del programa.
- **`this.size one of { 2, 4 }` sigue en `equals`, `toString` y `move`**, con muestras de pocos tamaños. Además, `Board:::OBJECT` pasó de `this.size >= 1` a `this.size >= 2`: un tablero de 1x1 es válido, pero las pruebas manuales no lo ejercitan, por lo que es una cota espuria más.
- **`setScore:::ENTER` dejó de inferir `value >= 0`.** Es el efecto inverso: la nueva prueba `setScoreNegativeThrowsTest` llama a `setScore(-1)`, y como Chicory registra la entrada antes de que el método lance la excepción, la traza contiene un valor negativo. Daikon no distingue entre una entrada inválida rechazada y una válida, por lo que ya no infiere la precondición. Esa regla ahora está garantizada por la validación del método y por `repOK()` (sección 6.3), y no por Daikon. En cambio `getCell:::ENTER` conserva las cotas `row >= 0` y `row <= size(this.grid[])-1`.
- **`this.value one of { 0, 2, 4 }` en `canMergeWith`**: solo se observaron esos valores en las fusiones.

**Conclusión de la Fase 3.3.** Ampliar la traza eliminó las invariantes espurias que dependían de una dimensión o de un modo de juego (`DEFAULT_SIZE`, `determinist`, cotas del puntaje) y confirmó las genuinas (`2 * this.value - return.value == 0` en `mergeWith`, `this.size == size(this.grid[])`, no nulidad de la grilla). Persisten invariantes espurias donde la variabilidad sigue siendo baja: casi todas las pruebas usan `determinist == true`, y algunos puntos de salida tienen una sola muestra. Daikon genera propiedades tan buenas como lo sea la diversidad de sus ejecuciones.


## 4. Comparación con `repOK()` y especificaciones previas

### 4.1 Invariantes que ya figuraban en `repOK()` y Daikon redescubrió

Daikon infirió varias propiedades que ya estaban definidas en `repOK()`:

1. No negatividad del valor de celda (`Cell:::OBJECT: this.value >= 0`), presente en `Cell.repOK()`.
2. Potencias de dos en fichas activas (`Cell.canMergeWith:::ENTER: this.value is a power of 2`), expresada en `Cell.repOK()` mediante `Integer.bitCount(value) == 1`.
3. Coherencia dimensional de la grilla (`Board:::OBJECT: this.size == size(this.grid[])`), verificada en `Board.repOK()` (`grid.length == size`).
4. Filas no nulas en la matriz (`Board:::OBJECT: this.grid[] elements != null`), verificada en el bucle de `Board.repOK()` (`grid[r] != null`).
5. No nulidad de componentes del tablero (`Board:::OBJECT: this.moveProvider != null`, `this.random != null`, `this.score != null`), presentes en `Board.repOK()`.

### 4.2 Propiedades que Daikon encontró fuera de `repOK()`

Sobre la línea base (corrida inicial), Daikon detectó propiedades y restricciones operacionales que no estaban formalizadas en `repOK()`:

1. Unicidad referencial de `Cell.EMPTY`:
   - Invariante inferido:
     ```text
     Cell:::CLASS: Cell.EMPTY has only one value && Cell.EMPTY != null
     Cell.isEmpty():::EXIT: (this.value == 0) ==> (Cell.EMPTY == orig(this))
     ```
   - Detalle: `Cell.repOK()` solo evaluaba el valor escalar `value == 0`. Daikon mostró que en la práctica toda celda vacía usa la misma instancia en memoria (`== Cell.EMPTY`), siguiendo el patrón Flyweight del proyecto.

2. Precondición de fusión (`value >= 2`):
   - Invariante inferido: `Cell.canMergeWith:::ENTER: this.value >= 2 && other.value >= 2`.
   - Detalle: la guarda defensiva de `canMergeWith` admite celdas de valor 0 retornando `false`. Daikon mostró que en el flujo real `Board` filtra las celdas vacías antes de consultar la fusión.

3. Límites en el acceso a celdas (`Board.getCell:::ENTER`): Daikon infirió las cotas $[0, \text{size}-1]$ para fila y columna, formalizando el contrato de acceso que antes residía únicamente en la guarda de `Board.java`.

4. Aliasing en el constructor de copia (`Board(Board other)`):
   - Invariante inferido: `this.score == other.score && this.random == other.random`.
   - Detalle: expuso que el constructor de copia comparte las referencias de `Score` y `Random`, lo que causa efectos colaterales en la copia durante `move()`.

5. Atributo inerte `emptyCells`:
   - Invariante inferido: `this.emptyCells == null` constante en `Board:::OBJECT`.
   - Detalle: mostró que el campo no se utiliza ni se inicializa, ya que las posiciones vacías se calculan localmente cuando se necesitan.

6. Fuga de representación en `getGrid()`:
   - Invariante inferido: `return == this.grid`.
   - Detalle: mostró que el getter entrega la matriz interna sin copia defensiva, permitiendo modificaciones externas directas.

7. Precondición de no negatividad en `setScore(int)`:
   - Invariante inferido: `setScore(int):::ENTER: value >= 0`.
   - Detalle: confirmó que en ejecuciones normales el puntaje no toma valores negativos, regla que no estaba validada defensivamente en el método.

### 4.3 Propiedades de `repOK()` que Daikon no pudo inferir y por qué

- Potencia de dos disyuntiva en `Cell:::OBJECT`:
  `Cell.repOK()` comprueba `value == 0 || Integer.bitCount(value) == 1`. Daikon no generó esta propiedad en el punto global `Cell:::OBJECT` por limitaciones de sus plantillas: busca predicados universales para todas las instancias de un punto de observación. Como conviven celdas vacías (`value == 0`) y fichas activas ($2, 4, 8, \dots$), Daikon carece de una plantilla disyuntiva para expresar que el valor es 0 o una potencia de dos. Sí logró inferirla de forma condicionada en puntos de salida (`isEmpty():::EXIT` cuando `return == false`).

## 5. Comparación de fuentes de oráculos

| Fuente de oráculo | Cómo se produce | Fortalezas | Debilidades |
|---|---|---|---|
| Aserciones manuales | Escritas a mano por quien programa | Muy precisas y alineadas con la intención del dominio. | Costosas de mantener y redactar; pueden omitir casos de borde. |
| `repOK()` | Invariante de representación escrito en la clase | Reutilizable y verificable al entrar y salir de los métodos. | Se limita al estado interno del objeto; no valida contratos de entrada y salida entre métodos. |
| Aserciones de Randoop | Inferidas a partir de una corrida de exploración aleatoria | Automáticas y útiles para detectar regresiones o caídas. | Frágiles ante cambios menores en el código; difíciles de leer y sin semántica de negocio. |
| Aserciones de EvoSuite | Generadas mediante algoritmos genéticos optimizando cobertura | Alta cobertura de ramas y combinaciones complejas. | Tienden a sobreajustar estados circunstanciales; oráculos de regresión difíciles de auditar. Al minimizar casos de prueba, por sí solas pueden generar trazas poco variadas para inferir invariantes. |
| Invariantes de Daikon | Inferidos a partir de los valores observados en múltiples ejecuciones | Generalizan propiedades abstractas; revelan precondiciones, postcondiciones y contratos lógicos. | Dependen de la diversidad de las trazas; generan invariantes espurias cuando la suite de pruebas es insuficiente. |

### Qué enfoque produjo los oráculos más útiles

Cada enfoque aportó en una etapa distinta:
1. Pruebas manuales: guiaron el desarrollo inicial para reproducir partidas reales y validar la lógica de movimientos y fusiones.
2. `repOK()`: definió el oráculo estructural básico, asegurando matrices cuadradas válidas, sin filas nulas ni celdas inconsistentes.
3. Randoop y EvoSuite: aportaron volumen de ejecuciones y cobertura de ramas para alimentar las trazas de Daikon.
4. Daikon: su mayor aporte estuvo en detectar problemas de manejo de referencias y omisiones de contrato:
   - Aliasing en `Board(Board)`: detectó que el constructor de copia compartía las instancias de `score` y `random`.
   - Unicidad de `Cell.EMPTY`: mostró que las celdas vacías usan la misma instancia canónica.
   - Fuga de representación: evidenció que `getGrid()` devolvía la matriz interna mutable.
   - Código muerto: identificó que el campo `emptyCells` no se utilizaba.

## 6. Actualizaciones a `repOK()` basadas en la salida de Daikon

A partir de las observaciones de Daikon, se aplicaron dos mejoras en los métodos `repOK()`:

### 6.1 Actualización en `Cell.repOK()`
Daikon infirió la relación de identidad para celdas vacías:
```text
(this.value == 0) ==> (Cell.EMPTY == orig(this))
```
En la versión inicial de `Cell.repOK()`, una instancia creada con `new Cell(0)` devolvía `true`, aunque el diseño del sistema requiere usar la referencia canónica `Cell.EMPTY`.

Mejora implementada en `Cell.repOK()`:
```java
public boolean repOK() {
    if (value == 0) {
        return this == Cell.EMPTY;
    }
    return value > 0 && Integer.bitCount(value) == 1;
}
```

### 6.2 Actualización en `Board.repOK()`
A partir de la unicidad de celdas vacías y la integridad de la matriz, `Board.repOK()` ahora comprueba que toda celda con `cell.isEmpty()` sea exactamente la instancia canónica:
```java
if (grid[row][column].isEmpty() && grid[row][column] != Cell.EMPTY) {
    return false;
}
```

### 6.3 Correcciones en `Board` derivadas de los invariantes incorrectos

Las invariantes 6, 7 y 9 de la sección 3.2 señalaban defectos reales. Se corrigieron y se agregaron pruebas que los verifican:

- `getGrid()` devuelve una copia de la matriz (`getGridReturnsDefensiveCopyTest`).
- `Board(Board)` crea su propio `Random` en lugar de compartir el del original (`copyDoesNotShareRandomTest`, `moveDoesNotConsumeRandomSequenceOfBoardTest`).
- `setScore(int)` lanza `IllegalArgumentException` si `value < 0` (`setScoreNegativeThrowsTest`).
- `getCell` y `setCell` validan los límites y lanzan una excepción descriptiva (`getCellOutOfBoundsThrowsTest`, `setCellOutOfBoundsThrowsAndNullCellStillIllegalArgumentTest`). Se lanza `ArrayIndexOutOfBoundsException`, subclase de `IndexOutOfBoundsException`, para mantener el tipo de excepción que esperan las suites generadas por Randoop y EvoSuite.

Para mantener la suite en verde se adaptaron dos pruebas existentes: `boardWithNullCellFailsRepOk` (ahora corrompe la grilla por reflexión, porque `getGrid()` devuelve una copia) y `test08` de `Board_ESTest` (ahora espera la excepción de `setScore(-14)`).

### 6.4 Actualización en `Board.repOK()` por la precondición de `setScore`

Daikon infirió en la corrida inicial `setScore(int):::ENTER: value >= 0`. Como el puntaje es un invariante del estado del tablero, y no solo una precondición del setter, se agregó a `Board.repOK()`:
```java
if (score.getScore() < 0) {
    return false;
}
```
Se cubre con `boardWithNegativeScoreFailsRepOkTest`, que corrompe el `Score` interno por reflexión y comprueba que `repOK()` devuelve `false`.
