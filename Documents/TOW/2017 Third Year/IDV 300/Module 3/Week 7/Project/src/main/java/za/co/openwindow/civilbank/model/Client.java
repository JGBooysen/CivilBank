package za.co.openwindow.civilbank.model;

import za.co.openwindow.civilbank.application.ExistingAccountsException;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Client implements Serializable {

    protected String name;
    protected double id;
    protected LinkedList accountCollection;


    public Client(String name, int id) {
        this.name = name;
        this.id = id;
        this.accountCollection = new LinkedList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountCollection() {
    }

    public String getName() {
        return name;
    }

    public double getId() {
        return id;
    }

    public List<Account> getAccountCollection() {
        return Collections.unmodifiableList(accountCollection);
    }

    public void removeAccount(Account account) {
        accountCollection.remove(account);
    }

    public void editAccount(Account account) {
        accountCollection.getClass();
    }

    @Override
    public String toString() {
        return " Hi name " + name;
    }

    //Testsuite
    public void addAccount(Account account) throws ExistingAccountsException {
        for (Object currentAccount : accountCollection) {
            if (account.getClass().equals(currentAccount.getClass())) {
                throw new ExistingAccountsException();
            }
        }
        accountCollection.add(account);
    }
}
