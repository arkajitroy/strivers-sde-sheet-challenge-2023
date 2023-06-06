import java.io.*;
import java.util.* ;

import java.util.ArrayList;

class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
		ArrayList<ArrayList<Long>> triangle = new ArrayList<>();

		for(int i=0; i<n; i++){
			ArrayList<Long> row = new ArrayList<>();
			for(int j=0; j<=i; j++){
				if(j==0 || j==i) row.add(1L);
				else{
					long prevRowLeft = triangle.get(i-1).get(j-1);
					long prevRowRight = triangle.get(i-1).get(j);
					row.add(prevRowLeft + prevRowRight);
				}
			}
			triangle.add(row);
		}
		return triangle;
	}
}
