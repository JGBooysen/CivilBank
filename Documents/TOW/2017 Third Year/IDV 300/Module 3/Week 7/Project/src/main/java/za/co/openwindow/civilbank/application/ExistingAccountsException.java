package za.co.openwindow.civilbank.application;

public class ExistingAccountsException extends Exception {

    @Override
    public String getMessage() {

        return "There is already an existing account like this in your portfolio";
    }

    public String toString() {

        return getMessage();
    }
}
