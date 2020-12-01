package week6;

public class Pizza {

    public static boolean eat(int n) {
//        double p = 1.0;
        int[] p = new int[n];
//        final double slices = p / n;
//        int clock = 0;
        double slow = 0, fast = 0;
        int i = p.length - 1;
        while (p[0] == 0) {
        }
        return fast >= slow;
    }

    public static void main(String[] args) {
//        for (int i = 2; i < 100; i++) {
//            System.out.println(i + ": " + eat(i));
//        }
        System.out.println(eat(3));

    }
}
