# Reporte de Análisis de Cobertura y Generación Automática de Pruebas

## 1. Generación automática de pruebas con EvoSuite

EvoSuite generó pruebas automáticamente para explorar diferentes comportamientos de `Board`, `Cell` y `MainCLI`.

Durante la generación se probaron casos como:

* Tableros de dimensiones grandes, por ejemplo `70x70`.
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

EvoSuite genera sus aserciones a partir del comportamiento observado durante la ejecución. Por lo tanto, muchas verifican constantes, estados internos o valores concretos que no necesariamente representan reglas funcionales del juego.

Además, si el código contiene un comportamiento incorrecto, EvoSuite puede tomarlo como resultado esperado y generar una prueba que simplemente lo preserve.

Por este motivo, las pruebas generadas son útiles principalmente para **exploración y regresión**, pero no reemplazan las pruebas que verifican los requisitos funcionales.

## 3. Hallazgos

Las pruebas generadas permitieron detectar algunos comportamientos no contemplados inicialmente:

* **Puntuaciones negativas:** el sistema permite registrar valores menores que cero.
* **Posiciones inválidas:** determinadas operaciones permiten utilizar índices menores que cero.
* **`MainCLI`:** aunque EvoSuite consiguió una cobertura alta, los tests no aportaron una validación funcional significativa. En la mayoría de los casos intentaban continuar jugando hasta quedarse sin entradas disponibles. Debido al ciclo de interacción del juego, esto terminaba produciendo una `NoSuchElementException`. La excepción no representa necesariamente un error del juego, sino que se produce porque el test ya no tiene más datos para proporcionar.

Esto muestra que una mayor cobertura no implica necesariamente una mayor calidad o utilidad funcional de las pruebas.

## 4. Conclusión

EvoSuite permitió explorar automáticamente casos que no estaban cubiertos por las pruebas existentes y detectar problemas relacionados con validaciones y entradas inválidas.

Sin embargo, sus pruebas deben analizarse antes de considerarlas útiles, ya que algunas aserciones simplemente reproducen el comportamiento observado y pueden incluso preservar comportamientos incorrectos.

Por lo tanto, EvoSuite se utiliza como complemento de las pruebas funcionales, principalmente para **exploración, detección de casos inesperados y regresión**.

## 5. Resultados de Cobertura (JaCoCo)

Los resultados generales obtenidos del reporte de JaCoCo reflejan una alta cobertura global del código:

* **Cobertura de Instrucciones:** 97% (38 instrucciones no cubiertas de un total de 1.478).
* **Cobertura de Ramas (Branches):** 90% (18 ramas no cubiertas de un total de 181).

**Desglose por paquetes:**
* `ar.edu.unrc.game2048`: 96% de instrucciones, 88% de ramas.
* `ar.edu.unrc.game2048.strategy`: 100% de instrucciones, 100% de ramas.
