package practice.DataStructures.LinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        Node node5 = new Node(1, null);
        Node node4 = new Node(2, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(4, node3);
        Node node1 = new Node(5, node2);

        LinkedListOperation operation =  new LinkedListOperation();
        operation.displayLinkedList(node1);
//        operation.reverseLinkedList(node1);

        Node node10 = new Node(8, null);
        Node node9 = new Node(3, node10);
        Node node8 = new Node(13, node9);
        Node node7 = new Node(2, node8);
        Node node6 = new Node(5, node7);
        System.out.println();
        operation.displayLinkedList(node6);
        operation.removeNodes(node6);

    }
}
