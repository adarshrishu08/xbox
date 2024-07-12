package practice.DataStructures.Tree;

public class BinaryTree {

    public static void traverseBinaryTreeInOrder(TreeNode root){
        if(root == null){
            return;
        }

        traverseBinaryTreeInOrder(root.left);
        System.out.println(root.data);
        traverseBinaryTreeInOrder(root.right);

    }

    public static void traverseBinaryTreePostOrder(TreeNode root){
        if(root == null){
            return;
        }
        traverseBinaryTreePostOrder(root.left);
        traverseBinaryTreePostOrder(root.right);
        System.out.println(root.data);
    }

    public static void traverseBinaryTreePreOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.data);
        traverseBinaryTreePreOrder(root.left);
        traverseBinaryTreePreOrder(root.right);
    }
}
