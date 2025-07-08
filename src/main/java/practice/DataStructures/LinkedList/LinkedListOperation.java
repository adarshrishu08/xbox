package practice.DataStructures.LinkedList;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedListOperation {

    public void displayLinkedList(Node node){
        while(node!=null){
            System.out.print(node.getValue());
            if(node.getNext() != null) {
                System.out.print("->");
            }
            node = node.getNext();
        }
    }

    public Node reverseLinkedList(Node node){
        Node prev = null;
        Node current = node;
        Node next = null;
        while(current!= null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        System.out.println();
        displayLinkedList(node);
        return node;

    }

    public boolean detectLoop(Node node){
        boolean isLoop = false;
        Set<Integer> set = new HashSet<>();
        while (node != null){
            if(set.contains(node.value)){
                isLoop =  true;
                break;
            }
            set.add(node.value);
        }
        System.out.println(isLoop);
        return isLoop;
    }

    public void removeNodes(Node head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            Node current = head;
            head = head.next;
            if(head!= null && current.value < head.value){
                stack.push(head.value);
            }
        }
        System.out.println();
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
