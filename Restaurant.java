import java.util.*;
import java.io.*;

/**
 * Sets up The Restaurant Simulation 
 * and runs one day operations
 * @author Ali Sultan
 */
public class Restaurant
{
   
    Float CashierCost; // Average Cost of Staffing The Cashiers
    float ProfitSum = 0; // an int to store the total revenue
    ArrayList<Integer> ServedCustomers = new ArrayList<Integer>(); // an ArrayList to store the wait-time of customers who were Served
    int OverFlow; // Variable to keep track of all the Customers turned away
    LinkedList<Customer> FIFO = new LinkedList<Customer>(); //   FIFO Queue to maintain a queue of customers waiting for their order
    PriorityQueue<Event> PQ = new PriorityQueue<Event>(); // Priority Queue to keep track of the Events
    int LastHangUpTime = 0; // used to store the time of the last departure so that it can help calculate the waititme
    int TotalServed = 0; // keeps trck of the total number of customers that are served
    float AverageWaitTime; // average waititme of all the customers that were served
    int MaxWaitTime; // stored the value of the maiximum wait time
    float DayProfit; // the profit collected in one day
    
    /**
     * sets up a priority queue where every customer that arrives is recorded as an arrival event
     * @param CollectedDtata CD to use the initial java api linked list with all the customers
     */
    public void FillPQueue(CollectData CD){
        while(!CD.InitialList.isEmpty()){
            Customer A =CD.InitialList.removeFirst();
            Event B = new Event (A.ArrivalTime,Event.ARRIVE,A);
            PQ.add(B);

        }

    }

    /**
     * method runs the shop simulation one time for one day and 
     * @return a string of all the information that was recored like the OverFlow rate, AverageWaitTime, Maximum waiting time, and the total profit collected in a day
     */
    public String obtainInfo(int numCashiers, long seed){
    runSimOneDay(numCashiers, seed);
    String output = OverFlow+","+ AverageWaitTime+","+ MaxWaitTime+","+ProfitSum+","+DayProfit+","+TotalServed;
    return output;
    
    }
    
    /**
     * method runs the simulation for one day
     * @param int numberofCashiers that were working on the particular day
     */
    public void runSimOneDay(int numCashiers, long seed){
        CollectData CD = new CollectData(); //inititailinsing the data collector which will later be used in all the subsequent methods 
        CD.CollectData(); // collecting the data from the input file
        int ExcpTime = exceptionCase(numCashiers,  CD);
        // the method is used to deal with an exceptional case when the last customer served was actually the forst cusotmer served
        Cashiers cashiers = new Cashiers(numCashiers); // initialising cashiers class according to the initial number of cashiers

        FillPQueue(CD); // setting up the initial priority queue to be used later
        Event Current = null; // Event Current tracks the current event according to the time

         // event handler, deals with the shop operations
        while(!PQ.isEmpty()){
            Current = PQ.remove(); // first event in time is removed
            
            // case 1 : departure
            if (Current.type ==Event.DEPART){
                cashiers.freeCashier();
                LastHangUpTime = Current.time; // store this time so that it can later help calculate the wait time
                TotalServed++; //as the cutomer leaves he is considered served
                // if the queue for customers is empty:
                
                if(!FIFO.isEmpty()){
                    Customer ServedWait =FIFO.removeFirst();  
                    ServedCustomers.add(Current.time - ServedWait.ArrivalTime - ServedWait.ServeTime); //add the cutomers wait time into the ArrayList 
                }
                
                
                // if the customer arrived within the the working hours of the customer
              } else if (Current.time < 75600){
                
                  //if the cashier is available
                if(cashiers.cashierAvailable()){

                    int waitTime = 0;
                    Customer Turn = Current.Cstmr; 
                    cashiers.assignCustomer(Turn,CD,seed); // assign the customer to the cashier
                    ProfitSum+=Turn.Profit; // add to the total profit
                    Current.time = Current.time + Turn.ServeTime ; //increases the current time tracker according to the event that took place
                    
                    Current.type = 2; // change the event from arrvial to departure as soon the customer is assigned to a cashier
                    PQ.add(Current); // add the departure event into the priority queue

                }else {
                    // if the waiting customer line isnt 
                    if (FIFO.size() < 8*numCashiers){
                        FIFO.add(Current.Cstmr);
                        if (LastHangUpTime==0){
                            // handling the exceptional case
                            Current.time=ExcpTime - Current.Cstmr.ArrivalTime;
                        }else{
                            Current.time=LastHangUpTime;
                        }

                        PQ.add(Current);
                    }else{
                        OverFlow++;
                    }
                }
            }
        }
        // variable to store the sum of all the waitTimes
        int sumWaitTime = 0;

        // add all the waiting times into the sumWait
        for (int i = 0; i<ServedCustomers.size();i++){
           sumWaitTime +=ServedCustomers.get(i);
        }
       
        //finally record a MaxWaitTime = Collections.max(ServedCustomers);ll the info needed
        AverageWaitTime = sumWaitTime / TotalServed;
        if (sumWaitTime==0){
        MaxWaitTime = 0;}else{
        MaxWaitTime = Collections.max(ServedCustomers);
    }
        DayProfit = ProfitSum -(CD.CashierCost *numCashiers);
        
    } 
    
    /**
     * Exception Case to calculate time of 
     * @param numCahiers, DataColletor
     * @retun the int which is the time of wait for the first customer
     */
    public int exceptionCase(int numCashiers, CollectData CD){
        ArrayList<Integer> EarlyServeTime = new ArrayList<Integer>();
        for (int i=0; i<numCashiers; i++){
            EarlyServeTime.add(CD.InitialList.get(i).ServeTime + CD.InitialList.get(i).ArrivalTime);

        }
       
        return Collections.min(EarlyServeTime);

    }
}

