package main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import static main.java.Command.*;
import static main.java.Operand.*;
import static main.java.Operator.PLUS;

public class Controller {
    private Expression expression = new Expression();
    private Input input = new Input();
    private int currentOperand = LEFT;
    boolean operandSwitched;
    boolean operatorPressed;

    @FXML
    private TextArea display;

    @FXML
    public void handleNumber(ActionEvent ev) {
        operandSwitched = false;

        Button btn = (Button) ev.getSource();
        input.append(btn.getText());
        display.setText(input.toString());
        expression.setOperand(currentOperand, Double.parseDouble(input.toString()));
    }

    @FXML
    public void handleOperator(ActionEvent ev) {
        expression.setOperator(((Button) ev.getSource()).getText());
        if (!operatorPressed) {
            switchOperand();
        }
    }

    @FXML
    public void handleUnaryOperator(ActionEvent ev) {
        String unary = (((Button) ev.getSource()).getText());

        switch (unary) {
            case "\u221A":
                expression.setOperand(1, Math.sqrt(Double.parseDouble(input.toString())));
                expression.setOperand(2, 0.0);
                expression.setOperator(PLUS);
                expression.evaluate();
                displayResult();
                break;
        }
    }


    private void switchOperand() {
        input.clear();
        currentOperand = currentOperand == LEFT ? RIGHT : LEFT;
        operandSwitched = true;
        operatorPressed = true;
    }

    @FXML
    public void handleEquals() {
        performCalculations();
        displayResult();
    }

    @FXML
    public void handleCommand(ActionEvent ev) {
        String command = ((Button) ev.getSource()).getText();
        switch (command) {
            case CLEAR:
                display.setText("0");
                expression = new Expression();
                reset();
                break;
        }
    }

    private void reset() {
        input.clear();
        operatorPressed = false;
        currentOperand = 1;
    }


    private void performCalculations() {
        expression.evaluate();
        reset();
    }

    private void displayResult() {
        display.setText(String.valueOf(expression.getResult()));
        reset();
    }
}
