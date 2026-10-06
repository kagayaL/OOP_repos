package ru.nsu.kagaya.task113.expressionparts;

import java.util.Map;

/**
 * Класс реализующий произведение.
 */
public class Mul extends Expression {
    private final Expression left;
    private final Expression right;

    /**
     * Конструктор произведения.
     *
     * @param left первый множитель.
     * @param right второй множитель.
     */
    public Mul(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " * " + right.toString() + ")";
    }

    @Override
    public Expression derivative(String variableName) {
        return new Add(new Mul(left.derivative(variableName), right),
                new Mul(right.derivative(variableName), left));
    }

    @Override
    protected int eval(Map<String, Integer> values) {
        return left.eval(values) * right.eval(values);
    }
}
