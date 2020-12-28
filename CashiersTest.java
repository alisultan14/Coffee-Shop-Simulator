

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing the Cashiers Class
 * @author Ali Sultan
 * @version (a version number or a date)
 */
public class CashiersTest
{
  /**
    * Assigning Cashiers test
    * Normal
    */
     @Test 
   public void testassignCashiers(){
        Cashiers A = new Cashiers(12);
        CollectData CD = new CollectData();
        CD.CollectData();
        A.assignCustomer(new Customer(23000,0,0),CD,423543);
        int Actual = A.availableCashiers;
        int Expected =11;
        
        assertEquals(Actual,Expected);
        
    }
    
    /**
    * Assigning Cashiers test
    * Boundary
    */
     @Test 
   public void testassignCashiers1(){
        Cashiers A = new Cashiers(0);
        CollectData CD = new CollectData();
        CD.CollectData();
        if (A.cashierAvailable()){
        A.assignCustomer(new Customer(23000,0,0),CD,423543);}
        
        int Actual = A.availableCashiers;
        int Expected =0;
        
        assertEquals(Actual,Expected);
        
    }
    
    /**
    * Assigning Cashiers test
    * Normal
    */
     @Test 
   public void testfreeCashiers(){
        Cashiers A = new Cashiers(12);
        CollectData CD = new CollectData();
        CD.CollectData();
        A.assignCustomer(new Customer(23000,0,0),CD,423543);
        A.freeCashier();
        int Actual = A.availableCashiers;
        int Expected =12;
        
        
        assertEquals(Actual,Expected);
        
    }
    
       /**
    * Test to see if the cashier is available
    * Normal
    */
     @Test 
   public void testCashierAvailable(){
        Cashiers A = new Cashiers(2);
        CollectData CD = new CollectData();
        CD.CollectData();
        A.assignCustomer(new Customer(23000,0,0),CD,423543);
        boolean Actual = A.cashierAvailable();
        boolean Expected = true;
        
        
        assertEquals(Actual,Expected);
        
    }
    
      /**
    * Boundary to see if the cashier is available
    * Normal
    */
     @Test 
   public void testCashierAvailable2(){
        Cashiers A = new Cashiers(1);
        CollectData CD = new CollectData();
        CD.CollectData();
        A.assignCustomer(new Customer(23000,0,0),CD,423543);
        boolean Actual = A.cashierAvailable();
        boolean Expected = false;
        
        
        assertEquals(Actual,Expected);
        
    }
    
    
    
    
}
