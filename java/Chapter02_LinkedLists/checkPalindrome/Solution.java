package CTCI.java.Chapter02_LinkedLists.checkPalindrome;

public class Solution {
    public static void main(){
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(2);
        head1.next.next.next.next = new Node(1);
        System.out.println(isPalindrome(head1));
    }

    public static boolean isPalindrome(Node head){
        Node mid = null, slow = head, fast = head;

        while(slow != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        mid = slow;

        Node rHead = reverseList(mid);
        Node p1 = head, p2 = rHead;

        boolean isPalindrome = true;
        while (p2 != null){
            if (p1.data != p2.data){
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        reverseList(rHead);

        return isPalindrome;
    }

    public static Node reverseList(Node head){
        Node curr = head, prev = null;

        while (curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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