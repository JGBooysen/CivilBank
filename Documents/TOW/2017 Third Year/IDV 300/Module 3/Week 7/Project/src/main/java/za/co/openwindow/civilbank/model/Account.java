package za.co.openwindow.civilbank.model;

import za.co.openwindow.civilbank.application.InsufficientFundsException;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class Account implements Serializable {

    protected double balance;
    protected double amount;

    public Account(double balance) {
        this.balance = getAccountBalanace();
        this.amount = 0;
    }


    public void withdraw(double amount) throws InsufficientFundsException {
        balance = balance - amount;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }
    
    public boolean isEmpty() {

        return balance <= 0;
    }
    
    @Override
    public String toString() {
        return " Balance: " + balance;
    }


    public double getAccountBalanace() {
        return balance;
    }

    
    protected abstract void addInterest();
    
    protected abstract void addTransactionFee();
    
    public abstract void endOfMonth();
}
