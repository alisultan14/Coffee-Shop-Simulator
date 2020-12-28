
/**
 * Customer Class for Customer Objects
 * @author Ali Sultan
 * @version (a version number or a date)
 */
public class Customer
{
    int ArrivalTime; //time at which the customer arrives
    int ServeTime; // time the Customer requires to be served;
    int WaitTime; //time the customer waited to get served
    float Profit; //the profit of serving every customer
    /**
     * Constructor for objects of class Customer
     * @param int ArrivalTime, int ServeTime, float Profit
     */
    public Customer(int ArrivalTime, int ServeTime, float Profit)
    {
        this.ArrivalTime = ArrivalTime;
        this.ServeTime = ServeTime;
        this.Profit = Profit;
    }

    /**
     * Used my Cashiers to set profit of serving a particular cusotmer
     * @param float profit
     */
    public void setProfit(float profit){
        this.Profit = profit;
    }

    /**
     * Used my Cashiers to set the time of serving a particular cusotmer
     * @param float sTime
     */
    public void setServeTime(int sTime){
        this.ServeTime = sTime;
    }

    

   
}
