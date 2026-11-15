#!/bin/bash
set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

# Compilar clases y tests si hace falta
if [ ! -d "target/classes" ] || [ ! -d "target/test-classes" ]; then
    echo "Compilando clases y tests..."
    mvn test-compile -q
fi

# Uso:
#   ./run-daikon.sh [--suite=NOMBRE] [ClaseDeTest ...]
#
# --suite=NOMBRE separa los resultados en subcarpetas:
#     daikon-traces/NOMBRE/   y   daikon-invariants/NOMBRE/
# Si no se pasan clases, --suite elige las de esa suite:
#     manual | randoop | evosuite | all
# Sin --suite se usa el comportamiento anterior (sin subcarpeta).
SUITE=""
CLASS_ARGS=()
for arg in "$@"; do
    case "$arg" in
        --suite=*) SUITE="${arg#--suite=}" ;;
        -*)
            echo "Opción desconocida: $arg" >&2
            echo "Uso: $0 [--suite=manual|randoop|evosuite|all] [ClaseDeTest ...]" >&2
            exit 2 ;;
        *)         CLASS_ARGS+=("$arg") ;;
    esac
done

P=ar.edu.unrc.game2048
MANUAL=("$P.manual.BoardTest" "$P.manual.CellTest" "$P.manual.SpuriousInvariantTests")
RANDOOP=("$P.randoop.board.RegressionTest0" "$P.randoop.cell.RegressionTest0")
EVOSUITE=("$P.evosuite.Board_ESTest" "$P.evosuite.Cell_ESTest")

if [ ${#CLASS_ARGS[@]} -gt 0 ]; then
    TEST_CLASSES=("${CLASS_ARGS[@]}")
else
    case "$SUITE" in
        manual)   TEST_CLASSES=("${MANUAL[@]}") ;;
        randoop)  TEST_CLASSES=("${RANDOOP[@]}") ;;
        evosuite) TEST_CLASSES=("${EVOSUITE[@]}") ;;
        all)      TEST_CLASSES=("${MANUAL[@]}" "${RANDOOP[@]}" "${EVOSUITE[@]}") ;;
        *)        TEST_CLASSES=("$P.manual.CellTest") ;;
    esac
fi

# Directorio de salida de trazas (con subcarpeta si se usa --suite)
TRACE_DIR="daikon-traces${SUITE:+/$SUITE}"
TRACE="$TRACE_DIR/JUnitCore.dtrace.gz"
mkdir -p "$TRACE_DIR"
# Borrar la traza anterior para no confundirla con una nueva
rm -f "$TRACE"

# Obtener classpath de dependencias con Maven
DEPS_CP=$(mvn dependency:build-classpath -Dmdep.outputFile=/dev/stdout -q)
FULL_CP="lib/daikon.jar:target/classes:target/test-classes:${DEPS_CP}"

# NOTA: no usar --sample-start: después de N llamadas por método Chicory muestrea
# y descarta casos poco frecuentes (p. ej. llamadas con Cell.EMPTY), lo que
# genera invariantes espurios.
echo "Ejecutando Chicory para: ${TEST_CLASSES[*]}..."
java -cp "$FULL_CP" \
    daikon.Chicory \
    --ppt-select-pattern='^ar\.edu\.unrc\.game2048\.(Board|Cell)([.$]|:)' \
    --ppt-omit-pattern=".*Position.*" \
    --output-dir="$TRACE_DIR" \
    --dtrace-file=JUnitCore.dtrace.gz \
    ar.edu.unrc.game2048.manual.utils.DaikonTestRunner \
    "${TEST_CLASSES[@]}" || true

OUT_DIR="daikon-invariants${SUITE:+/$SUITE}"
OUT_FULL="$OUT_DIR/daikon-output.txt"
OUT_CLEAN="$OUT_DIR/daikon-output-limpio.txt"
mkdir -p "$OUT_DIR"

if [ ! -s "$TRACE" ]; then
    echo "ERROR: no se generó la traza $TRACE" >&2
    exit 1
fi
echo "Traza generada en $TRACE"

# Inferir invariantes (salida completa, con los EXIT numerados por return)
echo "Ejecutando Daikon..."
java -cp lib/daikon.jar daikon.Daikon \
    --config_option daikon.split.PptSplitter.disable_splitting=true \
    -o "$TRACE_DIR/JUnitCore.inv.gz" \
    "$TRACE" > "$OUT_FULL"

# Versión limpia: elimina los puntos de programa EXITnn (uno por return)
# y deja solo ENTER, EXIT combinado, OBJECT y CLASS.
# Formato de Daikon: "=====", nombre del ppt, invariantes (sin separador
# después del nombre; un ppt sin invariantes queda como nombre seguido
# directamente del próximo "=====").
awk '
/^=+$/ { held=$0; next }
/:::(ENTER|EXIT[0-9]*|CLASS|OBJECT)$/ {
    skip = ($0 ~ /:::EXIT[0-9]+$/)
    if (!skip && held != "") print held
    held = ""
    if (!skip) print
    next
}
!skip { print }
' "$OUT_FULL" > "$OUT_CLEAN"

echo ""
echo "Listo:"
echo "  Completo: $OUT_FULL"
echo "  Limpio:   $OUT_CLEAN"
echo "  Traza:    $TRACE"
echo "  Archivo .inv: $TRACE_DIR/JUnitCore.inv.gz"