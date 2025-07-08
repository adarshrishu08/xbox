package practice.DataStructures.Arrays;

import java.sql.Array;
import java.util.*;

public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] arr = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        np.findPermutation(arr,0,res);
        System.out.println(res);
        int[] nums = {1,2,0,1};
                //{9,1,4,7,3,-1,0,5,8,-1,6};
        np.longestConsecutive(nums);
    }

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int count = 1;
        TreeSet<Integer> set = new TreeSet();
        for(int i=1; i<n; i++){
            if(nums[i] - nums[i-1] == 1){
                count++;
            } else {
                if(count > 1)
                    set.add(count);
                count = 1;
                continue;
            }
        }
        set.add(count);
        System.out.println(set);
        int result = set.last();
        System.out.println(result);
        return result;
    }

    public void findPermutation(int[] arr, int start, List<List<Integer>> res){
        if(start == arr.length){
            res.add(arrayToList(arr));
            return;
        }

        for(int i=start; i<arr.length; i++){
            swap(i, start, arr);
            findPermutation(arr, start+1, res);
            swap(i,start,arr);
        }
    }

    private static List<Integer> arrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }

    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
