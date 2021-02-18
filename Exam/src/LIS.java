import java.util.Arrays;

public class LIS {

    private final int[] arr; // input array
    private final int n; // size of arr
    private int[] help;
    private final int[][] mat;
    private final int teta;
    private int length; // length of the longest increasing subsequences
    private int numOfAll; // number of all the longest increasing subsequences

    public LIS(int[] arr, int teta) {
        this.arr = arr;
        this.teta = teta;
        this.n = arr.length;
        this.help = new int[n];
        this.mat = new int[n][];
        this.numOfAll = -1;
        this.length = -1;
    }

    public int lengthLIS() {
        if (length == -1) baseCalc();
        return length;
    }

    public int numOfLIS() {
        if (numOfAll == -1) baseCalc();
        return numOfAll;
    }

    public int[][] allLIS() {
        if (numOfAll == -1) {
            baseCalc();
        }
        if (numOfAll <= teta) {
            return allLISCalc();
        } else {
            return new int[][]{oneLISCalc()};
        }
    }

    private void baseCalc() {
        help[0] = arr[0];
        int counter = 1;
        int maxNum = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > help[counter - 1]) {
                help[counter++] = arr[i];
                maxNum = 1;
            } else {
                int index = binarySearch(help, counter - 2, arr[i]);
                if (index + 1 == counter) maxNum++;
                help[index] = arr[i];
            }
        }
        numOfAll = maxNum;
        length = counter;
    }

    private int[][] allLISCalc() {
        help = new int[n];
        mat[0] = new int[1];
        mat[0][0] = help[0] = arr[0];
        int[][] ans = new int[numOfAll][length];
        int counter = 1;
        int k = 0;
        for (int i = 1; i < n; i++) {
            int index = binarySearch(help, counter - 1, arr[i]);
            if (index == counter) counter++;

            mat[index] = new int[index + 1];
            for (int j = 0; j < index; j++) mat[index][j] = mat[index - 1][j];
            mat[index][index] = help[index] = arr[i];
            if (index + 1 == length) ans[k++] = mat[index];
            System.out.println("mat[index] = mat[" + index + "] =" + Arrays.toString(mat[index]));
        }
        return ans;
    }

    private int[] oneLISCalc() {
        help = new int[n];
        mat[0] = new int[1];
        mat[0][0] = help[0] = arr[0];
        int counter = 1;
        for (int i = 1; i < n; i++) {
            int index = binarySearch(help, counter - 1, arr[i]);

            if (index == counter) counter++;
            mat[index] = new int[index + 1];
            for (int j = 0; j < index; j++) mat[index][j] = mat[index - 1][j];

            mat[index][index] = help[index] = arr[i];
        }
        return mat[length - 1];
    }

    private int binarySearch(int[] arr, int start, int end, int value) {
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (arr[mid] < value) start = mid + 1;
            else if (arr[mid] > value) end = mid - 1;
            else return mid;
        }
        return start;
    }

    private int binarySearch(int[] arr, int end, int value) {
        return binarySearch(arr, 0, end, value);
    }
}
