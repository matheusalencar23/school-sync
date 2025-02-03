package io.github.matheusalencar23.schoolsync;

import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
    private static Stage stage;
    private static final Map<String, Scene> scenes = new HashMap<>();

    public static void init(Stage primaryStage) {
        stage = primaryStage;
    }

    public static void switchTo(String sceneName, String fxmlPath, int width, int height) {
        try {
            Scene scene = scenes.get(sceneName);

            if (scene == null) {
                Parent root = FXMLLoader.load(SceneManager.class.getResource(fxmlPath));
                scene = new Scene(root, width, height);
                scenes.put(sceneName, scene);
            }

            stage.setScene(scene);
            stage.setTitle("SchoolSync | " + sceneName);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
