package TestPractice;

public class Fib {

    public static int fib(int n) {
        if (n == 1 || n == 2) return 1;
        n -= 2;
        int[][] mat = {
                {1, 1},
                {1, 0}
        };
        int[][] res = {
                {1, 1},
                {1, 0}
        };
        while (n != 0) {
            if (n % 2 != 0) {
                res = matrixMul(res, mat);
            }
            mat = matrixMul(mat, mat);
            n /= 2;
        }
        return res[0][0];
    }

    private static int[][] matrixMul(int[][] A, int[][] B) {
        int x = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        int y = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        int z = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        int w = A[1][0] * B[0][1] + A[1][1] * B[1][1];

        return new int[][]{{x, y}, {z, w}};
    }

    public static int steps(int n) {
        int[] h = new int[n + 1];
        h[0] = 0;
        h[1] = 1;
        h[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            h[i] = h[i - 1] + h[i - 2];
        }
//        System.out.println(Arrays.toString(h));
        return h[n];
    }


    public static void main(String[] args) {
        for (int i = 1; i < 47; i++) {
//            System.out.printf("fib(%d) = %d\n", i, fib(i));
        }
        for (int i = 2; i < 46; i++) {
            System.out.println("steps(" + i + ") = " + steps(i));
        }
    }


}
