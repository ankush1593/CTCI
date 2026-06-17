package CTCI.java.Chapter02_LinkedLists.findIntersection;

public class Solution {

    public static void main(){
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        head1.next.next.next = node4;
        head1.next.next.next.next = node5;
        Node head2 = new Node(9);
        head2.next = new Node(10);
        head2.next.next = node4;
        head2.next.next.next = node5;
        System.out.println(findIntersection(head1, head2));
    }

    public static int findIntersection(Node head1, Node head2){
        if (head1 == null || head2 == null) {
            return -1;
        }
        Node tail1 = head1, tail2 = head2;
        int l1 = 1, l2 = 1, intersectionData = -1;
        while(tail1.next != null){
            tail1 = tail1.next;
            l1++;
        }

        while(tail2.next != null){
            tail2 = tail2.next;
            l2++;
        }

        if (tail1 != tail2){
            return -1;
        }

        Node curr1 = head1, curr2 = head2;

        int diff = Math.abs(l2-l1);
        for(int i=0; i<diff; i++){
            if(l2 > l1){
                curr2 = curr2.next;
            }else if(l1 > l2){
                curr1 = curr1.next;
            }
        }
        while (curr1 != null) {
            if (curr1 == curr2){
                intersectionData = curr1.data;
                break;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        return intersectionData;
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