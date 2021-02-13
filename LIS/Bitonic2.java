import java.util.Arrays;

public class Bitonic2 {

    public static int lis(int[] a) {
        int n = a.length;
        int[] h = new int[n];
        h[0] = a[0];
        int k = 1;
        for (int i = 1; i < n; i++) {
            int index = Arrays.binarySearch(h, 0, k, a[i]);
            if (index < 0) index = -index - 1;
            if (index == k) k++;
            h[index] = a[i];
        }
        return k;
    }

    public static int[] lisArray(int[] a) {
        int n = a.length;
        int[] h = new int[n];
        int[] lis = new int[n];
        h[0] = a[0];
        lis[0] = 1;
        int k = 1;
        for (int i = 1; i < n; i++) {
            int index = Arrays.binarySearch(h, 0, k, a[i]);
            if (index < 0) index = -index - 1;
            if (index == k) k++;
            h[index] = a[i];
            lis[i] = k;
        }
        return lis;
    }

    public static int lds(int[] a) {
        int[] rev = reversArray(a);
        return lis(rev);
    }

    public static int[] ldsArray(int[] a) {
        int[] rev = reversArray(a);
        return lisArray(rev);
    }

    public static int lbs(int[] a) {
        int[] lisArray = lisArray(a);
        int[] ldsArray = ldsArray(a);
        System.out.println("lisArray = " + Arrays.toString(lisArray));
        System.out.println("ldsArray = " + Arrays.toString(ldsArray));
        int max = -1;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, lisArray[i] + ldsArray[a.length - 1 - i] - 1);
        }
        return max;
    }

    public static int[] reversArray(int[] a) {
        int n = a.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = a[n - 1 - i];
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] a = {20, 7, 8, 3, 5, 0, -1, 10, 2, 12};
        int[] a = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println("lic(a) = " + lis(a));
        System.out.println("ldc(a) = " + lds(a));
        System.out.println("lbs(a) = " + lbs(a));
    }


}





