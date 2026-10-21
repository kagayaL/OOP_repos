package ru.nsu.kagaya.task112.graph.bricks;

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
}
