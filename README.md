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
├── docs/                              
│   ├── ASSIGNMENT-1.md
│   ├── ASSIGNMENT-2.md
│   ├── ASSIGNMENT-3.md
│   ├── ASSIGNMENT-4.md
│   └── Command-Guide.md
│
├── reports/                            # informes y entregables de cada asignación
│   ├── report-assignment-2.md          # resultados de Randoop, PITest y repOK
│   ├── report-assignment-3.md          # comparativa integral
│   └── report-assignment-4.md          # inferencia de invariantes con Daikon (en progreso)
│
├── scripts/                            # 
│   ├── run-tests-and-mutation.sh       # ejecución de tests y mutación (3 perfiles)
│   ├── run-evosuite.sh                 # generacion de tests con evosuite
│   ├── fuzzer.py                       # Fuzzer CLI 
│   └── cuts-file.txt                   # clases para generar tests con evosuite
│
├── recordings/                         # registros de ejecución, métricas y reportes HTML
│   ├── assignment-1-baseline/          # línea base de cobertura y mutación
│   ├── assignment-3/                   # reportes de JaCoCo, PITest y resultados de fuzzing
│   │   ├── metrics/                    # CSVs de cobertura
│   │   ├── pit-reports-*/              # reportes de mutación (manual, randoop, evosuite)
│   │   └── site/                       # reportes HTML JaCoCo
│   └── assignment-4/                   # traces e invariantes de Daikon
│
├── src/                                # código fuente y suites de tests
├── lib/                                # dependencias JAR externas
└── pom.xml                             # configuración de Maven y perfiles de testing
```

---

## Ejecución Rápida

### Compilación
```bash
mvn clean compile
```

### Ejecución de Tests por Perfiles
```bash

mvn test -P manual-tests

mvn test -P randoop-tests

mvn test -P evosuite-tests
```

### Ejecución Automatizada de Tests y Mutación (3 Perfiles)
Para ejecutar automáticamente los tests unitarios y el análisis de mutación (PITest) de los 3 perfiles y consolidar los reportes en `test-reports/`:
```bash
./run-tests-and-mutation.sh
```

Para ver la guía completa de comandos, generación de reportes y ejecución de herramientas, consultar [`docs/Command-Guide.md`](docs/Command-Guide.md).
