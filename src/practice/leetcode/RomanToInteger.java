package practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */

public class RomanToInteger {

    static final Map<Character, Integer> romanToIntegerValueMap = new HashMap<>();
    static final Map<Integer,Character> integerToRomanValueMap = new HashMap<>();
    static {
        romanToIntegerValueMap.put('I', 1);
        romanToIntegerValueMap.put('V', 5);
        romanToIntegerValueMap.put('X', 10);
        romanToIntegerValueMap.put('L', 50);
        romanToIntegerValueMap.put('C', 100);
        romanToIntegerValueMap.put('D', 500);
        romanToIntegerValueMap.put('M', 1000);

        integerToRomanValueMap.put(1,'I');
        integerToRomanValueMap.put(5,'V');
        integerToRomanValueMap.put(10,'X');
        integerToRomanValueMap.put(50,'L');
        integerToRomanValueMap.put(100,'C');
        integerToRomanValueMap.put(500,'D');
        integerToRomanValueMap.put(1000,'M');
    }
//1123
//1000/1123 = R=123,Q=1
//100/123 =  R=23, Q=1
//50/23 =  R=0, Q=2
//10/23 = R=3, Q=2
    public static void main(String[] args) {
        System.out.println(100/123);
        System.out.println(100%123);
//        String input = "III";// LVIII //MCMXCIV
//        System.out.println(new RomanToInteger().convertRomanToInteger(input));

    }

    public int convertRomanToInteger(String input){
        List<Integer> evaluatedNumbers = new ArrayList<>();
        for(int i=input.length()-1; i>=0; i--){
            int currentIndexValue = romanToIntegerValueMap.get(input.charAt(i));
            if(i == input.length()-1){
                evaluatedNumbers.add(romanToIntegerValueMap.get(input.charAt(i)));
                continue;
            }
            int previousIndexValue = romanToIntegerValueMap.get(input.charAt(i+1));
            if(currentIndexValue < previousIndexValue) {
                evaluatedNumbers.remove(evaluatedNumbers.size()-1);
                evaluatedNumbers.add(previousIndexValue-currentIndexValue);
            } else {
                evaluatedNumbers.add(currentIndexValue);
            }
        }
        int result = evaluatedNumbers.stream().mapToInt(Integer::intValue).sum();
        return result;
    }

//    public String convertIntegerToRoman(int input){
//        if(integerToRomanValueMap.containsKey(input)){
//            return String.valueOf(integerToRomanValueMap.get(input));
//        }
//
//        for(int i=0; i<)
//
//    }
}
