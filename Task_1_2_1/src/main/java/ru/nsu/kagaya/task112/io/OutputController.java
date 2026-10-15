package ru.nsu.kagaya.task112.io;

import ru.nsu.kagaya.task112.graph.bricks.Vertex;

import java.util.List;

public class OutputController {

    public static void chooseGraphType() {
        System.out.println("Выбери тип графа:");
        System.out.println("1 - списки смежности");
        System.out.println("2 - матрица смежности");
        System.out.println("3 - матрица инцидентности");
    }

    public static void askGraphPath() {
        System.out.println("Путь до файла:");
    }

    public static void printVertexList(List<Vertex> vertex) {
        System.out.print("( ");

        for (var vert : vertex) {
            System.out.print(vert.getVertex() + " ");
        }
        System.out.println(")");
    }
}
