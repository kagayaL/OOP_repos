package ru.nsu.kagaya.task113;

import ru.nsu.kagaya.task113.expressionparts.Add;
import ru.nsu.kagaya.task113.expressionparts.Mul;
import ru.nsu.kagaya.task113.expressionparts.Number;
import ru.nsu.kagaya.task113.expressionparts.Expression;
import ru.nsu.kagaya.task113.expressionparts.Variable;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Expression e = new Add(new Number(3), new Mul(new Number(2),
                new Variable("x"))); // (3+(2*x))
        e.print();
        Expression de = e.derivative("x");
        de.print();
        int result = e.eval("x = 10; y = 13");
        System.out.println(result);
    }
}