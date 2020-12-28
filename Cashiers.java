import java.util.*;
/**
 * Cashiers class to keep track of all the cashiers and use them to assign profit and wait time to the customers that they serve
 * @author Ali Sultan
 */
public class Cashiers
{
    int numCashiers; //total number of cashiers
    int availableCashiers; // number of cashiers available at the current time
    /**
     * constructor for the cashiers class 
     * @ int numCashiers is used to initialise based on how many cashiers are employed
     */
    public Cashiers(int numCashiers)
    {
        this.numCashiers = numCashiers; 
        this.availableCashiers = numCashiers;
    }

    /**
     * assignCustomer method is used when a customer arrives to a free cashier
     * @param Customer A who arrives, CollectData CD  
     */
    public void assignCustomer(Customer A, CollectData CD, long seed){
        RandomGenerator RG = new RandomGenerator();
        Random R = new Random(seed);
        // set a random serve time and profit to customer
        A.setServeTime((int)RG.ReturnTwoDpRandom(CD.lowServeTime,CD.highServeTime,R.nextLong()));
        A.setProfit(RG.ReturnTwoDpRandom(CD.LowProfit,CD.HighProfit,R.nextLong()));
        availableCashiers--;    

    }

    /**
     * check if a cashier is free to serve a customer
     */
    public boolean cashierAvailable(){
        if (availableCashiers > 0){
            return true;
        }else{
            return false;
        }

    }

    /**
     * free a cashier once a customer has been served
     */
    public void freeCashier(){
        this.availableCashiers ++ ;
    }
}
