### 3.2 Evaluate the Invariants

Análisis y clasificación de las invariantes dinámicas inferidas por Daikon sobre `Cell.java` a partir de la ejecución de tests.

---

#### 1. Invariante de Clase y Constructor (`Cell`)

```text
Cell:::OBJECT
  this.value >= 0
  this.value >= Cell.EMPTY.value

Cell.Cell(int):::ENTER
  value >= 0

Cell.Cell(int):::EXIT
  this.value == orig(value)
```

- **Clasificación:**
  - `this.value >= 0` (OBJECT / ENTER): **Correct and useful**. Refleja una propiedad genuina del invariante de representación (`repOK()`). Atraparía valores negativos si fallara la guarda del constructor.
  - `this.value >= Cell.EMPTY.value`: **Correct but trivial**. Redundante con `value >= 0` dado que `EMPTY.value == 0`.
  - `this.value == orig(value)`: **Correct and useful**. Garantiza la correcta inicialización del atributo inmutable.
- **Comparación con `repOK()`:** Daikon redescubrió `value >= 0`, pero omitió que el valor debe ser potencia de 2 (`Integer.bitCount(value) == 1`) por falta de plantillas lógicas a nivel de bits.
- **¿Demasiado fuerte?:** No, no acota a conjuntos espurios en este punto.
- **Qué faltaría reforzar:** Tests que esperen `IllegalArgumentException` ante entradas inválidas (números negativos y positivos que no sean potencia de 2: `3, 5, 6`).

---

#### 2. Método `canMergeWith(Cell other)`

```text
Cell.canMergeWith(Cell):::ENTER
  this.value one of { 0, 1, 2 }
  other != null
  other.value >= 0

Cell.canMergeWith(Cell):::EXIT82
  this.value one of { 0, 1 }
  other.value one of { 0, 1 }
  return == false

Cell.canMergeWith(Cell):::EXIT
  this.value == orig(this.value)
  other.value == orig(other.value)
  (other.value == 2)  <==>  (return == true)
  (other.value one of { 0, 1, 4 })  <==>  (return == false)

Cell.canMergeWith(Cell):::EXIT;condition="not(return == true)"
  other.value one of { 0, 1, 4 }
  return == false
```

- **Clasificación:**
  - `this.value == orig(this.value)` y `other.value == orig(other.value)`: **Correct and useful**. Demuestra que es una función pura e inmutable; atraparía mutaciones colaterales.
  - `other != null`: **Correct and useful**. Precondición genuina del contrato.
  - `this.value one of { 0, 1, 2 }` (ENTER): **Too strong / likely spurious**. Artefacto de los inputs ejecutados.
    - *Contraejemplo:* `new Cell(4).canMergeWith(new Cell(4))` es una llamada válida.
  - `(other.value == 2) <=> (return == true)`: **Too strong / likely spurious**. 
    - *Contraejemplo:* Mergear dos celdas con valor `4` devuelve `true` con `other.value == 4`.
  - `other.value one of { 0, 1, 4 } <=> return == false`: **Too strong / likely spurious**. Falso indicio: si ambas celdas valen `4`, no retorna `false`.
- **Qué faltaría reforzar:** Tests de merges válidos con valores más altos (`4` con `4`, `8` con `8`, `16` con `16`) y merges inválidos entre potencias distintas (`2` con `4`, `4` con `8`) o con `Cell.EMPTY`.

---

#### 3. Método `equals(Object o)`

```text
Cell.equals(Object):::ENTER
  this.value one of { 0, 1, 4 }

Cell.equals(Object):::EXIT115
  orig(this) == orig(o)
  this.value one of { 0, 4 }
  return == true

Cell.equals(Object):::EXIT118
  this.value one of { 0, 4 }
  return == true

Cell.equals(Object):::EXIT119
  this.value one of { 1, 4 }
  return == false

Cell.equals(Object):::EXIT
  this.value == orig(this.value)
  (return == true)  ==>  (this.value one of { 0, 4 })
  (return == false) ==>  (this.value one of { 0, 1, 4 })
```

- **Clasificación:**
  - `this.value == orig(this.value)`: **Correct but trivial** (método observador).
  - `orig(this) == orig(o) ==> return == true` (EXIT115): **Correct and useful** (reflexividad de equals).
  - Restricciones a `{ 0, 1, 4 }` en ENTER y salidas: **Too strong / likely spurious**. Artefacto estricto por falta de variedad en los tests.
    - *Contraejemplo igualdad:* `new Cell(8).equals(new Cell(8))` -> `return == true` con valor fuera de `{0, 4}`.
    - *Contraejemplo desigualdad:* `new Cell(8).equals(new Cell(4))` o `new Cell(16).equals(new Cell(2))` -> `return == false` con valores fuera de `{1, 4}`.
- **Qué faltaría reforzar:** Comparar celdas iguales con otros valores (`2==2`, `8==8`, `16==16`), pares dispares no probados (`2` vs `4`, `8` vs `16`), `equals(null)` y `equals` contra objetos de otro tipo.

---

#### 4. Método `getValue()`

```text
Cell.getValue():::ENTER
  this.value one of { 0, 1 }

Cell.getValue():::EXIT
  return == orig(this.value)
  this.value == return
  return one of { 0, 1 }
```

- **Clasificación:**
  - `this.value == return` y `return == orig(this.value)`: **Correct and useful**. Garantiza el contrato del getter sin efectos secundarios.
  - `this.value one of { 0, 1 }` / `return one of { 0, 1 }`: **Too strong / likely spurious**.
    - *Contraejemplo:* `new Cell(8).getValue()` retorna `8`.
- **Qué faltaría reforzar:** Invocar `getValue()` sobre celdas con valores típicos del juego (`2, 4, 8, 16, 2048`).

---

#### 5. Método `hashCode()`

```text
Cell.hashCode():::ENTER
  this.value one of { 4, 8 }

Cell.hashCode():::EXIT
  this.value == orig(this.value)
  this.value one of { 4, 8 }
  return one of { 35, 39 }
```

- **Clasificación:**
  - `this.value == orig(this.value)`: **Correct but trivial**.
  - `return one of { 35, 39 }`: **Too strong / likely spurious**. Artefacto total debido a que solo se llamó `hashCode()` sobre celdas de valor 4 (`hash=35`) y 8 (`hash=39`).
    - *Contraejemplo:* `new Cell(2).hashCode()` produce `33`.
- **Qué faltaría reforzar:** Evaluar `hashCode()` sobre `Cell.EMPTY`, `2`, `16` y verificar el contrato `c1.equals(c2) ==> c1.hashCode() == c2.hashCode()`.

---

#### 6. Método `isEmpty()`

```text
Cell.isEmpty():::EXIT53
  this.value == 0
  this.value == Cell.EMPTY.value
  return == true

Cell.isEmpty():::EXIT54
  this.value one of { 1, 2, 4 }
  this.value > Cell.EMPTY.value
  return == false

Cell.isEmpty():::EXIT
  (this.value == 0)  <==>  (return == true)
  (this.value one of { 1, 2, 4 })  <==>  (return == false)
```

- **Clasificación:**
  - `(this.value == 0) <=> (return == true)`: **Correct and useful**. Captura la postcondición exacta y completa del método.
  - `this.value > Cell.EMPTY.value ==> return == false`: **Correct and useful**.
  - `this.value one of { 1, 2, 4 }`: **Too strong / likely spurious**.
    - *Contraejemplo:* `new Cell(8).isEmpty()` devuelve `false` con `value = 8`.
- **Qué faltaría reforzar:** Invocar `isEmpty()` con celdas de valores mayores (`8, 16, 32, 2048`) para generalizar la postcondición de falsedad a todo `value > 0`.

---

#### 7. Método `mergeWith(Cell other)`

```text
Cell.mergeWith(Cell):::ENTER
  this.value == other.value
  this.value == 2
  other.value == 2

Cell.mergeWith(Cell):::EXIT
  this.value == orig(this.value)
  this.value == 2
  return.value == 4
```

- **Clasificación:**
  - `this.value == other.value` (ENTER): **Correct and useful**. Precondición indispensable requerida por `canMergeWith`.
  - `this.value == orig(this.value)`: **Correct and useful**. Garantiza inmutabilidad (produce una nueva celda sin modificar la receptora).
  - `this.value == 2` y `return.value == 4`: **Too strong / likely spurious**. Sobreajuste severo: solo se probó mergear celdas de valor 2.
    - *Contraejemplo:* `new Cell(4).mergeWith(new Cell(4))` retorna una celda con valor `8`.
- **Postcondición esperada no inferida:** `return.value == orig(this.value) * 2`.
- **Qué faltaría reforzar:** Merges exitosos con otros valores (`4+4 -> 8`, `8+8 -> 16`, `1024+1024 -> 2048`) y tests de excepciones cuando `other == null` o `!canMergeWith(other)`.

---

#### 8. Método `repOK()`

```text
Cell.repOK():::ENTER
  this.value one of { 0, 2, 2048 }

Cell.repOK():::EXIT
  this.value == orig(this.value)
  this.value one of { 0, 2, 2048 }
  return == true
```

- **Clasificación:**
  - `return == true`: **Correct and useful**. Para cualquier instancia legítima construida, el invariante se preserva.
  - `this.value == orig(this.value)`: **Correct but trivial** (método puro de verificación).
  - `this.value one of { 0, 2, 2048 }`: **Too strong / likely spurious**.
    - *Contraejemplo:* `new Cell(4).repOK()` o `new Cell(8).repOK()` retornan `true`.
- **Qué faltaría reforzar:** Evaluar `repOK()` sobre instancias con las restantes potencias de dos (`4, 8, 16, 32, 64, 128, 256, 512, 1024`).

---

#### 9. Método `toString()`

```text
Cell.toString():::EXIT
  this.value == orig(this.value)
  return != null
```

- **Clasificación:**
  - `return != null` y `this.value == orig(this.value)`: **Correct but trivial**. Daikon solo infiere que no devuelve nulo y no muta el objeto, pero no captura la relación con el formato (`"."` si es vacía, o el número en String).
- **Qué faltaría reforzar:** Tests unitarios específicos que aserten `Cell.EMPTY.toString().equals(".")` y `new Cell(4).toString().equals("4")`.
