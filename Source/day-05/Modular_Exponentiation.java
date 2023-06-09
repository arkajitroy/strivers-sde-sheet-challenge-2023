import java.io.*;
import java.util.* ;

class Solution {
    public static int modularExponentiation(int x, int n, int m) {
        if (n == 0) {
            return 1;
        }
        
        long result = 1;
        long base = x % m;
        
        while (n > 0) {
            if (n % 2 == 1) {
                result = (result * base) % m;
            }
            base = (base * base) % m;
            n = n / 2;
        }
        
        return (int) result;        
    }
}