package za.co.openwindow.civilbank.controller;

import com.sun.security.sasl.ClientFactoryImpl;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import za.co.openwindow.civilbank.application.AccountFactory;
import za.co.openwindow.civilbank.application.ExistingAccountsException;
import za.co.openwindow.civilbank.model.Account;
import za.co.openwindow.civilbank.model.Client;

public class ViewClientsController extends SceneController {

    @FXML
    private VBox clientsVBox;

    @FXML private MenuBar menuBar;
    @FXML private MenuBarController menuBarController;

    public ViewClientsController() {
        super();
    }

    public void initialize() {

    }

    @Override
    public void refresh() {
        menuBarController.setSceneSwitcher(sceneSwitcher);
        clientsVBox.getChildren().clear();
        for (final Client client : bank.getClients()) {
            Button clientButton = new Button(client.getName());
            clientButton.setMaxWidth(Double.POSITIVE_INFINITY);
            clientButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    bank.setActiveClient(client);
                    sceneSwitcher.switchToScene("ViewClientDetail");
                }
            });
            clientsVBox.getChildren().add(clientButton);
        }
    }

//    public void addAccountToCollection(Event event) {
//        AccountFactory factory = new AccountFactory() {
//        };
//        Account account = factory.create("", "");
//
//        try {
//            bank.getActiveAccount().addAccount(account);
//        } catch (ExistingAccountsException e) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setContentText(e.getMessage());
//            alert.showAndWait();
//        }
//        refresh();
//    }

    @FXML
    public void goBack(Event event) {
        sceneSwitcher.switchToScene("Master");
    }
}
