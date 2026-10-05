package ru.nsu.kagaya.task113.expressionparts;

import java.util.Map;

public class Div extends Expression {
    private final Expression left;
    private final Expression right;

    public Div(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " / " + right.toString() + ")";
    }

    @Override
    public Expression derivative(String variableName) {
        return new Div(new Sub(new Mul (left.derivative(variableName), right),
                new Mul(right.derivative(variableName), left)),
                new Mul(right, right));
    }

    @Override
    protected int eval(Map<String, Integer> values) {
        return left.eval(values) / right.eval(values);
    }
}
