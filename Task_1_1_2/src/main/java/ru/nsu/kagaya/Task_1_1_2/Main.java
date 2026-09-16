package ru.nsu.kagaya.Task_1_1_2;
import java.util.Scanner;

/**
 * Точка входа
 */
public class Main {
    /**
     * Запускает раунды по желанию пользователя
     * @param args их нету
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);

        while (true) {
            System.out.println("Play round? (y/n):");
            String ans = scanner.nextLine();
            if (ans.equals("y")) {
                game.doRound();
            }
            else if (ans.equals("n")) {
                break;
            }
            else {
                System.out.println("Wrong input. Try again...");
            }
        }

    }
}