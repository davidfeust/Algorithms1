import java.util.Arrays;

public class Continuous {

    public static int lcs(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[][] h = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (a[i - 1] == b[j - 1]) {
                    h[i][j] = 1 + h[i - 1][j - 1];
                } else {
                    h[i][j] = Math.max(h[i][j - 1], h[i - 1][j]);
                }
            }
        }
        for (int[] i : h) System.out.println(Arrays.toString(i));
        return h[n][m];
    }

    public static int continuousLcs(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int j = 0; j < m; j++) {
                if (a[i] == b[j]) {
                    k++;
                    if (k > 0 && i > 0 && a[i - 1] < a[i]) {
                        k++;
                        max = Math.max(max, k);
                        System.out.println(i + " " + j + " " + k);
                    } else {
                        k = 1;
                    }
                } else k = 1;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] x = {1, 2, 3, 2, 4, 1, 2};
        int[] y = {2, 4, 3, 1, 2, 1};
//        System.out.println("lcs(x,y) = " + lcs(x, y));
        int[] a = {1, 2, 3, 2, 4, 1, 2, 6};
        int[] b = {2, 2, 3, 2, 4, 1};
        System.out.println("continuousLcs(a,b) = " + continuousLcs(a, b));
    }
}
