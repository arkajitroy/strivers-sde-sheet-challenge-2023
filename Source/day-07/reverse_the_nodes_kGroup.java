import java.io.*;
import java.util.* ;





class Node
        {
        
	        int data;
	        Node next;
	        Node(int data)
	        {
		        this.data = data;
		        this.next = null;
	        }
        };



class Solution {
	public static int calc(Node head) {
        Node p = head;
        int len = 0;

        while (p != null) {
            len++;
            p = p.next;
        }

        return len;
    }

    public static Node reverse(Node head) {
        Node p = head;
        Node nxt, prev = null;

        while (p != null) {
            nxt = p.next;
            p.next = prev;

            prev = p;
            p = nxt;
        }

        return prev;
    }

    public static Node getListAfterReverseOperation(Node head, int n, int[] b) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node p = dummy, curr, nxt;

        int len = calc(head);
        for (int i = 0; i < n; i++) {
            if (len == 0)
                break;

            if (b[i] <= len) {
                curr = p.next;
                nxt = curr.next;

                if (b[i] == 0)
                    continue;

                for (int j = 0; j < b[i] - 1; j++) {
                    curr.next = nxt.next;
                    nxt.next = p.next;

                    p.next = nxt;
                    nxt = curr.next;
                }

                len -= b[i];
                p = curr;
            } else if (len <= b[i]) {
                p.next = reverse(p.next);
                len = 0;
            }
        }

        return dummy.next;
    }
}