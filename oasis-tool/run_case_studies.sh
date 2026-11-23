#!/bin/bash
# Corre los casos de estudio con un LLM real. Requiere una API key gratuita:
#   export OPENROUTER_API_KEY=...     (https://openrouter.ai/collections/free-models)
#   o bien  export NVIDIA_API_KEY=... y PROVIDER=nvidia   (https://build.nvidia.com/models)
#   export OASIS_MODEL=<id del modelo>   (por ejemplo, uno de la lista de modelos gratuitos, terminado en :free)
# Las respuestas quedan en .oasis_cache/ (se puede commitear como evidencia; no contiene la API key)
# y los informes en results/real/. NO escribas la API key en archivos ni la pegues en chats.
set -e
cd "$(dirname "${BASH_SOURCE[0]}")"
PROVIDER="${PROVIDER:-openrouter}"
mkdir -p results/real
V2='result.length == row.length && Arrays.stream(result).sum() == Arrays.stream(old_row).sum() && Subject.compacted(result) && (Subject.nonzero(result) < Subject.nonzero(old_row) || !Subject.hasMergeablePair(old_row))'
V3='Arrays.equals(result, Subject.expectedSlideLeft(old_row))'

# Caso 1 (falso positivo): aserción original y refinada
python3 -m oasis fp --provider "$PROVIDER" --spec cases/score_cap/spec.json \
    --out results/real/score_cap-iter1.md --json results/real/score_cap-iter1.json
python3 -m oasis fp --provider "$PROVIDER" --spec cases/score_cap/spec.json \
    --assertion 'result >= 0 && result % 4 == 0 && result <= Arrays.stream(row).sum()' \
    --out results/real/score_cap-iter2.md --json results/real/score_cap-iter2.json

# Caso 2 (falso negativo): aserción débil, aserción intermedia y aserción basada en implementación de referencia
python3 -m oasis fn --provider "$PROVIDER" --spec cases/slide_left/spec.json \
    --out results/real/slide_left-iter1.md --json results/real/slide_left-iter1.json
python3 -m oasis fn --provider "$PROVIDER" --spec cases/slide_left/spec.json --assertion "$V2" \
    --out results/real/slide_left-iter2.md --json results/real/slide_left-iter2.json
python3 -m oasis fn --provider "$PROVIDER" --spec cases/slide_left_ref/spec.json --assertion "$V3" \
    --out results/real/slide_left-iter3.md --json results/real/slide_left-iter3.json
