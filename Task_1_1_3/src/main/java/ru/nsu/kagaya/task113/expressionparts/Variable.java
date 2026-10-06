package ru.nsu.kagaya.task113.expressionparts;

import java.util.Map;
import java.util.Objects;

/**
 * Класс с переменной.
 * derivative - если производная по этой переменной,
 * то возвращает new Number(1),
 * иначе new Number(0)
 * eval - ищет значение переменной в хеш таблице
 * и подставляет
 */
public class Variable extends Expression {
    private final String name;

    /**
     * конструктор пересенной
     * @param name имя переменной
     */
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
