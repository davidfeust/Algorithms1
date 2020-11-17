package week1;

public class Car {
    static int count = 0;
    Car next, prev;
    String sign;
    int id;

    public Car() {
        id = count++;
        sign = "";
    }

    @Override
    public String toString() {
        return "{" + id + "}";
    }
}
