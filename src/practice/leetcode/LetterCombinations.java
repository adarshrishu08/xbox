package practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    Map<Integer, String> numToLetters = new HashMap<>();
    {
        numToLetters.put(2, "abc");
        numToLetters.put(3, "def");
        numToLetters.put(4, "ghi");
        numToLetters.put(5, "jkl");
        numToLetters.put(6, "mno");
        numToLetters.put(7, "pqrs");
        numToLetters.put(8, "tuv");
        numToLetters.put(9, "wxyz");
    }


    public static void main(String[] args) {
        //System.out.println(new LetterCombinations().letterCombinations("234"));
        new LetterCombinations().letterCombination("", 0, "234");
    }

    public List<String> letterCombinations(String digits) {


        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }
        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            List<String> temp = new ArrayList<>();
            String letters = numToLetters.get(Integer.parseInt(String.valueOf(digits.charAt(i))));
            for (int j = 0; j < result.size(); j++) {
                for (int k = 0; k < letters.length(); k++) {
                    temp.add(new StringBuilder(result.get(j)).append(letters.charAt(k)).toString());
                }
            }
            result.clear();
            result.addAll(temp);
        }

        return result;
    }




    public void letterCombination(String soFar, int i, String digits){
        if(soFar.length() == digits.length()){
            System.out.println(soFar);
            return;
        }
        String str = numToLetters.get(Integer.parseInt(""+digits.charAt(i)));
        for(int k =0; k<str.length(); k++){
            letterCombination(soFar+str.charAt(k), i+1, digits);
        }

    }
}
