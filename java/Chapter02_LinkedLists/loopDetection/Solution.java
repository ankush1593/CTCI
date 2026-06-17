package CTCI.java.Chapter02_LinkedLists.loopDetection;

public class Solution {
    public static void main(String[] args) {

        // Create nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create loop: 5 → 3
        Node loopStart = head.next.next; // node with value 3
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = loopStart;

        // Detect loop start
        Node result = findLoopStart(head);

        if (result != null) {
            System.out.println("Loop starts at node with value: " + result.data);
        } else {
            System.out.println("No loop detected");
        }
    }

    public static Node findLoopStart(Node head){
        if (head == null) return null;

        Node slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}