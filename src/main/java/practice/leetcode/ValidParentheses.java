package practice.leetcode;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "(})";
        System.out.println(new ValidParentheses().isValidParenthesis(s));

    }

    public boolean isValidParenthesis(String str){
        Stack<Character> stack = new Stack();
        boolean isValid = true;
        for(int i=0; i< str.length(); i++){
            char c = str.charAt(i);
            if(stack.isEmpty() && (str.charAt(0) == ')' || str.charAt(0) == '}' || str.charAt(0) == ']')){
                return false;
            }
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
                continue;
            }
            if(!stack.isEmpty() && ((stack.peek() == '(' && c == ')') || (stack.peek() == '{' && c == '}') || (stack.peek() == '[' && c == ']'))){
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
