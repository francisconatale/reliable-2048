# Assignment 2 - Resultados

## Resultados antes de los cambios de Assignment 2

Los archivos de los resultados se encuentran en `test_recordings/tests_before_assig_2/`

### JaCoCo

| Metrica | Cubierto | Total | Cobertura |
|---|---:|---:|---:|
| Instrucciones | 1136 | 1329 | 85.48% |
| Ramas | 115 | 159 | 72.33% |
| Lineas | 204 | 255 | 80.00% |

### Mutation testing con PITest

| Estado | Cantidad |
|---|---:|
| KILLED | 127 |
| SURVIVED | 36 |
| NO_COVERAGE | 33 |

## Resultados despues de mejorar los tests e implementar repOK()

La suite de tests manuales contiene actualmente 96 tests y finaliza sin fallos

### Suite manual de JaCoCo

| Metrica | Cubierto | Total | Cobertura |
|---|---:|---:|---:|
| Instrucciones | 1458 | 1462 | 99.73% |
| Ramas | 169 | 181 | 93.37% |
| Lineas | 274 | 276 | 99.28% |

El reporte se genera en `target/site/jacoco/index.html`

### Mejora respecto de los primeros resultados

- Instrucciones: 85.48% -> 99.73% (`+14.25%`)
- Ramas: 72.33% -> 93.37% (`+21.04%`)
- Lineas: 80.00% -> 99.28% (`+19.28%`)

La suite manual alcanza el objetivo del README de al menos 90% de cobertura de ramas

## Randoop despues de repOK()

Randoop se ejecuto sobre `Cell` y `Board` con un límite de 10 segundos. Genero un archivo de tests de regresion con 87 metodos:

- `src/test/java/randoopTests/RegressionTest0.java`
- Tests ejecutados: 87
- Tests exitosos: 68
- Tests fallidos: 19
- Errores: 0

La ejecucion aislada de JaCoCo usando unicamente la suite de Randoop produjo:

| Metrica | Cubierto | Total | Cobertura |
|---|---:|---:|---:|
| Instrucciones | 1062 | 1462 | 72.64% |
| Ramas | 116 | 181 | 64.09% |
| Lineas | 190 | 276 | 68.84% |

### Interpretacion de los fallos de Randoop

Los 19 fallos no son bugs confirmados, son posibles fallos que deben revisarse individualmente porque Randoop genera secuencias y aserciones automaticamente. Un fallo se considera un bug confirmado unicamente cuando:

1. La entrada generada es valida segun el contrato del juego o de la API
2. El resultado esperado es consistente con el contrato documentado
3. El fallo se puede reproducir independientemente de la secuencia generada

La observacion es que Randoop explora estados invalidos o inusuales que los constructores publicos permiten, incluyendo valores de `Cell` que no son potencias de dos. `Cell.repOK()` informa correctamente que esos estados son invalidos, pero el constructor todavia los acepta. Es una inconsistencia de diseño que debe revisarse, pero no implica automaticamente que haya que modificar el constructor

Randoop no se ejecuto sobre `MainCLI` porque `play()` lee desde `Scanner` y se bloquea esperando entrada interactiva. El comportamiento del CLI esta cubierto separadamente por `MainCLITest`, usando un `InputReader` inyectado
