package ru.nsu.kagaya.task112.io;

import java.util.List;
import ru.nsu.kagaya.task112.graph.bricks.Vertex;

/**
 * Класс - контроллер вывода.
 */
public class OutputController {

    /**
     * Печатает для пользователя варианты графа.
     */
    public static void chooseGraphType() {
        System.out.println("Выбери тип графа:");
        System.out.println("1 - списки смежности");
        System.out.println("2 - матрица смежности");
        System.out.println("3 - матрица инцидентности");
    }

    /**
     * Запрашивает путь до файла.
     */
    public static void askGraphPath() {
        System.out.println("Путь до файла:");
    }

    /**
     * Печатает список вершин.
     *
     * @param vertex список вершин.
     */
    public static void printVertexList(List<Vertex> vertex) {
        System.out.print("( ");

        for (var vert : vertex) {
            System.out.print(vert.getVertex() + " ");
        }
        System.out.println(")");
    }
}
