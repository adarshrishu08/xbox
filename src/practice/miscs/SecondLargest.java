package practice.miscs;

public class SecondLargest {

    public static void main(String[] args) {
        int[] arr = {4,5,2,1,7,3,10,19,73,6,65,45,23,45};

        int max = 0;
        int secondMax = 0;
        for(int i=0; i<arr.length; i++){
            if(i != 0 && arr[i-1] < arr[i]){
                secondMax = arr[i-1] > secondMax ? max : secondMax;
                max = arr[i];

            }
        }
        System.out.println(secondMax);
        System.out.println(max);
    }
}
