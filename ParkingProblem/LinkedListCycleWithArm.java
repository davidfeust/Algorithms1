public class LinkedListCycleWithArm extends LinkedListCycle {

    Node first;

    public void addArm(int size) {
        if (firstC == null) return;
        Node head;
        Node p = head = new Node(100);
        for (int i = 1; i <= size; i++) {
            Node n = new Node(i + 100);
            n.prev = p;
            p.next = n;
            p = n;
        }
        p.next = firstC;
        first = head;
    }

    @Override
    public void print() {
        Node temp = first;
        boolean flag = true;

        System.out.print("\nTraversal in forward direction \n");
        while (flag || temp.next != firstC) {
            if (temp.next == firstC) flag = false;
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

    public static void main(String[] args) {
        LinkedListCycleWithArm lla = new LinkedListCycleWithArm();
        for (int i = 0; i < 10; i++) {
            lla.add(i);
        }
        lla.addArm(5);
        lla.print();
    }

}
