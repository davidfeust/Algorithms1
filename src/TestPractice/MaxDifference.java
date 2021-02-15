package TestPractice;

public class MaxDifference {

    public static int maxDifference(int[] a) {
        int n = a.length;
        int min = a[0], max = a[1];
        int first = 0, last = 1;
        if (a[0] > a[1]) {
            min = a[1];
            max = a[0];
            first = 1;
            last = 0;
        }
        for (int i = 2; i < n - 1; i += 2) {
            int x = a[i + 1];
            int y = a[i];
            if (x > y) {
                if (x > max && i + 1 >= first) {
                    max = x;
                    last = i + 1;
                }
                if (y < min && i <= last) {
                    min = y;
                    first = i;
                }
            } else {
                if (y > max && i >= first) {
                    max = y;
                    last = i;
                }
                if (x < min && i <= last) {
                    min = x;
                    first = i + 1;
                }
            }
        }
        if (n % 2 == 1) {
            int x = a[n - 1];
            if (x > max) {
                max = x;
                last = n - 1;
            } else if (x < min) {
                min = x;
                first = n - 1;
            }
        }
        System.out.println("min = " + min + " = a[" + first + "]");
        System.out.println("max = " + max + " = a[" + last + "]");
        return max - min;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 7, 3, 9, 5};
        System.out.println("maxDifference(a) = " + maxDifference(a));
        int[] b = {22, 2, 12, 4, 7, 3, 19, 5};
        System.out.println("maxDifference(b) = " + maxDifference(b));
    }
}
