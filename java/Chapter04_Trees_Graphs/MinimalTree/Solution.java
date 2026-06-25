package CTCI.java.Chapter04_Trees_Graphs.MinimalTree;

public class Solution {
    public static void main(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        TreeNode root = createMinimalTree(arr);
        inorder(root);
    }

    public static TreeNode createMinimalTree(int[] arr){
        return build(arr, 0, arr.length-1);
    }

    public static TreeNode build(int[] arr, int left, int right){
        if (left > right){
            return null;
        }

        int mid = left + (right - left)/2;

        TreeNode node = new TreeNode(arr[mid]);

        node.left = build(arr, left, mid-1);
        node.right = build(arr, mid+1, right);

        return node;
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.data = data;
    }
}
