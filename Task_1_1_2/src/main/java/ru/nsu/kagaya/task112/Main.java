package ru.nsu.kagaya.task112;

import java.util.Scanner;

/**
 * Точка входа.
 */
public class Main {
    /**
     * Запускает игру.
     *
     * @param args их нету
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new Game(scanner).run();
    }
}