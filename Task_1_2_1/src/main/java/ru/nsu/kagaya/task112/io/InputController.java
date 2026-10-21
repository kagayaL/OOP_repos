package ru.nsu.kagaya.task112.io;

import java.util.Scanner;

/**
 * Класс реализующий контроллер ввода.
 */
public class InputController {
    private final Scanner _scanner;

    /**
     * Конструктор инициализирующий сканнер.
     */
    public InputController() {
        _scanner = new Scanner(System.in);
    }

    /**
     * Считывает консольнный ввод.
     *
     * @return консольнный ввод.
     */
    public String getLine() {
        return _scanner.next();
    }

}
