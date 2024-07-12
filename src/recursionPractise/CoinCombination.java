package recursionPractise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CoinCombination {
    static Set<List<Integer>> result = new TreeSet<>(new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            return o1.toString().compareTo(o2.toString());
        }
    });
    static int[] arr = {1, 2, 3};
    static int n = 6;
    public static void main(String[] args) {

        coinCombination(0, n, 0, new ArrayList<Integer>());
        System.out.println(result);
    }

    public static List<Integer> coinCombination(int element, int n, int prev, List currentPath) {
        if(prev == n){
            Collections.sort(currentPath);
            result.add(currentPath);
            return currentPath;
        }
        if(prev > n){
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            List newPath = new ArrayList(currentPath);
            newPath.add(arr[i]);
            coinCombination(arr[i], n,  arr[i]+prev, newPath);
        }
        return null;
    }
}
