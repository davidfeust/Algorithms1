import java.util.Arrays;

public class Bitonic {

    private static int[] lis(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        lis[0] = arr[0];
        int k = 1;
        for (int i = 1; i < n; i++) {
            int index = Arrays.binarySearch(lis, 0, k, arr[i]);
            if (index < 0) index = -index - 1;
            if (index == k) k++;
            lis[index] = arr[i];
//            System.out.println(Arrays.toString(lis));
        }
        return lis;
    }

    private static int[] lds(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        arr = revers(arr);
        lis[0] = arr[0];
        int k = 1;
        for (int i = 1; i < n; i++) {
            int index = Arrays.binarySearch(lis, 0, k, arr[i]);
            if (index < 0) index = -index - 1;
            if (index == k) k++;
            lis[index] = arr[i];
        }
        return lis;
    }

    public static int lbs(int[] a) {
        int[] up = lis(a);
        int[] down = lds(a);
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans = Math.max(up[i] + down[i] + 1, ans);
        }
        return ans;
    }

    public static int[] revers(int[] a) {
        int n = a.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = a[n - 1 - i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 11, 2, 10, 4, 5, 2, 1};
        int[] a2 = {1, 3, 5, 40, 11, 12};
//        System.out.println("lis(a) = " + Arrays.toString(lis(a1)));
//        System.out.println("lds(a) = " + Arrays.toString(lds(a1)));
        System.out.println("lbs(a) = " + lbs(a1));
        System.out.println("lbs(a) = " + lbs(a2));
    }

}
