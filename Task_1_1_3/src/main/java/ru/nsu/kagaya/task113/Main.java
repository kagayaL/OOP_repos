package ru.nsu.kagaya.task113;

import ru.nsu.kagaya.task113.expressionparts.Add;
import ru.nsu.kagaya.task113.expressionparts.Mul;
import ru.nsu.kagaya.task113.expressionparts.Number;
import ru.nsu.kagaya.task113.expressionparts.Expression;
import ru.nsu.kagaya.task113.expressionparts.Variable;
import ru.nsu.kagaya.task113.parser.ParseExpression;

import java.util.Scanner;

import static ru.nsu.kagaya.task113.parser.ParseExpression.parseExpression;

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

        Expression e = new Add(new Number(3), new Mul(new Number(2),
                new Variable("x"))); // (3+(2*x))
        e.print();
        Expression de = e.derivative("x");
        de.print();
        int result = e.eval("x = 10; y = 13");
        System.out.println(result);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        e = parseExpression(input);
        e.print();
        result = e.eval("x = 10; y = 13");
        System.out.println(result);
    }
}