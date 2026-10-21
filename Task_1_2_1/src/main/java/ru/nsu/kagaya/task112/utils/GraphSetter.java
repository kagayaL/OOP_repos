package ru.nsu.kagaya.task112.utils;

import ru.nsu.kagaya.task112.graph.Graph;
import ru.nsu.kagaya.task112.graph.types.AdjacencyListGraph;
import ru.nsu.kagaya.task112.graph.types.AdjacencyMatrixGraph;
import ru.nsu.kagaya.task112.graph.types.IncedentMatrixGraph;

/**
 * Класс устанавливающий тип графа.
 */
public class GraphSetter {

    /**
     * Устанавливает тип графа исходя из ответа пользователя.
     *
     * @param answer ответ пользователя.
     * @return тип графа.
     */
    public static Graph setGraphType(String answer) {
        var number = Integer.parseInt(answer);
        return switch (number) {
            case 1 -> new AdjacencyListGraph();
            case 2 -> new AdjacencyMatrixGraph();
            case 3 -> new IncedentMatrixGraph();
            default -> throw new IllegalArgumentException("Неправильный тип графа: " + number);
        };
    }
}
