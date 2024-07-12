package practice.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
 *
 * We repeatedly make k duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * Example 2:
 *
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * Example 3:
 *
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * 2 <= k <= 104
 * s only contains lowercase English letters.
 */

public class RemoveAdjacentDuplicateString {
    public static void main(String[] args) {
        String str = "yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy";
        int k = 4;
        System.out.println(reArrangeDuplicateString(str,k));
    }

    private static String reArrangeDuplicateString(String str, int k){
        Map<Character, Integer> charToCountMap = new LinkedHashMap<>();

        for(int i=0; i<str.length(); i++){

            if(charToCountMap.containsKey(str.charAt(i))){
                charToCountMap.put(str.charAt(i), charToCountMap.get(str.charAt(i))+1);
                if(charToCountMap.get(str.charAt(i)) == k){
                    charToCountMap.put(str.charAt(i),0);
                }
            } else {
                charToCountMap.put(str.charAt(i), 1);
            }
        }

        StringBuffer result = new StringBuffer();
        for(Map.Entry<Character, Integer> entry : charToCountMap.entrySet()){
            int value = entry.getValue();
            Character key = entry.getKey();
            for(int i=0; i<value; i++){
                result.append(key);
            }
        }
        return result.toString();
    }
}
