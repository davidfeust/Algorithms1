import java.util.Arrays;

public class NumbersGameProg {


    private static int[][] gameNumberCal(int[] a) {
        int n = a.length;
        int[][] h = new int[n][n];
        for (int i = 0; i < n; i++) h[i][i] = a[i];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                h[i][j] = Math.max(a[i] - h[i + 1][j], a[j] - h[i][j - 1]);
            }
        }
        return h;
    }

    public static int[] gameNumberProg(int[] a) {
        int n = a.length;
        int[][] h = gameNumberCal(a);
        int[] ans = new int[n];
        int k = 0, i = 0, j = n - 1;
        while (i != j) {
            if (a[i] - h[i + 1][j] > a[j] - h[i][j - 1]) ans[k++] = a[i++];
            else ans[k++] = a[j--];
        }
        ans[k] = a[i];
        return ans;
    }

    public static int gameNumber(int[] a) {
        return gameNumberCal(a)[0][a.length - 1];
    }

    public static void main(String[] args) {
//        int[] a = {2, 8, 7, 10, 4};
        int[] a = {1, 3, 6, 1, 3, 6};
        System.out.println("gameNumber(a) = " + gameNumber(a));
        System.out.println("gameNumberProg(a) = " + Arrays.toString(gameNumberProg(a)));
    }
}
