

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author  Ali Sultan
 */
public class CustomerTest
{

   /**
    * test case setting servetime
    * Normal
    */
     @Test 
   public void testSetServeTime(){
        Customer A = new Customer(24000,32,0);
        A.setServeTime(324);
        int Actual = A.ServeTime;
        int Expected =  324;
        
        assertEquals(Actual,Expected);
        
    }
    
    
    
    
    
    
    
    
    
    /**
    * test case setting profit
    * Normal
    */
     @Test 
   public void testSetProfi1t(){
        Customer A = new Customer(24000,32,0);
        A.setProfit(432.0f);
        float Actual = A.Profit;
        int Expected =  432;
        
        assertEquals(432,Expected);
        
    }
}
