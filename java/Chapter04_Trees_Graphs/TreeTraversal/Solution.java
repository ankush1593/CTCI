package CTCI.java.Chapter04_Trees_Graphs.TreeTraversal;

public class Solution {

    public static void main(){
        Solution sol = new Solution();

        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print("Inorder: ");
        sol.inorder(root);   // 4 2 5 1 6 3 7
        System.out.println();

        System.out.print("Preorder: ");
        sol.preorder(root);  // 1 2 4 5 3 6 7
        System.out.println();

        System.out.print("Postorder: ");
        sol.postorder(root); // 4 5 2 6 7 3 1
        System.out.println();
    }

    public void inorder(Node node){
        if (node != null){
            inorder(node.left);
            System.out.print(node.data);
            inorder(node.right);
        }
    }

    public void preorder(Node node){
        if (node != null){
            System.out.print(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(Node node){
        if (node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data);
        }
    }
}

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }
}
