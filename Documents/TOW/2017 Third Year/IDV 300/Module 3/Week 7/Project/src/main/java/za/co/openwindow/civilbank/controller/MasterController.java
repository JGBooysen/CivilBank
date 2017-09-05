package za.co.openwindow.civilbank.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import za.co.openwindow.civilbank.model.Client;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class MasterController extends SceneController {

    @FXML private GridPane masterGridPane;
    @FXML private ImageView logoImageView;
    @FXML private Button closeButton;

    @FXML
    public void initialize() {
        logoImageView.setImage(new Image("/images/logo.png", 600, 525, true, false));

        logoImageView.fitWidthProperty().bind(masterGridPane.widthProperty().divide(2));
        logoImageView.fitHeightProperty().bind(masterGridPane.heightProperty().divide(4));
        //how to add some padding?

    }

    //Setting gridPane for logo
//    public GridPane addGridPane() {
//        GridPane grid = new GridPane();
//        grid.setHgap(10);
//        grid.setVgap(10);
//        grid.setPadding(new Insets(0, 10, 0, 10));
//
//        ImageView imageHouse = new ImageView(
//                new Image("/images/logo.png"));
//        grid.add(logoImageView, 0, 0, 1, 2);
//        return grid;
//    }

    @FXML
    public void switchToViewClientsScene(Event e) {
        this.sceneSwitcher.switchToScene("ViewClients");
    }

    //public void loadClient (Event e) {}

    @FXML
    public void newClient(ActionEvent actionEvent) {
        //Add new client

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
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void searchClient(ActionEvent actionEvent) {
        sceneSwitcher.switchToScene("SearchClient");
    }

}
