package ru.nsu.kagaya.task113.expressionparts;

import java.util.Map;

/**
 * Класс с суммой
 */
public class Add extends Expression {
    private final Expression left;
    private final Expression right;

    /**
     * Конструктор суммы
     * @param left слагаемое 1
     * @param right слагаемое 2
     */
    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }

    @Override
    public Expression derivative(String variableName) {
        return new Add(left.derivative(variableName), right.derivative(variableName));
    }

    @Override
    protected int eval(Map<String, Integer> values) {
        return left.eval(values) + right.eval(values);
    }
}
