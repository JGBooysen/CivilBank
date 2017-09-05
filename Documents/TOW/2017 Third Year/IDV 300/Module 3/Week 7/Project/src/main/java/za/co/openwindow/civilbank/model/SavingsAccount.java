package za.co.openwindow.civilbank.model;

import java.util.List;

public abstract class SavingsAccount extends Account {

    protected int interest;

    public SavingsAccount(double balance, String holder) {
        super(balance);
    }

    public abstract List<Client> getClient();

    @Override
    protected void addInterest() {
    
    }
    
    @Override
    public void endOfMonth() {
        //Add interest to monthly balance
        addInterest();
    }

//    public void setInterest(double interest) {
//        this.interest = interest;
//    }

}
