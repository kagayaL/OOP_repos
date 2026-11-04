package ru.nsu.kagaya.task112;

import java.util.Scanner;
import ru.nsu.kagaya.task112.game.Game;
import ru.nsu.kagaya.task112.ui.ConsoleUI;

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
        new Game(new ConsoleUI(scanner)).run();
    }
}