package za.co.openwindow.civilbank.model;

import java.util.List;

public class DiamondCheque extends ChequeAccount {

    public DiamondCheque(double balance, String holder) {
        super(balance, holder);
    }
    
    @Override
    public String toString() {
        return super.toString() + " DiamondCheque";
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
    protected void addInterest() {
        //Do nothing here
    }
    
    @Override
    protected void addTransactionFee() {
        balance = balance + (balance  * 0.15);
    }
    
    @Override
    public void endOfMonth() {
        //Set number of free transactions back to zero
        addTransactionFee();
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
