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
            if (ran.nextDouble() < 0.5)
                cars.firstC.sign = v;
        }
    }

    public int howManyCars() {
        LinkedListCycle.Node first = cars.firstC;
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

    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {
            ParkingProblem pp = new ParkingProblem();
            System.out.println("pp.howManyCars() = " + pp.howManyCars());
        }
    }

}
