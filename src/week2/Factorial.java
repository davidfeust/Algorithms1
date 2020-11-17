package week2;

import java.util.Date;

public class Factorial {

    public static long recursion(long n) {
        if (n == 1)
            return 1;
        return n * recursion(n - 1);
    }
    public static long induction(long n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }


    public static void main(String[] args) {
        final int num = 15;
        long start1 = new Date().getTime();
        System.out.println(induction(num));
        long end1 = new Date().getTime();
        System.out.println("Calculation time of " + num + "! by induction is: " + (end1 - start1) / 1000.0);

        long start2 = new Date().getTime();
        System.out.println(recursion(num));
        long end2 = new Date().getTime();
        System.out.println("Calculation time of " + num + "! by induction is: " + (end2 - start2) / 1000.0);
    }
}
