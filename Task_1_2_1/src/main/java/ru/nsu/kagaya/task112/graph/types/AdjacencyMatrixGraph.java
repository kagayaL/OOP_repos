package ru.nsu.kagaya.task112.graph.types;

import ru.nsu.kagaya.task112.graph.bricks.Vertex;
import ru.nsu.kagaya.task112.graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {
    private final List<List<Integer>> _matrix;

    public AdjacencyMatrixGraph() {
        _matrix = new ArrayList<>();
    }

    @Override
    public void addVertex(Vertex vertex) {
        _matrix.add(new ArrayList<>());
        for (List<Integer> row : _matrix) {
            row.add(0);
        }
    }

    @Override
    public void removeVertex(Vertex vertex) {
        int vert = vertex.getVertex();

        _matrix.remove(vert);

        for (List<Integer> row : _matrix) {
            row.remove(vert);
        }
    }

    @Override
    public void addEdge(Vertex from, Vertex to) {
        _matrix.get(from.getVertex()).set(to.getVertex(), 1);
    }

    @Override
    public void removeEdge(Vertex from, Vertex to) {
        _matrix.get(from.getVertex()).set(to.getVertex(), 0);
    }

    @Override
    public List<Vertex> getNeightbours(Vertex vertex) {
        List<Vertex> neighbours = new ArrayList<>();
        List<Integer> row = _matrix.get(vertex.getVertex());

        for (int i = 0; i < row.size(); i++) {
            if (row.get(i) != 0) {
                neighbours.add(new Vertex(i));
            }
        }
        return neighbours;
    }

}