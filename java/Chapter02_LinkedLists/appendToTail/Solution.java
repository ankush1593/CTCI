package CTCI.java.Chapter02_LinkedLists.appendToTail;

public class Solution {
    public static void main(String[] args){
        Node head = new Node(1);
        appendToTail(2, head);
        appendToTail(3, head);
        printList(head);
    }

    public static void appendToTail(int val, Node head){
        Node end = new Node(val);
        Node temp = head;
        while (temp.next != null){
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
}


class Node{
    Node next;
    int data;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}