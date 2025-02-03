package io.github.matheusalencar23.schoolsync;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Scholl sync");
        primaryStage.setScene(new Scene(new StackPane(), 400, 600));
        primaryStage.show();
    }
}
