package practice.DataStructures.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

    /** Level Order Traversal Iterative Approach */
    public static List<List<Integer>> levelOrderIterative(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new LinkedList();

            for(int i=0; i<size; i++){
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                level.add(queue.poll().data);
            }
            levelOrder.add(level);
        }
        return levelOrder;
    }

    public static int maxDepthIterative(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lh = 1;
        int rh = 1;
        Stack<TreeNode> stack = new Stack();
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr.left != null){
                lh = lh+1;
                stack.push(curr.left);
            }
            if(curr.right != null){
                rh = rh+1;
                stack.push(curr.right);
            }
        }
        return Math.max(lh, rh);
    }
}
