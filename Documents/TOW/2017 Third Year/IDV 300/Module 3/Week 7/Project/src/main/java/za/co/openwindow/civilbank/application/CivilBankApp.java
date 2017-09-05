package za.co.openwindow.civilbank.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import za.co.openwindow.civilbank.controller.SceneController;
import za.co.openwindow.civilbank.model.Client;
import za.co.openwindow.civilbank.model.EasyAccessSavings;
import za.co.openwindow.civilbank.model.GoldCheque;
import za.co.openwindow.civilbank.model.TaxFreeSavings;

import java.io.IOException;

public class CivilBankApp extends Application {

    public void start(Stage primaryStage) throws Exception {

        SceneSwitcher sceneSwitcher = new SceneSwitcher(primaryStage);
        Bank bank = Bank.getINSTANCE();

        FXMLLoader loader = new FXMLLoader();
        loadSceneFromFile("MenuBar", bank, sceneSwitcher);
        loadSceneFromFile("Master", bank, sceneSwitcher);
        loadSceneFromFile("ViewClients", bank, sceneSwitcher);
        loadSceneFromFile("ViewClientDetail", bank, sceneSwitcher);
        loadSceneFromFile("EditClient", bank, sceneSwitcher);
        loadSceneFromFile("SearchClient", bank, sceneSwitcher);
        loadSceneFromFile("ViewAccountDetail", bank, sceneSwitcher);
        System.out.println("Hello Puny World!");


        Client client1 = new Client("John", 1234567891);
        client1.addAccount(new GoldCheque(1100, "John"));
        client1.addAccount(new EasyAccessSavings(999, "John"));

        Client client2 = new Client("Jane", 1234567892);
        client2.addAccount(new TaxFreeSavings( 850, "Jane"));
    
        Bank.getINSTANCE().getClients().add(client1);
        Bank.getINSTANCE().getClients().add(client2);

        sceneSwitcher.switchToScene("Master");
        primaryStage.setTitle("Civil Bank");
        primaryStage.show();

    }

    private void loadSceneFromFile(String name, Bank bank, SceneSwitcher sceneSwitcher) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/" + name + ".fxml"));
        Parent root = loader.load();
        SceneController controller = loader.getController();
        controller.setSceneSwitcher(sceneSwitcher);
        Scene scene = new Scene(root, 600, 600);
        sceneSwitcher.addScene(name, scene);
        sceneSwitcher.addController(name, controller);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
