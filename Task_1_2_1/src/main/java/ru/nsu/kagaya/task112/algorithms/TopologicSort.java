package ru.nsu.kagaya.task112;

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
        boolean[] visited = new boolean[vertexCount];
        boolean[] inStack = new boolean[vertexCount];
        List<Vertex> order = new ArrayList<>();

        for (int i = 0; i < vertexCount; i++) {
            if (!visited[i]) {
                dfs(graph, new Vertex(i), visited, inStack, order);
            }
        }

        List<Vertex> result = new ArrayList<>();
        for (int i = order.size() - 1; i >= 0; i--) {
            result.add(order.get(i));
        }
        return result;
    }

    private static void dfs(Graph graph, Vertex vertex, boolean[] visited,
                            boolean[] inStack, List<Vertex> order) {
        int v = vertex.getVertex();
        visited[v] = true;
        inStack[v] = true;

        for (Vertex neighbour : graph.getNeightbours(vertex)) {
            int n = neighbour.getVertex();

            if (inStack[n]) {
                throw new IllegalArgumentException("Граф содержит цикл");
            }
            if (!visited[n]) {
                dfs(graph, neighbour, visited, inStack, order);
            }
        }

        inStack[v] = false;
        order.add(vertex);
    }
}