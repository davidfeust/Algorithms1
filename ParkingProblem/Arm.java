import java.util.Random;

public class Arm {

    LinkedListCycleWithArm cars;
    final char v = 'v', w = 'w';

    public Arm() {
        cars = new LinkedListCycleWithArm();
        Random ran = new Random();
        int size = ran.nextInt(30) + 1;
        int arm_size = ran.nextInt(size) + 1;
        System.out.print("Size = " + size + "\t");
        for (int i = 1; i <= size; i++) {
            cars.add(i);
        }
        cars.addArm(arm_size);
    }

    public int howManyCars() {
        LinkedListCycle.Node fast = cars.first;
        LinkedListCycle.Node slow = cars.first;
        int counter = 0;
        while (fast != null && fast.next != null && slow != null) {
            counter++;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return counter;
        }
        return counter;
    }

    public static void main(String[] args) {
        Arm a;
        for (int i = 0; i < 15; ++i) {
            a = new Arm();
            System.out.println("a.howManyCars() = " + a.howManyCars());
        }
    }
}
