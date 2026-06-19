package CTCI.java.Chapter03_Stack_Queue.queueViaStacks;

import java.util.EmptyStackException;
import java.util.Stack;

public class Solution {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public Solution(){
        this.inStack = new Stack<Integer>();
        this.outStack = new Stack<Integer>();
    }

    public void enqueue(int val){
        inStack.push(val);
    }

    public int dequeue(){
        shiftStacks();
        if (outStack.isEmpty()){
            throw new EmptyStackException();
        }
        return outStack.pop();
    }

    public void shiftStacks(){
        if (outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }

    public int peek(){
        shiftStacks();
        if (outStack.isEmpty()){
            throw new EmptyStackException();
        }
        return outStack.peek();
    }

    public boolean isEmpty(){
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {

        Solution q = new Solution();

        System.out.println("Enqueue elements:");
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        System.out.println("Dequeued: " + q.dequeue()); // 1
        System.out.println("Dequeued: " + q.dequeue()); // 2

        q.enqueue(5);

        System.out.println("Peek: " + q.peek()); // 3

        System.out.println("Dequeuing remaining:");
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }
}
