package ru.nsu.kagaya.task113;

import static ru.nsu.kagaya.task113.parser.ParseExpression.parseExpression;

import java.util.Scanner;

import ru.nsu.kagaya.task113.bricks.Expression;

/**
 * Класс с главным методом.
 */
public class Main {
    /**
     * Главный метод с проверкой кода.
     *
     * @param args их нет.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введи выражение: ");
        String input = scanner.nextLine();
        Expression e = parseExpression(input);

        System.out.println("Введи переменную для дифференцирования:");
        input = scanner.nextLine();
        System.out.println("Производная по " + input + ":");
        e.derivative(input).print();

        System.out.println("Введи переменные в формате" +
                " name1 = value1 ; name2 = value2 ; ...");
        input = scanner.nextLine();
        System.out.println("Результат выражения: ");
        int result = e.eval(input);
        System.out.println(result);
    }
}