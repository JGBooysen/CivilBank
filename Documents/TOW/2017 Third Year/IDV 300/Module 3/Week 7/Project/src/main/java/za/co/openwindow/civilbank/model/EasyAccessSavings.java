package za.co.openwindow.civilbank.model;

import java.util.List;

public class EasyAccessSavings extends SavingsAccount {

    public EasyAccessSavings(double balance, String holder) {
        super(balance, holder);
    }
    
    @Override
    public String toString() {
        return super.toString() + " EasyAccessSavings";
    }
    
    @Override
    public List<Client> getClient() {
        return null;
    }
    
    @Override
    public double getAccountBalanace() {
        return 0;
    }
    
    @Override
    public void addInterest() {
        balance = balance + (balance / 100 * interest);
    }
    
    @Override
    protected void addTransactionFee() {
        //Do nothing here
    }
    
    @Override
    public void endOfMonth() {
        //Add interest to monthly balance
        addInterest();
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
