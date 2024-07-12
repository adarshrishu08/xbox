package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(4);
        LinkedListNode node2 = new LinkedListNode(2, node1);
        LinkedListNode node3 = new LinkedListNode(1, node2);

        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(3, node4);
        LinkedListNode node6 = new LinkedListNode(1, node5);

        new MergeTwoSortedLinkedLists().mergeLinkedList(node3, node6);


    }

    public LinkedListNode mergeLinkedList(LinkedListNode list1, LinkedListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        LinkedListNode mergedList = mergeList(list1, list2);
        LinkedListNode finalList = sortList(mergedList);
        List<Integer> result = new ArrayList<>();
        while (finalList != null){
            result.add(finalList.val);
            finalList = finalList.next;
        }
        System.out.println(result);
        return finalList;
    }

    public LinkedListNode mergeList(LinkedListNode list1, LinkedListNode list2){
        LinkedListNode head = list1;
        while(list1.next != null){
            list1 = list1.next;
        }
        list1.next = list2;
        return head;
    }

    public LinkedListNode sortList(LinkedListNode list1){
        LinkedListNode currentNode = list1;

        int temp;

        while (currentNode != null){
            LinkedListNode index = currentNode.next;
            while(index != null){
                if(currentNode.val > index.val){
                    temp = currentNode.val;
                    currentNode.val = index.val;
                    index.val = temp;
                }
                index = index.next;
            }
            currentNode = currentNode.next;
        }
        return list1;
    }
}


class LinkedListNode {
    int val;
    LinkedListNode next;

    LinkedListNode() {
    }

    LinkedListNode(int val) {
        this.val = val;
    }

    LinkedListNode(int val, LinkedListNode next) {
        this.val = val;
        this.next = next;
    }
}