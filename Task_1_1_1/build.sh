#!/bin/bash

echo "=============compile files================"
javac -d build/classes src/main/java/ru/nsu/kagaya/Task_1_1_1/*.java

echo "===========generate documentation========="
javadoc -d build/docs src/main/java/ru/nsu/kagaya/Task_1_1_1/*.java
echo "=========================================="

echo "===============create jar================="
jar cf build/heapsort.jar -C build/classes .

echo "==============run programm================"
java -cp build/classes ru.nsu.kagaya.Task_1_1_1.Main
echo "=========================================="