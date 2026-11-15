# Comandos de build y testing — reliable-2048
 
Referencia rápida de todos los comandos necesarios para compilar el proyecto
y correr cada tipo de test (manual, Randoop, EvoSuite), medir cobertura
(JaCoCo), mutantes (PITest), el fuzzer y la generación de invariantes con
Daikon.
 
## Requisitos previos
 
- **JDK 8** activo en la terminal (el proyecto compila a target 1.8, y
  EvoSuite específicamente requiere JDK 8 para correr).En este proyecto se utilizo java 8.0.504-amzn.
- Python 3 instalado, para el fuzzer (Fase 2 de Assignment 3).
- **JDK 11 hasta 21** activo solo para Daikon (Assignment 4): Daikon no corre con JDK 8.
  Además requiere `lib/daikon.jar` (Daikon 5.9.0).
---
 
## 1. Compilar el proyecto
 
```bash
mvn clean compile
```
 
---
 
## 2. Generar tests con Randoop
 
### Cell
 
```bash
java -cp "lib/randoop-all-4.3.4.jar:target/classes" randoop.main.Main gentests \
  --testclass=ar.edu.unrc.game2048.Cell \
  --time-limit=10 \
  --junit-output-dir=src/test/java \
  --junit-package-name=ar.edu.unrc.game2048.randoop.cell
```
 
### Board
 
```bash
java -cp "lib/randoop-all-4.3.4.jar:target/classes" randoop.main.Main gentests \
  --testclass=ar.edu.unrc.game2048.Board \
  --testclass=ar.edu.unrc.game2048.Direction \
  --testclass=ar.edu.unrc.game2048.Position \
  --time-limit=10 \
  --junit-output-dir=src/test/java \
  --junit-package-name=ar.edu.unrc.game2048.randoop.board \
  --omit-methods="ar\.edu\.unrc\.game2048\.Board\(.*\)"
```
 
El `--omit-methods` excluye los constructores públicos de `Board` (que crean
tableros con `Random` sin semilla), forzando a Randoop a usar
`Board.forTesting(int)`, que es determinista. Sin esto, la regression suite
generada es flaky (falla de forma intermitente entre corridas).
 
### Variante: exploración agresiva de `null` (para buscar bugs, no para la regression suite)
 
Agregar estos flags a cualquiera de los dos comandos de arriba:
 
```bash
--forbid-null=false \
--null-ratio=0.1 \
--npe-on-null-input=ERROR \
--npe-on-non-null-input=ERROR \
--no-regression-tests=true
```
 
Esto hace que Randoop inyecte `null` agresivamente y reporte como error
cualquier `NullPointerException` no controlada. Útil para encontrar bugs de
validación, pero no genera regression tests (por eso `--no-regression-tests=true`).
 
---
 
## 3. Generar tests con EvoSuite
 
```bash
./scripts/run-evosuite.sh
```
 
El script:
1. Genera tests para `Cell` y `Board` (uno por uno) con el `.jar` standalone
   de EvoSuite
2. Repaqueta automáticamente cada `_ESTest.java` / `_ESTest_scaffolding.java`
   generado hacia `src/test/java/ar/edu/unrc/game2048/evosuite/`, corrigiendo
   también la línea `package` dentro del archivo
3. Corre `mvn test -P evosuite-tests` al final para verificar
Para ajustar el tiempo de búsqueda por clase, editar `SEARCH_BUDGET` (en
segundos) al inicio del script. Por defecto estaba seteado a 60s pero no alcanza para que `Board`
termine de minimizar la suite y generar todas las assertions por lo que tira
warnings de `Minimization timeout` / `Reached maximum time to generate
assertions` en el log, por eso lo subimos a 120-180 (180 en este caso) para mejorar el resultado
a costa de más tiempo de corrida.

El script genera con `-Dreplace_calls=false -Dvirtual_fs=false
-Dvirtual_net=false -Dreset_static_fields=false -Djee=false`. Con
`replace_calls=true` los tests mockean `Random` y usan clases propias de EvoSuite
que hacen fallar a PITest (`RUN_ERROR`)
 
Nota: **No usar** el enfoque `mvn evosuite:generate evosuite:export -DcutsFile=...`
— ese modo (CTG) resultó no procesar todas las clases listadas de forma
confiable y usa nombres de propiedad distintos a `search_budget`.
 
---
 
## 4. Correr todos los tests juntos
 
```bash
mvn test
```
 
Usa el profile `all-tests` (activo por defecto), que incluye manual +
Randoop + EvoSuite en una sola corrida.
 
---
 
## 5. Correr cada suite por separado
 
```bash
mvn test -P manual-tests     # solo los tests escritos a mano (Assignment 1)
mvn test -P randoop-tests    # solo los tests generados por Randoop
mvn test -P evosuite-tests   # solo los tests generados por EvoSuite
```
 
---
 
## 6. Medir cobertura con JaCoCo

### Corre los tests y luego crea el report con JaCoCo
```bash
mvn test jacoco:report                    # todas las suites juntas
mvn test -P manual-tests jacoco:report     # solo manual
mvn test -P randoop-tests jacoco:report    # solo Randoop
mvn test -P evosuite-tests jacoco:report   # solo EvoSuite
```

### Solamente crea el report con JaCoCo (usar estos comandos si ya se ejecutaron los tests previamente)
```bash
mvn jacoco:report                    # todas las suites juntas
mvn -P manual-tests jacoco:report     # solo manual
mvn -P randoop-tests jacoco:report    # solo Randoop
mvn -P evosuite-tests jacoco:report   # solo EvoSuite
```
 
El `pom.xml` ya tiene configurado un `outputDirectory` distinto por profile,
así que cada corrida escribe en su propia carpeta sin pisar las demás:
 
| Profile | Reporte |
|---|---|
| `all-tests` (default) | `target/site/jacoco-all/index.html` |
| `manual-tests` | `target/site/jacoco-manual/index.html` |
| `randoop-tests` | `target/site/jacoco-randoop/index.html` |
| `evosuite-tests` | `target/site/jacoco-evosuite/index.html` |
 
---
 
## 7. Medir mutantes con PITest
 
```bash
mvn pitest:mutationCoverage                    # todas las suites juntas
mvn -P manual-tests pitest:mutationCoverage     # solo manual
mvn -P randoop-tests pitest:mutationCoverage    # solo Randoop
mvn -P evosuite-tests pitest:mutationCoverage   # solo EvoSuite
```

El `pom.xml` ya tiene configurado un `outputDirectory` distinto por profile,
así que cada corrida escribe en su propia carpeta sin pisar las demás:

| Profile | Reporte |
|---|---|
| `all-tests` (default) | `target/pit-reports-all/index.html` |
| `manual-tests` | `target/pit-reports-manual/index.html` |
| `randoop-tests` | `target/pit-reports-randoop/index.html` |
| `evosuite-tests` | `target/pit-reports-evosuite/index.html` |
 
---

## 8. Automatización: Correr tests y mutación de los 3 perfiles

Para correr automáticamente los tests unitarios y el análisis de mutación (PITest)
de los 3 perfiles (`manual-tests`, `randoop-tests`, `evosuite-tests`) y consolidar
todos los reportes en el directorio `test-reports/`:

```bash
./run-tests-and-mutation.sh
# o:
./scripts/run-tests-and-mutation.sh
```

### Opciones disponibles:
```bash
./scripts/run-tests-and-mutation.sh --help            # Ver ayuda
./scripts/run-tests-and-mutation.sh manual-tests      # Correr sólo manual-tests
./scripts/run-tests-and-mutation.sh --only-tests      # Correr sólo tests
./scripts/run-tests-and-mutation.sh --only-mutation   # Correr sólo PITest
./scripts/run-tests-and-mutation.sh --clean           # Limpiar antes de correr
```

Estructura de salida generada en `test-reports/`:
```text
test-reports/
├── manual-tests/
│   ├── surefire-reports/         # Reportes XML y TXT de JUnit
│   ├── pit-reports/              # Reporte HTML y XML de mutación
│   ├── jacoco/                   # Reporte HTML de cobertura
│   ├── tests-execution.log       # Log de salida de tests
│   └── mutation-execution.log    # Log de salida de PITest
├── randoop-tests/
│   └── ...
├── evosuite-tests/
│   └── ...
├── summary.txt                   # Resumen en texto plano
└── SUMMARY.md                    # Resumen y enlaces en Markdown
```

---

## 9. Correr el fuzzer (Assignment 3, Fase 2)
 
El comando devuelve la salida en la terminal por lo que se agrega
` > fuzzer-results.txt` para generar la salida en ese archivo.
 
```bash
python3 scripts/fuzzer.py > recordings/assignment-3/fuzzer-results.txt
```
 
Para la variante con `repOK()` activado vía assertions, editar `scripts/fuzzer.py`
(dentro del runner comentar y descomentar las lineas 50 y 52) para que invoque:

```python
['java', '-ea', '-cp', './target/classes', 'ar.edu.unrc.game2048.MainCLI']
```

y dentro de `MainCLI.java` descomentar la linea 70 y luego correr con:

```bash
python3 scripts/fuzzer.py > recordings/assignment-3/fuzzer-results-ea.txt
```

---

## 10. Generar invariantes con Daikon (Assignment 4)

Compilar las clases y los tests con el siguiente comando teniendo activo JDK 8.

```bash
mvn clean test-compile
```

Cambiar a JDK 11 (hasta 21) y ejecutar el script con una de las suites.
Cada una deja sus resultados en subcarpetas propias:

```bash
./run-daikon.sh --suite=manual     # BoardTest, CellTest, SpuriousInvariantTests
./run-daikon.sh --suite=randoop    # randoop.board / randoop.cell RegressionTest0
./run-daikon.sh --suite=evosuite   # Board_ESTest, Cell_ESTest
./run-daikon.sh --suite=all        # las tres juntas
```

También se pueden pasar clases de test concretas, con o sin `--suite`:

```bash
./run-daikon.sh --suite=manual ar.edu.unrc.game2048.manual.BoardTest
```

Sin `--suite` ni clases, el script usa solo `ar.edu.unrc.game2048.manual.CellTest`
y escribe en `daikon-traces/` y `daikon-invariants/` sin subcarpeta.

El script no tiene opciones aparte de `--suite=` y los nombres de clase.
Pasarle cualquier otra cosa que empiece con `-` (por ejemplo `--hola-mundo`) lo
detiene con un mensaje de uso.

El script hace tres pasos:
1. **Chicory** ejecuta los tests con `DaikonTestRunner` y genera la traza
   (borra la anterior antes de empezar). Solo se instrumentan `Board` y `Cell`
   (`--ppt-select-pattern`); `Position` se omite (`--ppt-omit-pattern`). No se
   usa `--sample-start`: Chicory empezaría a muestrear después de N llamadas por
   método y descartaría casos poco frecuentes, lo que produce invariantes falsos.
2. **Daikon** infiere los invariantes a partir de la traza y guarda también el
   archivo binario `.inv.gz` (opción `-o`). Por defecto se desactiva el *splitting*
   de puntos de programa para evitar implicaciones condicionales espurias
   (para activarlo, ver "Inferir con *splitting*" más abajo).
3. Se genera una versión limpia del resultado, sin los puntos intermedios de programa
   `EXITnn`.

Archivos generados:

| Archivo | Contenido |
|---|---|
| `daikon-traces/<suite>/JUnitCore.dtrace.gz` | Traza de Chicory |
| `daikon-traces/<suite>/JUnitCore.inv.gz` | Invariantes en formato binario de Daikon |
| `daikon-invariants/<suite>/daikon-output.txt` | Invariantes completos, con los `EXIT` numerados |
| `daikon-invariants/<suite>/daikon-output-limpio.txt` | Igual, sin los `EXIT` numerados (solo `ENTER`, `EXIT` unificado, `OBJECT` y `CLASS`) |

Notas:
- Los `EXITnn` (uno por cada `return`, `nn` es la línea del código fuente) dan
  información que el `EXIT` unificado pierde, por ejemplo la partición de
  `Cell.repOK()` entre `EMPTY` y las potencias de 2. Por eso se conserva el
  archivo completo como evidencia y se usa el limpio para leer.
- Las llamadas que terminan en excepción no aparecen en la traza (Daikon las
  ignora), por lo que los invariantes describen solo las llamadas que
  terminan normalmente.
- Algunos tests de EvoSuite dependen de un `Random` sin semilla y pueden fallar
  de forma intermitente al ejecutarse. Si fallan durante Chicory, la traza se
  genera igual con las llamadas hechas hasta ese punto.

### Correr un paso por separado

Solo inferir invariantes a partir de una traza ya generada (ejemplo con la suite `manual`):

```bash
java -cp lib/daikon.jar daikon.Daikon \
  --config_option daikon.split.PptSplitter.disable_splitting=true \
  -o daikon-traces/manual/JUnitCore.inv.gz \
  daikon-traces/manual/JUnitCore.dtrace.gz > daikon-invariants/manual/daikon-output.txt
```

### Inferir con *splitting*

El script desactiva el *splitting* de Daikon. Para inferir con *splitting*
activado (genera puntos condicionales `;condition="..."` e implicaciones
`==>` / `<==>`) a partir de la traza que ya generó el script, se ejecuta Daikon
a mano, sin la opción `disable_splitting` y con otra carpeta de salida, para no
pisar los resultados normales (ejemplo con la suite `all`, JDK 11 hasta 21):

```bash
mkdir -p daikon-invariants/all-splitting
java -cp lib/daikon.jar daikon.Daikon \
  -o daikon-traces/all/JUnitCore-splitting.inv.gz \
  daikon-traces/all/JUnitCore.dtrace.gz > daikon-invariants/all-splitting/daikon-output.txt
```

Requiere que `daikon-traces/all/JUnitCore.dtrace.gz` exista y sea válida (pesa
varios MB; si pesa unos pocos bytes, la corrida de Chicory falló y hay que
repetir `./run-daikon.sh --suite=all`). Esta salida es la completa, con los
`EXITnn`; no se genera versión limpia.

### Traza con el fuzzer

Se usa el registro de salida del fuzzer (`scripts/fuzzer.py`) como fuente de entradas: cada línea `Input:` es una partida. Con la primera línea de cada partida como archivo de entrada (200 partidas en este ejemplo) y con JDK 11 hasta 21:

```bash
mkdir -p fuzz-inputs daikon-traces/fuzzer
grep '^Input' fuzzer-results-2000T-1000M.txt | head -200 | \
  awk '{ f=sprintf("fuzz-inputs/%03d.txt",NR); for(i=3;i<=NF;i++) print $i > f }'

for f in fuzz-inputs/*.txt; do
  n=$(basename "$f" .txt)
  java -cp "lib/daikon.jar:target/classes" daikon.Chicory \
    --ppt-select-pattern='^ar\.edu\.unrc\.game2048\.(Board|Cell)([.$]|:)' \
    --ppt-omit-pattern=".*Position.*" \
    --output-dir=daikon-traces/fuzzer \
    --dtrace-file=run$n.dtrace.gz \
    ar.edu.unrc.game2048.MainCLI < "$f" > /dev/null
done
```

Para inferir solo el fuzzer, y la traza `all` más el fuzzer:

```bash
mkdir -p daikon-invariants/fuzzer daikon-invariants/all-fuzzer
java -Xmx6g -cp lib/daikon.jar daikon.Daikon \
  --config_option daikon.split.PptSplitter.disable_splitting=true \
  -o daikon-traces/fuzzer/JUnitCore.inv.gz \
  daikon-traces/fuzzer/run*.dtrace.gz > daikon-invariants/fuzzer/daikon-output.txt

java -Xmx6g -cp lib/daikon.jar daikon.Daikon \
  --config_option daikon.split.PptSplitter.disable_splitting=true \
  -o daikon-traces/all/JUnitCore-fuzzer.inv.gz \
  daikon-traces/all/JUnitCore.dtrace.gz daikon-traces/fuzzer/run*.dtrace.gz \
  > daikon-invariants/all-fuzzer/daikon-output.txt
```