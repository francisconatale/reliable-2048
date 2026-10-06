#!/bin/bash
# generate_evosuite_tests.sh
set -e

EVOSUITE_JAR="evosuite-1.0.6.jar"
EVOSUITE_URL="https://github.com/EvoSuite/evosuite/releases/download/v1.0.6/evosuite-1.0.6.jar"
SEARCH_BUDGET=180
TARGET_PACKAGE="ar.edu.unrc.game2048.evosuite"
TARGET_DIR="src/test/java/ar/edu/unrc/game2048/evosuite"

# Download EvoSuite if not exists
if [ ! -f "$EVOSUITE_JAR" ]; then
    echo "Downloading EvoSuite..."
    wget "$EVOSUITE_URL" || curl -L -o "$EVOSUITE_JAR" "$EVOSUITE_URL"
fi

CLASS_PATH=$(pwd)/target/classes
mkdir -p "$TARGET_DIR"

# Generate tests
for TARGET_CLASS in ar.edu.unrc.game2048.Cell ar.edu.unrc.game2048.Board; do
    echo "Generating EvoSuite tests for $TARGET_CLASS..."
    java -jar "$EVOSUITE_JAR" -projectCP "$CLASS_PATH" -class "$TARGET_CLASS" \
        -Dsearch_budget=$SEARCH_BUDGET -Dtest_dir=src/test/java

    SIMPLE_NAME=$(echo "$TARGET_CLASS" | awk -F. '{print $NF}')
    SRC_PKG_DIR=$(echo "$TARGET_CLASS" | sed 's/\.[^.]*$//' | tr '.' '/')

    for SUFFIX in "" "_scaffolding"; do
        SRC_FILE="src/test/java/${SRC_PKG_DIR}/${SIMPLE_NAME}_ESTest${SUFFIX}.java"
        if [ -f "$SRC_FILE" ]; then
            sed -i "s/^package ${TARGET_CLASS%.*};/package ${TARGET_PACKAGE};/" "$SRC_FILE"
            sed -i "s/separateClassLoader = true/separateClassLoader = false/" "$SRC_FILE"
            mv "$SRC_FILE" "$TARGET_DIR/"
        fi
    done
done

# Run tests
echo "Listo. Tests en $TARGET_DIR"
mvn test -P evosuite-tests