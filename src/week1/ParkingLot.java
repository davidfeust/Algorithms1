package week1;

public class ParkingLot {

    Car first, last;
    private boolean loop;

    public ParkingLot(boolean loop) {
//        this.last = this.first = null;
        this.loop = loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void add(Car c){
        if (loop) addLoop(c);
        else addNoLoop(c);
    }

    private void addNoLoop(Car c) {
        if (first == null) {
            first = last = c;
            last.next = last.prev = null;
        } else {
            Car p = first;
            while (p.next != null) {
                p = p.next;
            }
            p.next = c;
            last = c;
        }
    }

    private void addLoop(Car c) {
        if (first == null) {
            first = c;
            first.next = first;
            first.prev = first;
            last = first;
        } else {
            c.next = first;
            c.prev = last;
            first.prev = c;
            last.next = c;
            last = last.next;
        }
    }
    /*   public void display() {
        Car temp = first;

        System.out.print("\nTraversal in forward direction: \n");
        while (temp.next != first) {
            System.out.printf("%d -> ", temp.id);
//            System.out.print(temp.sign != null ? "S= " + temp.sign + " -> " : "-> ");
            temp = temp.next;
        }
        System.out.println();
//        System.out.printf("%d ", temp.id);


        System.out.print("\nTraversal in reverse direction: \n");
        Car last = first.prev;
        temp = last;
        while (temp.prev != last) {
            System.out.printf("%d ", temp.id);
            System.out.print(!temp.sign.equals("") ? "S= " + temp.sign + " -> " : "-> ");
            temp = temp.prev;
        }
        System.out.printf("%d \n\n", temp.id);

    }*/

    @Override
    public String toString() {
        String res = "";
        Car p = first;
        while (p != null && p.next != first && loop) {
            res += p.id + " -> ";
            p = p.next;
        }
        while (p != null && p.next != null && !loop) {
            res += p.id + " -> ";
            p = p.next;
        }
        res += p.id;
        return "ParkingLot{ " + res +", loop? " + loop + ", first= " + first + ", last= " + last + " }\n";
    }
}
