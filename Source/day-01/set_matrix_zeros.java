import java.io.*;
import java.util.* ;

class Solution {
    public static void setZeros(int matrix[][]) {
        int rows = matrix.length, cols = matrix[0].length;
        int tempRow[] = new int[rows];
        int tempCols[] = new int[cols];

        Arrays.fill(tempRow, -1);
        Arrays.fill(tempCols, -1);

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j] == 0){
                    tempRow[i] = 0;
                    tempCols[j] = 0;
                }
            }
        }

        // traversing the matrix
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(tempRow[i] == 0 || tempCols[j] == 0) matrix[i][j] = 0;
            }
        }
    }
}