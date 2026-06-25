package CTCI.java.Chapter04_Trees_Graphs.RouteBetweenNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    /* My initial implementation with global variable which is not a good approach (although correct) 
    private static boolean isExist = false;

    public static void isNodeexists(Map<Integer, List<Integer>> graph, int start, int end, Set<Integer> visited){

        if (visited.contains(start) || isExist){
            return;
        }

        if (start == end){
            isExist = true;
            return;
        }
        visited.add(start);

        for (int neighbour : graph.getOrDefault(start, new ArrayList<Integer>())){
            isNodeexists(graph, neighbour, end, visited);
        }

    }
    */

    public static boolean hasPath(Map<Integer, List<Integer>> graph, int start, int end, Set<Integer> visited){
        if (start == end){
            return true;
        }

        if (visited.contains(start)){
            return false;
        }

        visited.add(start);
        
        for(int neighbour : graph.getOrDefault(start, new ArrayList<Integer>())){
            if (hasPath(graph, neighbour, end, visited)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(0, Arrays.asList(1));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList());
        graph.put(3, Arrays.asList(4));
        graph.put(4, Arrays.asList());

        System.out.println(hasPath(graph, 0, 2, new HashSet<>())); // true
        System.out.println(hasPath(graph, 0, 4, new HashSet<>())); // false
        System.out.println(hasPath(graph, 3, 4, new HashSet<>())); // true
        System.out.println(hasPath(graph, 4, 3, new HashSet<>())); // false

    }
}
