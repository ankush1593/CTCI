package CTCI.java.Chapter02_LinkedLists.deleteMiddleNode;

public class Solution {
    public static void main(){
        Node head = new Node(1);
        appendToTail(2, head);
        appendToTail(3, head);
        appendToTail(4, head);
        appendToTail(5, head);
        appendToTail(6, head);
        appendToTail(7, head);
        printList(head);
        deleteMiddleNode(head.next.next.next);// Delete 4
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
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void deleteMiddleNode(Node node){
        if (node == null || node.next == null){
            return;
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }
    
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
