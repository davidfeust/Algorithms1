package week1;

public class ParkingAlgo {

    ParkingLot pl;
    Car currentCar;
    int count, steps;
    boolean flag;
    String olsSign, newSign;

    public void init(ParkingLot pl) {
        this.pl = pl;
        currentCar = pl.first.next;
        flag = true;
        count = 1;
        olsSign = "V";
        newSign = "W";
        steps = 0;
    }

    public int algo() {
        pl.first.sign = olsSign;
        while (flag) {
            if (!currentCar.sign.equals(olsSign)) {
                currentCar = currentCar.next;
                count++;
            } else {
                currentCar.sign = newSign;
                steps = count;
                while (steps > 0) {
                    currentCar = currentCar.prev;
                    steps--;
                }
                if (currentCar.sign.equals(newSign))
                    return count;
                else {
                    count = 1;
                    currentCar = pl.first.next;
                }
            }
        }
        return -1;
    }

}
