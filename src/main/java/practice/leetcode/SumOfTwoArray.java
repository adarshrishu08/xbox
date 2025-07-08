package practice.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an unsorted array arr of nonnegative integers and an integer sum, find a continuous subarray which adds to a given sum. There may be more than one subarrays with sum as the given sum, print first such subarray.
 * Examples :
 *
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Output: Sum found between indexes 2 and 4
 * Sum of elements between indices 2 and 4 is 20 + 3 + 10 = 33
 *
 * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
 * Output: Sum found between indexes 1 and 4
 * Sum of elements between indices 1 and 4 is 4 + 0 + 0 + 3 = 7
 *
 * Input: arr[] = {1, 4}, sum = 0
 * Output: No subarray found
 * There is no subarray with 0 sum
 */
public class SumOfTwoArray {
    public static void main(String[] args) {
        int[] arr = {142,112,54,69,148,45,63,158,38,60,124,142,130,179,117,36,191,43,89,107,41,143,65,49,47,6,91,130,171,151,7,102,194,149,30,24,85,155,157,41,167,177,132,109,145,40,27,124,138,139,119,83,130,142,34,116,40,59,105,131,178,107,74,187,22,146,125,73,71,30,178,174,98,113};
        int sum =665;
        System.out.println(subarraySum(arr, sum));
    }

    static ArrayList<Integer> subarraySum(int[] arr, int s)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int sum = 0;
        int left = 0;
        int originalSum = 0;
        for(int i=0; i<arr.length; i++){
            if(s == 0){
                return new ArrayList<>();
            }
            sum = sum+arr[i];
                if (sum > s) {
                    while(s < sum) {
                        if(sum < s) {
                            break;
                        }
                        sum = sum - arr[left];
                        left++;
                    }
                }
                if (sum == s) {
                    result.add(left + 1);
                    result.add(i + 1);
                    break;
                }
        }
        if(result.size() > 1){
            return result;
        } else {
            result.add(-1);
        }

        return result;
    }
}
