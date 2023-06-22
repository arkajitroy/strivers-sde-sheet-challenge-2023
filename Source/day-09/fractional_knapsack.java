import java.util.* ;
/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/

class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }


class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
    
        double totalValue = 0;
    
        for (int i = 0; i < n; i++) {
            if (w >= items[i].weight) {
                totalValue += items[i].value;
                w -= items[i].weight;
            } else {
                double fraction = (double) w / items[i].weight;
                totalValue += fraction * items[i].value;
                break;
            }
        }
        
        return totalValue;
    }
}
