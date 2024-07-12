package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCodeDSPractice {

    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,1};
//        System.out.println("findDuplicateElement :: "+findDuplicateElement(nums1));
//
//        int[] nums2 = {-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println("findMaximumSubArray ::" +findMaximumSubArray(nums2));
//
//        int[] nums3 = {2,7,11,15};
//        findIndicesForTwoSum(nums3, 9);

//        int[] nums4 = {0};
//        int[] nums5 = {1};
//        mergeSortedArray(nums4, 0, nums5, 1);

        int[] nums6 = {4,9,5};
        int[] nums7 = {9,4,9,8,4};
        arrayOFIntersection(nums6, nums7);
        Thread thread = new Thread();


    }


    public static boolean findDuplicateElement(int[] nums) {
     /*
        Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
        Example 1:

        Input: nums = [1,2,3,1]
        Output: true
        Example 2:

        Input: nums = [1,2,3,4]
        Output: false
      */

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() != nums.length;
//        for(int i=0; i<nums.length; i++){
//            for(int j=0; j<nums.length; j++){
//                if(i != j){
//                    nums[i] = nums[j];
//                    return true;
//                }
//            }
//        }
//        return false;
    }

    public static int findMaximumSubArray(int[] nums) {
        /*Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

                A subarray is a contiguous part of an array.

        Example 1:

        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.
        Example 2:

        Input: nums = [1]
        Output: 1*/

        /*Kadane Algorithm*/

//        int INT_MIN = -100000009;
//        int sum=0,max=INT_MIN;
//        int n = nums.length;
//        for(int i=0;i<n;++i)
//        {
//            sum+=nums[i];
//            max=Math.max(max,sum);
//            if(sum<0)
//                sum=0;
//        }
//        return max;


        int max_so_far = Integer.MIN_VALUE,
                max_ending_here = 0,
                start = 0,
                end = 0,
                s = 0;

        for (int i = 0; i < nums.length; i++) {
            max_ending_here = max_ending_here + nums[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        System.out.println("Maximum contiguous sum is "
                + max_so_far);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
        return max_so_far;
    }

    public static int[] findIndicesForTwoSum(int[] arr, int target) {
        /*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
                You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.
        Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

        Example 2:
        Input: nums = [3,2,4], target = 6
        Output: [1,2]*/

        //BRUTE FORCE ALGORITHM
//        int[] resultArr = new int[2];
//
//        for(int i=0; i<arr.length ; i++){
//            for(int j=1; j<arr.length; j++){
//                if(arr[i]+arr[j]==target){
//                    resultArr[0] = i;
//                    resultArr[1] = j;
//                }
//            }
//        }
//        System.out.println("findMaximumSubArray :: ");
//        for(int i=0;i<resultArr.length;i++){
//            System.out.println(resultArr[i]);
//        }

        //USING HASHMAP
        List<Integer> indexes = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int requiredNum = target - arr[i];
            if (map.containsKey(requiredNum)) {
                int result[] = {map.get(requiredNum), i};
                printArray(result);
                return result;
            }
            map.put(arr[i], i);
        }

        System.out.println("indexes ::" + indexes);
        return null;

    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0)
                System.out.print("[");
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(",");
            if (i == arr.length - 1)
                System.out.print("]");
        }
    }


    public static void mergeSortedArray(int[] nums1, int nums1Size, int[] nums2, int nums2Size) {
        /*You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

                Merge nums1 and nums2 into a single array sorted in non-decreasing order.

                The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



        Example 1:

        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        Output: [1,2,2,3,5,6]
        Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
        The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
                Example 2:

        Input: nums1 = [1], m = 1, nums2 = [], n = 0
        Output: [1]
        Explanation: The arrays we are merging are [1] and [].
                The result of the merge is [1].
                Example 3:

        Input: nums1 = [0], m = 0, nums2 = [1], n = 1
        Output: [1]
        Explanation: The arrays we are merging are [] and [1].
                The result of the merge is [1].
                Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.*/


        Arrays.sort(nums2);
        if (nums1Size == 0 && nums2Size != 0) {
            printArray(nums2);
        } else if (nums2Size == 0 && nums1Size != 0) {
            printArray(nums1);
        } else {
            int nums2Index = 0;
            for (int i = nums2.length; i < nums1.length; i++) {
                nums1[i] = nums2[nums2Index];
                nums2Index++;
            }
            Arrays.sort(nums1);
            printArray(nums1);
        }
    }


    public static void arrayOFIntersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (Integer i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Integer i : nums2) {
            int count = map.getOrDefault(i, 0);
            if (count != 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        System.out.println(list);

    }


    public static void bestTimeToBuyAndSellTheStock(int[] prices){
//      [7,1,5,3,6,4]
        for(int i=0; i<prices.length;i++){

        }
    }
}
