package ru.nsu.kagaya.task112.graph.types;

import ru.nsu.kagaya.task112.graph.bricks.Vertex;
import ru.nsu.kagaya.task112.graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class IncedentMatrixGraph implements Graph {

    private final List<List<Integer>> graphMatrix;
    private int vertexCount;

    /**
     * Конструктор инициализирует пустой граф.
     */
    public IncedentMatrixGraph() {
        graphMatrix = new ArrayList<>();
        vertexCount = 0;
    }

    @Override
    public void addVertex(Vertex vertex) {
        vertexCount++;
        for (var edge : graphMatrix) {
            edge.add(0);
        }
    }

    @Override
    public void removeVertex(Vertex vertex) {
        int vert = vertex.getVertex();
        for (int i = graphMatrix.size() - 1; i >= 0; i--) {
            if (graphMatrix.get(i).get(vert) != 0) {
                graphMatrix.remove(i);
            } else {
                graphMatrix.get(i).remove(vert);
            }
        }
        vertexCount--;
    }

    @Override
    public void addEdge(Vertex from, Vertex to) {
        List<Integer> edge = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            if (i == from.getVertex()) {
                edge.add(1);
            } else if (i == to.getVertex()) {
                edge.add(-1);
            } else {
                edge.add(0);
            }
        }
        graphMatrix.add(edge);
    }

    @Override
    public void removeEdge(Vertex from, Vertex to) {
        for (int i = graphMatrix.size() - 1; i >= 0; i--) {
            List<Integer> edge = graphMatrix.get(i);

            if (edge.get(from.getVertex()) == 1
                    && edge.get(to.getVertex()) == -1) {
                graphMatrix.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Vertex> getNeighbors(Vertex vertex) {
        List<Vertex> neighbours = new ArrayList<>();
        int vert = vertex.getVertex();

        for (List<Integer> edge : graphMatrix) {
            if (edge.get(vert) == 1) {
                for (int i = 0; i < vertexCount; i++) {
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