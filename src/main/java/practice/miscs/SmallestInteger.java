package practice.miscs;

import java.util.Arrays;

/**
 * This is a demo task.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class SmallestInteger {
    public static void main(String[] args) {
        int[] A = {-1, -3};
        System.out.println(new SmallestInteger().solution(A));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        int smallest = 1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == smallest) {
                smallest++;
            }
        }

        return smallest;
    }
}
