package ru.nsu.kagaya.task112.graph;

import ru.nsu.kagaya.task112.graph.bricks.Edge;
import ru.nsu.kagaya.task112.utils.GraphData;
import ru.nsu.kagaya.task112.utils.GraphReader;
import ru.nsu.kagaya.task112.graph.bricks.Vertex;

import java.io.IOException;
import java.util.List;

public interface Graph {
    void addVertex(Vertex vertex);
    void removeVertex(Vertex vertex);
    void addEdge(Vertex from, Vertex to);
    void removeEdge(Vertex from, Vertex to);
    List<Vertex> getNeightbours(Vertex vertex);

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
