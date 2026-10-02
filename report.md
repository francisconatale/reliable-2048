# Reporte de Análisis de Cobertura y Generación Automática de Pruebas

## 1. Introducción y objetivo

Este reporte evalúa la calidad de la suite de pruebas del proyecto `game2048`, comparando las pruebas escritas manualmente con las generadas automáticamente por EvoSuite. Se analizan tres aspectos: cobertura de código, cobertura de mutación y utilidad práctica de cada enfoque.

## 2. Herramientas y metodología

| Herramienta | Propósito |
| :--- | :--- |
| **JaCoCo** | Cobertura de instrucciones y ramas |
| **PIT (mutación)** | Cobertura de mutación y fuerza de las pruebas |
| **EvoSuite** | Generación automática de pruebas para `Board`, `Cell` y `MainCLI` |

Durante la generación con EvoSuite se exploraron casos como:

- Tableros de dimensiones grandes (por ejemplo `70x70`), para observar el comportamiento en casos límite y con alto consumo de memoria.
- Referencias `null`.
- Valores negativos.
- Índices y posiciones fuera de rango.

## 3. Resultados

### 3.1 Pruebas manuales

**Cobertura global (JaCoCo):**

- Instrucciones: 97% (38 sin cubrir de 1.478).
- Ramas: 90% (18 sin cubrir de 181).

| Paquete | Instrucciones | Ramas |
| :--- | ---: | ---: |
| `ar.edu.unrc.game2048` | 96% | 88% |
| `ar.edu.unrc.game2048.strategy` | 100% | 100% |

**Detalle por clase:**

| Clase | Instrucciones | Ramas |
| :--- | ---: | ---: |
| `MoveProvider` | 100.00% | N/A |
| `MoveRight` | 100.00% | 100.00% |
| `MoveUp` | 100.00% | 100.00% |
| `MoveDown` | 100.00% | 100.00% |
| `MoveLeft` | 100.00% | 100.00% |
| `Move` | 100.00% | 100.00% |
| `Cell` | 100.00% | 96.15% |
| `ScannerInputReader` | 100.00% | N/A |
| `Score` | 100.00% | N/A |
| `Board.Position` | 100.00% | 80.00% |
| `Board.Direction` | 100.00% | N/A |
| `Board` | 99.39% | 91.18% |
| `MainCLI` | 100.00% | 100.00% |

**Mutación:**

| Clases | Cobertura de líneas | Cobertura de mutación | Fuerza de las pruebas |
| :---: | :---: | :---: | :---: |
| 11 | 99% (272/274) | 97% (209/215) | 98% (209/213) |

| Paquete | Clases | Líneas | Mutación | Fuerza |
| :--- | :---: | :---: | :---: | :---: |
| `ar.edu.unrc.game2048` | 5 | 99% (196/198) | 98% (164/168) | 99% (164/166) |
| `ar.edu.unrc.game2048.strategy` | 6 | 100% (76/76) | 96% (45/47) | 96% (45/47) |

### 3.2 Pruebas generadas con EvoSuite

**Cobertura por clase:**

| Clase | Cobertura | Objetivos totales | Objetivos cubiertos |
| :--- | ---: | ---: | ---: |
| `Cell` | 93.57% | 223 | 208 |
| `Board` | 90.06% | 1224 | 1086 |
| `MainCLI` | 93.67% | 165 | 146 |

**Mutación:**

| Clases | Cobertura de líneas | Cobertura de mutación | Fuerza de las pruebas |
| :---: | :---: | :---: | :---: |
| 11 | 97% (267/274) | 95% (204/215) | 100% (204/204) |

| Paquete | Clases | Líneas | Mutación | Fuerza |
| :--- | :---: | :---: | :---: | :---: |
| `ar.edu.unrc.game2048` | 5 | 96% (191/198) | 93% (157/168) | 100% (157/157) |
| `ar.edu.unrc.game2048.strategy` | 6 | 100% (76/76) | 100% (47/47) | 100% (47/47) |

### 3.3 Comparación

| Métrica | Manuales | EvoSuite |
| :--- | :---: | :---: |
| Cobertura de líneas | 99% | 97% |
| Cobertura de mutación | 97% | 95% |
| Fuerza de las pruebas | 98% | 100% |

Ambos enfoques logran resultados muy similares. Las pruebas manuales superan levemente a EvoSuite en líneas y mutación, y en el paquete `strategy` EvoSuite alcanza 100% de mutación frente al 96% de las manuales.

## 4. Análisis cualitativo de las pruebas generadas

EvoSuite genera sus aserciones a partir del comportamiento observado durante la ejecución. Esto implica que:

- Muchas aserciones verifican constantes, estados internos o valores concretos que no representan reglas funcionales del juego.
- Como la herramienta no conoce las reglas del juego, si el código tiene un error, asume que ese es el comportamiento correcto y genera una prueba que lo preserva.

**Según la complejidad de la clase:**

- **Clases simples (`Cell`, utilitarias):** manejan principalmente tipos primitivos, por lo que los tests son legibles y directos. Podrían usarse como pruebas manuales.
- **Clases complejas (`Board`):** hay más relaciones entre clases y los estados no dependen solo de primitivas. Las pruebas son largas e intrincadas, **difíciles de leer y costosas de mantener**. Si el código cambia, entender por qué falló un test automático puede llevar más tiempo que escribirlo a mano.

## 5. Hallazgos

Las pruebas generadas encontraron escenarios que no habíamos considerado:

- **Puntuaciones negativas:** el sistema permite registrar valores menores que cero.
- **Posiciones inválidas:** algunas operaciones aceptan índices menores que cero.

## 6. Conclusiones

EvoSuite resultó un complemento valioso, principalmente para:

1. **Explorar el código** y encontrar entradas inválidas que olvidamos validar.
2. **Crear una red de seguridad rápida** (pruebas de regresión) que avise si cambios futuros rompen el comportamiento actual.

No reemplaza a las pruebas manuales: en clases complejas tiene un alto costo de mantenimiento y puede dar por válidos comportamientos que en realidad son errores. Sus pruebas deben revisarse con criterio.