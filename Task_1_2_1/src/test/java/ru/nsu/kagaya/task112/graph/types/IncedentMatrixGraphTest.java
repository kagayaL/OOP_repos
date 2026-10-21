package ru.nsu.kagaya.task112.graph.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import ru.nsu.kagaya.task112.graph.Graph;
import ru.nsu.kagaya.task112.graph.bricks.Vertex;

class IncedentMatrixGraphTest {

    @Test
    void addVertex() {
        Graph graph = new IncedentMatrixGraph();
        graph.addVertex(new Vertex(0));

        assertEquals(List.of(), graph.getNeighbors(new Vertex(0)));
    }

    @Test
    void addEdge() {
        Graph graph = new IncedentMatrixGraph();
        graph.addVertex(new Vertex(0));
        graph.addVertex(new Vertex(1));
        graph.addEdge(new Vertex(0), new Vertex(1));

        assertEquals(List.of(new Vertex(1)), graph.getNeighbors(new Vertex(0)));
    }

    @Test
    void removeEdge() {
        Graph graph = new IncedentMatrixGraph();
        graph.addVertex(new Vertex(0));
        graph.addVertex(new Vertex(1));
        graph.addEdge(new Vertex(0), new Vertex(1));
        graph.removeEdge(new Vertex(0), new Vertex(1));

        assertEquals(List.of(), graph.getNeighbors(new Vertex(0)));
    }

    @Test
    void removeVertex() {
        Graph graph = new IncedentMatrixGraph();
        graph.addVertex(new Vertex(0));
        graph.addVertex(new Vertex(1));
        graph.addVertex(new Vertex(2));
        graph.addEdge(new Vertex(0), new Vertex(2));
        graph.addEdge(new Vertex(1), new Vertex(2));

        graph.removeVertex(new Vertex(2));

        assertEquals(List.of(), graph.getNeighbors(new Vertex(0)));
        assertEquals(List.of(), graph.getNeighbors(new Vertex(1)));
    }

    @Test
    void getNeighborsMultiple() {
        Graph graph = new IncedentMatrixGraph();
        graph.addVertex(new Vertex(0));
        graph.addVertex(new Vertex(1));
        graph.addVertex(new Vertex(2));
        graph.addEdge(new Vertex(0), new Vertex(1));
        graph.addEdge(new Vertex(0), new Vertex(2));

        List<Vertex> neighbours = graph.getNeighbors(new Vertex(0));

        assertEquals(2, neighbours.size());
        assertTrue(neighbours.contains(new Vertex(1)));
        assertTrue(neighbours.contains(new Vertex(2)));
    }
}