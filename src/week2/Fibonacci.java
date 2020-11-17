package week2;

import java.util.Arrays;
import java.util.Date;

public class Fibonacci {

    public static long recursion(long n) {
        if (n == 1 || n == 0)
            return 1;
        return recursion(n - 1) + recursion(n - 2);
    }

    public static long induction(int n) {
        long[] res = new long[n + 1];
        res[0] = res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    public static void main(String[] args) {
        final int num = 40;
        long start1 = new Date().getTime();
        System.out.println(induction(num));
        long end1 = new Date().getTime();
        System.out.println("Calculation time of the " + num + "rd Fibonacci number by induction is: " + (end1 - start1) / 1000.0);

        long start2 = new Date().getTime();
        System.out.println(recursion(num));
        long end2 = new Date().getTime();
        System.out.println("Calculation time of the " + num + "rd Fibonacci number by recursion is: " + (end2 - start2) / 1000.0);

    }
}
