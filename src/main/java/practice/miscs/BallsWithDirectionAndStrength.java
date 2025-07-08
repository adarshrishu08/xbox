package practice.miscs;

import java.util.Stack;
import java.util.TreeSet;

public class BallsWithDirectionAndStrength {

    public static void main(String[] args) {
        int[] strength = {5,3,1};
        int[] direction = {1,-1,1};
        Stack<Integer> stack = new Stack<>();

        TreeSet<Integer> arr = new TreeSet<>();
        for(int i=0; i<strength.length ; i++){
            if(i == 0 && direction[i] == -1){
                arr.add(i);
                continue;
            }
            if(direction[i] == 1){
                stack.push(i);
            }
            if(direction[i] == -1){
                if(stack.empty()){
                    arr.add(i);
                } else {
                    int winIndex = i;
                    while(!stack.isEmpty() && direction[winIndex] == -1){
                        if(direction[stack.peek()] == 1){
                            Integer indx = stack.pop();
                            if(strength[indx] > strength[winIndex]){
                                stack.push(indx);
                            } else if(strength[indx] < strength[winIndex]){
                                stack.push(winIndex);
                            }
                            winIndex = stack.empty() ? -1 : stack.pop();
                        } else {
                            break;
                        }
                    }
                    if(winIndex!=-1) stack.push(winIndex);
                }
            }
        }
        while (!stack.empty()){
            arr.add(stack.pop());
        }
        System.out.println(arr);
    }
}
