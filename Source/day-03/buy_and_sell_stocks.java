import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){

        // base case
        if(prices == null || prices.size() <= 1) return 0;

        int minPrice = prices.get(0), maxProfit = 0;

        for(int i=1; i<prices.size(); i++){
            int currPrice = prices.get(i);

            if(currPrice < minPrice) minPrice = currPrice;
            else{
                int currentProfit = currPrice - minPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        return maxProfit;
    }
}