import java.util.*;
import java.util.*;
import java.io.*;
/**
 * The Class is used to initialise a random number generator which returns 2 dp number between a given range
 * @author Ali Sultan
 */
public class RandomGenerator
{
   /**
     * @return float 
     * Method to return a Two Decimal Place Random number between a given range
     */
    public float ReturnTwoDpRandom(String Low, String High, long seed){
        Random R = new Random (seed);
        float ReturnVal; float low = new Float (Low); float high = new Float(High);
        float Temp1 = R.nextFloat() * high;
        //in order to esure that the number is within range and best randomised 
        if (Temp1 < low ){
            float Temp2 = Temp1 + low;
            while (Temp2 > high){
                Temp2 = high * R.nextFloat() + new Float(Low);
            }
            String strDouble = String.format("%.2f", Temp2);
            ReturnVal = new Float(strDouble);}
        else{
            String strDouble = String.format("%.2f", Temp1);
            ReturnVal = new Float(strDouble);
        }
        return ReturnVal;

    }
}
