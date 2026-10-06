package ru.nsu.kagaya.task113.expressionparts;

import java.util.Map;

/**
 * Реализует константу.
 */
public class Number extends Expression {
    private final int value;

    /**
     * Конструктор константы.
     *
     * @param value значение константы.
     */
    public Number(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public Expression derivative(String variableName) {
        return new Number(0);
    }

    @Override
    protected int eval(Map<String, Integer> values) {
        return value;
    }

}
