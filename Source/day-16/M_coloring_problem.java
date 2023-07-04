import java.util.*;

class Solution {
  
  public static boolean isPossibleMthColor(int[][] mat, int[] nodeColorVector, int nodeToColor, int color, int n) {
    for (int i = 0; i < n; i++) {
      if (mat[nodeToColor][i] == 1 && nodeColorVector[i] == color) {
        return false;
      }
    }
    return true;
  }

  public static boolean solveGraph(int nodeToColor, int n, int m, int[] nodeColorVector, int[][] mat) {
    if (nodeToColor == n) {
      return true;
    }
    
    for (int i = 1; i <= m; i++) {
      if (isPossibleMthColor(mat, nodeColorVector, nodeToColor, i, n)) {
        nodeColorVector[nodeToColor] = i;
        if (solveGraph(nodeToColor + 1, n, m, nodeColorVector, mat)) {
          return true;
        }
        nodeColorVector[nodeToColor] = 0;
      }
    }
    return false;
  }

  public static String graphColoring(int[][] mat, int m) {
    int n = mat.length;
    int[] nodeColorVector = new int[n];
    Arrays.fill(nodeColorVector, 0);
    
    if (solveGraph(0, n, m, nodeColorVector, mat)) {
      return "YES";
    }
    
    return "NO";
  }
}