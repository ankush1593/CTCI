package CTCI.java.Chapter02_LinkedLists.sumLists;

public class Solution {
    public static void main(){
        Node head1 = new Node(7);
        appendToTail(1, head1);
        appendToTail(6, head1);
        Node head2 = new Node(5);
        appendToTail(9, head2);
        appendToTail(2, head2);
        Node head3 = sumList(head1, head2);
        printList(head3);
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

    public static Node sumListRaw(Node head1, Node head2){
        Node head3 = null, p1 = head1, p2 = head2, curr = null;
        int carry = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.data + p2.data + carry;
            int num;
            if (sum >= 10){
                num = sum%10;
                carry = 1;
            }else{
                num = sum;
                carry = 0;
            }
            Node node = new Node(num);
            if (curr == null){
                head3 = node;
                curr = node;
            }else{
                curr.next = node;
                curr = node;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // Check if p1 or p2 still has data, if so append the elements in the final output.
        // 5-1-2-3 = 3215
        // 9-8-2   =  289
        //           3504 = 4-0-5-3
        while(p1 != null){
            int sum = p1.data + carry;
            int num;
            if (sum >= 10){
                num = sum%10;
                carry = 1;
            }else{
                num = sum;
                carry = 0;
            }
            Node node = new Node(num);
            if (curr == null){
                head3 = node;
                curr = node;
            }else{
                curr.next = node;
                curr = node;
            }
            p1 = p1.next;
        }
        while(p2 != null){
            int sum = p2.data + carry;
            int num;
            if (sum >= 10){
                num = sum%10;
                carry = 1;
            }else{
                num = sum;
                carry = 0;
            }
            Node node = new Node(num);
            if (curr == null){
                head3 = node;
                curr = node;
            }else{
                curr.next = node;
                curr = node;
            }
            p2 = p2.next;
        }
        if (carry > 0){
            curr.next = new Node(carry);
        }
        return head3;
    }

    public static Node sumList(Node head1, Node head2){
        Node head3 = null, curr = null;
        Node p1 = head1, p2 = head2;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int sum = carry;

            if (p1 != null){
                sum += p1.data;
                p1 = p1.next;
            }

            if (p2 != null){
                sum += p2.data;
                p2 = p2.next;
            }
            
            int num = sum % 10;
            carry = sum / 10;
            
            Node node = new Node(num);
            
            if (curr == null){
                head3 = node;
                curr = node;
            }else{
                curr.next = node;
                curr = node;
            }
        }
        if (carry > 0){
            curr.next = new Node(carry);
        }
        return head3;
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