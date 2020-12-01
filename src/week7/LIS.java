package week7;

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
            }
        }
        return Arrays.copyOf(res, j);
    }
}
