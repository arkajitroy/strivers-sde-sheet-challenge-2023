import java.io.*;
import java.util.* ;

import java.util.ArrayList;

class Solution {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        while (top < bottom && left < right) {
            int prev = mat.get(top + 1).get(left);

            // Move top row to right column
            for (int i = left; i <= right; i++) {
                int curr = mat.get(top).get(i);
                mat.get(top).set(i, prev);
                prev = curr;
            }
            top++;

            // Move right column to bottom row
            for (int i = top; i <= bottom; i++) {
                int curr = mat.get(i).get(right);
                mat.get(i).set(right, prev);
                prev = curr;
            }
            right--;

            // Move bottom row to left column
            for (int i = right; i >= left; i--) {
                int curr = mat.get(bottom).get(i);
                mat.get(bottom).set(i, prev);
                prev = curr;
            }
            bottom--;

            // Move left column to top row
            for (int i = bottom; i >= top; i--) {
                int curr = mat.get(i).get(left);
                mat.get(i).set(left, prev);
                prev = curr;
            }
            left++;
        }
    }
}
