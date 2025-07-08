package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a number N, complete the following tasks,
 * Task 1. Generate a new number from N by changing the zeroes in the binary representation of N to 1.
 * Task  2. Find the difference between N and the newly generated number.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 8
 * Output: 7 15
 * Explanation:
 * There are 3 zeroes in binary representation
 * of 8. Changing them to 1 will give 15.
 * Difference between these two is 7.
 *
 * Example 2:
 *
 * Input: N = 6
 * Output: 1 7
 * Explanation:
 * There is 1 zero in binary representation
 * of 6. Changing it to 1 will give 7.
 * Difference between these two is 1.
 *
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function changeBits() which takes an integer N as input parameter and returns a list of two integers containing the difference and the generated number respectively.
 *
 *
 *
 * Expected Time Complexity: O(log(N))
 * Expected Auxiliary Space: O(1)
 */

public class ChangeBits {
    public static void main(String[] args) {
//        System.out.println(new ChangeBits().convertIntoDecimal(1111,new ArrayList<>()));
//        System.out.println(new ChangeBits().convertIntoBinary(10));
//        new ChangeBits().changeBits(8);
        long[] A = {20,8,22, 4, 12, 10, 14};
        sumBetweenTwoKth(A, 7, 3, 6);
    }

    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2)
    {
        // Your code goes here
        Arrays.sort(A);
        long sum = 0;
        for(int i=(int)K1; i<K2-1; i++){
            System.out.println("Adding :"+A[i]);
            sum+=A[i];
        }
        System.out.println("Result :"+sum);
        return sum;
    }

    public int changeBits(int N){
        List<Integer> binaryNumber = convertIntoBinary(N);
        for(int i=0; i< binaryNumber.size(); i++){
            if(binaryNumber.get(i) == 0){
                binaryNumber.set(i,1);
            }
        }
        System.out.println(convertIntoDecimal(0, binaryNumber));
        return convertIntoDecimal(0, binaryNumber);
    }

    public int convertIntoDecimal(int binaryNumber, List<Integer> binaryNum){
        int base = 2;
        int sum = 0;
        int count = 0;
        if(binaryNumber != 0) {
            while (binaryNumber > 0) {
                int remainder = binaryNumber % 10;
                sum = sum + remainder * (int) Math.pow(base, count);
                binaryNumber = binaryNumber / 10;
                count++;
            }
        } else {
            for(int i=binaryNum.size()-1; i>=0; i--){
                sum = sum+binaryNum.get(i)*(int)Math.pow(base,count);
                count++;
            }
        }

        return sum;
    }

    public List<Integer> convertIntoBinary(int decimalNumber){
        int base = 2;
        int sum = 0;
        List<Integer> binaryOriginalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        while (decimalNumber > 0){
            int remainder = decimalNumber%base;
            list.add(remainder);
            decimalNumber = decimalNumber/base;
        }
        for(int i=list.size()-1; i>=0; i--){
            binaryOriginalList.add(list.get(i));
        }
        return binaryOriginalList;
    }
}
