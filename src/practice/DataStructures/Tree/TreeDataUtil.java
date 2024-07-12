package practice.DataStructures.Tree;

public class TreeDataUtil {

    public static TreeNode createBinaryTree(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(30);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(5);

        return root;
    }


    public static TreeNode createBinarySearchTree(){
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(14);

        return root;
    }


    public static TreeNode createNormalBinarySearchTree(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(5);

        return root;
    }

}
