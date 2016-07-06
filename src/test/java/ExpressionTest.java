package test.java;

import main.java.Expression;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static main.java.Operator.*;

public class ExpressionTest {
    Expression expression;

    @Before
    public void setUp() {
        expression = new Expression();
    }

    @Test
    public void testCanEvaluateZeroAddition() {
        assertEquals(0, expression.evaluate(PLUS));
    }

    @Test
    public void testCanEvaluateZeroSubtraction() {
        assertEquals(0, expression.evaluate(MINUS));
    }

    @Test
    public void testCanIgnoreSingleAddition() {
        expression.append(7);
        assertEquals(7, expression.evaluate(PLUS));
    }

    @Test
    public void testCanIgnoreSingleSubtraction() {
        expression.append(7);
        assertEquals(7, expression.evaluate(MINUS));
    }

    @Test
    public void testCanEvaluateSubtraction() {
        expression.append(7).append(7);
        assertEquals(0, expression.evaluate(MINUS));
    }

    @Test
    public void testCanEvaluateAddition() {
        expression.append(1).append(1);
        assertEquals(2, expression.evaluate(PLUS));
    }

    @After
    public void tearDown() {
        expression = null;
    }
}