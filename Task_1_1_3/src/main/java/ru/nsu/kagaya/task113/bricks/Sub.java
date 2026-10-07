package ru.nsu.kagaya.task113.bricks;

import java.util.Map;

/**
 * Реализация разности.
 */
public class Sub extends Expression {
    private final Expression left;
    private final Expression right;

    /**
     * Конструктор для разности.
     *
     * @param left уменьшаемое.
     * @param right вычитаемое.
     */
    public Sub(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " - " + right.toString() + ")";
    }

    @Override
    public Expression derivative(String variableName) {
        return new Sub(left.derivative(variableName), right.derivative(variableName));
    }

    @Override
    protected int eval(Map<String, Integer> values) {
        return left.eval(values) - right.eval(values);
    }
}
