package ru.nsu.kagaya.task112.utils;

import ru.nsu.kagaya.task112.graph.bricks.Edge;

import java.util.List;

/**
 * Класс описывающий граф.
 *
 * @param vertexCount количество вершин.
 * @param edges список ребер.
 */
public record GraphData(int vertexCount, List<Edge> edges) {

}
