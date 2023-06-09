/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 };

 *****************************************************************/

class Solution {
    static int lengthOfLL(Node head) {

        if (head == null)

            return 0;

        Node curr = head;

        int h = 0;

        while (curr != null) {

            h++;

            curr = curr.next;

        }

        return h;

    }

    public static Node rotate(Node head, int k) {

        // Write your code here.

        if (head == null || head.next == null || k == 0)

            return head;

        int length = lengthOfLL(head);

        if (k >= length) {

            k = k % length;

        }

        if (k == 0)

            return head;

        head = reverse(head);

        Node temp1 = head;

        int i = 0;

        while (temp1 != null && i < k - 1) {

            i++;

            temp1 = temp1.next;

        }

        Node temp2 = null;

        if (temp1 != null) {

            temp2 = temp1.next;

            temp1.next = null;

        }

        head = reverse(head);

        temp2 = reverse(temp2);

        Node temp = head;

        while (temp.next != null) {

            temp = temp.next;

        }

        temp.next = temp2;

        return head;

    }

    static Node reverse(Node head) {

        Node prev = null, next = null;

        Node curr = head;

        while (curr != null) {

            next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;

        }

        head = prev;

        return head;

    }
}