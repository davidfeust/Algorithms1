package week12;

public class Power {

    public static double recursive(double b, double e, double ans) {
        if (e == 0) {
            return ans;
        }
        return recursive(b, e - 1, ans * b);
    }

    public static double iteration(double b, double e) {
        double ans = 1;
        for (int i = 0; i < e; i++) {
            ans *= b;
        }
        return ans;
    }

    // log(n)
    public static double pow(double b, double e, double ans) {
        if (e == 0) {
            return ans;
        }
        if (e % 2 == 1) {
            ans *= b;
        }
        e /= 2;
        b *= b;
        return pow(b, e, ans);
    }


    public static void main(String[] args) {
        System.out.println("recursive(5,2,1) = " + recursive(5, 2, 1));
        System.out.println("iteration(5,2) = " + iteration(5, 2));
        System.out.println("pow(5,2,1) = " + pow(5, 2, 1));
    }
}
