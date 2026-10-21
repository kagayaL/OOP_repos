package ru.nsu.kagaya.task112.algorithms;

import ru.nsu.kagaya.task112.graph.Graph;
import ru.nsu.kagaya.task112.graph.bricks.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * Топологическая сортировка вершин графа.
 */
public class TopologicSort {

    /**
     * Сортирует вершины графа в топологическом порядке.
     *
     * @param graph граф
     * @param vertexCount количество вершин
     * @return список вершин в топологическом порядке
     */
    public static List<Vertex> sort(Graph graph, int vertexCount) {
        List<Boolean> visited = new ArrayList<>();
        List<Boolean> inStack = new ArrayList<>();
        List<Vertex> order = new ArrayList<>();

        for (int i = 0; i < vertexCount; i++) {
            visited.add(Boolean.FALSE);
            inStack.add(Boolean.FALSE);
        }

        for (int i = 0; i < vertexCount; i++) {
            if (!visited.get(i)) {
                dfs(graph, new Vertex(i), visited, inStack, order);
            }
        }

        List<Vertex> result = new ArrayList<>();
        for (int i = order.size() - 1; i >= 0; i--) {
            result.add(order.get(i));
        }
        return result;
    }

    private static void dfs(Graph graph, Vertex vertex, List<Boolean> visited,
                            List<Boolean> inStack, List<Vertex> order) {
        int v = vertex.getVertex();
        visited.set(v, Boolean.TRUE);
        inStack.set(v, Boolean.TRUE);

        for (Vertex neighbour : graph.getNeighbors(vertex)) {
            int n = neighbour.getVertex();

            if (inStack.get(n)) {
                throw new IllegalArgumentException("Граф содержит цикл");
            }
            if (!visited.get(n)) {
                dfs(graph, neighbour, visited, inStack, order);
            }
        }

        inStack.set(v, Boolean.FALSE);
        order.add(vertex);
    }
}