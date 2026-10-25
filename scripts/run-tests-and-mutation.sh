#!/bin/bash
# ==============================================================================
# run-tests-and-mutation.sh
# 
# Ejecuta los tests unitarios y el análisis de mutación (PITest) para los
# 3 perfiles definidos en el pom.xml y documentados en el README:
#   1) manual-tests
#   2) randoop-tests
#   3) evosuite-tests
#
# Guarda todos los resultados y reportes en el directorio 'test-reports/'.
# ==============================================================================

set -o pipefail

# Colores para salida de terminal
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
CYAN='\033[0;36m'
BOLD='\033[1m'
NC='\033[0m' # No Color

# Ubicar la raíz del proyecto
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
if [ -f "$SCRIPT_DIR/pom.xml" ]; then
    PROJECT_ROOT="$SCRIPT_DIR"
elif [ -f "$SCRIPT_DIR/../pom.xml" ]; then
    PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
else
    echo -e "${RED}[ERROR] No se pudo encontrar el archivo pom.xml.${NC}" >&2
    exit 1
fi

cd "$PROJECT_ROOT"

# Directorio de salida de reportes
REPORTS_BASE_DIR="$PROJECT_ROOT/test-reports"
TIMESTAMP=$(date +"%Y-%m-%d %H:%M:%S")

# Perfiles disponibles
AVAILABLE_PROFILES=("manual-tests" "randoop-tests" "evosuite-tests")

# Variables de control
SELECTED_PROFILES=()
RUN_TESTS=true
RUN_MUTATION=true
RUN_JACOCO=true

# Función de ayuda
show_help() {
    cat <<EOF
Uso: $(basename "$0") [OPCIONES] [PERFIL...]

Ejecuta tests unitarios y testing de mutación (PITest) para los 3 perfiles
del proyecto y guarda los resultados estructurados en 'test-reports/'.

Perfiles disponibles:
  manual-tests      Tests escritos manualmente (JUnit 4/5)
  randoop-tests     Tests generados con Randoop
  evosuite-tests    Tests generados con EvoSuite

Opciones:
  --only-tests      Ejecuta solamente los tests unitarios (sin mutación).
  --only-mutation   Ejecuta solamente la mutación con PITest.
  --no-jacoco       No genera reportes de cobertura JaCoCo.
  --clean           Limpia 'target/' y 'test-reports/' antes de comenzar.
  -h, --help        Muestra esta ayuda y termina.

Ejemplos:
  $(basename "$0")                          # Corre los 3 perfiles completos
  $(basename "$0") manual-tests             # Corre solo el perfil manual-tests
  $(basename "$0") --only-tests             # Corre solo tests para los 3 perfiles
  $(basename "$0") manual-tests evosuite-tests # Corre 2 perfiles específicos
EOF
}

# Parseo de argumentos
while [[ $# -gt 0 ]]; do
    case "$1" in
        -h|--help)
            show_help
            exit 0
            ;;
        --only-tests)
            RUN_MUTATION=false
            shift
            ;;
        --only-mutation)
            RUN_TESTS=false
            shift
            ;;
        --no-jacoco)
            RUN_JACOCO=false
            shift
            ;;
        --clean)
            echo -e "${YELLOW}Limpiando target/ y test-reports/...${NC}"
            rm -rf "$REPORTS_BASE_DIR"
            mvn clean -q
            shift
            ;;
        manual|manual-tests)
            SELECTED_PROFILES+=("manual-tests")
            shift
            ;;
        randoop|randoop-tests)
            SELECTED_PROFILES+=("randoop-tests")
            shift
            ;;
        evosuite|evosuite-tests)
            SELECTED_PROFILES+=("evosuite-tests")
            shift
            ;;
        *)
            echo -e "${RED}[ERROR] Opción o perfil desconocido: $1${NC}"
            echo "Usa '$0 --help' para ver las opciones disponibles."
            exit 1
            ;;
    esac
done

# Si no se especificaron perfiles, correr los 3
if [ ${#SELECTED_PROFILES[@]} -eq 0 ]; then
    SELECTED_PROFILES=("${AVAILABLE_PROFILES[@]}")
fi

mkdir -p "$REPORTS_BASE_DIR"

echo -e "${BOLD}${CYAN}========================================================================${NC}"
echo -e "${BOLD}${CYAN}   reliable-2048: Ejecución de Tests y Mutación por Perfiles${NC}"
echo -e "${BOLD}${CYAN}========================================================================${NC}"
echo -e "Fecha:               ${TIMESTAMP}"
echo -e "Perfiles a ejecutar: ${BOLD}${SELECTED_PROFILES[*]}${NC}"
echo -e "Directorio destino:  ${BOLD}${REPORTS_BASE_DIR}/${NC}"
echo -e "Ejecutar tests:      ${RUN_TESTS}"
echo -e "Ejecutar mutación:   ${RUN_MUTATION}"
echo -e "Generar JaCoCo:      ${RUN_JACOCO}"
echo -e "${CYAN}------------------------------------------------------------------------${NC}"

# Arrays para el resumen final
declare -A TEST_STATUS
declare -A MUTATION_STATUS
declare -A TEST_DETAILS
declare -A MUTATION_DETAILS

OVERALL_SUCCESS=true

for PROFILE in "${SELECTED_PROFILES[@]}"; do
    SUFFIX="${PROFILE%-tests}"
    PROFILE_DIR="$REPORTS_BASE_DIR/$PROFILE"
    mkdir -p "$PROFILE_DIR"

    echo ""
    echo -e "${BOLD}${BLUE}>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>${NC}"
    echo -e "${BOLD}${BLUE} Procesando perfil: [${PROFILE}]${NC}"
    echo -e "${BOLD}${BLUE}<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<${NC}"

    # --------------------------------------------------------------------------
    # 1. EJECUCIÓN DE TESTS
    # --------------------------------------------------------------------------
    if [ "$RUN_TESTS" = true ]; then
        echo -e "${YELLOW}>> [${PROFILE}] Corriendo tests unitarios...${NC}"

        # Limpiar surefire-reports previo para no mezclar resultados
        rm -rf target/surefire-reports
        rm -rf "target/site/jacoco-${SUFFIX}"

        TEST_CMD="mvn test"
        if [ "$RUN_JACOCO" = true ]; then
            TEST_CMD="mvn test jacoco:report"
        fi

        TEST_LOG="$PROFILE_DIR/tests-execution.log"
        echo "Ejecutando: $TEST_CMD -P $PROFILE" | tee "$TEST_LOG"

        set +e
        $TEST_CMD -P "$PROFILE" 2>&1 | tee -a "$TEST_LOG"
        MAVEN_TEST_EXIT=${PIPESTATUS[0]}
        set -e

        # Copiar surefire-reports si existen
        if [ -d "target/surefire-reports" ] && [ "$(ls -A target/surefire-reports 2>/dev/null)" ]; then
            mkdir -p "$PROFILE_DIR/surefire-reports"
            cp -r target/surefire-reports/* "$PROFILE_DIR/surefire-reports/"
        fi

        # Copiar JaCoCo report si se generó
        if [ -d "target/site/jacoco-${SUFFIX}" ]; then
            mkdir -p "$PROFILE_DIR/jacoco"
            cp -r "target/site/jacoco-${SUFFIX}"/* "$PROFILE_DIR/jacoco/"
        fi

        # Extraer estadísticas de surefire
        TEST_SUMMARY_LINE=$(grep -E "Tests run: [0-9]+, Failures: [0-9]+, Errors: [0-9]+, Skipped: [0-9]+" "$TEST_LOG" | tail -n 1 || true)
        if [ -n "$TEST_SUMMARY_LINE" ]; then
            TEST_DETAILS["$PROFILE"]="$TEST_SUMMARY_LINE"
        else
            TEST_DETAILS["$PROFILE"]="No se pudo determinar el detalle"
        fi

        if [ $MAVEN_TEST_EXIT -eq 0 ]; then
            echo -e "${GREEN}✔ Tests finalizados exitosamente para [${PROFILE}].${NC}"
            TEST_STATUS["$PROFILE"]="EXITOSO"
        else
            echo -e "${RED}✘ Fallaron los tests unitarios para [${PROFILE}] (código: ${MAVEN_TEST_EXIT}).${NC}"
            TEST_STATUS["$PROFILE"]="FALLIDO"
            OVERALL_SUCCESS=false
        fi
    else
        TEST_STATUS["$PROFILE"]="OMITIDO"
        TEST_DETAILS["$PROFILE"]="No ejecutado (--only-mutation)"
    fi

    # --------------------------------------------------------------------------
    # 2. EJECUCIÓN DE MUTACIÓN (PITEST)
    # --------------------------------------------------------------------------
    if [ "$RUN_MUTATION" = true ]; then
        if [ "$RUN_TESTS" = true ] && [ "${TEST_STATUS["$PROFILE"]}" = "FALLIDO" ]; then
            echo -e "${RED}>> [${PROFILE}] Se omitió la mutación porque los tests unitarios fallaron.${NC}"
            MUTATION_STATUS["$PROFILE"]="CANCELADO (tests fallidos)"
            MUTATION_DETAILS["$PROFILE"]="Requiere que pasen los tests"
        else
            echo -e "${YELLOW}>> [${PROFILE}] Ejecutando análisis de mutación con PITest...${NC}"

            PIT_TARGET_DIR="target/pit-reports-${SUFFIX}"
            rm -rf "$PIT_TARGET_DIR"

            MUTATION_CMD="mvn pitest:mutationCoverage -P $PROFILE"
            MUTATION_LOG="$PROFILE_DIR/mutation-execution.log"
            echo "Ejecutando: $MUTATION_CMD" | tee "$MUTATION_LOG"

            set +e
            $MUTATION_CMD 2>&1 | tee -a "$MUTATION_LOG"
            PITEST_EXIT=${PIPESTATUS[0]}
            set -e

            # Copiar reportes de PITest
            if [ -d "$PIT_TARGET_DIR" ] && [ "$(ls -A "$PIT_TARGET_DIR" 2>/dev/null)" ]; then
                mkdir -p "$PROFILE_DIR/pit-reports"
                cp -r "$PIT_TARGET_DIR"/* "$PROFILE_DIR/pit-reports/"
                
                # Crear enlace simbólico o copia en la raíz de test-reports para compatibilidad
                rm -rf "$REPORTS_BASE_DIR/pit-reports-${SUFFIX}"
                ln -sfn "$PROFILE/pit-reports" "$REPORTS_BASE_DIR/pit-reports-${SUFFIX}" 2>/dev/null || true
            fi

            # Extraer estadísticas de PITest del log
            LINE_COV=$(grep -E ">> Line Coverage:" "$MUTATION_LOG" | tail -n 1 | sed 's/.*>> //' || true)
            MUT_COV=$(grep -E ">> Generated .* mutations Killed" "$MUTATION_LOG" | tail -n 1 | sed 's/.*>> //' || true)

            if [ -n "$MUT_COV" ]; then
                MUTATION_DETAILS["$PROFILE"]="${LINE_COV:-N/A} | ${MUT_COV}"
            else
                MUTATION_DETAILS["$PROFILE"]="Reporte generado en pit-reports/"
            fi

            if [ $PITEST_EXIT -eq 0 ]; then
                echo -e "${GREEN}✔ Mutación completada exitosamente para [${PROFILE}].${NC}"
                MUTATION_STATUS["$PROFILE"]="EXITOSO"
            else
                echo -e "${RED}✘ Error en la ejecución de mutación para [${PROFILE}] (código: ${PITEST_EXIT}).${NC}"
                MUTATION_STATUS["$PROFILE"]="FALLIDO"
                OVERALL_SUCCESS=false
            fi
        fi
    else
        MUTATION_STATUS["$PROFILE"]="OMITIDO"
        MUTATION_DETAILS["$PROFILE"]="No ejecutado (--only-tests)"
    fi
done

# ------------------------------------------------------------------------------
# 3. GENERACIÓN DEL RESUMEN FINAL
# ------------------------------------------------------------------------------
SUMMARY_FILE="$REPORTS_BASE_DIR/SUMMARY.md"
SUMMARY_TXT="$REPORTS_BASE_DIR/summary.txt"

{
    echo "# Resumen de Ejecución de Tests y Mutación"
    echo ""
    echo "- **Fecha de ejecución:** $TIMESTAMP"
    echo "- **Directorio base:** \`test-reports/\`"
    echo ""
    echo "## Resultados por Perfil"
    echo ""
    echo "| Perfil | Tests | Detalle Tests | Mutación (PITest) | Detalle Mutación |"
    echo "|---|---|---|---|---|"
    for PROFILE in "${SELECTED_PROFILES[@]}"; do
        echo "| \`$PROFILE\` | ${TEST_STATUS[$PROFILE]} | ${TEST_DETAILS[$PROFILE]} | ${MUTATION_STATUS[$PROFILE]} | ${MUTATION_DETAILS[$PROFILE]} |"
    done
    echo ""
    echo "## Ubicación de los Reportes"
    echo ""
    for PROFILE in "${SELECTED_PROFILES[@]}"; do
        echo "### Perfil: \`$PROFILE\`"
        echo "- **Tests (Surefire):** [\`test-reports/$PROFILE/surefire-reports/\`]($PROFILE/surefire-reports/)"
        if [ -d "$REPORTS_BASE_DIR/$PROFILE/pit-reports" ]; then
            echo "- **Mutación (PITest HTML):** [\`test-reports/$PROFILE/pit-reports/index.html\`]($PROFILE/pit-reports/index.html)"
            echo "- **Mutación (XML):** [\`test-reports/$PROFILE/pit-reports/mutations.xml\`]($PROFILE/pit-reports/mutations.xml)"
        fi
        if [ -d "$REPORTS_BASE_DIR/$PROFILE/jacoco" ]; then
            echo "- **Cobertura (JaCoCo HTML):** [\`test-reports/$PROFILE/jacoco/index.html\`]($PROFILE/jacoco/index.html)"
        fi
        echo "- **Logs:** [\`test-reports/$PROFILE/tests-execution.log\`]($PROFILE/tests-execution.log), [\`test-reports/$PROFILE/mutation-execution.log\`]($PROFILE/mutation-execution.log)"
        echo ""
    done
} > "$SUMMARY_FILE"

# Generar versión texto plano
{
    echo "================================================================================"
    echo "            RESUMEN DE EJECUCIÓN - reliable-2048"
    echo "================================================================================"
    echo "Fecha: $TIMESTAMP"
    echo "Reportes guardados en: $REPORTS_BASE_DIR"
    echo ""
    for PROFILE in "${SELECTED_PROFILES[@]}"; do
        echo "[$PROFILE]"
        echo "  - Tests:    ${TEST_STATUS[$PROFILE]} (${TEST_DETAILS[$PROFILE]})"
        echo "  - Mutación: ${MUTATION_STATUS[$PROFILE]} (${MUTATION_DETAILS[$PROFILE]})"
        echo "  - Directorio: test-reports/$PROFILE/"
        echo ""
    done
    echo "================================================================================"
} > "$SUMMARY_TXT"

echo ""
echo -e "${BOLD}${CYAN}========================================================================${NC}"
echo -e "${BOLD}${CYAN}                           RESUMEN FINAL                                ${NC}"
echo -e "${BOLD}${CYAN}========================================================================${NC}"
cat "$SUMMARY_TXT"
echo ""
echo -e "Reporte detallado en Markdown: ${BOLD}$SUMMARY_FILE${NC}"
echo -e "${CYAN}========================================================================${NC}"

if [ "$OVERALL_SUCCESS" = true ]; then
    echo -e "${GREEN}${BOLD}¡Todas las tareas solicitadas finalizaron con éxito!${NC}"
    exit 0
else
    echo -e "${RED}${BOLD}Algunas ejecuciones presentaron fallas. Revisar los logs en 'test-reports/'.${NC}"
    exit 1
fi
