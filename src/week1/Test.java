package week1;

public class Test {

    static final int MAXRAN = 100;
    static int numOfCars = (int) (Math.random() * MAXRAN) + 1;

    public static void main(String[] args) {
        System.out.println("num of cars is: " + numOfCars);
        test1();
        test2();
        test3();
    }


    public static void test1() {
        ParkingLot pl = new ParkingLot(true);
        for (int i = 0; i < numOfCars; i++) {
            Car c = new Car();
            pl.add(c);
        }
        ParkingAlgo pa = new ParkingAlgo();
        pa.init(pl);
        System.out.println("num of cars is by the algo: " + pa.algo());
        int ran = (int) (Math.random() * 100);
        for (int i = 0; i < ran; i++) {
            Car c = new Car();
            pl.add(c);
        }
        pa.init(pl);
        System.out.println("num of cars is by the algo after change : " + pa.algo() +
                "\nsuppuse to be: " + (numOfCars + ran));
    }

    public static void test2() {
        ParkingLot pl = new ParkingLot(true);
        for (int i = 0; i < 10; i++) {
            Car c = new Car();
            pl.add(c);
        }
        TurtleAndHareAlgo th = new TurtleAndHareAlgo();
        th.init(pl);
//        pl.display();
        System.out.println("has loop? " + th.isHasLoop() + ". should be true");
        System.out.println("meeting point is: " + th.getMeetingPoint());
        pl = new ParkingLot(false);
        for (int i = 0; i < 10; i++) {
            Car c = new Car();
            pl.add(c);
        }
        th.init(pl);
        System.out.println("has loop? " + th.isHasLoop() + ". should be false");
        System.out.println("meeting point is: " + th.getMeetingPoint() + ". should be null");
    }

    public static void test3() {
        ParkingLot circle = new ParkingLot(true);
        ParkingLot line = new ParkingLot(false);
        Car startCircleCar = new Car();
        circle.add(startCircleCar);
        int circleLen = 6, armLen = 4;
        for (int i = 0; i < circleLen; i++) {
            Car c = new Car();
            circle.add(c);
        }
        Car p = null;
        for (int i = 0; i <= armLen; i++) {
            Car c = new Car();
            line.add(c);
            p = c;
        }
        p.next = circle.first;
        line.last = circle.first;
        ParkingLot pl = line;
        pl.first = line.first;
        System.out.println(pl.first +" "+pl.last);
        pl.setLoop(true);

        TurtleAndHareAlgo th = new TurtleAndHareAlgo();
        th.init(pl);
        System.out.println("the start of the circle is: " + th.startPintCircle() + ". should be: " + startCircleCar);
        System.out.println("circle length: " + th.circleLen()+ ". should be: " + circleLen);
//        pl.first = line.first;
//        do not work:
//        System.out.println("arm length: " + th.armLength() + ". should be: " + armLen);
    }

}
