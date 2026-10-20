### 3.2 Evaluación de Invariantes de `Cell`

> **Nota metodológica sobre la recolección de trazas:**
> En una primera etapa se ejecutó Daikon únicamente sobre la suite unitaria aislada `Cell` (incluyendo test de randoop, evosuite, y manuales). Sin embargo, esto generó un sobreajuste severo e invariantes espurias (como acotar falsamente valores válidos a simples conjuntos `{0, 1, 2}` o `{1, 2, 4}`) debido a la limitada variedad de jugadas y combinaciones de las pruebas unitarias.
> 
> El mejor resultado y las invariantes más representativas del dominio se obtuvieron al ejecutar Daikon sobre la suite integral `BoardTest`: al simular partidas reales completas (inicialización de tableros, desplazamientos en las cuatro direcciones, fusiones continuas y apariciones aleatorias de fichas), la clase `Cell` fue probada exhaustivamente en todo su flujo natural. Esto eliminó las invariantes erróneas y permitió a Daikon redescubrir reglas genuinas del juego (como que las fichas activas son potencias de dos, la condición universal de fusión, la generalización de los getters y el patrón Singleton).
> 
> A continuación se presentan las invariantes definitivas obtenidas, su clasificación y análisis:

---

#### 1. Invariante de Clase y Objeto (`Cell:::CLASS` y `Cell:::OBJECT`)

```text
Cell:::CLASS
  Cell.EMPTY has only one value
  Cell.EMPTY != null
  Cell.EMPTY.value == 0

Cell:::OBJECT
  this.value >= 0
  this.value >= Cell.EMPTY.value
```

- **Clasificación:**
  - `Cell.EMPTY != null` y `Cell.EMPTY.value == 0`: **Correct and useful**. Identifica formalmente la constante centinela y su valor representativo.
  - `this.value >= 0` y `this.value >= Cell.EMPTY.value`: **Correct and useful**. Garantiza el invariante de representación: ninguna celda activa o vacía toma valores negativos.
- **Comparación con `repOK()`:** Refleja la condición de no-negatividad (`value >= 0`). Daikon no infiere `is a power of 2` en este punto de programa global porque `Cell.EMPTY` (con valor `0`) es una celda válida del sistema y matemáticamente el `0` no es potencia de dos.

---

#### 2. Constructor `Cell.Cell(int)`

```text
Cell.Cell(int):::EXIT
  this.value == orig(value)
  Cell.EMPTY.value % this.value == 0
  this.value > Cell.EMPTY.value
```

- **Clasificación:**
  - `this.value == orig(value)`: **Correct and useful**. Garantiza la correcta inicialización del atributo inmutable.
  - `this.value > Cell.EMPTY.value` (`value > 0`): **Correct and useful en contexto de juego**. En las partidas y tests de tablero, nunca se construyen celdas explícitas con valor `0` (ya que se utiliza la referencia canónica `Cell.EMPTY`). Daikon reconoce que toda celda instanciada durante la partida representa una ficha activa con valor positivo.

---

#### 3. Método `canMergeWith(Cell other)`

```text
Cell.canMergeWith(Cell):::ENTER
  this.value >= 2
  this.value is a power of 2
  other != null
  other.value >= 2
  other.value is a power of 2
  this.value > Cell.EMPTY.value
  Cell.EMPTY.value < other.value

Cell.canMergeWith(Cell):::EXIT
  this.value == orig(this.value)
  other.value == orig(other.value)
  (return == false)  <==>  (this.value != other.value)
  this.value >= 2
  this.value is a power of 2
  other.value >= 2
  other.value is a power of 2
```

- **Clasificación:** **Correct and useful**.
- **Impacto del testeo integral:** 
  - En las pruebas aisladas, Daikon sobreajustaba la entrada al conjunto espurio `{0, 1, 2}`.
  - Al ejercitar el tablero completo, Daikon descubrió que las celdas a fusionar son necesariamente potencias de 2 mayores o iguales a 2 (**`this.value is a power of 2`**, **`other.value is a power of 2`**) y dedujo la regla lógica canónica del 2048: dos fichas activas no pueden fusionarse si y solo si sus valores son distintos (**`(return == false) <==> (this.value != other.value)`**).
  - Comprueba además la inmutabilidad de ambas instancias (`this.value == orig(this.value)` y `other.value == orig(other.value)`).

---

#### 4. Método `getValue()`

```text
Cell.getValue():::EXIT
  this.value == return
  return == orig(this.value)
  return >= 0
  Cell.EMPTY.value <= return
```

- **Clasificación:** **Correct and useful**.
- **Impacto del testeo integral:** 
  - En la prueba unitaria aislada, Daikon acotaba `return one of { 0, 1 }` (un sobreajuste arbitrario por falta de variedad de tests).
  - Al probar con partidas de tablero donde las fichas van aumentando de valor, Daikon generalizó a **`return >= 0`** y **`return == orig(this.value)`**, deduciendo el contrato completo del getter observador sin efectos secundarios.

---

#### 5. Método `isEmpty()`

```text
Cell.isEmpty():::EXIT53  // rama return == true
  this.value == 0
  this.value == Cell.EMPTY.value
  Cell.EMPTY == orig(this)
  return == true

Cell.isEmpty():::EXIT54  // rama return == false
  this.value >= 2
  this.value is a power of 2
  this.value > Cell.EMPTY.value
  return == false

Cell.isEmpty():::EXIT    // salida general
  this.value == orig(this.value)
  (this.value == 0)  <==>  (return == true)
  (this.value == 0)  <==>  (this.value == Cell.EMPTY.value)
  (this.value == 0)  ==>   (Cell.EMPTY == orig(this))
```

- **Clasificación:** **Correct and useful**.
- **Impacto del testeo integral:** 
  - Eliminó la limitación espuria de la prueba unitaria que acotaba las celdas no vacías a `{1, 2, 4}`.
  - Daikon infiere que cuando `return == false`, **`this.value >= 2`** y **`this.value is a power of 2`**.
  - Deduce la equivalencia exacta **`(this.value == 0) <==> (return == true)`**.
  - Descubre la propiedad del patrón **Singleton**: **`(this.value == 0) ==> (Cell.EMPTY == orig(this))`**, comprobando que toda celda vacía observada en el tablero es exactamente la referencia canónica `Cell.EMPTY`.

---

#### 6. Método `mergeWith(Cell other)`

```text
Cell.mergeWith(Cell):::ENTER
  this.value == other.value
  this.value == 2

Cell.mergeWith(Cell):::EXIT
  this.value == other.value
  this.value == orig(this.value)
  other.value == orig(other.value)
  this.value == 2
  return.value == 4
```

- **Clasificación:**
  - `this.value == other.value` (ENTER): **Correct and useful**. Precondición indispensable requerida para fusionar.
  - Inmutabilidad de operandos (`this.value == orig(this.value)` y `other.value == orig(other.value)`): **Correct and useful**.
  - `this.value == 2` y `return.value == 4`: **Too strong / likely spurious**. En la traza capturada sólo se registraron fusiones directas de $2 + 2 \rightarrow 4$. Falta generalizar a la postcondición funcional esperada: `return.value == orig(this.value) * 2`.

---

#### 7. Método `equals(Object o)`

```text
Cell.equals(Object):::ENTER
  this.value one of { 0, 4 }
  o.getClass().getName() == Cell.class

Cell.equals(Object):::EXIT
  this.value == orig(this.value)
  (return == true)  ==> (this.value == 4)
  (return == false) ==> (this.value one of { 0, 4 })
```

- **Clasificación:**
  - `this.value == orig(this.value)` y `o.getClass().getName() == Cell.class`: **Correct and useful** (método puro que valida compatibilidad de tipos).
  - Restricción a `{ 0, 4 }`: **Too strong / likely spurious**. En `BoardTest`, `equals` fue invocado puntualmente en aserciones sobre tableros que utilizaban estos valores específicos.

---

#### 8. Método `hashCode()`

```text
Cell.hashCode():::ENTER
  this.value one of { 0, 2 }

Cell.hashCode():::EXIT
  this.value == orig(this.value)
  this.value one of { 0, 2 }
  return one of { 31, 33 }
  this.value < return
```

- **Clasificación:**
  - `this.value == orig(this.value)` y `this.value < return`: **Correct and useful** (pureza observacional y coherencia con la fórmula de hash `31 * 1 + value`).
  - Restricción a `{ 0, 2 }` y `{ 31, 33 }`: **Too strong / likely spurious**. Solo se calcularon hashes para celdas vacías (`0`) y fichas iniciales (`2`).

---

#### 9. Método `repOK()`

```text
Cell.repOK():::ENTER
  this == Cell.EMPTY
  this.value == 0

Cell.repOK():::EXIT
  this.value == 0
  return == true
```

- **Clasificación:**
  - `return == true`: **Correct and useful**. La verificación de invariante siempre tiene éxito en instancias construidas.
  - `this == Cell.EMPTY`: **Too strong / likely spurious**. En las pruebas de tablero, `Cell.repOK()` sólo se invocó de manera directa sobre la celda vacía por defecto.

---

#### 10. Método `toString()`

- **Clasificación:** En la ejecución de `BoardTest`, `Cell.toString()` no apareció registrado porque la clase `Board` formatea su representación visual recorriendo la matriz directamente, sin invocar `Cell.toString()`. En la evaluación unitaria previa se infería `return != null` y pureza del objeto (**Correct but trivial**).

---

### Resumen del Impacto: Test Unitario vs. Test Integral de Tablero

| Método | En `CellTest` (Aislado) | En `BoardTest` (Integral) | Mejora Obtenida |
|---|---|---|---|
| **`canMergeWith`** | Espurio: `value in {0, 1, 2}`, `(other.value==2) <=> (return==true)` | **`value is a power of 2`**, **`value >= 2`**, **`(return==false) <=> (value != other.value)`** | **Eliminó sobreajustes.** Descubrió que los valores son potencias de 2 y dedujo la regla formal de fusión del juego. |
| **`getValue`** | Espurio: `return in {0, 1}` | **`return >= 0`**, `return == orig(this.value)` | **Eliminó sobreajuste.** Generalizó la postcondición del getter a todo valor no negativo. |
| **`isEmpty`** | Espurio: `value in {1, 2, 4}` cuando es false | **`value is a power of 2`**, **`(value==0) <=> (return==true)`**, **`orig(this) == EMPTY`** | **Eliminó sobreajuste.** Estableció la relación bicondicional exacta y redescubrió el patrón **Singleton**. |
| **`Cell(int)`** | `value >= 0` | `this.value > EMPTY.value` (`value > 0`) | Refleja que en el tablero sólo se instancian celdas con fichas activas positivas. |
| **`Cell:::OBJECT`** | `value >= 0` | `value >= 0`, `EMPTY != null`, `EMPTY.value == 0` | Consolida la presencia del centinela inmutable `EMPTY`. |

---

### 3.3 Tests que aún faltaría agregar para completar la especificación

Habiendo comprobado que los tests integrales de `BoardTest` ya cubrieron con éxito la generalización de `canMergeWith(Cell)`, `getValue()` e `isEmpty()`, a continuación se detallan únicamente **los casos de prueba que todavía faltaría incorporar** para eliminar los sobreajustes residuales:

1. **`Cell.mergeWith(Cell other)` (Generalización de la duplicación):**
   - **Fusiones con potencias mayores:** Invocar `c1.mergeWith(c2)` para $4+4 \rightarrow 8$, $8+8 \rightarrow 16$, $1024+1024 \rightarrow 2048$, permitiendo a Daikon inferir la relación matemática `return.value == orig(this.value) * 2` en lugar de acotarse a $2+2 \rightarrow 4$.
   - **Tests de excepción:** Verificar que arroja `IllegalArgumentException` ante llamadas inválidas (`other == null` o celdas incompatibles como $2$ con $4$, o con `Cell.EMPTY`).

2. **`Cell.equals(Object o)` (Ampliación de dominio y robustez):**
   - **Igualdad con otras potencias:** Evaluar `c1.equals(c2)` con valores mayores ($8 == 8$, $16 == 16$, $2048 == 2048$).
   - **Desigualdad entre valores válidos:** Comparar fichas distintas ($2$ vs $4$, $8$ vs $16$) esperando `false` con valores fuera de `{0, 4}`.
   - **Casos de borde:** Evaluar `cell.equals(null)` y `cell.equals("String")` para verificar el manejo seguro ante tipos incompatibles y nulos sin excepciones.

3. **`Cell.hashCode()` (Distribución y consistencia):**
   - **Variedad de potencias:** Invocar `hashCode()` sobre celdas con valores superiores a 2 ($4, 8, 16, 2048$) e insertar celdas en estructuras de datos como `HashSet<Cell>` o `HashMap<Cell, ?>`.
   - **Consistencia con equals:** Asertar formalmente que si `c1.equals(c2)`, entonces `c1.hashCode() == c2.hashCode()`.

4. **`Cell.repOK()` (Verificación en celdas activas):**
   - **Invocación sobre fichas no vacías:** Invocar explícitamente `repOK()` sobre instancias con potencias de dos ($2, 4, 8, 16, \dots, 2048$) para que Daikon registre que `return == true` es un invariante universal para toda celda válida del juego, y no exclusivo de `Cell.EMPTY`.

5. **Constructor `Cell.Cell(int)` (Precondiciones negativas y excepciones):**
   - **Valores negativos:** Probar `new Cell(-1)` o `new Cell(-8)` esperando `IllegalArgumentException`.
   - **Valores positivos no potencia de 2:** Probar `new Cell(3)`, `new Cell(5)`, `new Cell(6)`, `new Cell(7)`, etc., esperando `IllegalArgumentException`. Esto permitirá a Daikon acotar con precisión la precondición del constructor ante entradas erróneas.

6. **`Cell.toString()` (Representación textual):**
   - **Aserciones directas:** Testear unitariamente `assertEquals(".", Cell.EMPTY.toString())` y `assertEquals("4", new Cell(4).toString())` para registrar el punto de programa ausente en la ejecución del tablero y constatar la relación entre `value` y `return`.
