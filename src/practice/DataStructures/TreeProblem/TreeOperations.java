package practice.DataStructures.TreeProblem;

public class TreeOperations {

    public static void main(String[] args) {
        Tree root = setUpData();
        System.out.println("In Order Traversal");
        inOrderTraversal(root);
        System.out.println("Post Order Traversal");
        postOrderTraversal(root);
        System.out.println("Pre Order Traversal");
        preOrderTraversal(root);
    }

    private boolean checkBst(Tree root){
        if(root == null){
            return true;
        }
        if(root.left != null && root.left.value > root.value){
            return false;
        }

        if(root.right != null && root.right.value < root.value){
            return false;
        }

        if(!checkBst(root.left) || !checkBst(root.right)){
            return false;
        }
        return true;
    }

    private static void inOrderTraversal(Tree root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    private static void postOrderTraversal(Tree root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
        System.out.println(root.value);
    }

    private static void preOrderTraversal(Tree root){
        if(root == null){
            return;
        }
        System.out.println(root.value);
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
    }


    private static Tree setUpData(){
        Tree root = new Tree(10);
        root.left = new Tree(12);
        root.right = new Tree(11);
        root.left.left = new Tree(13);
        root.left.right = new Tree(15);
        root.right.left = new Tree(20);
        root.right.right = new Tree(25);
        return root;
    }
}
