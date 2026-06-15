package CTCI.java.Chapter02_LinkedLists.partitionList;

public class Solution {
    public static void main(){
        Node head = new Node(3);
        appendToTail(5, head);
        appendToTail(8, head);
        appendToTail(5, head);
        appendToTail(10, head);
        appendToTail(2, head);
        appendToTail(1, head);
        printList(head);
        Node newHead = partitionList(head, 5);
        printList(newHead);
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

    public static Node partitionList(Node head, int partition){
        if (head == null){
            return null;
        }
        Node leftPointer = null, rightPointer = null, leftHead = null, rightHead = null;
        Node runner = head;
        while(runner != null){
            Node next = runner.next;
            runner.next = null;
            if(runner.data < partition){
                if (leftPointer == null){
                    leftHead = runner;
                }else{
                    leftPointer.next = runner;
                }
                leftPointer = runner;
            }else{
                if (rightPointer == null){
                    rightHead = runner;
                }else{
                    rightPointer.next = runner;
                }
                rightPointer = runner;
            }
            runner = next;
        }
        if (leftHead == null){
            return rightHead;
        }
        leftPointer.next = rightHead;
        return leftHead;
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