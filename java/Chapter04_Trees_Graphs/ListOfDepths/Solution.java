package CTCI.java.Chapter04_Trees_Graphs.ListOfDepths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        List<LinkedList<TreeNode>> lists = getListofNodePerDepth(root);

        for(int i=0; i<lists.size();i++){
            System.out.println("Depth " + i);
            for(int j=0; j<lists.get(i).size(); j++){
                System.out.println(lists.get(i).get(j).data);
            }
        }
    }

    public static List<LinkedList<TreeNode>> getListofNodePerDepth(TreeNode root){
        List<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();

        if (root == null){
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<TreeNode> levelList = new LinkedList<TreeNode>();

            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                levelList.add(node);

                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            lists.add(levelList);
        }
        return lists;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.data = data;
    }
    
}
