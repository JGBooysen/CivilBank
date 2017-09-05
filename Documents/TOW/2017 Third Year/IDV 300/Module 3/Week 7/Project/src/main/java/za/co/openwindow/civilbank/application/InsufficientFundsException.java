package za.co.openwindow.civilbank.application;

/**
 * Created by student on 2017/08/29.
 */
public class InsufficientFundsException extends Exception {
    
    @Override
    public String getMessage() {
        return "You have insufficient funds";
    }
    
    public String toString() {
        return getMessage();
    }
}
