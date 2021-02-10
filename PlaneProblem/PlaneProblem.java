class Node {
    int x, y, price;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class PlaneProblem {

    public static Node[][] matCalc(Node[][] mat) {
        int n = mat.length, m = mat[0].length;
        mat[0][0].price = 0;
        for (int i = 1; i < n; i++) {
            mat[i][0].price = mat[i - 1][0].price + mat[i - 1][0].y;
        }
        for (int i = 1; i < m; i++) {
            mat[0][i].price = mat[0][i - 1].price + mat[0][i - 1].x;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                mat[i][j].price = Math.min(mat[i - 1][j].price + mat[i - 1][j].y, mat[i][j - 1].price + mat[i][j - 1].x);
            }
        }
        return mat;
    }

    public static int minPrice(Node[][] mat) {
        int n = mat.length, m = mat[0].length;
        return matCalc(mat)[n - 1][m - 1].price;
    }

    public static String minPricePath(Node[][] mat) {
        int n = mat.length, m = mat[0].length;
        matCalc(mat);
        int i = n - 1, j = m - 1;
        String ans = "";
        while (i != 0 && j != 0) {
            if (mat[i - 1][j].price + mat[i - 1][j].y < mat[i][j - 1].price + mat[i][j - 1].x) {
                ans = "1" + ans;
                i--;
            } else {
                ans = "0" + ans;
                j--;
            }
        }
        while (i != 0) {
            ans = "1" + ans;
            i--;
        }
        while (j != 0) {
            ans = "0" + ans;
            j--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Node[][] mat = {
                {new Node(1, 5), new Node(4, 1), new Node(0, 6)},
                {new Node(4, 7), new Node(2, 5), new Node(0, 3)},
                {new Node(1, 0), new Node(2, 0), new Node(0, 0)},
        };
        System.out.println("minPrice(mat) = " + minPrice(mat));
        System.out.println("minPricePath(mat) = " + minPricePath(mat));
    }
}
