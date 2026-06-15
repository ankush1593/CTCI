package CTCI.java.Chapter02_LinkedLists.removeDuplicates;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args){
        Node head = new Node(1);
        appendToTail(2, head);
        appendToTail(3, head);
        appendToTail(2, head);
        appendToTail(1, head);
        appendToTail(2, head);
        appendToTail(4, head);
        appendToTail(5, head);
        appendToTail(3, head);
        printList(head);
        removeDuplicates(head);
        System.out.println("............");
        printList(head);
    }

    public static void appendToTail(int val, Node head){
        Node temp = head;
        Node end = new Node(val);
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = end;
    }

    public static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void removeDuplicates(Node head){
        if (head == null){
            return;
        }

        Node curr = head;
        Node prev = null;
        HashSet<Integer> set = new HashSet<Integer>();

        while (curr != null) {
            if (set.contains(curr.data)){
                prev.next = curr.next;
            }else{
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    public static void removeDuplicatesV2(Node head){
        if (head == null){
            return;
        }
        Node temp = head;
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(temp.data);
        while(temp.next != null){
            if (set.contains(temp.next.data)){
                temp.next = temp.next.next;
            }else{
                set.add(temp.next.data);
                temp = temp.next;
            }
        }
    }
    // Follow up: Using two loops: Check one element against all others and remove the duplicates in the process.

}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
