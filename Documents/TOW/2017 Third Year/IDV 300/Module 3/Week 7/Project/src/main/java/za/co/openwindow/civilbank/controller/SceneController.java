package za.co.openwindow.civilbank.controller;

import za.co.openwindow.civilbank.application.Bank;
import za.co.openwindow.civilbank.application.SceneSwitcher;

public class SceneController {

    protected Bank bank;
    protected SceneSwitcher sceneSwitcher;
    
    public SceneController() {
        bank = Bank.getINSTANCE();
    }
    
    public void setSceneSwitcher(SceneSwitcher sceneSwitcher) {
        this.sceneSwitcher = sceneSwitcher;
    }

    public void refresh() {
        //Do nothing yet
    }
}
