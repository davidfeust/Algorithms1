import java.util.Arrays;

public class LIS {

    private int[] arr;
//    private int[] num;
    private int[] h;
    private int[][] mat;
    //    ArrayList<int[]> all;
    private final int teta;
    private final int n; // size of arr
    private int length; // length of the longest increasing subsequences
    private int numOfAll; // number of all the longest increasing subsequences

    public LIS(int[] arr, int teta) {
        this.arr = arr;
        this.teta = teta;
        this.n = arr.length;
//        this.num = new int[n];
//        this.all = new ArrayList<>();
        this.h = new int[n];
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

    private void baseCalc() {
        h[0] = arr[0];
        int counter = 1;
        int maxNum = 0;
        for (int i = 1; i < n; i++) {
            int index = Arrays.binarySearch(h, 0, counter, arr[i]);
            if (index < 0) index = -index - 1;
            if (index == counter) {
                counter++;
                maxNum = 1;
            }
            else if (index +1 == counter) maxNum++;
//            num[index]++;
            h[index] = arr[i];
        }
//        numOfAll = num[counter - 1];
        numOfAll = maxNum;
        length = counter;
//        System.out.println("h:" + Arrays.toString(h));
//        System.out.println("num:" + Arrays.toString(num));
//        System.out.println("num[counter] = num[" + counter + "] = " + num[counter - 1]);
//        System.out.println();
//        for (int[] i : mat) System.out.println(Arrays.toString(i));
//        System.out.println("maxNum = " + maxNum);
    }

    public int[][] allLIS() {
        if (numOfAll == -1) baseCalc();
        if (numOfAll <= teta) {
            return allLISCalc();
        } else {
            return new int[][]{oneLIS()};
        }
    }

    private int[][] allLISCalc() {
        mat[0] = new int[1];
        mat[0][0] = h[0] = arr[0];
        int[][] ans = new int[numOfAll][length];
        int counter = 1;
        int k = 0;
        for (int i = 1; i < n; i++) {
            int index = Arrays.binarySearch(h, 0, counter, arr[i]);
            if (index < 0) index = -index - 1;
            if (index == counter) counter++;

            mat[index] = new int[index + 1];
            for (int j = 0; j < index; j++) mat[index][j] = mat[index - 1][j];
            mat[index][index] = h[index] = arr[i];
            if (index + 1 == length) ans[k++] = mat[index];
//            System.out.println("mat[index] = mat[" + index + "] =" + Arrays.toString(mat[index]));
        }
        return ans;
    }

    private int[] oneLIS() {
        mat[0] = new int[1];
        mat[0][0] = h[0] = arr[0];
        int counter = 1;
        for (int i = 1; i < n; i++) {
            int index = Arrays.binarySearch(h, 0, counter, arr[i]);
            if (index < 0) index = -index - 1;

            if (index == counter) counter++;
            mat[index] = new int[index + 1];
            for (int j = 0; j < index; j++) mat[index][j] = mat[index - 1][j];

            mat[index][index] = h[index] = arr[i];
        }
        return mat[length - 1];
    }


    public static void main(String[] args) {
        int[] x = {10, 2, 5, 7, 0, -3, -8, 11, -40, -30, -20, -10};
        int[] xSort = {-40, -30, -20, -10, -8, -3, 0, 2, 5, 7, 10, 11};
        int[] a = {1,2,3,0,-3,-2,-1,-5};
//        LIS lis = new LIS(x, 2);
//        LIS lis = new LIS(xSort, 8);
        LIS lis = new LIS(a, 8);
        System.out.println("lis.lengthLIS() = " + lis.lengthLIS());
        System.out.println("lis.numOfLIS() = " + lis.numOfLIS());
        System.out.println("lis.oneLIS() = " + Arrays.toString(lis.oneLIS()));
        System.out.println("lis.allLIS() = " + Arrays.deepToString(lis.allLIS()));
    }
}
