package za.co.openwindow.civilbank.application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import za.co.openwindow.civilbank.controller.SceneController;

import java.util.HashMap;

public class SceneSwitcher {

    private Stage primaryStage;
    private HashMap<String, Scene> scenes;
    private HashMap<String, SceneController> controllers;


    public SceneSwitcher(Stage stage) {
        primaryStage = stage;
        scenes = new HashMap<String, Scene>();
        controllers = new HashMap<String, SceneController>();
    }

    public void addScene(String name, Scene scene) {
        scenes.put(name, scene);
    }

    public void addController(String name, SceneController controller) {
        controllers.put(name, controller);
    }

    public void switchToScene(String name) {
        primaryStage.setScene(scenes.get(name));
        controllers.get(name).refresh();
    }

    public Window getStage() {
        return primaryStage;
    }
}
