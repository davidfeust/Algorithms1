package TestPractice;

public class PizzaProblem {

    public static int pizza(double x, int n) {
        int k = (int) x + 1;
        int p = n / (k + 1);
        int r = n % (k + 1);
        int ans = -1;
        if (r != 1) {
            double t = (x * p + r - 1) / ((x + 1) * p + r);
            if (t < x / (x + 1)) ans = 1;
            else ans = 0;
        }
        return ans;
    }

    public static int cutPizza(double x) {
        if (x == (int) x) return (int) x + 1;
        else return (int) x + 2;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * 6) + 1;
            int n = (int) (Math.random() * 15) + 1;
            System.out.println("pizza(" + x + ", " + n + ") = " + pizza(x, n));
        }
        System.out.println("\n***\n");
        for (double i = 0; i < 10; i += 0.3) {
            System.out.printf("cutPizza(%.1f) = %d\n", i, cutPizza(i));
        }
    }

}
