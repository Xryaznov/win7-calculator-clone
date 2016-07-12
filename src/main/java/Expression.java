package main.java;

import static main.java.Operator.*;

public class Expression {
    private Double operand1;
    private Double operand2;
    private String operator = "+";
    private Double result;

    public Double evaluate() {
        switch (operator) {
            case PLUS:
                System.out.print(this);
                result = operand1 + operand2;
                break;
            case MINUS:
                System.out.print(this);
                result = operand1 - operand2;
                break;
            case DIVISION:
                System.out.print(this);
                if (operand2 == 0) {
                    result = 0.0;
                    operand1 = 0.0;
                } else {
                    result = operand1 / operand2;
                }

                break;
            case PRODUCT:
                System.out.print(this);
                if (operand2 == null) {
                    operand2 = operand1;
                }
                result = operand1 * operand2;
                break;
        }
        operand1 = result;
        System.out.println(" = " + result);
        return result;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setOperand(int which, Double newValue) {
        switch (which) {
            case 1:
                operand1 = newValue;
                break;
            case 2:
                operand2 = newValue;
                break;
        }
    }

    @Override
    public String toString() {
        return operand1 + " "
                + operator + " "
                + operand2;
    }

    public double getResult() {
        return result;
    }
}