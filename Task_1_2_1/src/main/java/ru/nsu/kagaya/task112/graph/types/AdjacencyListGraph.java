package ru.nsu.kagaya.task112.graph.types;

import java.util.ArrayList;
import java.util.List;
import ru.nsu.kagaya.task112.graph.bricks.Vertex;
import ru.nsu.kagaya.task112.graph.Graph;

/**
 * Граф на списке смежности.
 */
public class AdjacencyListGraph implements Graph {
    private final List<List<Vertex>> graphList;

    /**
     * Конструктор инициализирует пустой граф.
     */
    public AdjacencyListGraph() {
        graphList = new ArrayList<>();
    }

    @Override
    public void addVertex(Vertex vertex) {
        graphList.add(new ArrayList<>());
    }

    @Override
    public void removeVertex(Vertex vertex) {
        int deletedVertex = vertex.getVertex();

        //удаляем вершину из листа
        graphList.remove(deletedVertex);

        //сдвигаем индекс вершин и удаляем из списка соседей
        // удаленныю вершину
        for (List<Vertex> neighbours : graphList) {
            for (int i = neighbours.size() - 1; i >= 0; i--) {

                var neighbour = neighbours.get(i);

                if (neighbour.getVertex() > deletedVertex) {
                    neighbour.setVertex(neighbour.getVertex() - 1);
                } else if (neighbour.getVertex() == deletedVertex) {
                    neighbours.remove(i);
                }
            }
        }
    }

    @Override
    public void addEdge(Vertex from, Vertex to) {
        graphList.get(from.getVertex()).add(to);
    }

    @Override
    public void removeEdge(Vertex from, Vertex to) {
        List<Vertex> neighbours = graphList.get(from.getVertex());

        for (int i = neighbours.size() - 1; i >= 0; i--) {
            if (neighbours.get(i).getVertex() == to.getVertex()) {
                neighbours.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Vertex> getNeighbors(Vertex vertex) {
        return new ArrayList<>(graphList.get(vertex.getVertex()));
    }

}
