package ru.nsu.kagaya.task113.parser;

import ru.nsu.kagaya.task113.bricks.Add;
import ru.nsu.kagaya.task113.bricks.Div;
import ru.nsu.kagaya.task113.bricks.Expression;
import ru.nsu.kagaya.task113.bricks.Mul;
import ru.nsu.kagaya.task113.bricks.Number;
import ru.nsu.kagaya.task113.bricks.Sub;
import ru.nsu.kagaya.task113.bricks.Variable;

/**
 * Класс для парсинга выражений.
 */
public class ParseExpression {

    /**
     * Метод создающий структуру из строки.
     *
     * @param expr строка с выражение.
     * @return структура с выражением.
     */
    public static Expression parseExpression(String expr) {
        expr = expr.replace(" ", "");
        int borderCount = 0;

        if (expr.charAt(0) != Token.LEFT_BORDER.getSymbol()) {
            if (Character.isDigit(expr.charAt(0))) {
                return new Number(Integer.parseInt(expr));
            }
            return new Variable(expr);
        }

        for (int i = 0; i < expr.length(); i++) {
            char currentChar = expr.charAt(i);
            Token currentToken = Token.getToken(currentChar);

            if (currentToken == Token.LEFT_BORDER) {
                borderCount++;
            } else if (currentToken == Token.RIGHT_BORDER) {
                borderCount--;
            } else if (borderCount == 1 && currentToken != null &&
                    currentToken.isOperator()) {
                Expression left = getMonome(i - 1, expr, -1);
                Expression right = getMonome(i + 1, expr, 1);
                switch (currentToken) {
                    case ADD:
                        return new Add(left, right);
                    case SUB:
                        return new Sub(left, right);
                    case MUL:
                        return new Mul(left, right);
                    case DIV:
                        return new Div(left, right);
                    default:
                        return null;
                }
            }
        }

        return null;
    }

    private static Expression getMonome(int position, String expr, int step) {
        int borderCount = 0;
        StringBuilder monome = new StringBuilder();

        while (position >= 0 && position < expr.length()) {
            char currentChar = expr.charAt(position);
            Token currentToken = Token.getToken(currentChar);

            if (currentToken == Token.RIGHT_BORDER) {
                borderCount++;
            } else if (currentToken == Token.LEFT_BORDER) {
                borderCount--;
            }

            monome.append(currentChar);

            if (borderCount == 0 && !Character.isLetterOrDigit(currentChar)) {
                break;
            }
            if (borderCount == 0 && Character.isLetterOrDigit(currentChar)
                    && (position + step < 0 || position + step >= expr.length()
                    || !Character.isLetterOrDigit(expr.charAt(position + step)))) {
                break;
            }

            position += step;
        }

        if (step < 0) {
            monome.reverse();
        }
        return parseExpression(monome.toString());
    }

}