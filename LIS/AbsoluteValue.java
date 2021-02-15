import java.util.Arrays;

public class AbsoluteValue {

    public static int lis(int[] a) {
        int n = a.length;
        int[] h = new int[n];
        h[0] = a[0];
        int k = 1;
        for (int i = 1; i < n; i++) {
            int index = Arrays.binarySearch(h, 0, k, a[i]);
            if (index < 0) index = -index - 1;
            if (k == index) k++;
            h[index] = a[i];
        }
        return k;
    }

    public static int absoluteValue(int[] a, int k) {
        int n = a.length;
        int[] h = new int[n];
        h[0] = 1;//a[0];
        int ans = 1;
        for (int i = 1; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (Math.abs(a[i] - a[j]) == k) {
                    max = Math.max(max, h[j] + 1);
                }
            }
            h[i] = max;
            ans = Math.max(ans, max);
        }
        System.out.println(Arrays.toString(h));
        return ans;
    }

    public static void main(String[] args) {
        int[] a0 = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println("lis(a0) = " + lis(a0));
        System.out.println("absoluteValue(a0, 2) = " + absoluteValue(a0, 2));
        int[] a1 = {10, 7, 5, 4, 3, 4, 1, 2, 4, 7};
        System.out.println("absoluteValue(a1, 3) = " + absoluteValue(a1, 3));
    }
}
