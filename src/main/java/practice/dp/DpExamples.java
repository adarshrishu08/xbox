package practice.dp;

import java.util.Map;

public class DpExamples {

    public static void main(String[] args) {
        int size = lcs("ABCDE", "BACEDF");
        System.out.println(size);
    }

    /**
     * input: x = ABCDE
     * input: y = BACEDF
     * output : 3
     * */
    public static int lcs(String x, String y){
        if(x.length() == 0 || y.length() == 0){
            return 0;
        }

        if(x.charAt(x.length()-1) == y.charAt(y.length()-1)){
            return 1 + lcs(x.substring(0, x.length()-1), y.substring(0, y.length()-1));
        }

        int xInclude = lcs(x.substring(0, x.length()-1), y);
        int yInclude = lcs(x, y.substring(0, y.length()-1));

        return Math.max(xInclude, yInclude);
    }
}
