package ru.nsu.kagaya.task112;

import java.io.File;
import java.util.List;

public interface Graph {
    void addVertex(Vertex vertex);
    void removeVertex(Vertex vertex);
    void addEdge(Vertex from, Vertex to);
    void removeEdge(Vertex from, Vertex to);
    List<Vertex> getNeightbours(Vertex vertex);
    Graph readGraph(File file);
}
