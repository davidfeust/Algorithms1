import java.util.Arrays;

public class LISAsg {

    private int[] arr, help;
    private int teta, n;

    public LISAsg(int[] arr, int teta) {
        this.arr = arr;
        this.teta = teta;
        this.n = arr.length;
    }

    public int lengthLIS() {
        help = new int[n];
        help[0] = arr[0];
        int res = 1;
        for (int i = 1; i < n; i++) {
            int index = Arrays.binarySearch(arr, 0, res, arr[i]);
            if (index < 0) {
                index = -index - 1;
            }
            if (index == res) {
                res++;
            }
            help[index] = arr[i];
        }
        System.out.println(Arrays.toString(help));
        return res;
    }

    public int numOfLIS() {
        return 0;
    }

    public int[][] allLIS() {
        return null;
    }

}
