package CTCI.java.Chapter02_LinkedLists.kthToLast;

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
        System.out.println(kthToLast(head, 3));
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

    public static int kthToLast(Node head, int k){
        if (head == null || k <= 0){
            return -1;
        }
        Node first =head, second = head;
        int count = 1;
        while(second != null){
            if (count > k){
                first = first.next;
            }
            count++;
            second = second.next;
        }
        return first.data;
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