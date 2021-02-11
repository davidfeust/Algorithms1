import java.util.Arrays;

public class LIS {

    public static int lisSize(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        lis[0] = arr[0];
        int k = 1;
        for (int i = 1; i < n; i++) {
            int index = Arrays.binarySearch(lis, 0, k, arr[i]);
            if (index < 0) index = -index - 1;
            if (index == k) k++;
            lis[index] = arr[i];
            System.out.println(Arrays.toString(lis));
        }
        return k;
    }

    public static int[] lis(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        int[][] mat = new int[n][];
        mat[0] = new int[1];
        lis[0] = mat[0][0] = arr[0];
        int k = 1;
        for (int i = 1; i < n; i++) {
            int index = Arrays.binarySearch(lis, 0, k, arr[i]);
            if (index < 0) index = -index - 1;
            if (index == k) {
                k++;
            }
            mat[index] = new int[index + 1];
            for (int j = 0; j < index; j++) {
                mat[index][j] = mat[index - 1][j];
            }
            lis[index] = mat[index][index] = arr[i];
        }
//        for (int[] i : mat) System.out.print(i == null ? "" : Arrays.toString(i) + "\n");
        return mat[k - 1];
    }



    public static void main(String[] args) {
        int[] a1 = {1, 11, 2, 10, 4, 5, 2, 1};
        int[] a2 = {5, 2, 9, 7, 8, 5, 3, 2, 1, 10, 6};
        int[] a3 = {9, 10, 8, 0, 1, 4, 3, 7};
//        System.out.println("lis(a1) = " + Arrays.toString(lis(a1)));
        System.out.println("lis(a2) = " + Arrays.toString(lis(a2)));
//        System.out.println("lis(a3) = " + Arrays.toString(lis(a3))); // 0,1,3,7,9,10
//        System.out.println(lisSize(new int[]{0, 5, 8, 3, 11, 7, 9, 61}));
    }
}
