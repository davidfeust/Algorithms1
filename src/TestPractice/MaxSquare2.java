package TestPractice;

public class MaxSquare2 {

    public static int maxSquare(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] h = new int[n][m];
        for (int i = 1; i < n; i++) h[i][0] = mat[i][0];
        for (int i = 1; i < m; i++) h[0][i] = mat[0][i];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 1) {
                    h[i][j] = min(h[i - 1][j], h[i - 1][j - 1], h[i][j - 1]) + 1;
                    max = Math.max(max, h[i][j]);
                }
            }
        }
//        for (int[] i : h) System.out.println(Arrays.toString(i));
        return max;
    }

    public static int numOfMaxSquare(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] h = new int[n][m];
        for (int i = 1; i < n; i++) h[i][0] = mat[i][0];
        for (int i = 1; i < m; i++) h[0][i] = mat[0][i];
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 1) {
                    h[i][j] = min(h[i - 1][j], h[i - 1][j - 1], h[i][j - 1]) + 1;
                    if (h[i][j] > max) {
                        max = h[i][j];
                        count = 1;
                    } else if (h[i][j] == max) {
                        count++;
                    }
                }
            }
        }
//        for (int[] i : h) System.out.println(Arrays.toString(i));
        return count;
    }

    private static int min(int... a) {
        int min = Integer.MAX_VALUE;
        for (int i : a) min = Math.min(min, i);
        return min;
    }

    public static void main(String[] args) {
        int[][] m = {
                {0, 0, 1, 0, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 1, 0, 1},
        };
        System.out.println("maxSquare(m) = " + maxSquare(m));
        System.out.println("numOfMaxSquare(m) = " + numOfMaxSquare(m));
    }
}
