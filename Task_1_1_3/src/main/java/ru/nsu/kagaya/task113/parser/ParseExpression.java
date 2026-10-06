package ru.nsu.kagaya.task113.parser;

import java.util.List;
import ru.nsu.kagaya.task113.expressionparts.Add;
import ru.nsu.kagaya.task113.expressionparts.Div;
import ru.nsu.kagaya.task113.expressionparts.Expression;
import ru.nsu.kagaya.task113.expressionparts.Mul;
import ru.nsu.kagaya.task113.expressionparts.Number;
import ru.nsu.kagaya.task113.expressionparts.Sub;
import ru.nsu.kagaya.task113.expressionparts.Variable;

/**
 * Класс для парсинга выражений.
 */
public class ParseExpression {
    private static final Character RIGHT_BORDER = ')';
    private static final Character LEFT_BORDER = '(';
    private static final List<Character> OPS = List.of('+', '-', '/', '*');

    /**
     * Метод создающий структуру из строки.
     *
     * @param expr строка с выражение.
     * @return структура с выражением.
     */
    public static Expression parseExpression(String expr) {
        expr = expr.replace(" ", "");
        int borderCount = 0;

        if (expr.charAt(0) != LEFT_BORDER) {
            if (Character.isDigit(expr.charAt(0))) {
                return new Number(Integer.parseInt(expr));
            }
            return new Variable(expr);
        }

        for (int i = 0; i < expr.length(); i++) {
            char currentChar = expr.charAt(i);

            if (currentChar == LEFT_BORDER) {
                borderCount++;
            }
            else if (currentChar == RIGHT_BORDER) {
                borderCount--;
            }
            else if (borderCount == 1 && OPS.contains(currentChar)) {
                Expression left = getLeftMonome(i - 1, expr);
                Expression right = getRightMonome(i + 1, expr);
                switch (currentChar) {
                    case '+':
                        return new Add(left, right);
                    case '-':
                        return new Sub(left, right);
                    case '*':
                        return new Mul(left, right);
                    case '/':
                        return new Div(left, right);
                    default:
                        return null;
                }
            }
        }

        return null;
    }

    private static Expression getLeftMonome(int currentPosition, String expr) {
        int borderCount = 0;
        StringBuilder leftMonome = new StringBuilder();

        while (currentPosition >= 0) {
            char currentChar = expr.charAt(currentPosition);

            if (currentChar == RIGHT_BORDER) {
                borderCount++;
            } else if (currentChar == LEFT_BORDER) {
                borderCount--;
            }

            leftMonome.append(currentChar);

            if (borderCount == 0 && !Character.isLetterOrDigit(currentChar)) {
                break;
            }
            if (borderCount == 0 && Character.isLetterOrDigit(currentChar)
                    && (currentPosition == 0
                    || !Character.isLetterOrDigit(expr.charAt(currentPosition - 1)))) {
                break;
            }

            currentPosition--;
        }

        leftMonome.reverse();
        return parseExpression(leftMonome.toString());
    }

    private static Expression getRightMonome(int currentPosition, String expr) {
        int borderCount = 0;
        StringBuilder rightMonome = new StringBuilder();

        while (currentPosition < expr.length()) {
            char currentChar = expr.charAt(currentPosition);

            if (currentChar == LEFT_BORDER) {
                borderCount++;
            } else if (currentChar == RIGHT_BORDER) {
                borderCount--;
            }

            rightMonome.append(currentChar);

            if (borderCount == 0 && !Character.isLetterOrDigit(currentChar)) {
                break;
            }
            if (borderCount == 0 && Character.isLetterOrDigit(currentChar)
                    && (currentPosition == expr.length() - 1
                    || !Character.isLetterOrDigit(expr.charAt(currentPosition + 1)))) {
                break;
            }

            currentPosition++;
        }

        return parseExpression(rightMonome.toString());
    }
}