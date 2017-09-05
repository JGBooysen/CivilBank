package za.co.openwindow.civilbank.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import za.co.openwindow.civilbank.model.Account;
import za.co.openwindow.civilbank.model.Client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EditClientController extends SceneController {

    @FXML private VBox accountsVBox;
    @FXML private TextField clientTextField;
    @FXML private MenuBar menuBar;
    @FXML private MenuBarController menuBarController;

    @Override
    public void refresh() {
        final Client client = bank.getActiveClient();
        clientTextField.setText(client.getName());
        menuBarController.setSceneSwitcher(sceneSwitcher);
        accountsVBox.getChildren().clear();
        for (final Account account : client.getAccountCollection()) {
            ImageView imageView = new ImageView();
            //imageView.setImage(new Image("/images/" + client.getClientIndexEntry() + ".png"));
            imageView.setFitWidth(64);
            imageView.setFitHeight(64);

            Label label = new Label(account.toString());
            label.setPrefWidth(300);

            Button releaseButton = new Button("Remove Account");
            releaseButton.setPrefWidth(130);
            releaseButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    client.removeAccount(account);
                    refresh();  }
            });

            Button editAccountButton = new Button("Edit");
            editAccountButton.setPrefWidth(50);
            editAccountButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    bank.setActiveAccount(account);
                    sceneSwitcher.switchToScene("ViewAccountDetail");
                    refresh();
                }
            });


            HBox accountBox = new HBox();
            accountBox.getChildren().add(imageView);
            accountBox.getChildren().add(label);
            accountBox.getChildren().add(releaseButton);
            accountBox.getChildren().add(editAccountButton);

            accountsVBox.getChildren().add(accountBox);

        }
    }

    public void addAccountToCollection(Event event) {
        refresh();
    }

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
    public void viewAccountDetail (ActionEvent actionEvent) {
        sceneSwitcher.switchToScene("ViewAccountDetail");
    }

    @FXML
    public void done(ActionEvent actionEvent) {
        bank.getActiveClient().setName(clientTextField.getText());
        sceneSwitcher.switchToScene("ViewClientDetail");
    }


}
