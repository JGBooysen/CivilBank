package za.co.openwindow.civilbank.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import za.co.openwindow.civilbank.model.Account;
import za.co.openwindow.civilbank.model.Client;


public class ViewAccountDetailController extends SceneController {

    @FXML private VBox accountVBox;
    @FXML private Label accountNameLabel;


    @FXML private MenuBar menuBar;
    @FXML private MenuBarController menuBarController;

    public ViewAccountDetailController() {
        super();
    }

    public void initialize() {

    }


    @Override
    public void refresh() {
        menuBarController.setSceneSwitcher(sceneSwitcher);
        Account activeAccount = bank.getActiveAccount();
        accountNameLabel.setText(String.valueOf(activeAccount));

    }

    @FXML
    public void done(Event event) {
        sceneSwitcher.switchToScene("EditClient");
        }
}
