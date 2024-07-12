package practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumDayForTravel {
    public static void main(String[] args) {
        int[] arr = {7, 5, 2, 7, 2, 7, 4, 7};
        System.out.println(new MinimumDayForTravel().minNoOfDayRequiredSecond(arr));
    }


    public int minNoOfDayRequiredSecond(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }
        int length = arr.length;
        int dayCount = 0;
        int max_day_count = length;
        for(int i=0; i< length; i++){
            int count = 0;
            Set<Integer> setCopy = new HashSet<>();
            for(int s=0; s<length; s++){
                setCopy.add(arr[s]);
            }
            for(int j=0; j<length; j++){
                if(setCopy.contains(arr[j])){
                    setCopy.remove(arr[j]);
                } else {
                    continue;
                }
                count = count + 1;

                if(setCopy.size() == 0){
                    dayCount = Math.min(count, max_day_count);
                    max_day_count = dayCount;
                    break;
                }
            }

        }
        return dayCount;
    }


    public int minNoOfDayRequiredBruteForce(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            }
        }
        int index1=0;
        int daycount=Integer.MAX_VALUE;
        Map<Integer, Integer> map2 = new HashMap<>();
        int count = 0;
        while (index1 < arr.length){
            int index2=index1;
            int prevday=index2;
            int ans=0;
            int count1=0;
            while(index2<arr.length){
                if(!map2.containsKey(arr[index2])){
                    count1 += 1;
                    ans+=(index2-prevday);
                    map2.put(arr[index2], 1);
                }
                index2+=1;
            }
            if(count1 == count){
                daycount=Math.min(ans,daycount);
            }
            map2.clear();
            index1+=1;
        }
        return daycount+1;
    }

    public int minNoOfDayRequired(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet();
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }
        boolean duplicateAtLastIndex = true;
        int count = 1;
        int max_count = set.size();
        int length = arr.length;
        int i=0, j=0, result=Integer.MAX_VALUE;
        while (i < length){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
                if(i == length-1) {
                    duplicateAtLastIndex = true;
                }
            } else {
                map.put(arr[i], count);
            }
            if(map.size() == max_count){
                result = Math.min(result, i-j);
            }
            while(map.size() == max_count && j<=i){
                map.put(arr[j], map.get(arr[j])-1);
                if(map.get(arr[j]) == 0){
                    map.remove(arr[j]);
                    j+=1;
                }
                if(map.size() < max_count){
                    break;
                }
                if(result == max_count) {
                    return result;
                }
                j+=1;
            }
            i+=1;
        }
        if(duplicateAtLastIndex){
            result = result-1;
        }
        return result;
    }
}
