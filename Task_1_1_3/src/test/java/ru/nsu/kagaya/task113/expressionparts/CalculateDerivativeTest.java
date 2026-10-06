package ru.nsu.kagaya.task113.expressionparts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class CalculateDerivativeTest {

    @Test
    void calculate1() {
        // X^2
        Expression e = new Mul(new Variable("x"), new Variable("x"));
        //производная по X
        Expression de = e.derivative("x");
        int result = de.eval("x = 3");
        assertEquals(6, result);
        result = e.eval("x = 6");
        assertEquals(36, result);
    }

    @Test
    void calculate2() {
        // (X - 5) / X
        Expression e = new Div(new Sub(new Variable("x"), new Number(5)), new Variable("x"));
        int result = e.eval("x = 5");
        assertEquals(0, result);
        //Производная по X
        Expression de = e.derivative("x");
        result = de.eval("x = 2");
        assertEquals(1, result);
    }

    @Test
    void calculate3() {
        // (X + 5) / X
        Map<String, Integer> values = new HashMap<>();
        values.put("x", 5);

        Expression e = new Div(new Add(new Variable("x"), new Number(5)), new Variable("x"));
        int result = e.eval(values);

        assertEquals(2, result);

    }

}