package TestPractice;

import java.util.Arrays;

public class Prisons {

    public static int lampOn(int n) {
        boolean[] enter = new boolean[n];
        Arrays.fill(enter, false);
        boolean lamp = true;
        int count = 0, step = 0;
        while (count < n) {
            step++;
            int p = (int) (Math.random() * n);
            if (p == 0) { // the counter prison entered
                if (!enter[0]) {
                    enter[0] = true;
                    count++;
                }
                if (!lamp) {
                    lamp = true;
                    count++;
                }
            } else {
                if (!enter[p] && lamp) {
                    lamp = false;
                    enter[p] = true;
                }
            }
        }
        boolean ans = true;
        for (int i = 0; i < n && ans; i++) {
            if (!enter[i]) ans = false;
        }
        System.out.println(ans);
        return step;
    }

    public static int lampUnknown(int n) {
        int[] enter = new int[n];
        Arrays.fill(enter, 0);
        int count = 0, step = 0;
        boolean lamp = (int) (Math.random() * 2) != 0;
        while (count < 2 * n) {
            step++;
            int p = (int) (Math.random() * n);
            if (p == 0 && !lamp) {
                lamp = true;
                count++;
                if (enter[0] == 0) {
                    enter[0]++;
                    count++;
                }
            } else {
                if (enter[p] < 2 && lamp) {
                    enter[p]++;
                    lamp = false;
                }
            }
        }
        boolean ans = true;
        for (int i = 0; i < n && ans; i++) {
            if (enter[i] == 0) ans = false;
        }
        System.out.println(ans);
        return step;

    }

    public static void main(String[] args) {
        System.out.println("lampOn(32) = " + lampOn(32));
        System.out.println("lampUnknown(32) = " + lampUnknown(32));
    }
}
