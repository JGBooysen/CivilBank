package za.co.openwindow.civilbank.application;

import za.co.openwindow.civilbank.model.Account;
import za.co.openwindow.civilbank.model.Client;

import java.util.LinkedList;
import java.util.List;

public class Bank {
    
    private static final Bank INSTANCE = new Bank();
    private String name;
    private Client activeClient;
    private Account activeAccount;
    private List<Client> clients;
    private List<Account> accounts;


    private Bank() {
        name = "Civil Bank";
        clients = new LinkedList<Client>();
        accounts = new LinkedList<Account>();
    }


    public String getBankName() {
        return "Civil Bank";
    }

    public List<Client> getClients() {
        return clients;
    }

    public Client getActiveClient() {
        return activeClient;
    }

    public void setActiveClient(Client activeClient) {
        this.activeClient = activeClient;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getActiveAccount() {
        return activeAccount;
    }

    public void setActiveAccount(Account activeAccount) {
        this.activeAccount = activeAccount;
    }
    
    public static Bank getINSTANCE() {
        return INSTANCE;
    }

}
