package practice.leetcode;

public class LongestSubstring {

    static int resultStart;
    static int resultLength;
    // Determine Longest substring without repeating characters
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Total cores in my mac :" + cores);
        String str = "babad";
        //String str = "abaccabe";
        System.out.println("Result -> " + new LongestSubstring().longestPallindrome(str));
    }

    public String longestPallindrome(String str) {
        int start = 0, end = 0;
        int strLength = str.length();
        if (strLength < 2) {
            return str;
        }
        for (int i = 0; i < strLength; i++) {
            int odd = expandRange(str, i, i);
            int even = expandRange(str, i, i+1);

            int len = Math.max(odd, even);

            if(len > end-start){
                //Even len (6) -> 2 start --> i-2, end -> i+3
                // Odd len (5) -> 2 start --> i-2, end -> i+2
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return str.substring(start, end+1);
    }


    public int expandRange(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

//        if(resultLength < begin - end -1){
//            resultStart = begin + 1;
//            resultLength = begin - end -1;
//        }
        return right - left -1;
    }
}
