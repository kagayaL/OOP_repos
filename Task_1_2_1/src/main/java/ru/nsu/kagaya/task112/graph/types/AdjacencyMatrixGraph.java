package ru.nsu.kagaya.task112.graph.types;

import java.util.ArrayList;
import java.util.List;

import ru.nsu.kagaya.task112.graph.bricks.Vertex;
import ru.nsu.kagaya.task112.graph.Graph;


/**
 * Граф на матрице смежности.
 */
public class AdjacencyMatrixGraph implements Graph {

    private final List<List<Integer>> graphMatrix;

    /**
     * Конструктор инициализирует пустой граф.
     */
    public AdjacencyMatrixGraph() {
        graphMatrix = new ArrayList<>();
    }

    @Override
    public void addVertex(Vertex vertex) {
        int newSize = graphMatrix.size() + 1;

        for (List<Integer> row : graphMatrix) {
            row.add(0);
        }

        List<Integer> newRow = new ArrayList<>();
        for (int i = 0; i < newSize; i++) {
            newRow.add(0);
        }
        graphMatrix.add(newRow);
    }

    @Override
    public void removeVertex(Vertex vertex) {
        int vert = vertex.getVertex();

        graphMatrix.remove(vert);

        for (List<Integer> row : graphMatrix) {
            row.remove(vert);
        }
    }

    @Override
    public void addEdge(Vertex from, Vertex to) {
        graphMatrix.get(from.getVertex()).set(to.getVertex(), 1);
    }

    @Override
    public void removeEdge(Vertex from, Vertex to) {
        graphMatrix.get(from.getVertex()).set(to.getVertex(), 0);
    }

    @Override
    public List<Vertex> getNeighbors(Vertex vertex) {
        List<Vertex> neighbours = new ArrayList<>();
        List<Integer> row = graphMatrix.get(vertex.getVertex());

        for (int i = 0; i < row.size(); i++) {
            if (row.get(i) != 0) {
                neighbours.add(new Vertex(i));
            }
        }
        return neighbours;
    }

}