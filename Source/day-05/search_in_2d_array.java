import java.util.ArrayList;

class SearchIn2DMatrix {
    public static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        if (mat == null || mat.size() == 0 || mat.get(0).size() == 0) {
            return false;
        }
        
        int rows = mat.size();
        int cols = mat.get(0).size();
        
        int row = 0;
        int col = cols - 1;
        
        while (row < rows && col >= 0) {
            int curr = mat.get(row).get(col);
            
            if (curr == target) {
                return true;
            } else if (curr < target) {
                row++;
            } else {
                col--;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(4);
        row1.add(7);
        row1.add(11);
        row1.add(15);
        matrix.add(row1);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(2);
        row2.add(5);
        row2.add(8);
        row2.add(12);
        row2.add(19);
        matrix.add(row2);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(3);
        row3.add(6);
        row3.add(9);
        row3.add(16);
        row3.add(22);
        matrix.add(row3);
        ArrayList<Integer> row4 = new ArrayList<>();
        row4.add(10);
        row4.add(13);
        row4.add(14);
        row4.add(17);
        row4.add(24);
        matrix.add(row4);
        ArrayList<Integer> row5 = new ArrayList<>();
        row5.add(18);
        row5.add(21);
        row5.add(23);
        row5.add(26);
        row5.add(30);
        matrix.add(row5);
        
        int target = 5;
        
        boolean found = searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + found);
    }
}

/* 
 * NOTES
 * 
 * Check if the given matrix is null or empty. If so, return false.

Get the number of rows and columns in the matrix.

Start from the top-right corner of the matrix (row = 0, col = cols - 1).

While row is less than the number of rows and col is greater than or equal to 0:

Get the value at the current position: curr = mat.get(row).get(col).
If curr is equal to the target, return true as we have found the target.
If curr is less than the target, increment row to move down to the next row.
If curr is greater than the target, decrement col to move left to the previous column.
If the loop completes without finding the target, return false as the target is not present in the matrix.

Test the solution with a sample matrix and target value.
 * 
 * 
 * 
 * 
*/