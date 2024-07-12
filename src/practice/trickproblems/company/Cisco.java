package practice.trickproblems.company;

import java.util.HashMap;
import java.util.Map;

public class Cisco {
    public static void main(String[] args) {
        int[] arr = {4,8,2,8,9};
//        int[] count = new int[arr.length];
//////        int[] repeatedElement = new int[arr.length];
//////        int counter = 0;
//////        for(int i=0; i<arr.length; i++){
//////            for(int j=0; j<arr.length; j++){
//////                if(i != j){
//////                    if(arr[i] == arr[j]){
//////                        repeatedElement[counter] = arr[i];
//////                    }
//////                }
//////            }
//////        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int countOfNRE = 0;
        for(Integer i : map.values()){
            if(i == 1){
                countOfNRE = countOfNRE+1;
            }
        }
        System.out.println(countOfNRE);
    }



}
