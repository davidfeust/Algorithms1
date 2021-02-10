package TestPractice;

import java.util.Arrays;

public class ArrayLCS {

    public static int lcsSize(int[] X, int[] Y) {
        int n = X.length, m = Y.length;
        int[][] lcs = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            lcs[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            lcs[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs[n][m];
    }

    public static int[] lcs(int[] X, int[] Y) {
        int n = X.length, m = Y.length;
        int[][] lcs = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            lcs[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            lcs[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        int index = lcs[n][m];
        int[] res = new int[index];
        int i = n, j = m;
        while (lcs[i][j] != 0) {
            if (X[i - 1] == Y[j - 1]) {
                res[--index] = X[i - 1];
                i--;
                j--;
            } else {
                if (lcs[i][j - 1] > lcs[i - 1][j]) j--;
                else i--;
            }
        }
        return res;
    }

    public static int lcs3Size(int[] X, int[] Y, int[] Z) {
        int n = X.length, m = Y.length, l = Z.length;
        int[][][] lcs = new int[n + 1][m + 1][l + 1];
        for (int i = 0; i < n + 1; i++) {
            lcs[i][0][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            lcs[0][j][0] = 0;
        }
        for (int k = 0; k < l + 1; k++) {
            lcs[0][0][1] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                for (int k = 1; k < l + 1; k++) {
                    if (X[i - 1] == Y[j - 1] && X[i - 1] == Z[k - 1]) {
                        lcs[i][j][k] = 1 + lcs[i - 1][j - 1][k - 1];
                    } else {
                        lcs[i][j][k] = Math.max(lcs[i - 1][j][k], Math.max(lcs[i][j - 1][k], lcs[i][j][k - 1]));
                    }
                }
            }
        }
        return lcs[n][m][l];
    }

/*
    public static int[] lcs3(int[] X, int[] Y, int[] Z) {
        int n = X.length, m = Y.length, l = Z.length;
        int[][][] lcs = new int[n + 1][m + 1][l + 1];
        for (int i = 0; i < n + 1; i++) {
            lcs[i][0][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            lcs[0][j][0] = 0;
        }
        for (int k = 0; k < l + 1; k++) {
            lcs[0][0][1] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                for (int k = 1; k < l + 1; k++) {
                    if (X[i - 1] == Y[j - 1] && X[i - 1] == Z[k - 1]) {
                        lcs[i][j][k] = 1 + lcs[i - 1][j - 1][k - 1];
                    } else {
                        lcs[i][j][k] = Math.max(lcs[i - 1][j][k], Math.max(lcs[i][j - 1][k], lcs[i][j][k - 1]));
                    }
                }
            }
        }
        int index = lcs[n][m][l];
        int[] res = new int[index];
        int i = n, j = m, k = l;
        while (lcs[i][j][k] != 0) {
            if (X[i - 1] == Y[j - 1] && X[i - 1] == Z[k - 1]) {
                res[--index] = X[i - 1];
                i--;
                j--;
                k--;
            } else {
                if (lcs[i - 1][j][k] > lcs[i][j - 1][k] || lcs[i - 1][j][k] > lcs[i][j][k - 1]) i--;
                if (lcs[i][j - 1][k] > lcs[i - 1][j][k] || lcs[i][j - 1][k] > lcs[i][j][k - 1]) j--;
                else k--;
            }
        }
        return res;
    }
*/

    public static void main(String[] args) {
        int[] x = {1, 3, 0, 8, 7, 6, 9, 12, 8};
        int[] y = {-4, 3, -15, 8, 13, 7, 92, 2, 6, 18};
        int[] z = {3, -4, -115, 8, 113, 7, 2, 0, 6, 921, 18, 11, -8, 19};
        System.out.println("lcsSize(x,y) = " + lcsSize(x, y));
        System.out.println("lcs(x,y) = " + Arrays.toString(lcs(x, y)));
        System.out.println("lcs3Size(x,y,z) = " + lcs3Size(x, y, z));
//        System.out.println("lcs3(x,y,z) = " + Arrays.toString(lcs3(x, y, z)));
    }
}
