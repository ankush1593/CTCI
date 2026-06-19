package CTCI.java.Chapter03_Stack_Queue.setOfStacks;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        // Create SetOfStacks with capacity = 3
        Solution set = new Solution(3);

        // 🔹 Push elements
        System.out.println("Pushing elements:");
        for (int i = 1; i <= 10; i++) {
            set.push(i);
            System.out.println("Pushed: " + i);
        }

        // 🔹 Pop elements
        System.out.println("\nPopping elements:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Popped: " + set.pop());
        }

        // 🔹 Peek
        System.out.println("\nTop element (peek): " + set.peek());

        // 🔹 Pop remaining elements
        System.out.println("\nPopping remaining elements:");
        try {
            while (true) {
                System.out.println("Popped: " + set.pop());
            }
        } catch (Exception e) {
            System.out.println("Stack is now empty!");
        }
    }
    
    ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
    int capactiy;

    public Solution(int capactiy){
        this.capactiy = capactiy;
        this.stacks = new ArrayList<>();
    }

    public Stack<Integer> getLastStack(){
        if (stacks.isEmpty()){
            return null;
        }
        return stacks.get(stacks.size()-1);
    }

    public void push(int value){
        Stack<Integer> last = getLastStack();

        if (last != null && last.size() < capactiy){
            last.push(value);
        }else{
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(value);
            stacks.add(stack);
        }
    }

    public int pop(){
        Stack<Integer> last = getLastStack();
        if (last == null || last.isEmpty()){
            throw new EmptyStackException();
        }
        int element = last.pop();

        if (last.isEmpty()){
            stacks.remove(stacks.get(stacks.size()-1));
        }
        return element;
    }

    public int peek(){
        Stack<Integer> last = getLastStack();
        if (last == null || last.isEmpty()){
            throw new EmptyStackException();
        }

        return last.peek();
    }
}
