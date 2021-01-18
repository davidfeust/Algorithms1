package week13;

import java.util.Arrays;

public class MaxSubArray {

    public static int greedy(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                res++;
            } else if (res > 0) {
                return res;
            }
        }
        return 0;
    }


    public static int improvesGreedy(int[] arr) {
        int temp_res = 0;
        int max_res = 0;
        for (int j : arr) {
            if (j == 1) {
                temp_res++;
            } else {
                if (temp_res > max_res) {
                    max_res = temp_res;
                }
                temp_res = 0;
            }
        }
        return Math.max(max_res, temp_res);
    }

    public static int dynamic(int[] arr) {
        int[] h = new int[arr.length];
        for (int i = 1; i < h.length; i++) {
            if (arr[i] == 0) {
                h[i] = 0;
            } else {
                h[i] = h[i - 1] + 1;
            }
        }
        return Arrays.stream(h).max().getAsInt();
    }
}
