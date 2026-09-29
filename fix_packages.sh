#!/bin/bash
find src/test/java/ar/edu/unrc/game2048/evosuite -name "*.java" -exec sed -i 's/package ar.edu.unrc.game2048;/package ar.edu.unrc.game2048.evosuite;/g' {} +
find src/test/java/ar/edu/unrc/game2048/manual -name "*.java" -exec sed -i 's/package ar.edu.unrc.game2048;/package ar.edu.unrc.game2048.manual;/g' {} +
find src/test/java/ar/edu/unrc/game2048/manual/utils -name "*.java" -exec sed -i 's/package ar.edu.unrc.game2048.utils;/package ar.edu.unrc.game2048.manual.utils;/g' {} +
