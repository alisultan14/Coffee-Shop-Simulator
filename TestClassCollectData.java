

import java.util.*;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// Test Class for Collecting Data
// A seperate txt file other than the deafault was used to test it


public class TestClassCollectData
{
   /**
    * Normal Testing Case for recording Profit Bounds from the input file
    */
    @Test 
   public void testRecordProfitBoundsLow(){
        CollectData CD = new CollectData();
        CD.CollectData();
        String Actual = CD.LowProfit;
        String Expected = "5.50";
        assertEquals(Actual,Expected);
        
    }
    
    /**
    * Normal Testing Case for recording Profit Bounds from the input file
    */
     @Test 
   public void testRecordProfitBoundsHigh(){
        CollectData CD = new CollectData();
        CD.CollectData();
        String Actual = CD.HighProfit;
        String Expected = "10.08";
        assertEquals(Actual,Expected);
        
    }
    
    
    /**
    * Normal Testing Case for recording the low serve time
    */
     @Test 
   public void testRecordServeBoundsLow(){
        CollectData CD = new CollectData();
        CD.CollectData();
        String Actual = CD.lowServeTime;
        String Expected = "90";
        assertEquals(Actual,Expected);
        
    }
    
     /**
    * Normal Testing Case for reading from the input text high serve time
    */
     @Test 
   public void testRecordServeBoundsHigh(){
        CollectData CD = new CollectData();
        CD.CollectData();
        String Actual = CD.highServeTime;
        String Expected = "278";
        assertEquals(Actual,Expected);
        
    }
    
    /**
    * Normal Testing Case for reading from the input text information about the customers
    */
     @Test 
   public void testCustomersArrival(){
        CollectData CD = new CollectData();
        CD.CollectData();
        LinkedList<Customer> Actual = CD.InitialList ;
        int second = Actual.removeFirst().ArrivalTime;
        int test =  21600;
        
        assertEquals(second,test);
        
    }
    
    
    
    
    
    
    
     

    
    
}