package za.co.openwindow.civilbank.model;

import java.util.List;

public abstract class ChequeAccount extends Account {

    protected double freeTransactions;

    public ChequeAccount(double balance, String holder) {
        super(balance);
//        balance = 0;
//        transactionFee = withdraw() + 2%;
    }


    public abstract List<Client> getClient();

    @Override
    public double getAccountBalanace() {
        return 0;
    }
    
    @Override
    protected abstract void addTransactionFee();
    
    @Override
    public void endOfMonth() {
        //Set number of free transactions back to zero
    }

    /*
    public double getInterest() {
        return interest;
    }

    public double getTransactionFee() {
        return transactionFee;
    }


    public abstract void calculateInterest(); //is this the same as getter?


    public abstract void calculateTransactionFee(); //is this the same as getter?
    */

}
