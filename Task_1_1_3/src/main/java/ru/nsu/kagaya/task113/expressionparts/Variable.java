package ru.nsu.kagaya.task113.expressionparts;

import java.util.Map;
import java.util.Objects;

public class Variable extends Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Expression derivative(String variableName) {
        if (Objects.equals(name, variableName)) {
            return new Number(1);
        }
        return new Number(0);
    }

    @Override
    protected int eval(Map<String, Integer> values) {
        return values.get(name);
    }
}
