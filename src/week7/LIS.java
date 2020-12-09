package week7;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS {

    public static int[] greedy(int[] arr) {
        int curr = arr[0];
        int[] res = new int[arr.length];
        res[0] = arr[0];
        int j = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= curr) {
                res[j++] = arr[i];
                curr = arr[i];
            } else {
                return Arrays.copyOf(res, j);
            }
        }
        return Arrays.copyOf(res, j);
    }

    public static int[] improvedGreedy(int[] arr) {
        int curr = arr[0];
        int[] res = new int[arr.length];
        res[0] = arr[0];
        int j = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= curr) {
                res[j++] = arr[i];
                curr = arr[i];
            }
        }
        return Arrays.copyOf(res, j);
    }

    /**
     * add 1 to binary number
     * the number are represent in array that every cell contains 1 or 0
     *
     * @param bin
     */
    public static void plus1(int[] bin) {
        int i = bin.length - 1;
        while (i >= 0 && bin[i] == 1) {
            bin[i--] = 0;
        }
        if (i >= 0) bin[i] = 1;
    }

    /**
     * return all the sub string of the giving string s
     *
     * @param
     * @return
     */
    public static ArrayList<int[]> allCombinations(int[] arr) {
        int n = arr.length;
        int count = (int) (Math.pow(2, n) - 1);
        ArrayList<int[]> res = new ArrayList<>();
        int[] bin = new int[n];

        for (int i = 0; i < count; i++) {
            plus1(bin);
            int[] tmp = new int[n];
            int end = 0;
            for (int j = 0; j < n; j++) {
                if (bin[j] == 1) {
                    tmp[end++] = arr[j];
                }
            }
            res.add(Arrays.copyOf(tmp, end));
        }
        return res;
    }

    /**
     * return if the array is rising sorted
     *
     * @param arr
     * @return
     */
    private static boolean isSortedRising(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i])
                return false;
        }
        return true;
    }

    public static int[] fullSearchRising(int[] arr) {
        int[] ans = null;
        int max_len = 0;
        for (int[] i : allCombinations(arr)) {
            int len = i.length;
            if (isSortedRising(i) && len > max_len) {
                max_len = len;
                ans = i;
            }
        }
        return ans;
    }

    /**
     * return if the array is rising sorted
     *
     * @param arr
     * @return
     */
    private static boolean isSortedDecline(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i])
                return false;
        }
        return true;
    }

    public static int[] fullSearchDecline(int[] arr) {
        int[] ans = null;
        int max_len = 0;
        for (int[] i : allCombinations(arr)) {
            int len = i.length;
            if (isSortedDecline(i) && len > max_len) {
                max_len = len;
                ans = i;
            }
        }
        return ans;
    }


    public static int[] LIS_with_LCS(int[] arr) {
        int[] t = Arrays.copyOf(arr, arr.length);
        Arrays.sort(t);
        return LCS(t, arr);
    }


    public static ArrayList<int[]> allLIS(int[] arr) {
        ArrayList<int[]> ans = new ArrayList<>();
        for (int[] i : allCombinations(arr)) {
            if (isSortedDecline(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static int[] LCS(int[] x, int[] y) {
        int i = y.length - 1, j = x.length - 1;
        int[] res = new int[Math.max(x.length, y.length)];
        int k = res.length - 1;
        while (i >= 0 && j >= 0) {
            if (x[j] == y[i]) {
                res[k--] = y[i];
                i--;
                j--;
            } else {
                i--;
            }
        }
        return Arrays.copyOfRange(res, k + 1, res.length);
    }

/*    private void initArr(int[] x, int[] y) {
        int[][] lcs = new int[x.length][y.length];
        int counter = 0;
        for (int i = 0; i < lcs[0].length; i++) {
            if (x[i] == y[0]) counter = 1;
            lcs[0][i] = counter;
        }
        counter = 0;
        for (int i = 0; i < lcs.length; i++) {
            if (x[0] == y[i]) counter = 1;
            lcs[i][0] = counter;
        }
        for (int i = 1; i < y.length; i++) {
            for (int j = 1; j < x.length; j++) {
                if (x[j] != y[i]) lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1]);
                else lcs[i][j] = lcs[i - 1][j - 1] + 1;
            }
        }
    }*/

}
