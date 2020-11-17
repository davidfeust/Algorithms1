package week2;

import java.util.Arrays;

public class MaxMin {

    private final int N = 1000;
    public int[] arr;

    public void init() {
        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
    }

    public int algo1() {
        int max = arr[0], min = arr[0];
        int eq = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
            eq += 2;
        }
        return eq;
    }

    public int algo2() {
        int max = arr[0], min = arr[0];
        int eq = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                eq++;
            } else if (arr[i] < min) {
                min = arr[i];
                eq += 2;
            }
        }
        return eq;
    }

    public int algo3() {
        int max, min;
        if (arr[0] > arr[1]) {
            max = arr[0];
            min = arr[1];
        } else {
            max = arr[1];
            min = arr[0];
        }
        int eq = 1;
//        System.out.println("max = " + max + "\tmin = " + min);

        for (int i = 2; i < arr.length - 1; i += 2) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > max)
                    max = arr[i];
                if (arr[i + 1] < min)
                    min = arr[i + 1];
            } else {
                if (arr[i + 1] > max)
                    max = arr[i + 1];
                if (arr[i] < min)
                    min = arr[i];
            }

//            System.out.println(arr[i] + "\t" + arr[i + 1] + "\t\t\tmax= " + max + "\t\tmin= " + min);

            eq += 3;
        }
        if (arr.length % 2 != 0) {
            if (arr[arr.length - 1] > max)
                max = arr[arr.length - 1];
            if (arr[arr.length - 1] < min)
                min = arr[arr.length - 1];
            eq += 2;
        }
//        System.out.println("max = " + max + " min = " + min);
        return eq;
    }


    public static void main(String[] args) {
        MaxMin a = new MaxMin();
//        a.init();
//        System.out.println(Arrays.toString(a.arr));
//        System.out.println(a.algo3());
        int time = 100000, sum1 = 0, sum2 = 0, sum3 = 0;
        for (int i = 0; i < time; i++) {
            a.init();
            sum1 += a.algo1();
            sum2 += a.algo2();
            sum3 += a.algo3();
        }
        System.out.println("algo 1, Average comparisons: " + (double) (sum1 / time) / a.N + "n");
        System.out.println("algo 2, Average comparisons: " + (double) (sum2 / time) / a.N + "n");
        System.out.println("algo 3, Average comparisons: " + (double) (sum3 / time) / a.N + "n");

    }
}
