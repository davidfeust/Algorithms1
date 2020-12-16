package week8;

import java.util.Arrays;

public class LIC2 {

    public static int LISLength(int[] arr) {
        int n = arr.length;
        int[] tmp = new int[n];
        tmp[0] = arr[0];
        int lis = 0;
        for (int i = 1; i < n; i++) {
            int index = binarySearchBetween(tmp, lis,arr[i]);
            tmp[index] = arr[i];
            if (index == arr[i]) {
                lis++;
            }
        }
        return lis;//Arrays.copyOf(tmp, k);
    }

    // not good
    private static int binarySearchBetween(int[] arr, int e, int value) {
        return Arrays.binarySearch(Arrays.copyOf(arr, e), value);
    }
}
