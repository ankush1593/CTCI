package CTCI.java.Chapter04_Trees_Graphs.ValidateBST;

public class Solution {
    public static void main(){
        // ✅ Test Case 1: Valid BST
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(7);

        System.out.println("Test 1 (Valid BST): " + isValidBST(root1));


        // ❌ Test Case 2: Invalid BST (subtree violation)
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.right.left = new TreeNode(6); // ❌ violates BST

        System.out.println("Test 2 (Invalid BST): " + isValidBST(root2));


        // ❌ Test Case 3: Duplicate values (assuming NOT allowed)
        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(10); // ❌ duplicate

        System.out.println("Test 3 (Duplicate): " + isValidBST(root3));


        // ✅ Test Case 4: Single node
        TreeNode root4 = new TreeNode(1);

        System.out.println("Test 4 (Single node): " + isValidBST(root4));


        // ✅ Test Case 5: Empty tree
        TreeNode root5 = null;

        System.out.println("Test 5 (Empty tree): " + isValidBST(root5));
    }

    private static boolean isValidBST(TreeNode root){
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max){
        if (node == null){
            return true;
        }

        if (node.data <= min || node.data >= max){
            return false;
        }

        return validate(node.left, min, node.data) && validate(node.right, node.data, max);
    }
}

class TreeNode{
    int data;
    TreeNode left, right;

    public TreeNode(int data){
        this.data = data;
    }
}
