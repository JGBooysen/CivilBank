package za.co.openwindow.civilbank.application;

import za.co.openwindow.civilbank.model.Account;
import za.co.openwindow.civilbank.model.GoldCheque;

import java.util.LinkedList;

public class AccountFactory {

    private LinkedList<String> accountType= new LinkedList<String>();

    //GOLDCHEQUE, DIAMONDCHEQUE, TAXFREESAVINGS, EASYACCESSSAVINGS

    public AccountFactory() {

        accountType = new LinkedList<String>();
        accountType.add("GoldCheque");
        accountType.add("DiamondCheque");
        accountType.add("TaxFreeSavings");
        accountType.add("EasyAccessSavings");
    }

    public Account create(String key, String name) {

        Account account = null;

        switch (key) {
            case "Goldcheque": account = new GoldCheque(100, "");
            case "DiamondCheque": account = new GoldCheque(100, "");
            case "TaxFreeSavings": account = new GoldCheque(100, "");
            case "EasyAccessSavings": account = new GoldCheque(100, "");

        }
        return account;
    }


}
