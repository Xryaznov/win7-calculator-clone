package test.java;

import main.java.Expression;
import org.junit.Before;
import org.junit.Test;

import static main.java.Operand.*;
import static org.junit.Assert.assertEquals;

public class ExpressionTest {
    private final double delta = 0.001;
    private Expression expression;

    @Before
    public void setUp() {
        expression = new Expression();
    }

    @Test
    public void testCanEvaluateAddition() {
        expression.setOperand(LEFT, 3.0);
        expression.setOperator("+");
        expression.setOperand(RIGHT, 3.0);
        assertEquals(6.0, expression.evaluate(), delta);
    }

    @Test
    public void testCanEvaluateSubtraction() {
        expression.setOperand(LEFT, 3.0);
        expression.setOperator("-");
        expression.setOperand(RIGHT, 4.0);
        assertEquals(-1.0, expression.evaluate(), delta);
    }

    @Test
    public void testCanEvaluateDivision() {
        expression.setOperand(LEFT, 4.0);
        expression.setOperator("/");
        expression.setOperand(RIGHT, 5.0);
        assertEquals(0.8, expression.evaluate(), delta);
    }

    @Test
    public void testCanEvaluateMultiplication() {
        expression.setOperand(LEFT, 4.0);
        expression.setOperator("*");
        expression.setOperand(RIGHT, 5.0);
        assertEquals(20.0, expression.evaluate(), delta);
    }
}