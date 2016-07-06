package main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {
    private Expression expression = new Expression();
    private StringBuilder input = new StringBuilder();

    @FXML
    private TextArea display;

    @FXML
    public void handleNumber(ActionEvent ev) {
        Button btn = (Button) ev.getSource();
        input.append(btn.getText());
        display.setText(input.toString());
    }

    @FXML
    public void handleOperator(ActionEvent ev) {
        try {
            expression.append(Integer.parseInt(input.toString()));
            input.setLength(0);
        } catch (NumberFormatException ex) {
            display.setText("Error.");
            return;
        }
        System.out.println(expression);
        Button btn = (Button) ev.getSource();
        display.setText(String.valueOf(expression.evaluate(btn.getText())));
    }
}
