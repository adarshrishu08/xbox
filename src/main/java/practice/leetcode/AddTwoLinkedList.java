package practice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class AddTwoLinkedList {
    public static void main(String[] args) {
//        Input: l1 = [2,4,3], l2 = [5,6,4]
//        Output: [7,0,8]
//        Explanation: 342 + 465 = 807.
//        Example 2:
//
//        Input: l1 = [0], l2 = [0]
//        Output: [0]
//        Example 3:
//
//        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//        Output: [8,9,9,9,0,0,0,1]

        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9, node1);
        ListNode node3 = new ListNode(9, node2);
        ListNode node4 = new ListNode(9, node3);
        ListNode node5 = new ListNode(9, node4);
        ListNode node6 = new ListNode(9, node5);
        ListNode node7 = new ListNode(9, node6);


        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9, node8);
        ListNode node10 = new ListNode(9, node9);
        ListNode node11 = new ListNode(9, node10);


//        ListNode node1 = new ListNode(4);
//        ListNode node2 = new ListNode(6, node1);
//        ListNode node3 = new ListNode(5, node2);
//
//        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(4, node4);
//        ListNode node6 = new ListNode(2, node5);


//        ListNode node0 = new ListNode(9);
//        ListNode node1 = new ListNode(4, node0);
//        ListNode node2 = new ListNode(6, node1);
//        ListNode node3 = new ListNode(5, node2);
//
//        ListNode node4 = new ListNode(9);
//        ListNode node5 = new ListNode(4, node4);
//        ListNode node6 = new ListNode(2, node5);


        addTwoNumbers(node7, node11);

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayDeque<Integer> queue1 = new ArrayDeque<>();
        ArrayDeque<Integer> queue2 = new ArrayDeque<>();

        while (l1 != null) {
            queue1.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            queue2.add(l2.val);
            l2 = l2.next;
        }

        List<Integer> list = new ArrayList<>();
        int remainder = 0;
        int carry = 0;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            int i = 0;
            int j = 0;
            if (!queue1.isEmpty()) {
                i = queue1.pop();
            }
            if (!queue2.isEmpty()) {
                j = queue2.pop();
            }
            int result = i + j + carry;
            if (result > 9) {
                remainder = result % 10;
                list.add(remainder);
                carry = 1;
            } else {
                list.add(result);
                carry = 0;
            }
        }
        if(carry > 0){
            list.add(carry);
        }
        ListNode prevNode = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            ListNode resultNode = new ListNode(list.get(i), prevNode);
            prevNode = resultNode;
        }

        while (prevNode != null) {
            System.out.println(prevNode.val);
            prevNode = prevNode.next;
        }
        return prevNode;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}