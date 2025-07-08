package practice.miscs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Properties;

public class TestOp {


    public static void main(String[] args) {
        int arr[] = {1 ,2 ,3 ,4 ,5};
        int N = 5, K = 5;
        max_of_subarrays(arr, N, K);
    }

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        boolean allSubArrayDone = false;
        ArrayList<Integer> subArray = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<k; j++){
                subArray.add(arr[j]);
            }
            if(allSubArrayDone){
                break;
            }
            result.add(getMax(subArray));
            subArray.clear();
            if(k+1 <= arr.length) {
                k += 1;
            } else {
                k = arr.length;
                allSubArrayDone = true;
            }
        }
        return result;
    }

    public static Integer getMax(List<Integer> list) {
        Integer max = 0;
        for(Integer i : list){
            if(i > max)
                max = i;
        }
        return max;
    }
}
