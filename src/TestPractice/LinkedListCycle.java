package TestPractice;

import java.util.Random;

class ParkingProblem {
    LinkedListCycle cars;
    final char v = 'v', w = 'w';

    public ParkingProblem() {
        cars = new LinkedListCycle();
        Random ran = new Random();
        int size = ran.nextInt(30) + 1;
        System.out.print("Size = " + size + "\t");
        for (int i = 1; i <= size; i++) {
            cars.add(i);
        }
    }

    public int howManyCars() {
        LinkedListCycle.Node first = cars.first;
        first.sign = v;
        LinkedListCycle.Node p = first.next;
        int count = 1;
        while (true) {
            if (p.sign == v) {
                p.sign = w;
                for (int i = 0; i < count; i++) {
                    p = p.prev;
                }
                if (p.sign == v) {
                    for (int i = 0; i < count; i++) {
                        p = p.next;
                    }
                } else if (p.sign == w) {
                    return count;
                }
            }
            p = p.next;
            count++;
        }
    }
}

public class LinkedListCycle {
    class Node {
        int data;
        char sign;
        Node next, prev;

        public Node(int i) {
            this.data = i;
        }
    }

    Node first;

    public void add(int i) {
        if (first == null) {
            Node n = new Node(i);
            n.next = n;
            n.prev = n;
            first = n;
            return;
        }
        Node last = first.prev;
        Node n = new Node(i);
        n.next = first;
        first.prev = n;
        n.prev = last;
        last.next = n;
    }

    public void display() {
        Node temp = first;

        System.out.print("\nTraversal in forward direction \n");
        while (temp.next != first) {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.printf("%d ", temp.data);

        System.out.print("\nTraversal in reverse direction \n");
        Node last = first.prev;
        temp = last;
        while (temp.prev != last) {
            System.out.printf("%d ", temp.data);
            temp = temp.prev;
        }
        System.out.printf("%d ", temp.data);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {
            ParkingProblem pp = new ParkingProblem();
            System.out.println("pp.howManyCars() = " + pp.howManyCars());

        }
//        pp.cars.display();
    }
}