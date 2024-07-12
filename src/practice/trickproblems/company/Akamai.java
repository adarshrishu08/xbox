import java.util.ArrayList;
import java.util.List;

public class Akamai {

    public static void main(String[] args) {

//        int[] arr = {2, 3, 4, 1, 6};
//        adding 1 into the arr and result should come as a array
//        int[] result = {2, 3, 4, 1, 7}

//        ["aabb"]
//
//        a, aa, aab, aabb, abb, bb, b

//        int[] arr1 = {2, 9, 4, 9, 9};
//        int[] arr2 = {9, 9, 9, 9, 9};
//
//        int[] result = getSummedArray(arr1);
//        for(int i=0; i<result.length ; i++){
//            System.out.print(result[i]+",");
//        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
        int arr[] = {1, 2 ,3 ,4 ,5, 6, 7, 8};
        reverseInGroups(list, list.size(), 3);

    }
    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
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
        System.out.println(reversedGroupOne);
    }

    public static int[] getSummedArray(int[] arr){
        int[] result1 = new int[arr.length];
        int[] result2 = new int[arr.length+1];
        boolean isBiggerArray = false;
        boolean continueAdding = true;

        for(int i=arr.length-1 ; i>=0; i--){
            if(arr[i] == 9 && continueAdding){
                result1[i] = 0;
                if(i==0 && result1[0] == 0){
                    result2[0] = 1;
                    isBiggerArray =  true;
                }
                continue;
            }
            if(continueAdding) {
                result1[i] = arr[i] + 1;
                continueAdding = false;
            } else {
                result1[i] = arr[i];
            }
        }
        if(isBiggerArray){
            return result2;
        }
        return result1;
    }
}
