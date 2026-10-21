package ru.nsu.kagaya.task112;

import ru.nsu.kagaya.task112.algorithms.TopologicSort;
import ru.nsu.kagaya.task112.graph.Graph;
import ru.nsu.kagaya.task112.io.InputController;
import ru.nsu.kagaya.task112.io.OutputController;
import ru.nsu.kagaya.task112.utils.GraphSetter;

/**
 * Точка входа.
 */
public class Main {

    /**
     * Главный метод.
     *
     * @param args аргументы - их нет.
     */
    public static void main(String[] args) {

        InputController inputController = new InputController();

        OutputController.askGraphPath();
        String path = inputController.getLine();

        OutputController.chooseGraphType();
        Graph graph = GraphSetter.setGraphType(inputController.getLine());

        graph.readGraph(path);

        OutputController.printVertexList(TopologicSort.sort(graph, 5));

    }
}