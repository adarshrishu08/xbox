package practice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FistMissingPositive {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(new FistMissingPositive().firstMissingPositive(arr));
    }

    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length ; i++){
            if(nums[i] > 0){
                set.add(nums[i]);
            }
        }
        int startPointer = 1;
        int minPointer = 0;
        boolean foundMinimum = false;
        for(int i=0; i<nums.length; i++){
            if(set.contains(startPointer)){
                startPointer++;
            } else {
                if(!foundMinimum){
                    minPointer = startPointer;
                    foundMinimum = true;
                }
                startPointer++;
            }
            if(!foundMinimum){
                minPointer = startPointer;
            }
        }
        return minPointer;
    }

}
