import org.junit.Assert;
import org.junit.Test;
import za.co.openwindow.civilbank.application.ExistingAccountsException;
import za.co.openwindow.civilbank.model.*;

import static org.junit.Assert.*;

public class MyTests {
    
    
    @Test
    public void testClientCannotHaveMultipleAccountsOfSameType() {
        Client client1 = new Client("John", 1234567891);
        String message = "Expects only one of each account type";
        
        try {
            client1.addAccount(new DiamondCheque(0, "John"));
            client1.addAccount(new GoldCheque(0, "John"));
            client1.addAccount(new GoldCheque(0, "John"));
            fail("Expected exception to be thrown");
        } catch (Exception e) {
            assertEquals("Expected ExistingAccountsException", e.getClass(), ExistingAccountsException.class);
            assertEquals(message, client1.getAccountCollection().size(), 2);
        }
        
    }

    @Test
    public void taxFreeInterestTest() {
        Client client2 = new Client("Jane", 1234567892);
        try {
            client2.addAccount(new TaxFreeSavings( 30000, "Jane"));
        } catch (ExistingAccountsException e) {
            e.printStackTrace();
        } // Not sure how to Check for taxFreeSavings account to grow from R30 000 to R31 845 after 6 months

    }

    @Test
    //Check that clienCollection returns list of clients
    public Client getClientCollection() {
        Client client = new Client("John", 1234567891);
//        try {
//            client.getClientCollection();
//            Assert.fail("Expected an exception");
//        } catch (Exception e) {
//            String message = "Expected a list of clients";
//            Assert.assertEquals(message, e.getClass());
//        }

        return client;
    }
    
    
        //Account balance test extra:

//        if(balance < 0) {
//
//            System.out.println(balance + "Your account is above board");
//        } else {
//            assertFalse(boolean balanceNotNull)
//
//        }
    
    }