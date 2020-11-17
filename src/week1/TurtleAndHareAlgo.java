package week1;

public class TurtleAndHareAlgo {

    ParkingLot pl;
    Car slow, fast;
    private Car meetingPoint;
//    boolean hasLoop;

    public void init(ParkingLot pl) {
        this.pl = pl;
        slow = fast = pl.first;
//        hasLoop = isHasLoop();
    }

    public void init() {
        slow = fast = pl.first;
    }

    public boolean isHasLoop() {
        while (true) {
            if (null == slow.next || null == fast.next)
                return false;
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null || slow == null)
                return false;
            if (fast == slow) {
                meetingPoint = fast;
                return true;
            }
        }
    }

    public Car getMeetingPoint() {
        this.init();
        if (isHasLoop())
            return this.meetingPoint;
        else return null;
    }

    public Car startPintCircle() {
        this.init();
        if (!isHasLoop())
            return null;
        slow = getMeetingPoint();
        fast = pl.first;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public int circleLen() {
        fast = startPintCircle();
        slow = fast.next;
        int counter = 0;
        while (slow != fast) {
            slow = slow.next;
            counter++;
        }
        return counter;
    }

/*
    public int armLength() {
        slow = pl.first;
        fast = startPintCircle();
        slow = slow.next;
        System.out.println(slow);
        System.out.println(fast);
        int counter = 0;
        while (slow != fast) {
            slow = slow.next;
            counter++;
        }
        return counter;
    }
*/
}
