package CTCI.java.Chapter03_Stack_Queue.stackMin;

import java.util.EmptyStackException;

public class Solution {
    private static StackNode top;

        // 🔥 Main method to test
    public static void main(String[] args) {

        push(5);
        System.out.println("Min after pushing 5: " + min()); // 5

        push(3);
        System.out.println("Min after pushing 3: " + min()); // 3

        push(7);
        System.out.println("Min after pushing 7: " + min()); // 3

        push(2);
        System.out.println("Min after pushing 2: " + min()); // 2

        System.out.println("Popped: " + pop()); // 2
        System.out.println("Min now: " + min()); // 3

        System.out.println("Popped: " + pop()); // 7
        System.out.println("Min now: " + min()); // 3

        System.out.println("Popped: " + pop()); // 3
        System.out.println("Min now: " + min()); // 5

        System.out.println("Popped: " + pop()); // 5

        // Uncomment to test exception
        // System.out.println(min());
    }

    public static void push(int val){
        StackNode node = new StackNode(val);
        node.next = top;
        if (top != null && top.minTillNow < val){
            node.minTillNow = top.minTillNow;
        }else{
            node.minTillNow = val;
        }
        top = node;        
    }

    public static int pop(){
        if (top == null){
            throw new EmptyStackException();
        }
        int item = top.data;
        top = top.next;
        return item;
    }

    public static int min(){
        if (top == null){
            throw new EmptyStackException();
        }
        return top.minTillNow;
    }

}

class StackNode{
    int data;
    StackNode next;
    int minTillNow;
    public StackNode(int data){
        this.data = data;
        this.next = null;
    }
}