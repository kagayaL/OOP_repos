package ru.nsu.kagaya.task112.graph.types;

import ru.nsu.kagaya.task112.graph.bricks.Vertex;
import ru.nsu.kagaya.task112.graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph implements Graph {
    private List<List<Vertex>> _list;

    public AdjacencyListGraph() {
        _list = new ArrayList<>();
    }

    @Override
    public void addVertex(Vertex vertex) {
        _list.add(new ArrayList<>());
    }

    @Override
    public void removeVertex(Vertex vertex) {
        int vert = vertex.getVertex();

        //удаляем вершину из листа
        _list.remove(vert);

        //сдвигаем индекс вершин и удаляем из списка соседей
        // удаленныю вершину
        for (List<Vertex> neighbours : _list) {
            for (int i = neighbours.size() - 1; i >= 0; i--) {

                var neighbour = neighbours.get(i);

                if (neighbour.getVertex() > vert) {
                    neighbour.setVertex(neighbour.getVertex() - 1);
                } else if (neighbour.getVertex() == vert) {
                    neighbours.remove(i);
                }
            }
        }
    }

    @Override
    public void addEdge(Vertex from, Vertex to) {
        _list.get(from.getVertex()).add(to);
    }

    @Override
    public void removeEdge(Vertex from, Vertex to) {
        List<Vertex> neighbours = _list.get(from.getVertex());

        for (int i = neighbours.size() - 1; i >= 0; i--) {
            if (neighbours.get(i).getVertex() == to.getVertex()) {
                neighbours.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Vertex> getNeightbours(Vertex vertex) {
        return new ArrayList<>(_list.get(vertex.getVertex()));
    }

}
