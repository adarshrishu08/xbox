package practice.DataStructures.Tree;

import java.util.*;

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
        //BinarySearchTree.convertBinaryTreeToBST(TreeDataUtil.createBinaryTree());

        /** Convert Normal BST to a Balanced BST*/
        //BinarySearchTree.convertNormalBSTToBalancedBST(TreeDataUtil.createNormalBinarySearchTree());

        /** Level Order Traversal */
        TreeNode root = TreeDataUtil.createBinaryTree();
        //List<List<Integer>> levelOrder = BinaryTree.levelOrderIterative(root);
        int height = BinaryTree.maxDepthIterative(root);
        System.out.println(height);

    }


}
class Pair<TreeNode, Integer>{
    TreeNode key;
    Integer value;

    public Pair() {
    }

    public Pair(TreeNode key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public TreeNode getKey() {
        return key;
    }

    public void setKey(TreeNode key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

