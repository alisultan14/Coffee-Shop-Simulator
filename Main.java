




import java.util.*;
import java.io.*;



/**
 * Test main class
 */
public class Main
{
  public static void main (String [] args){
    Scanner reader = new Scanner(System.in);
    try{
        System.out.println ("How Many cashiers do you want to employ?");
          int InitialSize = reader.nextInt();
      long[] seeds = {54657,6675567,645434,65435,98756};
    int ovflow=0; int AverageWaitTime=0; int MaxWaitTime=0; int ProfitSum=0; int DayProfit=0;int TotalServed = 0;
    for (int i=0;i<seeds.length;i++){
    Restaurant a = new Restaurant();
    String b = a.obtainInfo(InitialSize,seeds[i]);
    String[] values = b.split(",");
    ovflow += Integer.parseInt(values[0]);
    AverageWaitTime += Float.parseFloat(values[1]);
    MaxWaitTime+=Float.parseFloat(values[2]);
    ProfitSum+=Float.parseFloat(values[3]);
    DayProfit+=Float.parseFloat(values[4]);
    TotalServed+=Integer.parseInt(values[5]);
  
    }
    System.out.println(" OverFlow: "+ovflow/5+" AverageWaitTime: "+AverageWaitTime/5+" MaxWaitTime: "+MaxWaitTime/5+" Revenue: "+ProfitSum/5+" Day's Profit: "+DayProfit/5+" TotalServed: " +TotalServed/5 );
}catch(Exception e){
    System.out.println(e);
}
    
    
    
    }
}
