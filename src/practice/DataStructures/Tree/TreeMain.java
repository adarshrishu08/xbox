package practice.DataStructures.Tree;

public class TreeMain {

    static int index = 0;

    public static void main(String[] args) {

        /** Binary Tree Traversal */
//        BinaryTree.traverseBinaryTreeInOrder(TreeDataUtil.createBinaryTree());
//        BinaryTree.traverseBinaryTreePostOrder(TreeDataUtil.createBinaryTree());
//        BinaryTree.traverseBinaryTreePreOrder(TreeDataUtil.createBinaryTree());
//
//        /** Binary Search Tree */
//        boolean result = BinarySearchTree.isIdenticalBst(TreeDataUtil.createBinarySearchTree(), TreeDataUtil.createBinarySearchTree());
//        System.out.println(result);
//        System.out.println(BinarySearchTree.countNodes(TreeDataUtil.createBinarySearchTree()));

        /** Convert Binary Tree To Binary Search Tree*/
        BinarySearchTree.convertBinaryTreeToBST(TreeDataUtil.createBinaryTree());

        /** Convert Normal BST to a Balanced BST*/
        BinarySearchTree.convertNormalBSTToBalancedBST(TreeDataUtil.createNormalBinarySearchTree());

    }


}
