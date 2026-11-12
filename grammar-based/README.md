# Grammar-Based Test Generator for 2048

Generador basado en gramáticas para fuzzing y testing de tableros del juego 2048.

## Requisitos

- Python >= 3.13
- [uv](https://docs.astral.sh/uv/) (recomendado) o `venv` estándar de Python

## Setup del Entorno

### Con `uv` (Recomendado)

El entorno y sus dependencias de desarrollo (`pytest`, `ruff`) se sincronizan automáticamente:

```bash
cd grammar-based
uv sync
```

Para activar el entorno virtual en tu shell:
```bash
source .venv/bin/activate
```

O podés ejecutar cualquier comando directamente a través de `uv run`:
```bash
uv run python main.py [n]
```

### Con `venv` estándar (Alternativa)

```bash
cd grammar-based
python3 -m venv .venv
source .venv/bin/activate
pip install -e ".[dev]"
```

## Uso

Generar 1 tablero (por defecto):
```bash
uv run python main.py
```

Generar $N$ tableros:
```bash
uv run python main.py 5
```

## Testing y Calidad de Código

Ejecutar tests unitarios:
```bash
uv run pytest
```

Ejecutar linter / formateador:
```bash
uv run ruff check .
```

## Integración con Reliable 2048

El formato de salida es:
```text
<size> <cell_0>,<cell_1>,...,<cell_(size*size-1)>
```

Por ejemplo, para inicializar el juego CLI en Java con un tablero generado:
```bash
mvn exec:java -Dexec.mainClass="ar.edu.unrc.game2048.MainCLI" -Dexec.args='4 "[0,0,0,0,0,2,0,0,0,0,0,0,2,0,0,2]"'
```
