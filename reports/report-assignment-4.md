# Reporte Assignment 4: inferencia dinámica de invariantes con Daikon

## 1. Resumen

Se instrumentaron `Board` y `Cell` con Chicory y se infirieron invariantes con Daikon 5.9.0 sobre cuatro trazas: tests manuales (`manual`), Randoop, EvoSuite y las tres juntas (`all`).

- Daikon redescubrió casi todo lo que expresa `repOK()` para las condiciones simples del objeto, y no pudo inferir lo que requiere cuantificar sobre la matriz (celdas no nulas, filas de largo `size`).
- Aportó contratos que `repOK()` no expresa, como `2 * this.value == return.value` en `Cell.mergeWith` o las precondiciones de `Cell(int)`.
- Señaló cinco defectos de diseño, todos corregidos. El último: **`Board(Board)` no copiaba el campo `determinist`** (B6). Tras la corrección, `this.determinist == other.determinist` aparece en las cuatro suites.
- Ampliar la traza redujo los invariantes espurios: los `one of { ... }` pasaron de 36 a 10 y los `this.determinist == true` de 18 a 3 (sección 4).

## 2. Recolección e inferencia

Entorno: JDK 11 hasta 21 para Daikon (versión usada: 11), EvoSuite con JDK 8, `lib/daikon.jar` 5.9.0, proyecto compilado con `mvn test-compile`.

```bash
./run-daikon.sh --suite=manual     # también randoop, evosuite y all
```

El script ejecuta Chicory con un runner propio (`DaikonTestRunner`, que corre JUnit 4 y 5) y luego Daikon:

```bash
java -cp "lib/daikon.jar:target/classes:target/test-classes:<deps>" daikon.Chicory \
    --ppt-select-pattern='^ar\.edu\.unrc\.game2048\.(Board|Cell)([.$]|:)' \
    --ppt-omit-pattern=".*Position.*" \
    --output-dir=daikon-traces/<suite> --dtrace-file=JUnitCore.dtrace.gz \
    ar.edu.unrc.game2048.manual.utils.DaikonTestRunner <clases de prueba>

java -cp lib/daikon.jar daikon.Daikon \
    --config_option daikon.split.PptSplitter.disable_splitting=true \
    -o daikon-traces/<suite>/JUnitCore.inv.gz \
    daikon-traces/<suite>/JUnitCore.dtrace.gz > daikon-invariants/<suite>/daikon-output.txt
```

- El patrón de `--ppt-select-pattern` está anclado: sin anclar, Chicory también instrumentaba métodos de otras clases que reciben un `Board` o un `Cell`.
- No se usa `--sample-start`: descartaba casos poco frecuentes y produjo invariantes falsos. En Daikon 5.9.0 el `.inv` se guarda con `-o` (no existe `--save_inv_to`).
- Se desactiva el *splitting* para evitar implicaciones condicionales espurias (sección 4.3 mide su efecto).
- Daikon descarta las llamadas que terminan en excepción (292 en `all`). Por eso las precondiciones inferidas describen solo el dominio de las llamadas válidas.

Evidencia entregada, por suite (`manual`, `randoop`, `evosuite`, `all`): trazas e `.inv` en `daikon-traces/<suite>/`, salida completa y limpia (sin los puntos `EXITnn`) en `daikon-invariants/<suite>/`. Además: `fuzzer` y `all-fuzzer` (sección 4.4), `all-splitting` (sección 4.3) y las entradas del fuzzer en `fuzz-inputs/`.

| Suite | Tests | Mutantes muertos (PIT) |
|---|---|---|
| `manual` | 154 | 238/251 (95%) |
| `randoop` | 509 | 93/251 (37%) |
| `evosuite` | 86 | 182/251 (73%) |

## 3. Invariantes clasificados (salida de `all`, salvo indicación)

Criterios: **útil** (regla real del programa), **trivial** (cierta pero obvia), **espurio** (se cumple por poca variedad en la traza y existe una ejecución válida que la viola), **incorrecto** (contradice la especificación o delata un defecto).

### 3.1 `Cell`

| # | Invariante (punto de programa) | Clasificación | Razonamiento |
|---|---|---|---|
| C1 | `EMPTY != null`, `EMPTY.value == 0` (`Cell:::CLASS`) | Útil | Fija la celda vacía canónica. `EMPTY has only one value` es trivial (`static final`). |
| C2 | `this.value >= 0` (`Cell:::OBJECT`) | Útil, incompleto | Es la primera parte de `repOK()`. No expresa "positivo implica potencia de dos": requiere una disyunción. |
| C3 | `value >= 2`, `value is a power of 2` (`Cell(int):::ENTER`) | Útil | Es exactamente la guarda del constructor. Con Randoop sola da `value == 32` y con EvoSuite `one of { 2, 4, 8 }` (espurios). |
| C4 | `this.value == orig(value)`, `this.value > EMPTY.value` (`Cell(int):::EXIT`) | Útil | El constructor público nunca produce una celda vacía; `Cell():::EXIT` da `this.value == 0`. |
| C5 | `this.value == other.value`, `other != null` (`mergeWith:::ENTER`) | Útil | Es el contrato del método (lanza excepción si no se pueden fusionar). |
| C6 | `2 * this.value - return.value == 0` (`mergeWith:::EXIT`) | Útil (el más valioso) | Oráculo funcional de la fusión; detecta errores aritméticos. |
| C7 | `Cell.repOK():::EXIT: return == true` | Útil (evidencia) | Ninguna celda observada violó `repOK()`; coincide con que sus mutantes sobreviven en PIT. |
| C8 | `this.value one of { 0, 2, 4 }`, `return one of { 31, 33, 35 }` (`hashCode`) | Espurio | Solo se invocó con 0, 2 y 4; una celda de 8 es válida y da otro hash. |

### 3.2 `Board`

| # | Invariante (punto de programa) | Clasificación | Razonamiento |
|---|---|---|---|
| B1 | `this.size == size(this.grid[])`, `this.size >= 1` (`OBJECT`) | Útil | Equivale a `size > 0` y `grid.length == size` de `repOK()`. |
| B2 | `grid`, `score`, `random != null`; `grid[] elements != null` (`OBJECT`) | Útil | Coincide con `repOK()`. `random != null` es real desde que el constructor valida `Random` nulo. No infiere que cada celda sea no nula. |
| B3 | `MAX_SIZE >= this.size` (`OBJECT`) | Útil | Corresponde a `MAX_SIZE < size` en `repOK()`; el `>=` indica que se probó el tamaño máximo. |
| B4 | `WINNING_VALUE > this.size` (`OBJECT`) | Trivial | Solo porque `MAX_SIZE = 300 < 2048`; no es una regla del dominio. |
| B5 | `DEFAULT_SIZE == this.size`, `this.determinist == false` (`Board():::EXIT`) | Útil | Postcondición documentada de `new Board()`. |
| B6 | `this.determinist == false` en `Board(Board):::EXIT` (antes); `== other.determinist` (ahora) | **Incorrecto** (defecto, corregido) | El constructor de copia nunca asignaba `determinist`: la copia de un tablero determinista era no determinista y `move()` le agregaba fichas aleatorias. Ninguna prueba lo detectaba porque `Board.equals` no compara `determinist`. Se corrigió con `this.determinist = other.determinist;`. |
| B7 | `0 <= row, col <= size-1`, `return != null` (`getCell`) | Útil | Define el rango válido de coordenadas y que el resultado es una celda no nula. |
| B8 | `this.size == size(return[])`, sin `this.grid == return` (`getGrid:::EXIT`) | Útil | La corrida inicial mostraba `this.grid == return` (fuga de la matriz interna); ahora `getGrid()` devuelve una copia. |
| B9 | `direction != null` (`move:::ENTER`) | Útil | Equivale a la guarda del método. `move:::EXIT` no dice nada sobre el valor devuelto ni sobre el contenido. |
| B10 | `this.determinist == false` (`addRandomTile:::ENTER`) | Útil | Solo se invoca en modo no determinista. |
| B11 | `WINNING_VALUE >= return`, `MAX_SIZE != return` (`getScore:::EXIT`) | Espurio | El puntaje supera 2048 con facilidad (`setScore(5000)` lo viola). Las suites nunca vieron puntajes altos; el fuzzer sí y lo refuta (sección 4.4). |
| B12 | `WINNING_VALUE > current.value`, `WINNING_VALUE % current.value == 0` (`canMerge:::ENTER`) | Espurio | Una celda de 2048 o 4096 es válida y viola ambos. |
| B13 | `this.size one of { 2, 3, 5 }` (`isLosingBoard:::EXIT296`) | Espurio | `new Board(300, false)` o un 7x7 son válidos. Con una sola suite aparecen más `one of` sobre el tamaño; al unir las suites casi todos desaparecen. |

## 4. Ampliación de la traza (Fase 3.3)

### 4.1 Corrida inicial contra final

La inicial es la commiteada antes de ampliar las pruebas y corregir `Board`. Tenía el *splitting* activado, así que para comparar se excluyen sus puntos condicionales e implicaciones.

| Métrica | Inicial | Final (`all`) |
|---|---|---|
| Invariantes | 701 | 569 |
| `one of { ... }` | 36 | 10 |
| `this.determinist == true` | 18 | 3 |
| `DEFAULT_SIZE == this.size` | 10 | 4 |
| `this.emptyCells == null`, `this.score == other.score`, `this.random == other.random`, `this.grid == return` en `getGrid` | 3, 1, 1, 1 | 0 |

- Las pruebas manuales nuevas (tamaños 1 a 150, tableros deterministas llenos, puntajes distintos de 0 y 4, movimientos que no cambian el tablero) eliminaron la mayoría de los `determinist == true` y `DEFAULT_SIZE == this.size`.
- Los invariantes de aliasing, de `emptyCells` y de `getGrid` desaparecieron porque se corrigieron los defectos.
- Los que quedan (3 y 4) están en puntos `EXITnn` que solo se alcanzan en casos puntuales (`isLosingBoard:::EXIT296`, `repOK:::EXIT114` y `EXIT125` con tableros corrompidos por reflexión, `equals:::EXIT335`) y en `Board():::EXIT`, donde son correctos.

### 4.2 Entre suites

| Suite | Puntos de programa | Invariantes | `one of` |
|---|---|---|---|
| `manual` | 94 | 627 | 14 |
| `randoop` | 60 | 386 | 25 |
| `evosuite` | 91 | 549 | 29 |
| `all` | 96 | 569 | 10 |

Randoop sola da los invariantes más débiles (`value == 32`), EvoSuite se queda en `one of` y las pruebas manuales, que eligen los valores con intención, dan la regla general. Combinar trazas no suma invariantes: Daikon solo conserva lo que vale en todas las muestras. Por ejemplo, `repOK:::EXIT: return == true` de EvoSuite desaparece en `all` porque las pruebas manuales hacen que `repOK()` devuelva `false` a propósito.

### 4.3 Efecto del *splitting*

Se repitió la inferencia de `all` con el *splitting* activado (`daikon-invariants/all-splitting/`). Los 569 invariantes no condicionales coinciden con la corrida sin *splitting*; se agregan 46 puntos condicionales y 57 implicaciones (la corrida inicial tenía 42 y 65).

- Las implicaciones de apariencia espuria bajan de 10 en la corrida inicial a 6 (por ejemplo, `canMerge: (return == true) ==> (this.determinist == true)`, que se debe a que las fusiones solo se observaron en tableros deterministas y pequeños).
- Aparecen postcondiciones legítimas que sin *splitting* no existen: `Cell.isEmpty: (this.value == 0) <==> (return == true)`, `Board.canMerge: (return == true) <==> (current.value == neighbor.value)` y, en `Cell.canMergeWith`, `(return == true) ==> (this.value == other.value)`.

### 4.4 Traza con el fuzzer

Se reprodujeron bajo Chicory, contra `MainCLI`, las entradas de las primeras 200 partidas del fuzzer del Assignment 3 (`fuzz-inputs/001.txt` a `200.txt`), una traza por partida (63 MB en total). `MainCLI` crea `new Board()` sin semilla, por lo que repetir una entrada no reproduce el mismo tablero; lo que se aprovecha es la variedad de secuencias.

```bash
java -cp "lib/daikon.jar:target/classes" daikon.Chicory \
    --ppt-select-pattern='^ar\.edu\.unrc\.game2048\.(Board|Cell)([.$]|:)' \
    --ppt-omit-pattern=".*Position.*" \
    --output-dir=daikon-traces/fuzzer --dtrace-file=runNNN.dtrace.gz \
    ar.edu.unrc.game2048.MainCLI < fuzz-inputs/NNN.txt > /dev/null
```

| Métrica | `all` | `fuzzer` solo | `all` + `fuzzer` |
|---|---|---|---|
| Puntos de programa | 96 | 64 | 96 |
| Invariantes | 569 | 349 | 568 |
| `one of { ... }` | 10 | 4 | 9 |
| `this.determinist == true` | 3 | 0 | 2 |

- **Solo el fuzzer** reintroduce los espurios estructurales que las suites habían eliminado (`DEFAULT_SIZE == this.size`, `this.determinist == false`), porque el CLI siempre juega en un 4x4 no determinista. Tampoco ejecuta `repOK`, `isFull`, `getSize`, `hashCode`, `setScore` ni `getGrid`. Muestra propiedades ciertas del juego pero demasiado fuertes para la API: `getScore: return % DEFAULT_SIZE == 0` (el puntaje solo sube con fusiones de al menos 4; `setScore(3)` lo viola).
- **Sumado a las suites** refuta cuatro invariantes espurios: `getScore: WINNING_VALUE >= return` y `MAX_SIZE != return`, y `this.size one of { 2, 3, 5 }` junto con `this.determinist == true` en `isLosingBoard:::EXIT296`. También desaparece `other.size >= 1` en `Board(Board):::ENTER` (sigue siendo cierto; no hay explicación comprobada).

**Conclusión.** Ampliar la traza eliminó la mayoría de los espurios que dependían de una dimensión o de un modo de juego, y reveló propiedades genuinas (`2 * this.value == return.value`, la precondición general de `Cell(int)`). El *splitting* recupera postcondiciones condicionales legítimas con pocos espurios. El fuzzer aportó poco por encima de las suites (569 a 568 invariantes): su límite es estructural, porque un CLI que siempre crea un tablero 4x4 no determinista no puede revelar propiedades de otros tamaños ni del modo determinista. Persisten espurios donde la variedad numérica sigue siendo baja (`Cell.hashCode`, cotas con `WINNING_VALUE`).

## 5. Comparación con `repOK()`

| Condición de `repOK()` | ¿Daikon la infirió? |
|---|---|
| `Board`: `size > 0`, `size <= MAX_SIZE`, `grid != null`, `grid.length == size`, `score`/`random != null`, `grid[row] != null` | Sí (`Board:::OBJECT`; `size >= 1` solo en `evosuite` y `all`) |
| `Board`: `score.getScore() >= 0` | Indirecto (`getScore:::EXIT`, `setScore:::ENTER`); `Score` no está instrumentada |
| `Board`: `grid[row].length == size`, `grid[row][col] != null`, `grid[row][col].repOK()`, celda vacía es `Cell.EMPTY` | No |
| `Cell`: `value >= 0` | Sí |
| `Cell`: `value == 0 ⇒ this == EMPTY`; `value > 1` y potencia de dos si no es 0 | Parcial (`Cell():::EXIT`, `Cell(int):::EXIT`), no en `OBJECT` |

**Qué infirió Daikon que no está en `repOK()`:** contratos de métodos (postcondición de `mergeWith`, precondiciones de `Cell(int)`, `mergeWith`, `move`, `getCell`), postcondiciones de construcción, la copia defensiva de `getGrid()` y el defecto de `determinist` en la copia. No se agregó nada de esto a `repOK()`, que no mira entradas ni salidas; se tradujo en pruebas.

**Qué no pudo inferir y por qué:**
- **Cuantificación sobre la matriz.** Las plantillas de Daikon relacionan pocas variables; no hay una para "todo elemento de la matriz es no nulo y es una celda válida" ni "todas las filas tienen largo `size`".
- **Disyunciones** (`value == 0 || value es potencia de dos`): Daikon solo las produce como implicaciones con *splitting*, y aun así no en `OBJECT`.
- **Estados antes y después.** Compara referencias, no contenido: no puede decir si el puntaje cambió ni que `move` devuelve `true` si y solo si el tablero cambió.
- **Estados inválidos.** Solo ve ejecuciones válidas y descarta las llamadas que terminan en excepción, así que las entradas inválidas probadas (tamaño 0, 301 o 400, `Random` nulo, `Cell(3)`) no dejan huella. Por eso `Board(int, boolean, Random):::ENTER` no muestra la cota `size <= MAX_SIZE`, aunque el constructor la exige.

## 6. Comparación de fuentes de oráculos

| Fuente | Fortalezas | Debilidades | Dato en este proyecto |
|---|---|---|---|
| Aserciones manuales | Precisas, con intención de dominio | Costosas; pueden omitir casos | 95% de mutantes muertos |
| `repOK()` | Reutilizable en cualquier prueba | Solo estado, no contratos de métodos | Casi todo redescubierto por Daikon |
| Randoop | Automático; detecta regresiones | Frágil; sin semántica de dominio | 37% |
| EvoSuite | Alta cobertura | Difícil de auditar; algunos tests son intermitentes (usan `Random` sin semilla) | 73% |
| Invariantes de Daikon | Generalizan; revelan contratos y defectos | Dependen de la traza; espurios | Secciones 3 a 5 |

Ningún enfoque fue el mejor por sí solo. Como **oráculo ejecutable** (detecta mutantes y regresiones) fueron más eficaces las pruebas manuales, y `repOK()` permite reutilizarlas como chequeo de estado. Como **herramienta para descubrir qué faltaba especificar** fue la más útil Daikon: señaló los cinco defectos y propuso contratos que no estaban escritos en ningún lado. Randoop y EvoSuite sirvieron como proveedores de ejecuciones para Daikon, no como oráculos. Los invariantes de Daikon no son oráculos ejecutables por sí mismos y solo tienen valor tras una clasificación manual; traducirlos a aserciones y medir si matan mutantes no se hizo.

## 7. Cambios derivados de Daikon

- Corridas anteriores: `Cell.repOK()` exige que una celda vacía sea `Cell.EMPTY`; `Board.repOK()` exige lo mismo y `score >= 0`; `getGrid()` devuelve una copia; `Board(Board)` crea su propio `Random` y `Score`; `setScore` rechaza valores negativos; `getCell` y `setCell` validan límites; se eliminó el campo `emptyCells`.
- Esta corrida: `Board.MAX_SIZE = 300` (validado en el constructor y en `repOK()`; tableros enormes colgaban a Chicory y a EvoSuite) y validación de `Random` nulo (vuelve real `this.random != null`).
- **B6:** se agregó `this.determinist = other.determinist;` en `Board(Board)`. La nueva inferencia en las cuatro suites lo confirma. Falta una prueba que lo proteja: `copyABoardTest` solo usa `equals`, que no compara `determinist`.

## 8. Limitaciones

- Las clasificaciones de la sección 3 son manuales, sobre la salida de `all`; los conteos de la sección 4 salen de un script de expresiones regulares y son orientativos.
- La traza del fuzzer usa 200 de las 2000 partidas del registro y solo explora el tablero 4x4 no determinista.
- La suite de EvoSuite tiene tests intermitentes; se dejó así. Las trazas pueden variar levemente entre corridas.
- Los `.dtrace` son pesados (63 MB solo los del fuzzer); hay que verificar su tamaño antes de commitearlos.