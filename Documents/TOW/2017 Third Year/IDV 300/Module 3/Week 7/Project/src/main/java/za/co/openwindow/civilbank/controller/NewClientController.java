package za.co.openwindow.civilbank.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import za.co.openwindow.civilbank.model.Client;

/**
 * Created by student on 2017/08/15.
 */
public class NewClientController extends SceneController {
    
    @FXML
    private Label clientNameLabel;
    
    @FXML private MenuBar menuBar;
    @FXML private MenuBarController menuBarController;
    
    
    @Override
    public void refresh() {
        menuBarController.setSceneSwitcher(sceneSwitcher);
        Client activeClient = bank.getActiveClient();
        clientNameLabel.setText(activeClient.getName());
        
    }
}
