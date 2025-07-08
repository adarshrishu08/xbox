package practice.DataStructures.Queue;

import java.util.Arrays;

public class CustomQueue {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(2);
        queue.push(5);
        queue.push(1);
        queue.push(3);
        queue.push(9);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}

class Queue{
    private int currentIndex = 0;
    private int INITIAL_CAPACITY = 10;
    private int capacity = 0;
    private int[] arr;


    public void push(int value){
        if(arr == null){
            arr = new int[INITIAL_CAPACITY];
        }
        if(arr.length == capacity){
            arr = Arrays.copyOf(arr, capacity*2);
        }
        arr[currentIndex] = value;
        currentIndex++;
        capacity++;
    }

    public int poll(){
        if(capacity == 0){
            throw new RuntimeException("Queue is Empty, No elements are found to Poll");
        }
        int result = arr[0];
        for(int i=0; i<currentIndex;i++){
            arr[i] = arr[i+1];
        }
        currentIndex--;
        capacity--;
        return result;
    }
}
