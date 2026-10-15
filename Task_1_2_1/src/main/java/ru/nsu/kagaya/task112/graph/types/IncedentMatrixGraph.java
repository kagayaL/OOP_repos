package ru.nsu.kagaya.task112.graph.types;

import ru.nsu.kagaya.task112.graph.bricks.Vertex;
import ru.nsu.kagaya.task112.graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class IncedentMatrixGraph implements Graph {
    private List<List<Integer>> _matrix;
    private int _edgeCount;
    private int _vertexCount;

    public IncedentMatrixGraph() {
        _matrix = new ArrayList<>();
        _edgeCount = 0;
        _vertexCount = 0;
    }

    @Override
    public void addVertex(Vertex vertex) {
        _vertexCount++;
        for (var edge : _matrix) {
            edge.add(0);
        }
    }

    @Override
    public void removeVertex(Vertex vertex) {
        int vert = vertex.getVertex();
        for (int i = _matrix.size() - 1; i >= 0; i--) {
            if (_matrix.get(i).get(vert) != 0) {
                _matrix.remove(i);
                _edgeCount--;
            } else {
                _matrix.get(i).remove(vert);
            }
        }
        _vertexCount--;
    }

    @Override
    public void addEdge(Vertex from, Vertex to) {
        List<Integer> edge = new ArrayList<>();
        for (int i = 0; i < _vertexCount; i++) {
            if (i == from.getVertex()) {
                edge.add(1);
            } else if (i == to.getVertex()) {
                edge.add(-1);
            } else {
                edge.add(0);
            }
        }
        _matrix.add(edge);
        _edgeCount++;
    }

    @Override
    public void removeEdge(Vertex from, Vertex to) {
        for (int i = _matrix.size() - 1; i >= 0; i--) {
            List<Integer> edge = _matrix.get(i);

            if (edge.get(from.getVertex()) == 1
                    && edge.get(to.getVertex()) == -1) {
                _matrix.remove(i);
                _edgeCount--;
                break;
            }
        }
    }

    @Override
    public List<Vertex> getNeightbours(Vertex vertex) {
        List<Vertex> neighbours = new ArrayList<>();
        int vert = vertex.getVertex();

        for (List<Integer> edge : _matrix) {
            if (edge.get(vert) == 1) {
                for (int i = 0; i < _vertexCount; i++) {
                    if (edge.get(i) == -1 && !neighbours.contains(new Vertex(i))) {
                        neighbours.add(new Vertex(i));
                        break;
                    }
                }
            }
        }
        return neighbours;
    }

}