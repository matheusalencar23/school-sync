package io.github.matheusalencar23.schoolsync;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneManager.init(primaryStage);
        SceneManager.switchTo("Login", "view/login.fxml", 800, 600);
    }
}
