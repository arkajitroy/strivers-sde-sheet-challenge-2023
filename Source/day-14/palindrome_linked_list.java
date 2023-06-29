	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

class PalindromeLinkedList {
    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) {
            // Empty or single-node linked list is a palindrome
            return true;
        }

        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> prev = null;

        // Move fast pointer twice as fast as slow pointer
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            // Reverse the first half of the linked list
            LinkedListNode<Integer> temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // Handle odd-length palindromes
        if (fast != null) {
            slow = slow.next;
        }

        // Compare the reversed first half with the second half
        while (prev != null && slow != null) {
            if (!prev.data.equals(slow.data)) {
                return false; // Not a palindrome
            }

            prev = prev.next;
            slow = slow.next;
        }

        return true; // Palindrome
    }

    public static void main(String[] args) {
        // Example usage
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(2);
        head.next.next.next.next = new LinkedListNode<>(1);

        boolean isPal = isPalindrome(head);
        System.out.println("Is Palindrome: " + isPal);
    }
}
