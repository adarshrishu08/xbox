package practice.GFG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentSkipListMap;

public class Driver {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases

        //while testcases exist
        while(t-->0){

            String inputLine1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine1[0]);
            int k = Integer.parseInt(inputLine1[1]);

            ArrayList<Integer> arr = new ArrayList<>();
            String inputLine2[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr.add(Integer.parseInt(inputLine2[i]));
            }

            Solution obj = new Solution();
            obj.reverseInGroups(arr, n, k);

            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr.get(i) + " ");
            }
            System.out.println(str);
        }
    }
}

class Solution {
    //Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        if(k > n){
            k = n;
        }
        ArrayList<Integer> reversedGroupOne = new ArrayList<>();
        int startIndex = k-1;
        int endIndex = 0;

        for(int i=startIndex; i>=endIndex; i--){
            reversedGroupOne.add(arr.get(i));
            if(i == endIndex && (reversedGroupOne.size()+startIndex+1)<= arr.size()){
                endIndex = reversedGroupOne.size();
                startIndex = reversedGroupOne.size()+startIndex+1;
                i = startIndex;
            }
        }
        int endIndexForSecondArr = arr.size()-(arr.size()-reversedGroupOne.size());
        for(int i=n-1; i>=endIndexForSecondArr; i--){
            reversedGroupOne.add(arr.get(i));
        }
        for(int i=0; i<arr.size(); i++){
            arr.set(i,reversedGroupOne.get(i));
        }
    }
}
