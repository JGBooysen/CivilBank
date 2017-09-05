package za.co.openwindow.civilbank.controller;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import za.co.openwindow.civilbank.model.Client;

import java.io.*;

public class MenuBarController extends SceneController {

    @FXML MenuBar menuBar;
    @FXML private Button closeButton;

    public void initialize() {
    }

    @FXML
    public void goToHome() {
        sceneSwitcher.switchToScene("Master");
    }

    @FXML
    public void goToClients() {
        sceneSwitcher.switchToScene("ViewClients");
    }

    @FXML
    public void saveClient(Event event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName(bank.getActiveClient().getName());
        File saveFile = fileChooser.showSaveDialog(sceneSwitcher.getStage());
        if (saveFile != null) {
            try {
                FileOutputStream fileOutputStream = new
                        FileOutputStream(saveFile.getPath());
                ObjectOutputStream out = new
                        ObjectOutputStream(fileOutputStream);
                out.writeObject(bank.getActiveClient());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void loadClient(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File loadFile = fileChooser.showOpenDialog(sceneSwitcher.getStage());  if (loadFile != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(loadFile.getPath());
                ObjectInputStream in = new ObjectInputStream(fileInputStream);
                Client client = (Client) in.readObject();  bank.getClients().add(client);
                bank.setActiveClient(client);
                sceneSwitcher.switchToScene("ViewClientDetail");
            } catch (Exception exception) {
                exception.printStackTrace();  }
        }
    }

    @FXML
    private void closeApp(ActionEvent actionEvent) {
        Platform.exit();
    }

}