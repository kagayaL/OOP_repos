package ru.nsu.kagaya.task112.utils;

import ru.nsu.kagaya.task112.graph.Graph;
import ru.nsu.kagaya.task112.graph.types.AdjacencyListGraph;
import ru.nsu.kagaya.task112.graph.types.AdjacencyMatrixGraph;
import ru.nsu.kagaya.task112.graph.types.IncedentMatrixGraph;

public class GraphSetter {

    public static Graph setGraphType(String answer) {
        Integer number = Integer.parseInt(answer);
        return switch (number) {
            case 1 -> new AdjacencyListGraph();
            case 2 -> new AdjacencyMatrixGraph();
            case 3 -> new IncedentMatrixGraph();
            default -> throw new IllegalArgumentException("Неправильный тип графа: " + number);
        };
    }
}
