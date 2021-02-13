package TestPractice;

public class NumbersGame2 {

    public static int gameNumber(int[] a) {
        int n = a.length;
        int[][] h = new int[n][n];
        for (int i = 0; i < n; i++) {
            h[i][i] = a[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                h[i][j] = Math.max(a[i] - h[i + 1][j], a[j] - h[i][j - 1]);
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(i + "\t" + Arrays.toString(h[i]));
//        }
        return h[0][n - 1];
    }

    public static void main(String[] args) {
        int[] a = {2, 8, 7, 10, 4};
        System.out.println("gameNumber(a) = " + gameNumber(a));
    }
}
