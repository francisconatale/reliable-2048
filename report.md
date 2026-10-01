# Reporte de Análisis de Cobertura y Generación Automática de Pruebas

## 1. Generación automática de pruebas con EvoSuite

EvoSuite generó pruebas automáticamente para explorar diferentes comportamientos de `Board`, `Cell` y `MainCLI`.

Durante la generación se probaron casos como:

* Tableros de dimensiones grandes, por ejemplo `70x70`. (buscando ver como se comporta en casos limites y que requieren mas memoria)
* Referencias `null`.
* Valores negativos.
* Índices y posiciones fuera de rango.

Los resultados obtenidos fueron:

| Clase     | Cobertura | Objetivos totales | Objetivos cubiertos |
| --------- | --------: | ----------------: | ------------------: |
| `Cell`    |    93.57% |               223 |                 208 |
| `Board`   |    90.06% |              1224 |                1086 |
| `MainCLI` |    93.67% |               165 |                 146 |

## 2. Características de las pruebas

EvoSuite genera sus aserciones a partir del comportamiento observado durante la ejecución.
Por lo tanto, muchas verifican constantes, estados internos o valores concretos que no necesariamente representan reglas funcionales del juego.

Además, como la herramienta no conoce las reglas del juego, si el código tiene un error, EvoSuite asume que así es como debe funcionar y crea una prueba para asegurar que ese error se mantenga.

**Diferencia según la complejidad de la clase:**
* **Clases simples (`Cell` o utilitarias):** Las pruebas generadas para estas clases suelen ser similares a las que un desarrollador escribiría manualmente. Al tratarse de lógicas más acotadas y manejar principalmente tipos primitivos, los tests resultan legibles y directos. Podrian tranquilamente usarse como si fuera un test manual. 

* **Clases complejas (`Board`):** A medida que aumenta la complejidad, existen más relaciones entre clases y los estados dejan de depender únicamente de primitivas. En clases como `Board`, los resultados de EvoSuite empiezan a ser diferentes. Las pruebas se vuelven más largas e intrincadas, lo que hace que sean **muy difíciles de leer y costosas de mantener**. Si el código cambia en el futuro, entender por qué falló uno de estos tests automáticos puede llevar más tiempo que hacer la prueba a mano.

Por este motivo, las pruebas generadas sirven principalmente para detectar si rompimos algo accidentalmente (**regresión**) y para encontrar casos raros, pero no reemplazan a las pruebas que hacemos nosotros para asegurar que el juego funcione como debe.

## 3. Hallazgos

Las pruebas generadas demostraron ser muy útiles para encontrar escenarios que no habíamos pensado. En concreto, detectaron:

* **Puntuaciones negativas:** el sistema permite registrar valores menores que cero.
* **Posiciones inválidas:** determinadas operaciones permiten utilizar índices menores que cero.

## 4. Conclusión

EvoSuite nos resulto una herramienta valiosa como complemento principalmente útil para:
1. **Explorar el código** y encontrar casos o entradas inválidas que olvidamos validar.
2. **Crear una red de seguridad rápida** para darnos cuenta si cambios futuros rompen el comportamiento actual del sistema.

Sin embargo, sus pruebas deben revisarse con criterio, ya que en clases complejas generan un alto costo de mantenimiento y pueden llegar a dar por válidos comportamientos que en realidad son errores

## 5. Resultados de Cobertura (JaCoCo)

Los resultados generales obtenidos del reporte de JaCoCo reflejan una alta cobertura global del código:

* **Cobertura de Instrucciones:** 97% (38 instrucciones no cubiertas de un total de 1.478).
* **Cobertura de Ramas (Branches):** 90% (18 ramas no cubiertas de un total de 181).

**Desglose por paquetes:**
* `ar.edu.unrc.game2048`: 96% de instrucciones, 88% de ramas.
* `ar.edu.unrc.game2048.strategy`: 100% de instrucciones, 100% de ramas.

### Detalle por Clase (Pruebas Manuales)

Los resultados obtenidos fueron (combinando instrucciones y ramas):

| Clase                | Instrucciones     |   Ramas            | 
| :------------------- | ----------------: | ----------------: |
| `MoveProvider`       |           100.00% |               N/A |
| `MoveRight`          |           100.00% |           100.00% |
| `MoveUp`             |           100.00% |           100.00% |
| `Move`               |           100.00% |           100.00% |
| `MoveDown`           |           100.00% |           100.00% |
| `MoveLeft`           |           100.00% |           100.00% |
| `Cell`               |           100.00% |            96.15% |
| `ScannerInputReader` |           100.00% |               N/A |
| `Score`              |           100.00% |               N/A |
| `Board.Position`     |           100.00% |            80.00% |
| `Board.Direction`    |           100.00% |               N/A |
| `Board`              |            99.39% |            91.18% |
| `MainCLI`            |           100.00% |           100.00% |

### Resultados de Mutación (PITest) - Pruebas Manuales

**Resumen del Proyecto**

| Clases | Cobertura de Líneas | Cobertura de Mutación | Fuerza de las Pruebas |
| :--- | :---: | :---: | :---: |
| 11 | 99% (272/274) | 97% (209/215) | 98% (209/213) |

**Desglose por Paquete**

| Nombre | Clases | Cobertura de Líneas | Cobertura de Mutación | Fuerza de las Pruebas |
| :--- | :---: | :---: | :---: | :---: |
| `ar.edu.unrc.game2048` | 5 | 99% (196/198) | 98% (164/168) | 99% (164/166) |
| `ar.edu.unrc.game2048.strategy` | 6 | 100% (76/76) | 96% (45/47) | 96% (45/47) |

### Resultados de Mutación (PITest) - Pruebas EvoSuite

**Resumen del Proyecto**

| Clases | Cobertura de Líneas | Cobertura de Mutación | Fuerza de las Pruebas |
| :--- | :---: | :---: | :---: |
| 11 | 97% (267/274) | 95% (204/215) | 100% (204/204) |

**Desglose por Paquete**

| Nombre | Clases | Cobertura de Líneas | Cobertura de Mutación | Fuerza de las Pruebas |
| :--- | :---: | :---: | :---: | :---: |
| `ar.edu.unrc.game2048` | 5 | 96% (191/198) | 93% (157/168) | 100% (157/157) |
| `ar.edu.unrc.game2048.strategy` | 6 | 100% (76/76) | 100% (47/47) | 100% (47/47) |
