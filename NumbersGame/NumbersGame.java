public class NumbersGame {

    public static int numberGame(int[] arr) {
        int n = arr.length;
        int[][] h = new int[n][n];
        for (int i = 0; i < n; i++) {
            h[i][i] = arr[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                h[i][j] = Math.max(arr[i] - h[i + 1][j], arr[j] - h[i][j - 1]);
            }
        }
        return h[0][n - 1];
    }

    public static int numberGameCycle(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int[] rest = new int[n - 1];
            for (int j = 0; j < n - 1; j++) {
                rest[j] = arr[(j + i + 1) % n];
            }
            int f = numberGame(rest);
            max = Math.max(max, x - f);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 1, 3, 6};
        System.out.println(numberGame(a));
        System.out.println(numberGameCycle(a));
    }
}
