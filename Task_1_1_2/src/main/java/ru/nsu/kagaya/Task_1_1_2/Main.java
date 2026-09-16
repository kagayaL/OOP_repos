package ru.nsu.kagaya.Task_1_1_2;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {

        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Play round? (y/n):");
            String ans = scanner.nextLine();
            if (ans.equals("y")) {
                game.DoRound();
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