package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/simpleLayout.fxml"));
        stage.setScene(new Scene(root, 265, 360, Paint.valueOf("D9E4F1")));
        stage.setTitle("Calc");
        stage.resizableProperty().set(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
