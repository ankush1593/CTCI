package CTCI.java.Chapter03_Stack_Queue.sortStack;

import java.util.Stack;

public class Solution {

    private static Stack<Integer> temp = new Stack<Integer>();

    public static void sort(Stack<Integer> input){
        if (input == null || input.isEmpty())
            return;

        while(!input.isEmpty()){
            int curr = input.pop();
            while(!temp.isEmpty() && temp.peek() < curr){
                input.push(temp.pop());
            }
            temp.push(curr);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);

        Solution.sort(stack);

        System.out.println("Sorted Stack (smallest on top):");

        while (!temp.isEmpty()) {
            System.out.println(temp.pop());
        }
    }
}
