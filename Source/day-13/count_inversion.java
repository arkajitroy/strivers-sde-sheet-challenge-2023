import java.util.* ;
import java.io.*;

class Solution {
    public static long getInversions(long arr[], int n) {

        // Write your code here.

        long count = 0;

        for(int i = 0; i < arr.length; i++)

        {

            for(int j = i; j < arr.length; j++)

            {

                if(arr[i] > arr[j])

                {

                    count++;

                }

            }

        }

        return count;

    }
}