import java.util.Arrays;

public class Ones {

    public static int licOnes(int[] a, int[] b) {
        int n = a.length, m = b.length;
        if (n != m) return -1;
        int[] h = new int[n];
        int j = 0;
        while (b[j] == 0) h[0] = a[j++];
        h[0] = a[0];
        int k = 1;
        for (int i = 1; i < n; i++) {
            if (b[i] == 1) {
                int index = Arrays.binarySearch(h, 0, k, a[i]);
                if (index < 0) index = -index - 1;
                if (index == k) k++;
                h[index] = a[i];
            }
        }
        System.out.println(Arrays.toString(h));
        return k;
    }

    public static void main(String[] args) {
        int[] a = {0, 5, 8, 3, 11, 7, 9, 61};
        int[] b = {1, 1, 1, 1, 0, 0, 1, 1};
        System.out.println("licOnes(a,b) = " + licOnes(a, b));
    }
}
