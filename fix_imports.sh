#!/bin/bash
for f in $(find src/test/java/ar/edu/unrc/game2048 -name "*.java"); do
    sed -i '/^package /a \
import ar.edu.unrc.game2048.*;\
import ar.edu.unrc.game2048.strategy.*;' "$f"
done
