package practice.DataStructures.LinkedList;

public class LinkedListLoop {
    public static void main(String[] args) {

        Node node5 = new Node(6, null);
        Node node4 = new Node(5, node5);
        Node node3 = new Node(4, node4);
        Node node2 = new Node(3, node3);
        Node node1 = new Node(2, node2);
        Node node0 = new Node(1, node1);
        node5.next = node2;
         //1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null

        new LinkedListOperation().detectLoop(node0);
    }
}
