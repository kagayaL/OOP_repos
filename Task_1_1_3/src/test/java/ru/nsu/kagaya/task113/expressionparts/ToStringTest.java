package ru.nsu.kagaya.task113.expressionparts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToStringTest {

    @Test
    void testToString() {
        Add first = new Add(new Number(10), new Number(19));
        Add second = new Add(new Number(-3), new Sub(new Number(19),
                new Variable("name")));
        Div third = new Div(new Number(-3), new Mul(new Number(19),
                new Variable("name")));

        assertEquals("(10 + 19)", first.toString());
        assertEquals("(-3 + (19 - name))", second.toString());
        assertEquals("(-3 / (19 * name))", third.toString());

    }

}