package practice.sorting;

public class binarySearch {

    public static void main(String[] args) {

        int arr[] = {10, 20, 30, 50, 60, 80, 110, 130, 140, 170};
        System.out.println(binarySearch(arr, 170));

        int missingElementArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        System.out.println(findMissingElementInSequencialSortedArray(missingElementArr));
    }

    public static int binarySearch(int[] arr, int key) {
        if (arr.length == 1) {
            return arr[0];
        }

        int mid = arr.length / 2;
        int min = 0;
        int max = arr.length;

        while (min < max) {
            if (key < arr[mid]) {
                max = mid - 1;
            } else if (key == arr[mid]) {
                return mid;
            } else {
                min = mid + 1;
            }
            mid = (min + max) / 2;
        }

        return -1;
    }


    public static int findMissingElementInSequencialSortedArray(int arr[]) {
        if (arr.length == 1) {
            return 0;
        }

        int min = 0;
        int max = arr.length;

        while (min < max) {
            int mid = (min + max) / 2;

            if (arr[mid] != mid + 1 && arr[mid - 1] == mid) {
                return mid + 1;
            } else if (arr[mid] == mid + 1) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }


        }
        return -1;
    }
}
