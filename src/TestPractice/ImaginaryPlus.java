package TestPractice;

public class ImaginaryPlus {
    public static int longestOfOne(int[] arr) {
        int res = 0, max = 0;
        for (int j : arr) {
            if (j == 1) res++;
            else {
                max = Math.max(res, max);
                res = 0;
            }
        }
        return Math.max(res, max);
    }

    public static int imaginaryPlus(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] u = new int[n][m]; // up
        int[][] d = new int[n][m]; // down
        int[][] l = new int[n][m]; // left
        int[][] r = new int[n][m]; // right
        // base
        System.arraycopy(mat[0], 0, u[0], 0, m);
        System.arraycopy(mat[n - 1], 0, d[n - 1], 0, m);
        for (int i = 0; i < n; i++) l[i][0] = mat[i][0];
        for (int i = 0; i < n; i++) r[i][m - 1] = mat[i][m - 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    if (i != 0) u[i][j] = u[i - 1][j] + 1;
                    if (j != 0) l[i][j] = l[i][j - 1] + 1;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    if (i != n - 1) d[i][j] = d[i + 1][j] + 1;
                    if (j != m - 1) r[i][j] = r[i][j + 1] + 1;
                }
            }
        }
        // finds the maximum size of plus
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(u[i][j] + d[i][j] + l[i][j] + r[i][j], max);
            }
        }
        return max - 3;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("longestOfOne(arr) = " + longestOfOne(arr));
        int[][] mat = {
                {1, 0, 1, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 1, 0},
                {1, 1, 1, 1, 0, 0, 0, 1, 0},
        };
        System.out.println("TestPractice.imaginaryPlus(mat) = " + imaginaryPlus(mat));
    }
}
