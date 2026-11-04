package ru.nsu.kagaya.Task_1_1_1;

import java.util.Scanner;

/**
 * Entrance point
 */
public class Main {
    /**
     * Entrance main function
     * @param args nothing expected
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers with space:");
        String input = scanner.nextLine();
        String[] splitText = input.split("\\s+");

        int[] arr = new int[splitText.length];
        for (int i = 0; i < splitText.length; i++) {
            if (!splitText[i].isEmpty()) {
                arr[i] = Integer.parseInt(splitText[i]);
            }
        }

        Sort.sort(arr);

        System.out.print("Result: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        scanner.close();
    }
}