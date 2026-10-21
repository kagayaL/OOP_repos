package ru.nsu.kagaya.task112.graph;

import ru.nsu.kagaya.task112.graph.bricks.Edge;
import ru.nsu.kagaya.task112.utils.GraphData;
import ru.nsu.kagaya.task112.utils.GraphReader;
import ru.nsu.kagaya.task112.graph.bricks.Vertex;

import java.io.IOException;
import java.util.List;

/**
 * Интерфейс графа.
 */
public interface Graph {

    /**
     * Добавляет вершину в граф.
     *
     * @param vertex вершина.
     */
    void addVertex(Vertex vertex);

    /**
     * Удаляет вершину из графа.
     *
     * @param vertex вершина.
     */
    void removeVertex(Vertex vertex);

    /**
     * Добавляет ребро между вершинами.
     *
     * @param from начальная вершина.
     * @param to конечная вершина.
     */
    void addEdge(Vertex from, Vertex to);

    /**
     * Удаляет ребро между вершинами.
     *
     * @param from начальная вершина.
     * @param to конечная вершина.
     */
    void removeEdge(Vertex from, Vertex to);

    /**
     * Возвращает соседей вершины.
     *
     * @param vertex вершина.
     * @return список соседей.
     */
    List<Vertex> getNeighbors(Vertex vertex);

    /**
     * Читает граф из файла.
     *
     * @param path путь до файла.
     */
    default void readGraph(String path) {
        try {
            GraphData data = GraphReader.readFromFile(path);
            for (int i = 0; i < data.vertexCount(); i++) {
                addVertex(new Vertex(i));
            }
            for (Edge edge : data.edges()) {
                addEdge(new Vertex(edge.from()), new Vertex(edge.to()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать граф: " + path, e);
        }
    }
}