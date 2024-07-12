package recursionPractise;

import java.util.Stack;

public class BalancedParentheses {

    public static void main(String[] args) {
        String str = "{[(){}]}([])";
        String str2 = "{[]}";
        System.out.println(checkBalancedParantheses(str));
    }


    //Stack Approach
    public static boolean checkBalancedParantheses(String expression) {
        Stack<Character> stack = new Stack();
        char[] expressArr = expression.toCharArray();
        for (int i = 0; i < expressArr.length; i++) {
            if (stack.size() > 0) {
                if ('(' == stack.peek() && expressArr[i] == ')' ||
                        '{' == stack.peek() && expressArr[i] == '}' ||
                        '[' == stack.peek() && expressArr[i] == ']') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(expressArr[i]);
        }

        return stack.empty();
    }

//    //Recursion Approach
//    public static boolean checkBalancedParanthesesWithrecursion (String expression, int charLength, char currentChar){
//        if(expression.length() == charLength){
//            return true;
//        }
//        if ('(' == expression.charAt(charLength) && currentChar == ')' ||
//                '{' == expression.charAt(charLength) && currentChar == '}' ||
//                '[' == expression.charAt(charLength) && currentChar == ']') {
//        } else {
//            return checkBalancedParanthesesWithrecursion(expression.substring(charLength, expression.length()-1), ,expression.charAt(charLength))
//        }
//    }

}
