import java.util.* ;
import java.io.*; 
class Solution 
{
    public static void sort012(int[] arr)
    {
        int lo=0, mid=0, hi=arr.length - 1;
        while(mid <= hi){
            if(arr[mid] == 0){
                swap(arr, lo, mid);
                lo++;
                mid++;
            }
            else if(arr[mid] == 1) mid++;
            else if(arr[mid] == 2){
                swap(arr, mid, hi);
                hi--;
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }
}