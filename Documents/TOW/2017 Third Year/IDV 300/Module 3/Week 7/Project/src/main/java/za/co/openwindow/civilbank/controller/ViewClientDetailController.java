package za.co.openwindow.civilbank.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import za.co.openwindow.civilbank.model.Account;
import za.co.openwindow.civilbank.model.Client;

public class ViewClientDetailController extends SceneController {

    @FXML private Label clientNameLabel;
    @FXML private Label numAccountLabel;

    @FXML private MenuBar menuBar;
    @FXML private MenuBarController menuBarController;

    public ViewClientDetailController() {
        super();
    }

    public void initialize() {

    }


    @Override
    public void refresh() {
        Client activeClient = bank.getActiveClient();
        clientNameLabel.setText(activeClient.getName());
        numAccountLabel.setText(activeClient.getAccountCollection().size() + "");
    }



    @FXML
    public void goBack(Event event) {
        sceneSwitcher.switchToScene("ViewClients");
    }

    @FXML
    public void editClient(Event event) {
        sceneSwitcher.switchToScene("EditClient");
    }
}
