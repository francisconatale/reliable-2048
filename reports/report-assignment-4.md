# Reporte Assignment 4: Inferencia Dinámica de Invariantes y Generación de Oráculos con Daikon

## 1. Comandos para Instrumentar y Recolectar Trazas

Para la instrumentación y recolección de trazas de ejecución se utilizó **Chicory** (front-end de Daikon para Java) ejecutando la suite de pruebas unitarias sobre JUnit 4.

### 1.1 Compilación previa
Se verificó que el proyecto estuviera compilado con información de depuración habilitada:
```bash
mvn clean test-compile
```

### 1.2 Ejecución de Chicory (Instrumentación y Trace Collection)
A fin de recolectar un conjunto de trazas rico, diverso y representativo del comportamiento real del sistema, **la ejecución de Chicory no se realizó sobre una sola suite de pruebas aislada**, sino sobre un **conjunto combinado exhaustivo de `Board` y `Cell` que integró pruebas manuales, pruebas generadas por Randoop y pruebas generadas por EvoSuite**:

1. **Pruebas manuales:** `ar.edu.unrc.game2048.manual.BoardTest` y `ar.edu.unrc.game2048.manual.CellTest` (ejercitan la semántica de alto nivel del juego, inicializaciones y partidas completas con fusiones continuas).
2. **Pruebas de Randoop:** `ar.edu.unrc.game2048.randoop.board.RegressionTest` y `ar.edu.unrc.game2048.randoop.cell.RegressionTest` (aportan diversidad mediante exploración aleatoria dirigida por feedback y secuencias inusuales de métodos).
3. **Pruebas de EvoSuite:** `ar.edu.unrc.game2048.evosuite.Board_ESTest` y `ar.edu.unrc.game2048.evosuite.Cell_ESTest` (maximizan la cobertura de ramas y exploran casos de borde difíciles de alcanzar).

Se utilizó el script `run-daikon.sh`, restringiendo la instrumentación de Chicory a las clases del modelo (`Board` y `Cell`), omitiendo clases auxiliares como `Position`:

```bash
# Ejecución integral sobre el conjunto combinado (Manual + Randoop + EvoSuite) para Board y Cell
./run-daikon.sh \
    ar.edu.unrc.game2048.manual.BoardTest \
    ar.edu.unrc.game2048.manual.CellTest \
    ar.edu.unrc.game2048.randoop.board.RegressionTest \
    ar.edu.unrc.game2048.randoop.cell.RegressionTest \
    ar.edu.unrc.game2048.evosuite.Board_ESTest \
    ar.edu.unrc.game2048.evosuite.Cell_ESTest
```

El comando subyacente que ejecuta dicho script es:
```bash
java -cp "lib/daikon.jar:target/classes:target/test-classes:$(mvn dependency:build-classpath -Dmdep.outputFile=/dev/stdout -q)" \
    daikon.Chicory \
    --ppt-select-pattern="ar.edu.unrc.game2048.Board|ar.edu.unrc.game2048.Cell" \
    --ppt-omit-pattern=".*Position.*" \
    --sample-start=500 \
    --output-dir=daikon-traces \
    org.junit.runner.JUnitCore \
    ar.edu.unrc.game2048.manual.BoardTest \
    ar.edu.unrc.game2048.manual.CellTest \
    ar.edu.unrc.game2048.randoop.board.RegressionTest \
    ar.edu.unrc.game2048.randoop.cell.RegressionTest \
    ar.edu.unrc.game2048.evosuite.Board_ESTest \
    ar.edu.unrc.game2048.evosuite.Cell_ESTest
```
Esto generó el archivo de trazas comprimido: `daikon-traces/JUnitCore.dtrace.gz`.

### 1.3 Inferencia de Invariantes con Daikon
Una vez obtenidas las trazas, se invocó a Daikon para contrastar los valores observados contra su catálogo de plantillas de invariantes, redirigiendo la salida cruda a `daikon-output.txt` y guardando el modelo binario en `.inv`:

```bash
# Inferencia de invariantes y generación de la salida de texto plano
java -cp lib/daikon.jar daikon.Daikon daikon-traces/JUnitCore.dtrace.gz > daikon-output.txt

# Guardado en formato binario .inv para inspección posterior
java -cp lib/daikon.jar daikon.Daikon --save_inv_to daikon-traces/JUnitCore.inv daikon-traces/JUnitCore.dtrace.gz
```

---

## 2. Metodología de Evaluación y Selección de Trazas

> **Nota metodológica sobre la recolección de trazas:**
> La calidad de los invariantes inferidos dinámicamente depende de forma crítica de la diversidad de las trazas recolectadas. Si se ejecuta Daikon sobre una única suite unitaria aislada (por ejemplo, evaluando `Cell` únicamente con tests unitarios directos), se produce un sobreajuste severo (*overfitting*) que da lugar a invariantes espurias (como restringir falsamente valores numéricos válidos a pequeños conjuntos arbitrarios como `{0, 1, 2}` o `{1, 2, 4}`).
> 
> Por este motivo, **la recolección definitiva de trazas se realizó sobre el conjunto integrado de `Board` y `Cell`, combinando tests manuales, Randoop y EvoSuite**. Al conjugar la lógica de alto nivel de las partidas manuales con la exploración aleatoria de Randoop y la cobertura exhaustiva de ramas de EvoSuite para ambas clases simultáneamente, las celdas y el tablero fueron ejercitados en todo su espectro operativo: inicialización, inserciones aleatorias, corrimientos en todas las direcciones, fusiones continuas de fichas y estados límite (tablero lleno o partidas perdidas/ganadas). Esto permitió a Daikon descartar sobreajustes accidentales y redescubrir las verdaderas propiedades invariantes y contratos del sistema.

---

## 3. Discusión y Clasificación de Invariantes Inferidos

De acuerdo con las directrices de la Fase 3.2, cada invariante inferido se clasifica en una de cuatro categorías:
1. **Correct and useful (Correcta y útil):** Refleja una regla genuina del programa y sirve como aserción u oráculo para atrapar bugs reales si se violara.
2. **Correct but trivial (Correcta pero trivial):** Verdadera en todos los casos pero no aporta valor semántico profundo (pureza observacional en getters, no-nulidad de constantes, etc.).
3. **Too strong / likely spurious (Demasiado fuerte / espuria):** Falso invariante producido por sobreajuste debido a entradas limitadas en la prueba. Se rompe con una ejecución válida del programa.
4. **Incorrect (Incorrecta):** Contradice la especificación del programa (ocurre típicamente si el código contiene un defecto que Daikon toma como normal).

---

### 3.1 Invariantes de `Cell`

#### Invariante 1: No-negatividad del valor de celda
- **Punto de programa:** `ar.edu.unrc.game2048.Cell:::OBJECT`
- **Invariante inferido:**
  ```text
  this.value >= 0
  this.value >= ar.edu.unrc.game2048.Cell.EMPTY.value
  ```
- **Clasificación:** **Correct and useful**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Modela el invariante de representación fundamental de `Cell`. En el 2048, una celda solo puede estar vacía (`value == 0`) o contener una ficha activa positiva ($2, 4, 8, \dots$). No existen fichas con valores negativos.
  - *Utilidad como oráculo:* Detectaría inmediatamente cualquier corrupción de memoria o error aritmético en la lógica del juego (por ejemplo, desbordamientos de enteros o restas accidentales).
  - *Relación con `repOK()`:* Coincide de manera exacta con la primera condición evaluada en `Cell.repOK()` (`if (value < 0) return false;`).

---

#### Invariante 2: Las celdas operables son potencias de dos
- **Punto de programa:** `ar.edu.unrc.game2048.Cell.canMergeWith(Cell):::ENTER`
- **Invariante inferido:**
  ```text
  this.value is a power of 2
  other.value is a power of 2
  this.value >= 2
  other.value >= 2
  ```
- **Clasificación:** **Correct and useful**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Precondición operacional del juego. Demuestra que en el flujo real del tablero, `canMergeWith` solo es invocado entre fichas activas ya consolidadas en el tablero ($2, 4, 8, \dots$), excluyendo celdas vacías (`0`).
  - *Utilidad como oráculo:* Funciona como un contrato de precondición estricto: si un componente externo intentara consultar la posibilidad de fusión pasando una celda con un valor inválido (como 3, 5 o una celda vacía no filtrada), este invariante atraparía el fallo antes de procesar la lógica.
  - *Relación con `repOK()`:* Redescubre dinámicamente la propiedad matemática `Integer.bitCount(value) == 1` exigida en `Cell.repOK()`.

---

#### Invariante 3: Regla bicondicional canónica de fusión
- **Punto de programa:** `ar.edu.unrc.game2048.Cell.canMergeWith(Cell):::EXIT`
- **Invariante inferido:**
  ```text
  (return == false)  <==>  (this.value != other.value)
  ```
- **Clasificación:** **Correct and useful**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Daikon dedujo de forma autónoma la regla lógica formal del juego: dos fichas activas no pueden fusionarse si y solo si sus valores numéricos son distintos
  - *Utilidad como oráculo:* Constituye una postcondición formal completa para el método. Serviría directamente como un oráculo de verificación formal para cualquier implementación de `canMergeWith`.
  - *Relación con el código:* Valida el comportamiento exacto de la instrucción `return this.value == other.value;`.

---

#### Invariante 4: Pureza y consistencia del observador `getValue()`
- **Punto de programa:** `ar.edu.unrc.game2048.Cell.getValue():::EXIT`
- **Invariante inferido:**
  ```text
  this.value == return
  return == orig(this.value)
  return >= 0
  ```
- **Clasificación:** **Correct but trivial**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Establece que el getter retorna fielmente el valor interno del campo y que la invocación no produce ningún efecto colateral sobre el objeto (`orig(this.value) == this.value`).
  - *Por qué es trivial:* Aunque es verdadera y obligatoria en el diseño de un tipo de dato inmutable, se limita a constatar el comportamiento estándar de lectura de un campo inmutable sin añadir restricciones semánticas nuevas sobre el juego.

---

#### Invariante 5: Restricción de fusión a valores $2 + 2 \rightarrow 4$
- **Punto de programa:** `ar.edu.unrc.game2048.Cell.mergeWith(Cell):::EXIT`
- **Invariante inferido:**
  ```text
  this.value == 2
  other.value == 2
  return.value == 4
  ```
- **Clasificación:** **Too strong / likely spurious**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Falso invariante producido por sobreajuste (*overfitting*). Aparece porque en la traza específica capturada durante la prueba unitaria solo se ejercitaron fusiones elementales con fichas iniciales de valor 2.
  - *Contraejemplo que lo rompe:* Cualquier partida real donde se fusionen fichas de mayor denominación (por ejemplo, $4 + 4 \rightarrow 8$ o $1024 + 1024 \rightarrow 2048$) viola este invariante. La postcondición correcta y generalizada debería ser: `return.value == orig(this.value) * 2`.
 - *Solucion*: se agregaron tests parametrizados incluyendo mas situaciones, asi logrando que daikon deduzca que formalmente nuestro mergeWith siempre devuelva el doble de lo hecho

---

### 3.2 Invariantes de `Board`

#### Invariante 1: Coherencia de dimensiones de la grilla
- **Punto de programa:** `ar.edu.unrc.game2048.Board:::OBJECT`
- **Invariante inferido:**
  ```text
  this.size == size(this.grid[])
  this.size >= 1
  ```
- **Clasificación:** **Correct and useful**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Invariante de representación estructural esencial. Garantiza que la dimensión lógica del tablero (`size`) coincida exactamente con la cantidad de filas de la matriz interna `grid`.
  - *Utilidad como oráculo:* Previene inconsistencias de estado. Si un método redimensionara el tablero o inicializara incorrectamente la matriz, se lanzarían excepciones del tipo `ArrayIndexOutOfBoundsException` al recorrer las posiciones.
  - *Relación con `repOK()`:* Es una de las aserciones principales verificadas manualmente en `Board.repOK()` (`if (grid.length != size) return false;`).

---

#### Invariante 2: Integridad estructural de las filas de la grilla
- **Punto de programa:** `ar.edu.unrc.game2048.Board:::OBJECT`
- **Invariante inferido:**
  ```text
  this.grid != null
  this.grid[] elements != null
  ```
- **Clasificación:** **Correct and useful**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Garantiza que ni la grilla principal ni ninguna de sus filas sea una referencia nula.
  - *Utilidad como oráculo:* Asegura que la estructura bidimensional está completamente instanciada y previene de forma contundente fallos por `NullPointerException` durante las operaciones de movimiento y consulta.
  - *Relación con `repOK()`:* Corresponde directamente a la validación defensiva en bucle de `Board.repOK()` que chequea que `grid[i] != null` para todo $0 \le i < \text{size}$.

---

#### Invariante 3: Precondición de límites válidos en el acceso a celdas
- **Punto de programa:** `ar.edu.unrc.game2048.Board.getCell(int, int):::ENTER`
- **Invariante inferido:**
  ```text
  row >= 0
  col >= 0
  row <= size(this.grid[]) - 1
  col <= size(this.grid[]) - 1
  ```
- **Clasificación:** **Correct and useful**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Precondición contractual de límites de coordenadas. Daikon deduce formalmente el rango estricto de índices válidos $[0, \text{size}-1]$ para acceder a cualquier celda del tablero.
  - *Utilidad como oráculo:* Atrapa como violación de contrato cualquier intento de acceso a coordenadas negativas o fuera de rango proveniente de la interfaz gráfica, el CLI o un algoritmo de juego, antes de que alcance la indexación de la matriz.
  - *Relación con el código:* Refleja la guarda interna de validación de rangos presente en `Board.java`.

---

#### Invariante 4: Pureza observacional en `getSize()`
- **Punto de programa:** `ar.edu.unrc.game2048.Board.getSize():::EXIT`
- **Invariante inferido:**
  ```text
  return == this.size
  this.size == orig(this.size)
  ```
- **Clasificación:** **Correct but trivial**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Constata que el método `getSize()` retorna el valor exacto del atributo `size` y que el método no altera el estado del tablero (`orig(this.size) == this.size`).
  - *Por qué es trivial:* Es un comportamiento estándar y esperado de cualquier método getter elemental; no expresa ninguna regla del juego 2048 ni lógica algorítmica compleja.

---

#### Invariante 5: Restricción del tablero lleno únicamente al modo estocástico
- **Punto de programa:** `ar.edu.unrc.game2048.Board.isFull():::EXIT` (rama `return == true`)
- **Invariante inferido:**
  ```text
  (return == true)  ==>  (this.determinist == false)
  ```
- **Clasificación:** **Too strong / likely spurious**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Daikon infiere que un tablero sólo puede llenarse si el juego se ejecuta en modo no determinista (`determinist == false`).
  - *Por qué es espurio:* Es un sesgo de la suite de pruebas: los tests que llevaron el juego hasta llenar la grilla se ejecutaron sobre instancias normales con generación aleatoria de fichas.
  - *Contraejemplo que lo rompe:* Es perfectamente válido configurar un tablero determinista (`new Board(4, true)`) y ejecutar movimientos continuos hasta llenar todas las celdas disponibles. En esa ejecución válida, `return == true` conviviría con `this.determinist == true`, violando la implicación inferida.

---

#### Invariante 6: Aliasing de colaboradores mutables en constructor de copia `Board(Board other)`
- **Punto de programa:** `ar.edu.unrc.game2048.Board.Board(ar.edu.unrc.game2048.Board):::EXIT`
- **Invariante inferido:**
  ```text
  this.score == other.score
  this.score == orig(other.score)
  this.random == other.random
  this.random == orig(other.random)
  ```
- **Clasificación:** **Incorrect** (detector de defecto / bug)
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Daikon expone que el constructor de copia comparte la misma referencia física del objeto `Score` y del generador `Random` entre el tablero original y la copia.
  - *Defecto descubierto (*Aliasing*):* Aunque el constructor documenta crear una copia profunda (*deep copy*), `Score` es mutable (`score.increaseScore(...)`). Al compartir la referencia, cualquier mutación en una copia modifica inmediatamente el puntaje del original. Esto compromete directamente la lógica de `move()`, que crea `Board previous = new Board(this);` para determinar si el estado cambió comparando `!this.equals(previous)`.
  - *Relación con el código:* Refleja las asignaciones directas `this.score = other.score;` y `this.random = other.random;` en `Board.java:149-150`.

---

#### Invariante 7: Falsa equivalencia bicondicional de derrota ligada a `DEFAULT_SIZE` en `isLosingBoard()`
- **Punto de programa:** `ar.edu.unrc.game2048.Board.isLosingBoard():::EXIT`
- **Invariante inferido:**
  ```text
  (return == false)  <==>  (ar.edu.unrc.game2048.Board.DEFAULT_SIZE != this.size)
  (return == true)   <==>  (ar.edu.unrc.game2048.Board.DEFAULT_SIZE == this.size)
  ```
- **Clasificación:** **Too strong / likely spurious**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Daikon dedujo erróneamente que un tablero es perdedor (`game over`) **si y solo si** su tamaño es exactamente 4 (`DEFAULT_SIZE == 4`), y que un tablero de cualquier otra dimensión nunca puede perder.
  - *Causa del sesgo (*overfitting*):* En las pruebas unitarias y suites automáticas ejecutadas, los tableros configurados en estado de bloqueo/derrota (sin casillas vacías ni fusiones contiguas) fueron todos de tamaño estándar 4x4. Los tableros de otros tamaños (e.g. 1x1, 2x2, 100x100) siempre se probaron con celdas vacías disponibles.
  - *Contraejemplo que lo rompe:* Un tablero de 2x2 lleno y bloqueado $\begin{pmatrix} 2 & 4 \\ 8 & 16 \end{pmatrix}$ tiene `size == 2 != DEFAULT_SIZE`, pero `isLosingBoard()` devuelve `true`.

---

#### Invariante 8: Asunción espuria de dimensión estándar `DEFAULT_SIZE` para ganar y llenar el tablero
- **Punto de programa:** `ar.edu.unrc.game2048.Board.isWinningBoard():::EXIT` y `isFull():::EXIT`
- **Invariante inferido:**
  ```text
  // En isWinningBoard():::EXIT:
  (return == true)  ==>  (ar.edu.unrc.game2048.Board.DEFAULT_SIZE == this.size)

  // En isFull():::EXIT:
  (return == true)  ==>  (ar.edu.unrc.game2048.Board.DEFAULT_SIZE == this.size)
  ```
- **Clasificación:** **Too strong / likely spurious**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Daikon asume que es imposible ganar la partida o llenar completamente la grilla en tableros que no sean del tamaño por defecto (4x4).
  - *Causa del sesgo:* Los casos de prueba donde se alcanzó la ficha 2048 o se llenó la matriz fueron ejecutados únicamente sobre tableros de $4\times 4$.
  - *Contraejemplo que lo rompe:* En un tablero válido de tamaño 3x3 o 5x5 es perfectamente posible alcanzar la celda 2048 o llenar todas las posiciones, violando la implicación.

---

#### Invariante 9: Acotamiento espurio del puntaje observable por `DEFAULT_SIZE` en `getScore()`
- **Punto de programa:** `ar.edu.unrc.game2048.Board.getScore():::EXIT`
- **Invariante inferido:**
  ```text
  return one of { 0, 4 }
  ar.edu.unrc.game2048.Board.DEFAULT_SIZE >= return
  ```
- **Clasificación:** **Too strong / likely spurious**
- **Razonamiento y Justificación:**
  - *Significado en el dominio:* Daikon concluye que el puntaje del juego nunca puede superar el tamaño por defecto del tablero (`return <= DEFAULT_SIZE`, es decir $\le 4$).
  - *Causa del sesgo:* En las trazas recolectadas no hubo simulaciones prolongadas de partidas con fusiones acumulativas de alto orden ($8, 16, 32, \dots, 2048$) que incrementaran masivamente el puntaje.
  - *Contraejemplo que lo rompe:* Una sola fusión elemental de dos fichas de 4 otorga 8 puntos ($8 > 4$), invalidando la cota superior asumida.

---

### 3.3 Tabla Resumen de Clasificación

| Clase | Punto de Programa | Invariante Representativo | Clasificación |
|---|---|---|---|
| **`Cell`** | `Cell:::OBJECT` | `this.value >= 0` | **Correct and useful** |
| **`Cell`** | `Cell.canMergeWith:::ENTER` | `this.value is a power of 2` | **Correct and useful** |
| **`Cell`** | `Cell.canMergeWith:::EXIT` | `(return == false) <=> (this.value != other.value)` | **Correct and useful** |
| **`Cell`** | `Cell.getValue:::EXIT` | `return == orig(this.value)` | **Correct but trivial** |
| **`Cell`** | `Cell.mergeWith:::EXIT` | `this.value == 2 && return.value == 4` | **Too strong / likely spurious** |
| **`Board`** | `Board:::OBJECT` | `this.size == size(this.grid[])` | **Correct and useful** |
| **`Board`** | `Board:::OBJECT` | `this.grid[] elements != null` | **Correct and useful** |
| **`Board`** | `Board.getCell:::ENTER` | `0 <= row < size && 0 <= col < size` | **Correct and useful** |
| **`Board`** | `Board.Board(Board):::EXIT` | `this.score == other.score && this.random == other.random` | **Incorrect** (Bug detector) |
| **`Board`** | `Board.getSize:::EXIT` | `return == this.size` | **Correct but trivial** |
| **`Board`** | `Board.isFull:::EXIT` | `(return == true) ==> (this.determinist == false)` | **Too strong / likely spurious** |
| **`Board`** | `Board.isLosingBoard:::EXIT` | `(return == true) <=> (DEFAULT_SIZE == this.size)` | **Too strong / likely spurious** (Asume `DEFAULT_SIZE`) |
| **`Board`** | `Board.isWinningBoard:::EXIT` | `(return == true) ==> (DEFAULT_SIZE == this.size)` | **Too strong / likely spurious** (Asume `DEFAULT_SIZE`) |
| **`Board`** | `Board.getScore:::EXIT` | `DEFAULT_SIZE >= return && return one of {0, 4}` | **Too strong / likely spurious** (Asume `DEFAULT_SIZE`) |

Posteriormente a estos resultados, se fixearon los invariantes **Too strong / likely spurious** con mas casos de test
---

## 4. Comparación con `repOK()` y Especificaciones Previas

### 4.1 Invariantes que ya se expresaban en `repOK()` y Daikon redescubrió

Daikon logró redescubrir de forma autónoma gran parte del contrato y las propiedades de representación especificadas manualmente en el código y en los métodos `repOK()`:

1. **No-negatividad del valor en celdas (`Cell:::OBJECT: this.value >= 0`):** Presente en el invariante de representación de `Cell` y en `repOK()`.
2. **Propiedad de potencias de 2 en celdas activas (`Cell.canMergeWith:::ENTER: this.value is a power of 2`):** Expresada en `Cell.repOK()` mediante `Integer.bitCount(value) == 1`.
3. **Consistencia dimensional de la grilla (`Board:::OBJECT: this.size == size(this.grid[])`):** Chequeada en `Board.repOK()` (`grid.length == size`).
4. **Integridad de filas en la matriz (`Board:::OBJECT: this.grid[] elements != null`):** Validada en el bucle principal de `Board.repOK()` (`grid[r] != null`).
5. **No nulidad de componentes del tablero (`Board:::OBJECT: this.moveProvider != null`, `this.random != null`, `this.score != null`):** Presentes explícitamente en `Board.repOK()`.

---

### 4.2 Qué encontró Daikon que NO teníamos definido en `repOK()`

Daikon descubrió propiedades formales y restricciones operacionales del dominio que no estaban contempladas en `repOK()`:

1. **Patrón Singleton y unicidad referencial de `Cell.EMPTY`:**
   - *Invariante inferido:*
     ```text
     Cell:::CLASS: Cell.EMPTY has only one value && Cell.EMPTY != null
     Cell.isEmpty():::EXIT: (this.value == 0) ==> (Cell.EMPTY == orig(this))
     ```
   - *Análisis:* En `Cell.repOK()` únicamente se valida el estado escalar interno (`value == 0`). Daikon descubrió que en la arquitectura del sistema **toda celda vacía comparte exactamente la misma identidad de objeto en memoria (`== Cell.EMPTY`)**. Se trata de una propiedad estructural de optimización (patrón Flyweight) que no estaba formalizada en el invariante local.

2. **Precondición operacional de fusión (`value >= 2`):**
   - *Invariante inferido:* `Cell.canMergeWith:::ENTER: this.value >= 2 && other.value >= 2`.
   - *Análisis:* La implementación defensiva de `Cell.canMergeWith` permite teóricamente llamarlo con celdas de valor 0 (retornando `false`). Daikon reveló que durante el juego real, `Board` jamás lo invoca sobre celdas vacías, filtrándolas previamente.

3. **Invariante de límites de acceso (`Board.getCell:::ENTER`):**
   - Daikon infirió las precondiciones completas de frontera $[0, \text{size}-1]$ para filas y columnas, formalizando el contrato de acceso que antes sólo residía de manera implícita en un chequeo defensivo.

4. **Detección de aliasing de objetos mutables en constructor de copia (`Board(Board other)`):**
   - *Invariante inferido:* `this.score == other.score && this.random == other.random`.
   - *Análisis:* Daikon descubrió un defecto crítico de diseño: el constructor de copia comparte la misma instancia de `Score` y `Random`, violando la independencia requerida en una copia profunda y alterando el chequeo de igualdad tras movimientos.

5. **Detección de variable de instancia inerte / código muerto (`emptyCells`):**
   - *Invariante inferido:* `this.emptyCells == null` constante en `Board:::OBJECT`.
   - *Análisis:* Expone un residuo de refactorización: el campo `private List<Position> emptyCells;` nunca se inicializa ni se usa, ya que las posiciones vacías se calculan localmente bajo demanda.

6. **Exposición de representación interna mutable en `getGrid()` (*Representation Exposure*):**
   - *Invariante inferido:* `return == this.grid`.
   - *Análisis:* Revela que el método getter entrega directamente la matriz de celdas interna sin clonación defensiva, permitiendo que clientes externos muten el estado sin pasar por las validaciones de `Board`.

7. **Precondición de no-negatividad en `setScore(int)`:**
   - *Invariante inferido:* `setScore(int):::ENTER: value >= 0`.
   - *Análisis:* Identifica formalmente que el puntaje acumulado nunca puede ser negativo en una ejecución válida del juego.

---

### 4.3 Qué NO pudo inferir Daikon de `repOK()` y por qué

- **Invariante global de potencia de dos disyuntiva en `Cell:::OBJECT`:**
  - `Cell.repOK()` establece: `value == 0 || Integer.bitCount(value) == 1`.
  - Daikon no pudo generar este invariante en el punto global `Cell:::OBJECT`. Esto se debe a una **limitación intrínseca de su catálogo de plantillas**: Daikon busca predicados universales lineales o relacionales que se cumplan para *todas* las instancias observadas en ese punto. Dado que conviven celdas vacías (`0`, no potencia de dos) y fichas activas ($2, 4, 8$, potencias de dos), Daikon no posee una plantilla nativa que exprese *«o bien vale 0, o bien es potencia de 2»*.
  - Sin embargo, Daikon compensó esta limitación descomponiendo la propiedad en puntos de salida condicionales (en `isEmpty():::EXIT` cuando `return == false`, deduce `this.value is a power of 2`).

---

## 5. Reflexión de la Fase 4.2: Comparación de Fuentes de Oráculos

A lo largo de los cuatro assignments se utilizaron cinco enfoques complementarios para la generación de oráculos de prueba:

| Fuente de Oráculo | Cómo se producen | Fortalezas | Debilidades |
|---|---|---|---|
| **Aserciones manuales** | Escritas a mano por el desarrollador | Muy precisas y alineadas con la intención del negocio. | Costosas de mantener y redactar; pueden pasar por alto casos de borde. |
| **`repOK()`** | Escritas a mano como invariante de representación | Reutilizables de forma universal; chequeables al inicio y fin de cualquier método. | Limitadas a la consistencia del estado del objeto; no validan contratos funcionales entrada/salida. |
| **Aserciones de Randoop** | Inferidas a partir de una única corrida de exploración aleatoria | Automáticas y rápidas para detectar regresiones o crashes. | Extremadamente frágiles ante cambios menores; poco legibles y sin semántica de negocio. |
| **Aserciones de EvoSuite** | Generadas mediante algoritmos genéticos optimizando cobertura de código | Muy alta cobertura de ramas y combinaciones complejas. | Tienden a sobreajustar estados circunstanciales; oráculos de estilo regresión difíciles de auditar. Evosuite trata de minimizar los casos, asi que por si solo, no podria correrse daikon sin obtener posiblemente invariantes espurias |
| **Invariantes de Daikon** | Inferidos analizando miles de valores a través de múltiples ejecuciones | Generalizan propiedades abstractas; revelan precondiciones y contratos lógicos bicondicionales. | Altamente dependientes de la diversidad de las trazas; susceptibles a invariantes espurias por sobreajuste. |

### Justificación y Conclusión: ¿Qué enfoque produjo los oráculos más útiles para este programa?

Para el proyecto *Reliable 2048*, **el oráculo más importante y fundamental de todo el sistema fue `repOK()`**, pero la combinación con **Daikon** aportó una capacidad de diagnóstico única que ninguno de los otros métodos pudo proporcionar por sí solo:

1. **`repOK()` como pilar fundamental de integridad estructural:**
   Fue la herramienta más valiosa, robusta y reutilizable del proyecto. Mientras que los tests unitarios solo verifican escenarios puntuales de entrada/salida, `repOK()` actuó como un contrato universal omnipresente: garantizó en todo momento que ningún tablero pudiera existir con matrices rectangulares o rotas, filas nulas, celdas vacías desconectadas o valores numéricos ilegales. Representó la barrera de contención definitiva contra la corrupción silenciosa del estado interno tanto en desarrollo como durante las pruebas masivas.

2. **Daikon como detector de problemas de referencias, aliasing y defectos ocultos:**
   Daikon no solo dedujo reglas de negocio abstractas (como la postcondición bicondicional canónica de fusión `(return == false) <=> (this.value != other.value)`), sino que **fue el único enfoque capaz de hacernos ver problemas críticos de manejo de referencias y comportamientos incorrectos en la arquitectura**:
   - **Aliasing de objetos mutables en el constructor de copia (`Board(Board other)`):** Daikon reveló que `this.score == other.score` y `this.random == other.random`. Se estaba utilizando exactamente la misma instancia en memoria para objetos mutables en lugar de realizar una copia profunda real, lo cual falseaba la comparación de cambio de estado en `move()` (`!this.equals(previous)`), provocando que mutaciones en la copia alteraran silenciosamente el tablero original.
   - **Unicidad de referencias en celdas vacías (`Cell.EMPTY`):** Descubrió que todas las celdas vacías válidas comparten la misma identidad canónica en memoria (`== Cell.EMPTY`), lo que permitió fortalecer el propio `repOK()` para chequear identidad referencial (patrón Flyweight).
   - **Fuga de representación (*representation exposure*):** Detectó mediante `return == this.grid` que el método `getGrid()` entregaba la referencia interna directa, exponiendo la matriz a mutaciones externas no controladas.
   - **Detección de código muerto:** Evidenció que el atributo `emptyCells` era un residuo inerte de refactorizaciones previas que siempre quedaba en `null`.

3. **Complementariedad del ecosistema de pruebas:**
   - **Tests manuales:** Resultaron esenciales en la primera etapa para replicar escenarios ad-hoc y depurar bugs visuales y lógicos (como inconsistencias al reorganizar o compactar celdas).
   - **Randoop, EvoSuite y Fuzzer:** Fueron determinantes para maximizar la cobertura de caminos y generar un volumen masivo y diverso de trazas de ejecución. Sin esta exploración automatizada exhaustiva, Daikon no habría dispuesto de la riqueza de datos necesaria para filtrar invariantes espurias (como las que asumían erróneamente `DEFAULT_SIZE`) y revelar los defectos reales del sistema.

---

## 6. Actualizaciones a `repOK()` Basadas en la Salida de Daikon

A partir de los hallazgos de Daikon, se identificaron dos mejoras concretas para fortalecer los métodos `repOK()`:

### 6.1 Actualización en `Cell.repOK()`
Daikon descubrió la propiedad de unicidad referencial:
```text
(this.value == 0) ==> (Cell.EMPTY == orig(this))
```
En la versión original de `Cell.repOK()`, cualquier instancia con `value == 0` creada mediante `new Cell(0)` devolvía `true`, a pesar de que el diseño arquitectónico del proyecto exige que las celdas vacías utilicen la instancia canónica `Cell.EMPTY` (patrón Flyweight para ahorro de memoria).

**Mejora implementada en `Cell.repOK()`:**
```java
public boolean repOK() {
    if (value == 0) {
        // Enforce referential integrity: empty cells must be the canonical singleton
        return this == Cell.EMPTY;
    }
    // Active cells must be strictly positive powers of two
    return value > 0 && Integer.bitCount(value) == 1;
}
```

### 6.2 Actualización en `Board.repOK()`
Inspirado por la deducción de Daikon sobre la coherencia de celdas vacías y la no-nulidad de elementos, `Board.repOK()` verifica ahora no solo que cada celda satisfaga individualmente `cell.repOK()`, sino que si `cell.isEmpty()` es verdadero, la referencia en la matriz sea exactamente la referencia canónica:
```java
if (grid[row][column].isEmpty() && grid[row][column] != Cell.EMPTY) {
    return false; // Violación de unicidad de instancia vacía
}
```
Esto refuerza la integridad del invariante de representación de todo el sistema.

---

## 7. Catálogo de Hallazgos y Defectos de Diseño Descubiertos en `Board` (Actionable Findings & Fixes)

A partir de la inferencia dinámica de invariantes realizada con Daikon sobre la clase `Board`, se detectaron defectos concretos de diseño, bugs latentes y violaciones de encapsulamiento que deben ser corregidos para robustecer el sistema:

---

### Hallazgo 1 (Crítico): Aliasing de objeto mutable `score` y generador `random` en constructor de copia
- **Evidencia en Daikon:**
  ```text
  ar.edu.unrc.game2048.Board.Board(ar.edu.unrc.game2048.Board):::EXIT
  this.score == other.score
  this.score == orig(other.score)
  this.random == other.random
  this.random == orig(other.random)
  ```
- **Diagnóstico del problema:**
  El constructor de copia declara realizar una copia profunda (*deep copy*), pero asigna por referencia directa los objetos `score` y `random`:
  ```java
  this.score = other.score;
  this.random = other.random;
  ```
  Como `Score` es mutable (`increaseScore`, `setScore`), ambas instancias de `Board` comparten la misma referencia en memoria. Esto introduce un bug directo en el método `move()`:
  ```java
  Board previous = new Board(this);
  Move move = moveProvider.provide(direction);
  move.execute(this, grid, score); // Al mutar score, también muta previous.score
  boolean moved = !this.equals(previous);
  ```
  Al evaluar `this.equals(previous)`, los puntajes siempre coinciden (`score.getScore() == board.score.getScore()`), perdiendo la independencia requerida.
- **Fix propuesto en `Board.java` (Constructor de copia):**
  ```java
  // Reemplazar:
  // this.score = other.score;
  // this.random = other.random;

  // Por copias e instancias independientes:
  this.score = new Score(other.score.getScore());
  this.random = new java.util.Random();
  ```

---

### Hallazgo 2: Campo inerte / código muerto (`emptyCells`)
- **Evidencia en Daikon:**
  ```text
  ar.edu.unrc.game2048.Board:::OBJECT
  this.emptyCells == null
  ```
- **Diagnóstico del problema:**
  Daikon infirió que `emptyCells` permanece en `null` durante todo el ciclo de vida de cualquier tablero. En `Board.java:47` se encuentra declarado:
  ```java
  private List<Position> emptyCells;
  ```
  Dicho atributo nunca se inicializa en ningún constructor ni se actualiza durante los movimientos. El método `getEmptyPositions()` calcula las posiciones vacías instanciando un `HashSet<Position>()` local en cada invocación, dejando a `emptyCells` como código muerto.
- **Fix propuesto en `Board.java`:**
  Eliminar la declaración de la línea 47:
  ```java
  // Eliminar:
  // private List<Position> emptyCells;
  ```

---

### Hallazgo 3: Fuga de encapsulamiento / Escape de representación mutable en `getGrid()`
- **Evidencia en Daikon:**
  ```text
  ar.edu.unrc.game2048.Board.getGrid():::EXIT
  return == this.grid
  ```
- **Diagnóstico del problema:**
  `getGrid()` retorna la referencia directa a la matriz interna (`Cell[][]`). Esto permite a cualquier llamador externo mutar directamente el arreglo bidimensional (`board.getGrid()[0][0] = new Cell(-1)`), eludiendo todas las validaciones de `Board` y violando los contratos de `repOK()`.
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

### Hallazgo 4: Ausencia de validación defensiva en `setScore(int value)`
- **Evidencia en Daikon:**
  ```text
  ar.edu.unrc.game2048.Board.setScore(int):::ENTER
  value >= 0
  ```
- **Diagnóstico del problema:**
  Daikon descubrió que en partidas válidas el puntaje siempre es no negativo. Sin embargo, `Board.java:373` carece de guarda defensiva:
  ```java
  public void setScore(int value) { score.setScore(value); }
  ```
  Invocaciones con valores negativos (e.g. `board.setScore(-100)`) corrompen el estado del juego sin arrojar excepción.
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

### Hallazgo 5: Ausencia de validación defensiva explícita de límites en `getCell` y `setCell`
- **Evidencia en Daikon:**
  ```text
  ar.edu.unrc.game2048.Board.getCell(int, int):::ENTER
  ar.edu.unrc.game2048.Board.setCell(int, int, Cell):::ENTER
  0 <= row < size(this.grid[]) && 0 <= col < size(this.grid[])
  ```
- **Diagnóstico del problema:**
  Aunque el Javadoc de ambos métodos documenta `@throws IndexOutOfBoundsException`, la implementación delega directamente en la indexación de arreglos crudos de Java, lanzando `ArrayIndexOutOfBoundsException` no encapsulada y sin mensajes descriptivos de error.
- **Fix propuesto en `Board.java`:**
  ```java
  public Cell getCell(int row, int col) {
      if (row < 0 || row >= size || col < 0 || col >= size) {
          throw new IndexOutOfBoundsException("Coordinates out of bounds: (" + row + ", " + col + ")");
      }
      return grid[row][col];
  }

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

