/**
 * Shortest common string
 */
public class SCS {
    public static int[][] lcsMat(String x, String y) {
        int n = x.length(), m = y.length();
        int[][] help = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) help[i][0] = 0;
        for (int i = 0; i < m + 1; i++) help[0][i] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    help[i][j] = help[i - 1][j - 1] + 1;
                } else {
                    help[i][j] = Math.max(help[i - 1][j], help[i][j - 1]);
                }
            }
        }
        return help;
    }

    public static int lcsSize(String x, String y) {
        return lcsMat(x, y)[x.length()][y.length()];
    }

    public static String lcs(String x, String y) {
        String ans = "";
        int[][] help = lcsMat(x, y);
        int i = x.length(), j = y.length();
        while (i != 0 && j != 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                ans = x.charAt(i - 1) + ans;
                i--;
                j--;
            } else if (help[i][j - 1] > help[i - 1][j]) j--;
            else i--;
        }
        return ans;
    }

    public static int scsSize(String x, String y) {
        return x.length() + y.length() - lcsSize(x, y);
    }

    public static String scs(String x, String y) {
        String lcs = lcs(x, y);
        int n = x.length(), m = y.length(), l = lcs.length();
        int i = 0, j = 0, k = 0;
        String ans = "";
        while (i < n && j < m && k < l) {
            if (x.charAt(i) != lcs.charAt(k)) ans += x.charAt(i++);
            else {
                while (y.charAt(j) != lcs.charAt(k) && j < m) ans += y.charAt(j++);
                ans += lcs.charAt(k++);
                i++;
                j++;
            }
            if (i >= n || j >= m || k >= l) {
                break;
            }
            if (y.charAt(j) != lcs.charAt(k)) ans += y.charAt(j++);
            else {
                while (x.charAt(i) != lcs.charAt(k) && i < n) ans += x.charAt(i++);
                ans += lcs.charAt(k++);
                i++;
                j++;
            }
        }
        while (i < n) ans += x.charAt(i++);
        while (j < m) ans += y.charAt(j++);
        return ans;
    }

    public static void main(String[] args) {
        String x = "abcdefghi";
        String y = "tttabtttcttdtt";
        System.out.println("lcs(x,y) = " + lcs(x, y));
        System.out.println("lcsSize(x,y) = " + lcsSize(x, y));
        System.out.println("scsSize(x,y) = " + scsSize(x, y));
        System.out.println("scs(x,y) = " + scs(x, y));
        x = "abcbdab";
        y = "bdcaba";
        System.out.println("lcs(x,y) = " + lcs(x, y));
        System.out.println("lcsSize(x,y) = " + lcsSize(x, y));
        System.out.println("scsSize(x,y) = " + scsSize(x, y));
        System.out.println("scs(x,y) = " + scs(x, y)); // abdcabdab
    }
}
