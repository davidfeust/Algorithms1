package week12;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.Callable;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Fibnacci {

    public static int recursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return recursion(n - 1) + recursion(n - 2);
    }

    public static int iteration(int n) {
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            int t = a + b;
            a = b;
            b = t;
        }
        return b;
    }

    static int[] arr;

    public static int recursion2iteration(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (arr[n - 1] != 0) {
            return arr[n - 1];
        }
        arr[n - 1] = recursion2iteration(n - 1) + recursion2iteration(n - 2);
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            int t = a + b;
            a = b;
            b = t;
        }
        return b;
    }

    /**
     * Compute matrix multiply of 2x2 matrices.
     *
     * @param A matrix A
     * @param B matrix B
     * @return AxB
     */
    private static int[][] matrixMul(int[][] A, int[][] B) {
        int x = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        int y = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        int z = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        int w = A[1][0] * B[0][1] + A[1][1] * B[1][1];

        return new int[][]{{x, y}, {z, w}};
    }

    public static int[][] matrixPow(int[][] b, int e) {
        return matrixPow(b, e, new int[][]{{1, 1}, {1, 1}});
    }


    // log(n)
    public static int[][] matrixPow(int[][] b, int e, int[][] ans) {
        if (e == 0) {
            return ans;
        }
        if (e % 2 == 1) {
            ans = matrixMul(ans, b);
        }
        e /= 2;
        b = matrixMul(b, b);
        return matrixPow(b, e, ans);
    }

    public static long time(Callable<Integer> m) {
        long s = System.currentTimeMillis();
        try {
            m.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long e = System.currentTimeMillis();
        return e - s;
    }

    @Test
    public void compareTimes() {
        long iteration_time = time(() -> iteration(100));
        System.out.println("iteration_time = " + iteration_time);
        Fibnacci.arr = new int[100];
        long recursion2iteration_time = time(() -> recursion2iteration(100));
        System.out.println("recursion2iteration_time = " + recursion2iteration_time);
        long recursion_time = time(() -> recursion(100));
        System.out.println("recursion_time = " + recursion_time);
    }

    @Test
    public void fibComp() {
        for (int i = 0; i < 10; i++) {
            int r = recursion(i);
            out.printf("recursion(%d) = %d\t", i, r);
            int it = iteration(i);
            out.printf("iteration(%d) = %d\t", i, it);
            arr = new int[i];
            int rit = recursion2iteration(i);
            out.printf("recursion2iteration(%d) = %d\n", i, rit);
            assertTrue(r == it && it == rit);
        }
    }

    @Test
    public void mul() {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        int[][] C = matrixMul(A, B);
        assertArrayEquals(C[0], new int[]{19, 22});
        assertArrayEquals(C[1], new int[]{43, 50});
    }

    @Test
    public void matrixPow() {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] C = matrixPow(A, 2);
        out.println(Arrays.deepToString(C));
        assertArrayEquals(C, new int[][]{{7, 10}, {15, 22}});

    }
}
