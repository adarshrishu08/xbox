package practice.leetcode;

public class Pallindrome {

    public static void main(String[] args) {

        int i = -121;
        System.out.println(isPalindrome(i));
    }

    public static boolean isPalindrome(int x){
        int y = 0;
        int x1 = x;
        while(x1>0) {
            y = y * 10 + x1%10;
            x1 = x1/10;
        }
        return y == x;
    }

}
