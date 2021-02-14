package TestPractice;

import java.util.Arrays;

public class FibPow {

    public static int power(double x, int n) {
        int ans = 1;
        while (n > 0) {
            if (n % 2 == 1) ans *= x;
            x *= x;
            n /= 2;
        }
        return ans;
    }

    public static int[][] power(int[][] x, int n) {
        int[][] ans = {{1, 0}, {0, 1}};
        while (n > 0) {
            if (n % 2 == 1) ans = matMul2x2(ans, x);
            x = matMul2x2(x, x);
            n /= 2;
        }
        return ans;
    }

    public static int fib(int n) {
        int[][] a = {{1, 1}, {1, 0}};
        return power(a, n)[0][1];
    }

    private static int[][] matMul2x2(int[][] A, int[][] B) {
        int x = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        int y = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        int z = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        int w = A[1][0] * B[0][1] + A[1][1] * B[1][1];
        return new int[][]{{x, y}, {z, w}};
    }

    public static void main(String[] args) {
        System.out.println("power(6,2) = " + power(6, 2));
        int[][] x = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(power(x, 4)));
        for (int i = 1; i < 10; i++) {
            System.out.println(fib(i));
        }
    }
}
