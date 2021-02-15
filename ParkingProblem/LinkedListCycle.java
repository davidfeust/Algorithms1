public class LinkedListCycle {
    class Node {
        int data;
        char sign;
        Node next, prev;

        public Node(int i) {
            this.data = i;
        }
    }

    Node firstC;

    public void add(int i) {
        if (firstC == null) {
            Node n = new Node(i);
            n.next = n;
            n.prev = n;
            firstC = n;
            return;
        }
        Node last = firstC.prev;
        Node n = new Node(i);
        n.next = firstC;
        firstC.prev = n;
        n.prev = last;
        last.next = n;
    }

    public void print() {
        Node temp = firstC;

        System.out.print("\nTraversal in forward direction \n");
        while (temp.next != firstC) {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.printf("%d ", temp.data);

        System.out.print("\nTraversal in reverse direction \n");
        Node last = firstC.prev;
        temp = last;
        while (temp.prev != last) {
            System.out.printf("%d ", temp.data);
            temp = temp.prev;
        }
        System.out.printf("%d ", temp.data);
    }
}