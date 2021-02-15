public class MaxSquare {

    public static int maxSquare(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] help = new int[n][m];
        for (int i = 0; i < m; i++) help[0][i] = mat[0][i];
        for (int i = 0; i < n; i++) help[i][0] = mat[i][0];

        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 1) {
                    help[i][j] = Math.min(Math.min(help[i][j - 1], help[i - 1][j]), help[i - 1][j - 1]) + 1;
                }
                max = Math.max(max, help[i][j]);
            }
//            System.out.println(Arrays.toString(help[i]));
        }
        return max;
    }

    public static int maxSquare2x2(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] help = new int[n][m];
        for (int i = 0; i < m; i++) help[0][i] = mat[0][i];
        for (int i = 0; i < n; i++) help[i][0] = mat[i][0];

        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 1) {
                    help[i][j] = Math.min(Math.min(help[i][j - 1], help[i - 1][j]), help[i - 1][j - 1]) + 1;
                }
                if (help[i][j] >= 2) res++;
            }
//            System.out.println(Arrays.toString(help[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 1, 0, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1},
        };
        System.out.println("maxSquare(mat) = " + maxSquare(mat));
        System.out.println("maxSquare2x2(mat) = " + maxSquare2x2(mat));
    }
}
