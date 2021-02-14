import java.util.Arrays;

public class TwoArray {

    public static int[][] gameNumber(int[] a) {
        int n = a.length;
        int[][] h = new int[n][n];
        for (int i = 0; i < n; i++) {
            h[i][i] = a[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                h[i][j] = Math.max(a[i] - h[i + 1][j], a[j] - h[i][j - 1]);
            }
        }
        return h;
    }

    public static int gameNumber(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[][][][] h = new int[n][n][m][m];
        int[][] gameA = gameNumber(a);
        int[][] gameB = gameNumber(b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                h[i][i][j][j] = Math.abs(a[i] - b[j]);
            }
        }

        for (int x = 1; x < m; x++) {
            for (int y = 0; y + x < m; y++) {
                int b2 = y + x;
                for (int i = 0; i < n; i++) {
                    int ans1 = a[i] - gameB[y][b2];
                    int ans2 = b[y] - h[i][i][y + 1][b2];
                    int ans3 = b[b2] - h[i][i][y][b2 - 1];
                    int ans = max(ans1, ans2, ans3);
                    h[i][i][y][b2] = ans;
                }
            }
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                int a2 = j + i;
                for (int y = 0; y < m; y++) {
                    int ans1 = b[y] - gameA[j][a2];
                    int ans2 = a[j] - h[j + 1][a2][y][y];
                    int ans3 = a[a2] - h[j][a2 - 1][y][y];
                    int ans = max(ans1, ans2, ans3);
                    h[j][a2][y][y] = ans;
                }
            }
        }

        for (int k = 1; k < m; k++) {
            for (int i = 1; i < n; i++) {
                for (int j = 0; j + i < n; j++) {
                    int a2 = i + j;
                    for (int x = 0; x + k < m; x++) {
                        int b2 = x + k;
                        int ans1 = a[j] - h[j + 1][a2][x][b2];
                        int ans2 = a[a2] - h[j][a2 - 1][x][b2];
                        int ans3 = b[x] - h[j][a2][x + 1][b2];
                        int ans4 = b[b2] - h[j][a2][x][b2 - 1];
                        int ans = max(ans1, ans2, ans3, ans4);
                        h[j][a2][x][b2] = ans;
                    }
                }
            }

        }

        print(h);


        return h[0][a.length - 1][0][b.length - 1];
    }

    private static int max(int... ints) {
        int ans = ints[0];
        for (int i : ints) {
            ans = Math.max(ans, i);
        }
        return ans;
    }


    private static void print(int[][][][] f) {
        System.out.println("************f[a1][a2][b1][b2]***************");
        for (int i = 0; i < f.length; i++) {
            System.out.println("f[" + i + "]");
            for (int j = 0; j < f[0].length; j++) {
                System.out.println("f[" + i + "][" + j + "]");
                for (int k = 0; k < f[0][0].length; k++) {
                    System.out.println(Arrays.toString(f[i][j][k]));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 2, 3};
        int[] b = {4, 5, 6, 6, 5, 4, 8};
        System.out.println("gameNumber(a, b) = " + gameNumber(a, b));
    }
}
