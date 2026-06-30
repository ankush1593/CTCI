package CTCI.java.Chapter04_Trees_Graphs.CheckBalanced;

public class Solution {
    public static void main(String[] args) {

        // ✅ Test Case 1: Balanced Tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        System.out.println("Test 1 (Balanced): " + isBalanced(root1));


        // ❌ Test Case 2: Unbalanced Tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);

        System.out.println("Test 2 (Unbalanced): " + isBalanced(root2));


        // ✅ Test Case 3: Single Node
        TreeNode root3 = new TreeNode(10);

        System.out.println("Test 3 (Single node): " + isBalanced(root3));


        // ✅ Test Case 4: Empty Tree
        TreeNode root4 = null;

        System.out.println("Test 4 (Empty): " + isBalanced(root4));
    }

    private static boolean isBalanced(TreeNode root){
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node){
        if (node == null){
            return 0;
        }

        int left = checkHeight(node.left);
        if (left == -1){
            return -1;
        }

        int right = checkHeight(node.right);
        if (right == -1){
            return -1;
        }

        if (Math.abs(right - left) > 1){
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}

class TreeNode{
    int data;
    TreeNode left, right;

    public TreeNode(int data){
        this.data = data;
    }
}