import java.util.Arrays;

public class PowOrSqrt {

    private static int powOrSqrtSize(int[] a) {
        int n = a.length;
        int[] h = new int[n];
        h[0] = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] * a[j] == a[i] || a[i] * a[i] == a[j]) max = Math.max(h[j] + 1, max);
                else max = Math.max(1, max);
            }
            h[i] = max;
            ans = Math.max(ans, max);
        }
        System.out.println(Arrays.toString(h));
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 1, 49, 3, 4, 1, 9, 2, 30, 81};
        System.out.println("powOrSqrt(a) = " + powOrSqrtSize(a));
    }
}
