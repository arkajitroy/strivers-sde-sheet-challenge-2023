import java.util.*;

class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> finish) {
        int count = 0;
        int n = start.size();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indexes.add(i);
        }
        Collections.sort(indexes, new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                return finish.get(i) - finish.get(j);
            }
        });
        int index = indexes.get(0);
        for (int i = 1; i < n; i++) {
            int ind = indexes.get(i);
            if (start.get(ind) >= finish.get(index)) {
                index = ind;
                count++;
            }
        }
        return count + 1;
    }
}