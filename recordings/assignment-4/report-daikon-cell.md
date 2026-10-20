# Reporte Assignment 4: Inferencia Dinámica de Invariantes y Generación de Oráculos con Daikon

### 1.  Ejecución de Chicory (Instrumentación y Trace Collection)
A fin de recolectar un conjunto de trazas rico, diverso y representativo del comportamiento real del sistema, **la ejecución de Chicory no se realizó sobre una sola suite de pruebas aislada**, sino sobre un **conjunto combinado exhaustivo de `Board` y `Cell` que integró pruebas manuales, pruebas generadas por Randoop y pruebas generadas por EvoSuite**:

1. **Pruebas manuales:** `ar.edu.unrc.game2048.manual.BoardTest` y `ar.edu.unrc.game2048.manual.CellTest`
2. **Pruebas de Randoop:** `ar.edu.unrc.game2048.randoop.board.RegressionTest` y `ar.edu.unrc.game2048.randoop.cell.RegressionTest`
3. **Pruebas de EvoSuite:** `ar.edu.unrc.game2048.evosuite.Board_ESTest` y `ar.edu.unrc.game2048.evosuite.Cell_ESTest`

Se utilizó el script `run-daikon.sh`, restringiendo la instrumentación de Chicory a las clases del modelo (`Board` y `Cell`), omitiendo clases auxiliares como `Position`:

```bash
./run-daikon.sh \
    ar.edu.unrc.game2048.manual.BoardTest \
    ar.edu.unrc.game2048.manual.CellTest \
    ar.edu.unrc.game2048.randoop.board.RegressionTest \
    ar.edu.unrc.game2048.randoop.cell.RegressionTest \
    ar.edu.unrc.game2048.evosuite.Board_ESTest \
    ar.edu.unrc.game2048.evosuite.Cell_ESTest
```
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
  - *Significado en el dominio:* Daikon dedujo de forma autónoma la regla lógica formal del juego: dos fichas activas no pueden fusionarse si y solo si sus valores numéricos son distintos (lo que equivale a: la fusión es posible si y solo si sus valores son idénticos).
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
  - *Por qué es trivial:* Aunque es verdadera y obligatoria en el diseño de un tipo de dato inmutable, se limita a constatar el comportamiento estándar de lectura de un campo inmutable (`final int value`) sin añadir restricciones semánticas nuevas sobre el juego.

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
  - *Utilidad como oráculo:* Previene inconsistencias catastróficas de estado. Si un método redimensionara el tablero o inicializara incorrectamente la matriz, se lanzarían excepciones del tipo `ArrayIndexOutOfBoundsException` al recorrer las posiciones.
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
| **`Board`** | `Board.getSize:::EXIT` | `return == this.size` | **Correct but trivial** |
| **`Board`** | `Board.isFull:::EXIT` | `(return == true) ==> (this.determinist == false)` | **Too strong / likely spurious** |

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
| **Aserciones de EvoSuite** | Generadas mediante algoritmos genéticos optimizando cobertura de código | Muy alta cobertura de ramas y combinaciones complejas. | Tienden a sobreajustar estados circunstanciales; oráculos de estilo regresión difíciles de auditar. |
| **Invariantes de Daikon** | Inferidos analizando miles de valores a través de múltiples ejecuciones | Generalizan propiedades abstractas; revelan precondiciones y contratos lógicos bicondicionales. | Altamente dependientes de la diversidad de las trazas; susceptibles a invariantes espurias por sobreajuste. |

### Justificación: ¿Qué enfoque produjo los oráculos más útiles para este programa?

Para el proyecto *Reliable 2048*, **la combinación entre `repOK()` y los invariantes inferidos por Daikon** produjo los oráculos más valiosos y con mayor significado técnico:

1. **`repOK()`** proporcionó la barrera de seguridad estructural más sólida y reutilizable: garantizó en todo momento que ningún tablero contuviera matrices rectangulares inválidas, filas nulas o celdas con valores negativos o no permitidos.
2. **Daikon** aportó el mayor salto cualitativo en contratos de comportamiento: logró formular la regla lógica universal de fusión `(return == false) <=> (this.value != other.value)` y descubrir el patrón Singleton de `Cell.EMPTY`, propiedades que ni los tests manuales ni los generadores automáticos habían formalizado explícitamente.
3. En contraste, aunque Randoop y EvoSuite alcanzaron alta cobertura de código, sus oráculos son predominantemente de regresión superficial (asertar que un método arrojó un valor particular en una corrida), careciendo de la generalización conceptual que ofrecen los invariantes formales de Daikon.

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
