

public class LCS {

    public static int lcsSize(String x, String y) {
        int n = x.length(), m = y.length();
        int[][] lcs = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            lcs[i][0] = 0;
        }
        for (int i = 0; i < m + 1; i++) {
            lcs[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs[n][m];
    }

    public static String lcs(String x, String y) {
        int n = x.length(), m = y.length();
        int[][] lcs = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            lcs[i][0] = 0;
        }
        for (int i = 0; i < m + 1; i++) {
            lcs[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        int i = n, j = m;
        String res = "";
        while (lcs[i][j] != 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                res = x.charAt(i - 1) + res;
                i--;
                j--;
            } else {
                if (lcs[i][j - 1] > lcs[i - 1][j]) j--;
                else i--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String x = "abcdefgh";
        String y = "frhbcdenfgh";
        System.out.println("lcsSize(x,y) = " + lcsSize(x, y));
        System.out.println("lcs(x,y) = " + lcs(x, y));
    }
}
