package ru.nsu.kagaya.task113.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import ru.nsu.kagaya.task113.bricks.Add;
import ru.nsu.kagaya.task113.bricks.Div;
import ru.nsu.kagaya.task113.bricks.Expression;
import ru.nsu.kagaya.task113.bricks.Mul;
import ru.nsu.kagaya.task113.bricks.Number;
import ru.nsu.kagaya.task113.bricks.Sub;
import ru.nsu.kagaya.task113.bricks.Variable;

class ParseExpressionTest {

    @Test
    void parseNumber() {
        Expression e = ParseExpression.parseExpression("42");
        assertTrue(e instanceof Number);
        assertEquals(42, e.eval(""));
    }

    @Test
    void parseVariable() {
        Expression e = ParseExpression.parseExpression("x");
        assertTrue(e instanceof Variable);
        assertEquals(10, e.eval("x = 10"));
    }

    @Test
    void parseAdd() {
        Expression e = ParseExpression.parseExpression("(3+5)");
        assertTrue(e instanceof Add);
        assertEquals(8, e.eval(""));
    }

    @Test
    void parseSub() {
        Expression e = ParseExpression.parseExpression("(3-5)");
        assertTrue(e instanceof Sub);
        assertEquals(-2, e.eval(""));
    }

    @Test
    void parseMul() {
        Expression e = ParseExpression.parseExpression("(3*5)");
        assertTrue(e instanceof Mul);
        assertEquals(15, e.eval(""));
    }

    @Test
    void parseDiv() {
        Expression e = ParseExpression.parseExpression("(10/2)");
        assertTrue(e instanceof Div);
        assertEquals(5, e.eval(""));
    }

    @Test
    void parseNested() {
        Expression e = ParseExpression.parseExpression("(3+(2*x))");
        assertEquals(23, e.eval("x = 10"));
    }

    @Test
    void parseWithVariables() {
        Expression e = ParseExpression.parseExpression("((x+y)*(x-y))");
        assertEquals(21, e.eval("x = 5; y = 2"));
    }

    @Test
    void parseWithSpaces() {
        Expression e = ParseExpression.parseExpression("( 3 + ( 2 * x ) )");
        assertEquals(23, e.eval("x = 10"));
    }
}