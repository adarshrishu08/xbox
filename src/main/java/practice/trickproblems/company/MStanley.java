package practice.trickproblems.company;

public class MStanley {
//    static int arr[] = {1, 5, 6};
    public static void main(String[] args) {
        int total = 5;
        int k = 3;
        int arr[] = new int[k];
        for(int i=1;i<=arr.length;i++){
            arr[i-1]=i;
        }
        System.out.println(countWays(total, arr));
    }

//    static int countWaysNew(int N, int k){
//        int count[] = new int[N];
//        // base case
////        count[0] = 1;
//        for (int i = 0; i < N; i++){
//            int[] arr2 = new int[N-i];
//            for (int j = 0; j < k; j++) {
//                if(i > arr[j])
//            }
//        }
//    }


    static int countWays(int N,int arr[])
    {
        int count[] = new int[N + 1];

        // base case
        count[0] = 1;

        // count ways for all values up
        // to 'N' and store the result
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < arr.length; j++) {

                // if i >= arr[j] then
                // accumulate count for value 'i' as
                // ways to form value 'i-arr[j]'
                if (i >= arr[j])
                    count[i] += count[i - arr[j]];
            }
//            printArray(arr);
        }

        // required number of ways
        return count[N];

    }

    static void printArray(int arr[]){
        for (int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
}
