package za.co.openwindow.civilbank.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;

public class SearchClientController extends SceneController {

    @FXML private TextField clientTextField;
    @FXML private MenuBar menuBar;
    @FXML private MenuBarController menuBarController;
    
    public SearchClientController() {
        super();
    }
    
    @Override
    public void refresh() {
        menuBarController.setSceneSwitcher(sceneSwitcher);
    }
    

    public void searchClient(ActionEvent actionEvent) {
        //loop through all clients names and or ID numbers and return the result
    }
    
    @FXML
    public void goBack(Event event) {
        sceneSwitcher.switchToScene("Master");
    }

}
