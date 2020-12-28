
import java.util.*;
import java.io.*;
/**
 * Data Collector which takes in information from the input txt file
 * @author Ali Sultan
 */
public class CollectData
{

    String LowProfit; // lower profit bound from the input file
    String HighProfit; // higher profit bound from the input file
    String lowServeTime; // lower serveTime bound from the input file, customers are assigned serve time higher than or equal to this time
    String highServeTime; // higher serveTime bound from the input file, customers are assigned serve time lower than or equal to this time
    float CashierCost; // the cost of staffing each cashier
    LinkedList<Customer> InitialList = new LinkedList<Customer>(); //use Java API Linked List to first store all the cusomters from the txt file initially
    /**
     * CollectData function to read information from the txt file
     */
    public void CollectData(){
        try{
            FileReader FR = new FileReader("input.txt"); //FileReader to read from the input txt file
            Scanner Reader = new Scanner(FR); //Scanner to read the input text
            RandomGenerator RG = new RandomGenerator(); //instance of RandomGenerator that determines generates random numbers between a range
            LowProfit = Reader.next(); HighProfit = Reader.next();
            
            // storing the upper and lower bounds of the profit from the txt file
            CashierCost = Reader.nextFloat(); //cost of employing one cashier per day
            lowServeTime = Reader.next(); //lowerServeTimebound
            highServeTime = Reader.next();
           
            //upperServeTimeBound
            // use a while loop to iterate through the input file and store the info about customers by creating Customer objects
            while (Reader.hasNext()){
                String[] TimeStore = Reader.next().split(":"); //txt file has hh:mm:ss format so we split every line through :
                int hr = new Integer(TimeStore[0])*60*60; //hours into seconds
                int min = new Integer(TimeStore[1])*60; //minutes into seconds
                int seconds = new Integer(TimeStore[2]); //seconds

                int ArrivalTime = hr + min + seconds; //adding all the parameters to give the arrival time of every customer in second
                InitialList.add(new Customer(ArrivalTime,0,0)); // adding the customer objects into the initial java api list
            }

            Reader.close(); // closing the scanner after all the txt file has been read

        }
        catch (Exception e){
            System.out.println(e); // catch and print out on the console any exception that may have occured
        }
    }
}
