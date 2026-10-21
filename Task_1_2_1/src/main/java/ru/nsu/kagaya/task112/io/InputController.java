package ru.nsu.kagaya.task112.io;

import java.util.Scanner;

/**
 * Класс реализующий контроллер ввода.
 */
public class InputController {
    private final Scanner scanner;

    /**
     * Конструктор инициализирующий сканнер.
     */
    public InputController() {
        scanner = new Scanner(System.in);
    }

    /**
     * Считывает консольнный ввод.
     *
     * @return консольнный ввод.
     */
    public String getLine() {
        return scanner.next();
    }

}
