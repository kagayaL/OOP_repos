package ru.nsu.kagaya.task113.expressionparts;

import ru.nsu.kagaya.task113.Console;
import ru.nsu.kagaya.task113.ParseVariables;

import java.util.Map;

public abstract class Expression {

    protected static Map<String, Integer> values;

    public abstract Expression derivative(String variableName);

    public int eval(String variables) {
        return eval(ParseVariables.parse(variables));
    }

    protected abstract int eval(Map<String, Integer> values);

    public void print() {
        Console.print(this.toString());
    }

}
