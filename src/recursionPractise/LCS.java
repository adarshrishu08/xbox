package recursionPractise;

import java.util.ArrayList;
import java.util.List;

public class LCS {
    // Longest Common Sequence
    public static void main(String[] args) {
        LCS lcs = new LCS();
        String A = "ABC";
        String B = "ABD";
        System.out.println(lcs.lcs(A,B, new ArrayList<>()));
    }

    public int lcs(String str1, String str2, List<String> list) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        if (str1.length() == 0 || str2.length() == 0) {
            System.out.println(list);
            list.clear();
            return 0;
        }

        if (str1.charAt(str1.length() - 1) == str2.charAt(str2.length() - 1)) {
            list.add(str1.charAt(str1.length() - 1)+"");
            return 1+lcs(str1.substring(0, str1.length() - 1), str2.substring(0, str2.length() - 1), list);
        } else {
            int left = lcs(str1.substring(0,str1.length()-1), str2, list);
            int right = lcs(str1, str2.substring(0, str2.length()-1), list);
            return Math.max(left, right);
        }


    }
}
