 class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

 class LinkedList {
    public static Node removeKthNode(Node head, int K) {
        Node fast = head;
        Node slow = head;

        // Move fast pointer K positions ahead
        for (int i = 0; i < K; i++) {
            fast = fast.next;
        }

        // If fast pointer becomes null, remove the head node
        if (fast == null) {
            return head.next;
        }

        // Move both pointers until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the Kth node
        slow.next = slow.next.next;

        return head;
    }

    public static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a sample linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int K = 2; // Kth node from end to be deleted

        System.out.println("Original linked list:");
        printLinkedList(head);

        // Remove Kth node from end
        head = removeKthNode(head, K);

        System.out.println("Updated linked list:");
        printLinkedList(head);
    }
}
