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
 }

 *****************************************************************/

class Solution {
    public static int findIntersection(Node firstHead, Node secondHead) {
        //Write your code here
        Node ptr1 = firstHead;
        Node ptr2 = secondHead;

        while (ptr1 != ptr2) {
            // Move ptr1 to the head of the second list if it reaches the end of the first list
            ptr1 = (ptr1 == null) ? secondHead : ptr1.next;
            // Move ptr2 to the head of the first list if it reaches the end of the second list
            ptr2 = (ptr2 == null) ? firstHead : ptr2.next;
        }

        if (ptr1 == null) {
            // Both pointers reached the end of their respective lists without finding an intersection
            return -1;
        } else {
            // ptr1 and ptr2 point to the same node (intersection point)
            return ptr1.data;
        }
    }
}