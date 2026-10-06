# Comandos de build y testing — reliable-2048
 
Referencia rápida de todos los comandos necesarios para compilar el proyecto
y correr cada tipo de test (manual, Randoop, EvoSuite), medir cobertura
(JaCoCo), mutantes (PITest) y el fuzzer.
 
## Requisitos previos
 
- **JDK 8** activo en la terminal (el proyecto compila a target 1.8, y
  EvoSuite específicamente requiere JDK 8 para correr).En este proyecto se utilizo java 8.0.504-amzn.
- Python 3 instalado, para el fuzzer (Fase 2 de Assignment 3).
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
./runEvosuite.sh
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
termine de minimizar la suite y generar todas las assertions y tira
warnings de `Minimization timeout` / `Reached maximum time to generate
assertions` en el log, por eso lo subimos a 120-180 (180 en este caso) para mejorar el resultado
a costa de más tiempo de corrida.
 
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
 
## 8. Correr el fuzzer (Assignment 3, Fase 2)
 
El comando devuelve la salida en la terminal por lo que se agrega
` > fuzzer-results.txt` para generar la salida en ese archivo.
 
```bash
python3 fuzzer.py > fuzzer-results.txt
```
 
Para la variante con `repOK()` activado vía assertions, editar `fuzzer.py`
(dentro del runner comentar y descomentar las lineas 50 y 52) para que invoque:

```python
['java', '-ea', '-cp', './target/classes', 'ar.edu.unrc.game2048.MainCLI']
```

y dentro de `MainCLI.java` descomentar la linea 70 y luego correr con:

```bash
python3 fuzzer.py > fuzzer-results-ea.txt
```
