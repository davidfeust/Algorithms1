package TestPractice;

import java.util.Arrays;

public class GlassBalls {
    public static int triangular(int n) {
        int t = n + (n * n);
        return t / 2;
    }

    public static int twoBalls(int[] build, int ball) {
        int n = build.length;
        int jump = 1;
        int i;
        while (n > triangular(jump)) {
            jump++;
        }
        for (i = jump; i <= n; i += jump) { // slice by triangle number jumps
            if (i < n && build[i] >= ball) {
                System.out.println("1 BROKEN");
                int start = i - jump;
                for (i = start; i <= start + jump && i < n; ++i) { // check this slice one by one
                    if (build[i] >= ball) {
                        System.out.println("2 BROKEN");
                        return i;
                    }
                }
            }
            --jump;
        }
        return i;
    }

    public static int kBalls(int n, int k) {
        int[][] mat = new int[k + 1][n + 1];
        for (int i = 0; i < k; i++) mat[i][1] = 1;
        for (int i = 0; i < n; i++) mat[1][i] = i;
        for (int i = 2; i < k; i++) {
            for (int j = 2; j < n; j++) {
                int min = n+1;
                for (int l = 1; l < j; l++) {
                    min = Math.min(min, Math.max(mat[i - 1][l - 1], mat[i][j - l]));
                }
                mat[i][j] = 1 + min;
            }
            System.out.println(Arrays.toString(mat[i]));
        }
        return mat[k][n];
    }

    public static void dynamicEgg(int k, int n) { // k = num of eggs   n = num pf floor
        int[][] help = new int[k + 1][n + 1];
        for (int i = 0; i < help.length; i++) {
            help[i][0] = 0;
            help[i][1] = 1;

        }
        for (int i = 0; i < help[0].length; i++) {
            help[0][i] = 0;
            help[1][i] = i;
        }
        for (int i = 2; i < help.length; i++) {

            for (int j = 2; j < help[i].length; j++) {
                int min = n + 1;
                for (int l = 1; l < j; l++) {
                    min = Math.min(Math.max(help[i - 1][l - 1], help[i][j - l]), min);
                }
                help[i][j] = min + 1;

            }
            System.out.println(Arrays.toString(help[i]));
        }
    }

    /*private static int min(int n, int k, int[][] mat) {
        int min = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, Math.max(mat[n - i][k], mat[n - 1][k - 1]));
        }
        return 0;
    }*/

    public static void main(String[] args) {
        int[] a = new int[100];
        Arrays.fill(a, 99, 100, 2);
//        System.out.println("twoBalls(a, 1) = " + twoBalls(a, 1));
//        kBalls(10, 5);
        dynamicEgg(5,10);
    }
}
