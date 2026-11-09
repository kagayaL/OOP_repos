package ru.nsu.kagaya.task112.graph.bricks;

import java.util.Objects;

/**
 * Класс реализующий вершину.
 */
public class Vertex {

    private int vertex;

    /**
     * Конструктор задающий номер вершине.
     *
     * @param vertex номер вершины.
     */
    public Vertex(int vertex) {
        this.vertex = vertex;
    }

    /**
     * Устанавливает новое значение верщине.
     *
     * @param vertex новое значение.
     */
    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    /**
     * Получает значение вершины.
     *
     * @return значение вершины.
     */
    public int getVertex() {
        return vertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vertex)) {
            return false;
        }
        Vertex other = (Vertex) o;
        return vertex == other.vertex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex);
    }
}
