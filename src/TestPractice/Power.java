package TestPractice;

public class Power {
    public static double power(double x, int n) {
        double ans = 1;
        while (n > 0) {
            if (n % 2 == 1) ans *= x;
            x *= x;
            n /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("power(25,2) = " + power(5, 2));
    }
}
