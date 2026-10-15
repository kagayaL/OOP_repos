package ru.nsu.kagaya.task112;

public class Edge {
    private final int _from;
    private final int _to;

    public Edge(int from, int to) {
        _from = from;
        _to = to;
    }

    public int from() {
        return _from;
    }

    public int to() {
        return _to;
    }
}
