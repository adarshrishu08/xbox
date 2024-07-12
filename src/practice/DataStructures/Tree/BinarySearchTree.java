package practice.DataStructures.Tree;

import java.util.Arrays;

public class BinarySearchTree {

    static int index = 0;

    public static boolean isIdenticalBst(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data == root2.data && isIdenticalBst(root1.left, root2.left)
                && isIdenticalBst(root1.right, root2.right)) {
            return true;
        }
        return false;
    }

    public static void convertBinaryTreeToBST(TreeNode root){
        int tempArraySize = BinarySearchTree.countNodes(root);
        int[] tempArray = new int[tempArraySize];
        //Sort Array
        BinarySearchTree.traverseBinaryTreeInOrder(root, tempArray);
        Arrays.sort(tempArray);
        index = 0;
        BinarySearchTree.convertBST(root, tempArray);
        BinaryTree.traverseBinaryTreeInOrder(root);
    }

    /* Count Nodes of BST*/

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) +
                countNodes(root.right)
                +
                1;
    }

    public static void convertBST(TreeNode root, int[] arr){
        if(root == null){
            return;
        }
        convertBST(root.left, arr);
        root.data = arr[index];
        index++;
        convertBST(root.right, arr);
    }

    public static void traverseBinaryTreeInOrder(TreeNode root, int[] tempArr){
        if(root == null){
            return;
        }

        traverseBinaryTreeInOrder(root.left,tempArr);
        tempArr[index] = root.data;
        index++;
        traverseBinaryTreeInOrder(root.right,tempArr);

    }


    public static void convertNormalBSTToBalancedBST(TreeNode root){
        int[] BSTArray = new int[countNodes(root)];
        traverseBinaryTreeInOrder(root, BSTArray);
        index = 0;
        int[] BalancedBSTArray = new int[BSTArray.length];
        convertBalancedBST(BSTArray, 0, BSTArray.length-1, BalancedBSTArray);
        BinaryTree.traverseBinaryTreeInOrder(root);
    }



    public static void convertBalancedBST(int[] BSTArray, int start, int end, int[] BalancedBSTArray){
        if(BSTArray.length <= 0){
            return;
        }
        int mid = BSTArray.length/2;
        BalancedBSTArray[index] = BSTArray[mid];
        index++;
        convertBalancedBST(BSTArray, start, mid-1, BalancedBSTArray);
        convertBalancedBST(BSTArray, mid, end, BalancedBSTArray);
    }

}
