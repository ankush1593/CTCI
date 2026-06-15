package CTCI.java.Chapter02_LinkedLists.deleteElement;

public class Solution {
    public static void main(String[] args){
        Node head = new Node(1);
        appendToTail(2, head);
        appendToTail(3, head);
        printList(head);
        head = deleteElement(head, 2);
        System.out.println("............");
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

    public static Node deleteElement(Node head, int d){
        Node temp = head;
        if (temp.data == d){
            return temp.next;
        }
        while (temp.next != null) {
            if (temp.next.data == d){
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        return head;
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