class Node {
  public int data;
  public Node next;

  Node() {
    this.data = 0;
    this.next = null;
  }

  Node(int data) {
    this.data = data;
    this.next = null;
  }

  Node(int data, Node next) {
    this.data = data;
    this.next = next;
  }
}

class Solution {

  public static boolean detectCycle(Node head) {

    if (head == null || head.next == null) {
      return false;
    }

    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }
    }

    return false;
  }
}