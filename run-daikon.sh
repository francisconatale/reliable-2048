#!/bin/bash
set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

# Compilar clases y tests si hace falta
if [ ! -d "target/classes" ] || [ ! -d "target/test-classes" ]; then
    echo "Compilando clases y tests..."
    mvn test-compile -q
fi

# Clases o suites de tests a ejecutar
if [ $# -eq 0 ]; then
    TEST_CLASSES=("ar.edu.unrc.game2048.CellTest")
else
    TEST_CLASSES=("$@")
fi

# Directorio de salida de trazas
mkdir -p daikon-traces

# Obtener classpath de dependencias con Maven
DEPS_CP=$(mvn dependency:build-classpath -Dmdep.outputFile=/dev/stdout -q)
FULL_CP="lib/daikon.jar:target/classes:target/test-classes:${DEPS_CP}"

echo "Ejecutando Chicory para: ${TEST_CLASSES[*]}..."
java -cp "$FULL_CP" \
    daikon.Chicory \
    --ppt-select-pattern="ar.edu.unrc.game2048.Board|ar.edu.unrc.game2048.Cell" \
    --ppt-omit-pattern=".*Position.*" \
    --sample-start=500 \
    --output-dir=daikon-traces \
    org.junit.runner.JUnitCore \
    "${TEST_CLASSES[@]}" || true

echo ""
echo "¡Traza generada con éxito en daikon-traces/JUnitCore.dtrace.gz!"
echo "Para inferir invariantes ejecuta:"
echo "  java -cp lib/daikon.jar daikon.Daikon daikon-traces/JUnitCore.dtrace.gz > daikon-output.txt"
