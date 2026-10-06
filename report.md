# Reporte de Análisis de Cobertura y Generación Automática de Pruebas

## 1. Introducción y objetivo

Este reporte evalúa la calidad de la suite de pruebas del proyecto `game2048`,
comparando cuatro enfoques: las pruebas escritas manualmente (Assignment 1),
las generadas automáticamente con **Randoop** (Assignment 2), las generadas
con **EvoSuite** (Assignment 3), y un **fuzzer** sobre la interfaz de línea
de comandos del juego (Assignment 3). Se analizan cobertura de código,
cobertura de mutación, calidad/utilidad práctica de cada enfoque, y los bugs
reales encontrados por cada técnica.

## 2. Herramientas y metodología

| Herramienta | Propósito |
| :--- | :--- |
| **JaCoCo** | Cobertura de instrucciones, ramas y líneas |
| **PIT (mutación)** | Cobertura de mutación y fuerza de las pruebas |
| **Randoop** | Generación de pruebas por exploración aleatoria dirigida por feedback, sobre `Cell` y `Board` |
| **EvoSuite** | Generación de pruebas por búsqueda evolutiva (algoritmos genéticos), sobre `Cell` y `Board` |
| **fuzzer.py** | Fuzzing de caja negra sobre la interfaz CLI (`MainCLI`), basado en *The Fuzzing Book* |

Cada suite se mide **por separado** (perfiles de Maven `manual-tests`,
`randoop-tests`, `evosuite-tests`), con su propio archivo de datos de
JaCoCo y su propia carpeta de reporte de PITest, para que los números de
una suite nunca se mezclen con los de otra.

**Nota metodológica:** durante la preparación de este reporte se detectaron
y corrigieron dos problemas de medición que invalidaban corridas anteriores:

1. El `jacoco.exec` no estaba parametrizado por perfil, por lo que corridas
   consecutivas sin `mvn clean` podían acumular datos de distintas suites en
   el mismo archivo. Se agregó un `destFile`/`dataFile` propio por perfil.
2. Las pruebas generadas por EvoSuite usan `separateClassLoader = true` por
   defecto en su scaffolding, lo cual hace que JaCoCo (y PITest) midan 0% de
   cobertura, porque cargan la clase bajo prueba con un classloader distinto
   al que fue instrumentado. Se corrigió seteando `separateClassLoader =
   false` en los archivos generados.

Los números de este reporte corresponden a corridas posteriores a ambas
correcciones, y por lo tanto son los representativos del estado final del
proyecto.

## 3. Resultados

### 3.1 Pruebas manuales

**JaCoCo:**

| Paquete | Instrucciones | Ramas | Líneas |
| :--- | ---: | ---: | ---: |
| `ar.edu.unrc.game2048` | 95.6% (1123/1175) | 87.4% (146/167) | 94.5% (208/220) |
| `ar.edu.unrc.game2048.strategy` | 100.0% (371/371) | 100.0% (30/30) | 100.0% (76/76) |
| **Total** | **96.6% (1494/1546)** | **89.3% (176/197)** | **95.9% (284/296)** |

**PITest:**

| Clases | Cobertura de líneas | Cobertura de mutación | Fuerza de las pruebas |
| :---: | :---: | :---: | :---: |
| 11 | 96% (282/294) | 96% (246/255) | 98% (246/250) |

### 3.2 Pruebas generadas con Randoop

**JaCoCo:**

| Paquete | Instrucciones | Ramas | Líneas |
| :--- | ---: | ---: | ---: |
| `ar.edu.unrc.game2048` | 50.6% (595/1175) | 46.7% (78/167) | 49.1% (108/220) |
| `ar.edu.unrc.game2048.strategy` | 86.8% (322/371) | 80.0% (24/30) | 89.5% (68/76) |
| **Total** | **59.3% (917/1546)** | **51.8% (102/197)** | **59.5% (176/296)** |

**PITest:**

| Clases | Cobertura de líneas | Cobertura de mutación | Fuerza de las pruebas |
| :---: | :---: | :---: | :---: |
| 11 | 59% (174/294) | 42% (108/255) | 76% (108/143) |

La cobertura de Randoop es notablemente más baja que la de manual y
EvoSuite. Esto es esperable y no indica que Randoop sea "peor": `Cell` y
`Board` fueron las únicas clases usadas como `--testclass`, así que Randoop
nunca ejercita `MainCLI` ni las clases de `strategy/` a través del flujo
completo del juego — solo lo que alcanza a cubrir indirectamente al llamar
métodos de `Board` (que sí usa `MoveProvider`/`Move` internamente, de ahí el
86.8% en `strategy` pese a no haber sido el target).

### 3.3 Pruebas generadas con EvoSuite

**JaCoCo:**

| Paquete | Instrucciones | Ramas | Líneas |
| :--- | ---: | ---: | ---: |
| `ar.edu.unrc.game2048` | 82.2% (966/1175) | 80.2% (134/167) | 73.6% (162/220) |
| `ar.edu.unrc.game2048.strategy` | 88.4% (328/371) | 83.3% (25/30) | 86.8% (66/76) |
| **Total** | **83.7% (1294/1546)** | **80.7% (159/197)** | **77.0% (228/296)** |

**PITest:**

| Clases | Cobertura de líneas | Cobertura de mutación | Fuerza de las pruebas |
| :---: | :---: | :---: | :---: |
| 11 | 81% (238/294) | 77% (197/255) | 88% (197/225) |

Igual que con Randoop, EvoSuite solo targeteó `Cell` y `Board`
(`SEARCH_BUDGET=60` segundos por clase), así que la cobertura de
`strategy/` y de partes de `MainCLI` viene exclusivamente de uso indirecto,
no de un targeting explícito.

### 3.4 Comparación general

| Métrica | Manual | Randoop | EvoSuite |
| :--- | :---: | :---: | :---: |
| Cobertura de líneas (JaCoCo) | 95.9% | 59.5% | 77.0% |
| Cobertura de ramas (JaCoCo) | 89.3% | 51.8% | 80.7% |
| Cobertura de líneas (PIT) | 96% | 59% | 81% |
| Cobertura de mutación (PIT) | 96% | 42% | 77% |
| Fuerza de las pruebas (PIT) | 98% | 76% | 88% |

Las pruebas manuales siguen siendo las más efectivas en todas las métricas,
lo cual tiene sentido: fueron escritas con conocimiento completo de las
reglas del juego y cubren el flujo end-to-end (`MainCLI` incluido). Entre
las dos técnicas automáticas, **EvoSuite superó claramente a Randoop** en
este proyecto — ver la comparación detallada en la sección 5.

## 4. Análisis cualitativo de las pruebas generadas

### EvoSuite

Las aserciones de EvoSuite se generan a partir del comportamiento observado
durante la ejecución, no de las reglas del dominio:

- Muchas aserciones verifican constantes, estados internos o valores
  concretos que no representan reglas funcionales del juego.
- Como la herramienta no conoce las reglas del juego, si el código tiene un
  error, asume que ese es el comportamiento correcto y genera una prueba que
  lo preserva (regresión, no corrección).

Según la complejidad de la clase:

- **`Cell` (clase simple):** tests legibles y directos, manejan
  principalmente `int`. Podrían pasar por pruebas manuales.
- **`Board` (clase compleja):** tests largos e intrincados, difíciles de
  leer y costosos de mantener. Entender por qué falló un test automático
  puede llevar más tiempo que escribirlo a mano.

### Randoop

Las pruebas de regresión de Randoop tienen el mismo problema de fondo que
las de EvoSuite (capturan el comportamiento actual como "correcto", sin
noción de si es deseable), pero con una diferencia importante: Randoop
permite conectar explícitamente los invariantes (`repOK()` vía `@CheckRep`)
como oráculo adicional durante la generación — no solo después. Esto lo
convierte en una herramienta más dirigida a encontrar violaciones de
contratos e invariantes internos (ver sección 5), mientras que EvoSuite está
más orientado a maximizar cobertura de ramas.

Las secuencias que genera Randoop también tienden a ser más cortas y
atómicas (llamadas directas a métodos encadenadas) que los tests de
EvoSuite, lo que las hace, en general, más legibles para `Cell`, pero igual
de densas que las de EvoSuite para `Board` cuando la secuencia involucra
muchas llamadas intermedias.

## 5. Comparación EvoSuite vs Randoop

| Aspecto | Randoop | EvoSuite |
| :--- | :--- | :--- |
| Estrategia de búsqueda | Exploración aleatoria dirigida por feedback (forward generation) | Algoritmo genético (búsqueda evolutiva) |
| Objetivo que optimiza | Generar secuencias válidas y diversas | Maximizar cobertura de ramas / otros criterios |
| Oráculo | Regresión + contrato `equals`/`hashCode` automático + `repOK()` si se conecta vía `@CheckRep` | Regresión (comportamiento observado) |
| Cobertura lograda (este proyecto) | 59.5% líneas | 77.0% líneas |
| Mutación lograda (este proyecto) | 42% | 77% |
| Legibilidad de los tests | Alta para clases simples, media para `Board` | Alta para clases simples, baja para `Board` |
| Mayor fortaleza | Encontrar violaciones de invariantes y contratos (null-safety, `equals`/`hashCode`, `repOK()`) | Maximizar cobertura con poco esfuerzo de configuración |
| Mayor debilidad | Cobertura más baja si no se itera (budget corto, sin guiar hacia ramas específicas) | Tests frágiles y poco legibles en clases complejas; sensible al `SEARCH_BUDGET` |

En este proyecto, **EvoSuite logró mayor cobertura y mutation score**, pero
**Randoop encontró bugs más profundos y variados** (ver sección 6) gracias a
la combinación con `repOK()` y su chequeo automático del contrato
`equals`/`hashCode`. Son técnicas complementarias: EvoSuite es más efectivo
para "llenar huecos" de cobertura rápidamente; Randoop es más efectivo para
cazar violaciones de invariantes cuando se lo conecta con oráculos
explícitos del dominio.

## 6. Hallazgos — bugs encontrados por técnica

### Randoop

| # | Bug | Input mínimo reproducible |
| :-: | :--- | :--- |
| 1 | `Cell`: el constructor permitía valores que no son potencia de 2, violando el invariante documentado | `new Cell(10)` → `repOK()` devuelve `false` |
| 2 | `Cell.canMergeWith` / `mergeWith`: `NullPointerException` sin controlar | `cell.canMergeWith(null)` |
| 3 | `Board`: violación del contrato `equals`/`hashCode` — `hashCode()` hasheaba el objeto `Score` en vez de `score.getScore()` | Dos `Board` con mismo puntaje pero distinta instancia de `Score`: `a.equals(b) == true` pero `a.hashCode() != b.hashCode()` |
| 4 | `Board(Board other)` (copy constructor): `NullPointerException` sin controlar | `new Board(null)` |
| 5 | `Board.move(direction)`: `NullPointerException` si `moveProvider` (campo entonces público) se asignaba `null` directamente | `board.moveProvider = null; board.move(Direction.UP);` |
| 6 | `Board.move(direction)`: `NullPointerException` si `direction == null` | `board.move(null)` |
| 7 | `Board`: regression suite no-determinista (flaky) por `Random` sin semilla en los constructores públicos | Cualquier secuencia que cree `Board` vía `new Board(int, boolean)` |

Todos corregidos durante Assignment 2/3 (validaciones explícitas de `null`,
fix del `hashCode()`, factory `Board.forTesting()` + exclusión de
constructores no-deterministas vía `--omit-methods`).

### EvoSuite

- **Puntuaciones negativas:** el sistema permite registrar valores menores
  que cero vía `setScore`.
- **Posiciones inválidas:** algunas operaciones aceptan índices fuera de
  rango sin una validación explícita propia (más allá de la excepción nativa
  de Java al acceder al array).

### Fuzzer

**0 bugs encontrados**, tanto en la corrida básica (20/20 `PASS`) como en la
corrida con `-ea` + `assert repOK()` (20/20 `PASS`). Ver sección 7 para la
interpretación de este resultado.

## 7. El fuzzer

### Cómo funciona

`fuzzer.py` sigue la estructura de *The Fuzzing Book*: una clase `Runner`
(`CLIRunner`) que envuelve el programa bajo prueba, y una clase `Fuzzer`
(`RandomFuzzer`) responsable de generar los inputs.

- **`RandomFuzzer.fuzz()`** (implementado para este trabajo): genera una
  secuencia aleatoria de entre 10 y 50 teclas de movimiento (`a`/`s`/`w`/`d`,
  elegidas con igual probabilidad), una por línea, terminada en `q\n` para
  salir del programa de forma prolija.
- **`CLIRunner.run()`** manda ese input por `stdin` a
  `java -cp ./target/classes ar.edu.unrc.game2048.MainCLI` (agregando `-ea`
  en la variante potenciada), con timeout de 10 segundos, y clasifica el
  resultado como `PASS`, `FAIL` (código de salida ≠ 0 o contenido en
  `stderr`) o `UNRESOLVED` (timeout).
- `main()` corre 20 trials y muestra un resumen al final.

### Resultados

| Corrida | PASS | FAIL | UNRESOLVED |
| :--- | :---: | :---: | :---: |
| Básica (sin `-ea`) | 20/20 | 0 | 0 |
| Con `-ea` + `assert repOK()` en `MainCLI` tras cada `move()` | 20/20 | 0 | 0 |

### Comparación con EvoSuite y Randoop

El fuzzer ataca el programa por una vía completamente distinta — la
interfaz externa (stdin del CLI) en vez de llamadas directas a métodos — y,
a diferencia de Randoop y EvoSuite, **no tiene ningún conocimiento de la
estructura interna del código** (es fuzzing de caja negra puro). Por eso su
"hit rate" para encontrar bugs es más bajo en términos relativos: genera
muchas menos variantes por segundo de ejecución, y con un alfabeto reducido
(`a`/`s`/`w`/`d`/`q`) nunca prueba inputs verdaderamente "sucios" (texto
arbitrario, EOF prematuro, caracteres de control).

Que el fuzzer no haya encontrado nada **no es un resultado vacío**: es una
segunda confirmación, independiente y por un camino distinto, de que el
invariante `repOK()` de `Board` se sostiene — consistente con que Randoop ya
lo había validado exhaustivamente (miles de secuencias, 0 violaciones)
después de los fixes de la sección 6.

## 8. Reflexión final: ¿qué técnica fue más efectiva?

No hay una única "ganadora" — cada técnica fue más efectiva para un
propósito distinto:

- **Pruebas manuales:** las más efectivas en cobertura y mutación en
  términos absolutos, porque incorporan conocimiento del dominio que
  ninguna herramienta automática tiene. Costo: tiempo de escritura y
  mantenimiento manual.
- **Randoop:** la más efectiva para **encontrar bugs de invariantes y
  contratos** (`equals`/`hashCode`, null-safety, `repOK()`) — justamente
  porque permite conectar oráculos explícitos del dominio durante la
  generación. Menos efectiva maximizando cobertura bruta con un budget
  corto.
- **EvoSuite:** la más efectiva para **maximizar cobertura rápidamente**
  con mínima configuración, a costa de tests poco legibles en clases
  complejas y bugs encontrados más superficiales (validación de rangos,
  más que invariantes internos).
- **Fuzzing:** la más efectiva para **validar robustez end-to-end** del
  flujo completo del programa tal como lo usaría un usuario real, aunque
  en este proyecto no encontró nada nuevo — lo cual en sí mismo es
  evidencia de la solidez del trabajo de validación previo con Randoop.

Para este proyecto puntual, **Randoop fue la técnica más valiosa en
relación al esfuerzo invertido**: encontró 7 bugs reales y accionables
(sección 6) con configuración mínima, varios de ellos no triviales
(violación de contrato `equals`/`hashCode`, flakiness por `Random` sin
semilla) que ni las pruebas manuales ni EvoSuite habían detectado.

## 9. Conclusiones

Las cuatro técnicas resultaron complementarias, no sustitutas entre sí:

1. Las pruebas manuales siguen siendo la base más sólida de la suite,
   porque son las únicas que verifican reglas del dominio de forma
   explícita.
2. Randoop, potenciado con `repOK()`, fue la herramienta más efectiva para
   **encontrar bugs reales** de robustez e invariantes internos.
3. EvoSuite es un buen complemento para **cerrar huecos de cobertura**
   rápidamente, aunque sus tests requieren revisión crítica antes de
   confiar en ellos como documentación del comportamiento esperado.
4. El fuzzer aporta una capa adicional de confianza end-to-end, barata de
   correr, aunque con menor poder de detección de bugs sutiles que las
   herramientas de generación de unit tests guiadas por invariantes.

Ninguna de las técnicas automáticas reemplaza el criterio humano: tanto
Randoop como EvoSuite pueden "aprender" un comportamiento incorrecto como si
fuera la especificación correcta si no se las combina con oráculos
explícitos del dominio (como `repOK()`) o con revisión manual de los
hallazgos.