package practice.trickproblems.company;

import java.util.*;
import java.util.stream.Collectors;

public class JPMC {

    public static void main(String[] args) {

        Map<String, String> map = new TreeMap<>();
        List<String> edgeStr = new ArrayList<>();
        String edgeString = "";


        String str = "123456";
        char[] arr = str.toCharArray();
        int evenFlag = 0;
        int oddFlag = 0;
        String finalString = "";
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            if(num % 2 == 0){
                evenFlag++;
                if(evenFlag > 1){
                    finalString = finalString.concat("*");
                }
                oddFlag = 0;
                finalString = finalString.concat(arr[i]+"");
            } else {
                oddFlag++;
                if(oddFlag > 1){
                    finalString = finalString.concat("-");
                }
                evenFlag = 0;
                finalString = finalString.concat(arr[i]+"");
            }
        }
        System.out.println("Final String result is :" + finalString);
    }
}
