import java.util.Arrays;

public class Circle {

    public static int[] lisCircle(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        int[][] mat = new int[n][];
        mat[0] = new int[1];
        lis[0] = mat[0][0] = arr[0];
        int k = 1;
        int start = minIndex(arr);
        for (int i = start; i < start + n; i++) {
            int index = Arrays.binarySearch(lis, 0, k, arr[i % n]);
            if (index < 0) index = -index - 1;
            if (index == k) {
                k++;
            }
            mat[index] = new int[index + 1];
            for (int j = 0; j < index; j++) {
                mat[index][j] = mat[index - 1][j];
            }
            lis[index] = mat[index][index] = arr[i % n];
        }
//        for (int[] i : mat) System.out.println(Arrays.toString(i));
        return mat[k - 1];
    }

    // O(n)
    private static int minIndex(int[] arr) {
        int min = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 11, 2, 10, 4, 5, 2, 1};
        int[] a2 = {5, 2, 9, 7, 8, 5, 3, 2, 1, 10, 6};
        int[] a3 = {9, 10, 8, 0, 1, 4, 3, 7};
        System.out.println("lis(a1) = " + Arrays.toString(lisCircle(a1)));
        System.out.println("lis(a2) = " + Arrays.toString(lisCircle(a2)));
        System.out.println("lis(a3) = " + Arrays.toString(lisCircle(a3))); // 0,1,3,7,9,10
    }

}
