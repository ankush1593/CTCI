package CTCI.java.Chapter04_Trees_Graphs.GraphTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {


    // Create a queue and a visited Set. In a graph represented by Map[int, list]: add root to queue and mark it as visited.
    // then iterate over the queue till it is not empty print the current element and for the current element, get all the
    // neighbours using the adjacency list (map). Iterate over the map, add all elements to queue and mark everything as visited.
    public static void bfs(Map<Integer, List<Integer>> graph, int start){
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int data = queue.poll();
            System.out.println(data + " ");

            for(int neighbour : graph.getOrDefault(data, new ArrayList<>())){
                if (!visited.contains(neighbour)){
                    queue.offer(neighbour);
                    visited.add(neighbour);
                }
            }
        }

    }

    public static void dfs(Map<Integer, List<Integer>> graph, int num, Set<Integer> visited){
        if (visited.contains(num)){
            return;
        }

        System.out.println(num + " ");
        visited.add(num);

        for (int neighbour : graph.getOrDefault(num, new ArrayList<>())){
            dfs(graph, neighbour, visited);
        }
    }

    public static void dfsIterative(Map<Integer, List<Integer>> graph, int start){
        Stack<Integer> stack = new Stack<Integer>();
        Set<Integer> visited = new HashSet<Integer>();

        stack.push(start);
        visited.add(start);

        while (!stack.isEmpty()) {
            int num = stack.pop();
            System.out.println(num + " ");
            visited.add(num);

            for(int neighbour : graph.getOrDefault(num, new ArrayList<Integer>())){
                if (!visited.contains(neighbour)){
                    stack.push(neighbour);
                }
            }
        }

    }

    public static void main(String[] args){
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

        graph.put(0, Arrays.asList(1,2));
        graph.put(1, Arrays.asList(0, 3));
        graph.put(2, Arrays.asList(0));
        graph.put(3, Arrays.asList(1));

        System.out.println("BFS: ");
        bfs(graph, 0);

        System.out.println();

        System.out.println("DFS (Recursive): ");
        dfs(graph, 0, new HashSet<>());

        System.out.println();

        System.out.print("DFS (Iterative): ");
        dfsIterative(graph, 0);

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
