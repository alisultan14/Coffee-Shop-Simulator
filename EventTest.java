

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EventTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EventTest
{
   /**
    * Test Case comparing two events based on their time
    * Normal
    */
     @Test 
   public void testEventCompare(){
        Event A = new Event(22000,1,new Customer(22000,0,0));
        Event B = new Event(24000,1,new Customer(22000,0,0));
        int Actual = A.compareTo(B);
        int Expected =  -2000;
        
        assertEquals(Actual,Expected);
        
    }
    
    
   /**
    * Test Case comparing two events based on their time
    * Boundary
    */
     @Test 
   public void testEventCompare2(){
        Event A = new Event(23000,1,new Customer(22000,0,0));
        Event B = new Event(23000,1,new Customer(22000,0,0));
        int Actual = A.compareTo(B);
        int Expected =  0;
        
        assertEquals(Actual,Expected);
        
    }
}
