class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public static LinkedListNode<Integer> mergeTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        LinkedListNode<Integer> dummy = new LinkedListNode<>(0);
        LinkedListNode<Integer> current = dummy;

        while (first != null && second != null) {
            if (first.data <= second.data) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        // Append remaining nodes from the non-empty list
        if (first != null) {
            current.next = first;
        } else {
            current.next = second;
        }

        return dummy.next;
    }

    public static void printLinkedList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create two sorted linked lists
        LinkedListNode<Integer> head1 = new LinkedListNode<>(1);
        head1.next = new LinkedListNode<>(3);
        head1.next.next = new LinkedListNode<>(5);

        LinkedListNode<Integer> head2 = new LinkedListNode<>(2);
        head2.next = new LinkedListNode<>(4);
        head2.next.next = new LinkedListNode<>(6);

        System.out.println("Linked list 1:");
        printLinkedList(head1);
        System.out.println("Linked list 2:");
        printLinkedList(head2);

        // Merge the two sorted linked lists
        LinkedListNode<Integer> merged = mergeTwoLists(head1, head2);

        System.out.println("Merged list:");
        printLinkedList(merged);
    }
}
