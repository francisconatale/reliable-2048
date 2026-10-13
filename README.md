# Reliable 2048

Proyecto de testing y verificación del juego **2048**, desarrollado a lo largo de 4 asignaciones prácticas:
1. **Assignment 1:** Pruebas unitarias manuales (JUnit 4) y medición de cobertura (JaCoCo).
2. **Assignment 2:** Generación automática basada en feedback (Randoop), testing de mutación (PITest) e invariantes de representación (`repOK`).
3. **Assignment 3:** Generación evolutiva (EvoSuite), análisis comparativo de mutación y Fuzzing de caja negra sobre la CLI.
4. **Assignment 4:** Inferencia dinámica de invariantes y generación de oráculos con Daikon.

---

## Estructura del Repositorio

```text
reliable-2048/
├── docs/                               # Consignas originales y guías
│   ├── ASSIGNMENT-1.md
│   ├── ASSIGNMENT-2.md
│   ├── ASSIGNMENT-3.md
│   ├── ASSIGNMENT-4.md
│   └── Command-Guide.md
│
├── reports/                            # Informes y entregables de cada asignación
│   ├── report-assignment-2.md          # Resultados de Randoop, PITest y repOK
│   ├── report-assignment-3.md          # Comparativa integral (Manual vs Randoop vs EvoSuite vs Fuzzer)
│   └── report-assignment-4.md          # Inferencia de invariantes con Daikon (en progreso)
│
├── scripts/                            # Scripts de automatización y herramientas
│   ├── run-evosuite.sh                 # Generación y adecuación de tests con EvoSuite
│   ├── fuzzer.py                       # Fuzzer CLI (Fuzzing Book)
│   └── cuts-file.txt                   # Clases objetivo (Classes Under Test)
│
├── recordings/                         # Registros de ejecución, métricas y reportes HTML
│   ├── assignment-1-baseline/          # Línea base de cobertura y mutación
│   ├── assignment-3/                   # Reportes de JaCoCo, PITest y resultados de fuzzing
│   │   ├── metrics/                    # CSVs de cobertura
│   │   ├── pit-reports-*/              # Reportes de mutación (manual, randoop, evosuite)
│   │   └── site/                       # Reportes HTML JaCoCo
│   └── assignment-4/                   # Traces e invariantes de Daikon
│
├── src/                                # Código fuente y suites de tests (manual, randoop, evosuite)
├── lib/                                # Dependencias JAR externas (Randoop, Daikon)
└── pom.xml                             # Configuración de Maven y perfiles de testing
```

---

## Ejecución Rápida

### Compilación
```bash
mvn clean compile
```

### Ejecución de Tests por Perfiles
```bash
# tests manuales
mvn test -P manual-tests

# tests generados con Randoop
mvn test -P randoop-tests

# Tests generados con EvoSuite
mvn test -P evosuite-tests
```

Para ver la guía completa de comandos, generación de reportes y ejecución de herramientas, consultar [`docs/Command-Guide.md`](docs/Command-Guide.md).
