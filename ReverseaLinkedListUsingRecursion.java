public class ReverseaLinkedListUsingRecursion {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printList(head);

        head = reverseList(head);

        System.out.println("\nReversed Linked List:");
        printList(head);
    }

    public static Node reverseList(Node current) {
        if (current == null || current.next == null) {
            return current;
        }

        Node newHead = reverseList(current.next);
        current.next.next = current;
        current.next = null;

        return newHead;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    } 
    
}
