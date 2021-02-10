package week13;

import java.util.Arrays;

public class MaxSubMatrix {

    static boolean isOnesMat(int[][] arr, int x1, int x2, int y1, int y2) {
        if (x2 > arr.length || y2 > arr[0].length) {
            return false;
        }
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int greedy(int[][] arr) {
        int m = Math.max(arr.length, arr[0].length);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    res = 0;
                    for (int k = 1; k <= m; k++) {
                        if (isOnesMat(arr, i, i + k, j, j + k)) {
                            res = Math.max(res, k);
                        } else {
                            return res;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static int improvedGreedy(int[][] arr) {
        int m = Math.max(arr.length, arr[0].length);
        int res = 0;
        int max_res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    res = 0;
                    for (int k = 1; k <= m; k++) {
                        if (isOnesMat(arr, i, i + k, j, j + k)) {
                            res = Math.max(res, k);
                        } else {
                            max_res = Math.max(max_res, res);
                            break;
                        }
                    }
                    max_res = Math.max(max_res, res);
                }
            }
        }
        return max_res;
    }

    public static int exhaustiveSearch(int[][] mat) {
        int n = mat.length, max_dim = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    int k = 1, p = i + k, q = j + k;
                    while (p < n && q < n) {
                        if (isOnesMat(mat, i, p, j, q)) {
                            if (k + 1 > max_dim) {
                                max_dim = k + 1;
                            }
                        }
                        k++;
                        p = i + k;
                        q = j + k;
                    }
                }
            }
        }
        return max_dim;
    }

}
