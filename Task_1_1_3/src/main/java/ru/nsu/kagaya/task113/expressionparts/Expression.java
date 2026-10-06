package ru.nsu.kagaya.task113.expressionparts;

import ru.nsu.kagaya.task113.console.Console;
import ru.nsu.kagaya.task113.parser.ParseVariables;

import java.util.Map;

/**
 * Общий класс всех выражений.
 */
public abstract class Expression {

    protected static Map<String, Integer> values;

    /**
     * Метод находящий производную от заданной переменной.
     *
     * @param variableName имя переменной.
     * @return производная.
     */
    public abstract Expression derivative(String variableName);

    /**
     * Промежуточный метод для вычисления.
     * выражения с заданными значениями переменных.
     * Использует парсер, чтобы передать основному методу.
     * хеш таблицу.
     *
     * @param variables переменные в формате:
     *                  name1 = value1 ; ... ; ...
     * @return результат подсчета основного метода.
     */
    public int eval(String variables) {
        return eval(ParseVariables.parse(variables));
    }

    /**
     * Основной метод для вычисления выражений. Подставляет вместо переменных их значения.
     *
     * @param values хеш таблица имя - значение.
     * @return результат вычисления.
     */
    protected abstract int eval(Map<String, Integer> values);

    /**
     * Метод для вывода выражения в консоль
     */
    public void print() {
        Console.print(this.toString());
    }

}
