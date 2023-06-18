class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    public static void deleteNode(LinkedListNode<Integer> node) {
        LinkedListNode<Integer> nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
        nextNode.next = null; // Remove the reference to the next node
    }

    public static void printLinkedList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a sample linked list
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);
        head.next.next.next.next = new LinkedListNode<>(5);

        // Node to be deleted
        LinkedListNode<Integer> nodeToDelete = head.next.next;

        System.out.println("Original linked list:");
        printLinkedList(head);

        // Delete the node
        deleteNode(nodeToDelete);

        System.out.println("Updated linked list:");
        printLinkedList(head);
    }
}
