package ru.nsu.kagaya.task112.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import ru.nsu.kagaya.task112.graph.Graph;
import ru.nsu.kagaya.task112.graph.bricks.Vertex;
import ru.nsu.kagaya.task112.graph.types.AdjacencyListGraph;

class TopologicSortTest {

    @Test
    void emptyGraph() {
        Graph graph = new AdjacencyListGraph();

        List<Vertex> result = TopologicSort.sort(graph, 0);

        assertEquals(0, result.size());
    }

    @Test
    void simpleGraph() {
        Graph graph = new AdjacencyListGraph();
        graph.addVertex(new Vertex(0));
        graph.addVertex(new Vertex(1));
        graph.addVertex(new Vertex(2));
        graph.addEdge(new Vertex(0), new Vertex(1));
        graph.addEdge(new Vertex(1), new Vertex(2));

        List<Vertex> result = TopologicSort.sort(graph, 3);

        assertEquals(3, result.size());
        assertEquals(0, result.get(0).getVertex());
        assertEquals(1, result.get(1).getVertex());
        assertEquals(2, result.get(2).getVertex());
    }

    @Test
    void cycleThrows() {
        Graph graph = new AdjacencyListGraph();
        graph.addVertex(new Vertex(0));
        graph.addVertex(new Vertex(1));
        graph.addVertex(new Vertex(2));
        graph.addEdge(new Vertex(0), new Vertex(1));
        graph.addEdge(new Vertex(1), new Vertex(2));
        graph.addEdge(new Vertex(2), new Vertex(0));

        assertThrows(IllegalArgumentException.class,
                () -> TopologicSort.sort(graph, 3));
    }
}