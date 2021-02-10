package TestPractice;

import java.util.Arrays;

public class Rectangles {

    public static int numRectangles(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] help = new int[n][m];
        int counter = help[0][0] = mat[0][0];
        for (int i = 1; i < n; i++) {
            if (mat[0][i] == 1) {
                if (mat[0][i - 1] != 0) {
                    help[0][i] = mat[0][i - 1];
                } else {
                    help[0][i] = ++counter;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (mat[i][0] == 1) {
                if (mat[i - 1][0] != 0) {
                    help[i][0] = mat[i - 1][0];
                } else {
                    help[i][0] = ++counter;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 1) {
                    if (mat[i - 1][j] != 0 || mat[i][j - 1] != 0) {
                        help[i][j] = Math.max(help[i - 1][j], help[i][j - 1]);
                    } else {
                        help[i][j] = ++counter;
                    }
                }
            }
        }
        for (int[] i : help) System.out.println(Arrays.toString(i));
        return counter;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 0, 1, 1},
        };
        System.out.println("numRectangles(mat) = " + numRectangles(mat));
    }

}
