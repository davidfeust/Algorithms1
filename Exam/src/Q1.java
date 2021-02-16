

public class Q1 {

    public static int lis(int[] X) {
        int n = X.length;
        int[] h = new int[n];
        h[0] = X[0];
        int counter = 1;
        for (int i = 1; i < n; i++) {
            int j = binarySearch(h, 0, counter, X[i]);
            if (j < 0) {
                j = -j - 1;
            }
            if (j == counter) {
                counter++;
            }
            h[j] = X[i];
        }
        return counter;
    }

    public static int[] lcs(int[] X, int[] Y) {
        int n = X.length, m = Y.length;
        int[][] h = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            h[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            h[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    h[i][j] = h[i - 1][j - 1] + 1;
                } else {
                    h[i][j] = Math.max(h[i - 1][j], h[i][j - 1]);
                }
            }
        }
        int index = h[n][m];
        int[] ans = new int[index];
        int i = n, j = m;
        while (h[i][j] != 0) {
            if (X[i - 1] == Y[j - 1]) {
                ans[--index] = X[i - 1];
                i--;
                j--;
            } else {
                if (h[i][j - 1] > h[i - 1][j]) j--;
                else i--;
            }
        }
        return ans;
    }

    public static int lcsIncrease(int[] X, int[] Y) {
        int n = X.length, m = Y.length;
        return lis(lcs(X, Y));
    }

    private static int binarySearch(int[] a, int start, int end, int key) {
        int low = start;
        int high = end - 1;
        while (low <= high) {
            int mid = (low + high);
            if (a[mid] < key) low = mid + 1;
            else if (a[mid] > key) high = mid - 1;
            else return mid;
        }
        return (low + 1) * -1;
    }
}
