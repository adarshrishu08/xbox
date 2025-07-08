package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindMinimumInRotatedArray {
    List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
//                {2,4,5,6,7,0,1};
//        {0,1,2,4,5,6,7}
//      {3,4,5,1,2}           ;
//        System.out.println(new FindMinimumInRotatedArray().findMin(nums));
    }

    /**
     * start = 0; end = 3; mid = 1
     * start = 0; end = 1; mid = 0;
     */
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = (start+end)/2;
            min = Math.min(min, nums[mid]);
            if(nums[end] <= nums[mid]){
                start = mid + 1;
            } else {
                end = mid -1 ;
            }
        }
        return min;
    }

}
