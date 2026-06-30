package CTCI.java.Chapter04_Trees_Graphs.BSTSuccessor;

public class Solution {
    public static void main(String[] args) {

        /*
                20
               /  \
             10    30
            /  \
           5   15
              /
             12
        */

        TreeNode root = new TreeNode(20);

        root.left = new TreeNode(10);
        root.right = new TreeNode(30);

        root.left.parent = root;
        root.right.parent = root;

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);

        root.left.left.parent = root.left;
        root.left.right.parent = root.left;

        root.left.right.left = new TreeNode(12);
        root.left.right.left.parent = root.left.right;

        // 🔍 Test cases

        TreeNode node1 = root.left.right; // 15
        TreeNode node2 = root.left;       // 10
        TreeNode node3 = root.left.left;  // 5
        TreeNode node4 = root.right;      // 30 (max node)

        printSuccessor(node1); // expected: 20
        printSuccessor(node2); // expected: 12
        printSuccessor(node3); // expected: 10
        printSuccessor(node4); // expected: null
    }

    private static void printSuccessor(TreeNode node) {
        TreeNode succ = inorderSuccessor(node);
        System.out.println(
            "Successor of " + node.data + " is: " +
            (succ != null ? succ.data : "null")
        );
    }

    public static TreeNode inorderSuccessor(TreeNode node){
        if (node == null){
            return null;
        }

        if (node.right != null){
            return getLeftmostElement(node.right);
        }

        TreeNode current = node;
        TreeNode parent = node.parent;

        while (parent != null && parent.right == current) {
            current = parent;
            parent = parent.parent;
        }

        return parent;
    }

    public static TreeNode getLeftmostElement(TreeNode node){
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}

class TreeNode {
    TreeNode left, right, parent;
    int data;

    public TreeNode(int data){
        this.data = data;
    }
}