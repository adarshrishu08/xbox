package practice.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] input = {12, 11, 13, 5, 6, 7};
        int[] leftArray = {12, 11, 13};
        int[] rightArray = {5, 6, 7};
        mergeSort(input);
        for(int i=0; i< input.length; i++){
            System.out.println(input[i]);
        }

    }

    public static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if (inputArray.length < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }

        for (int i = midIndex; i < inputArray.length; i++) {
            rightHalf[i - midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(inputArray, leftHalf, rightHalf);

    }

    // {3,1,4,2, 5}  {5}   {4,2} =  resultArray {4,5,2}
    public static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }

    }


}
