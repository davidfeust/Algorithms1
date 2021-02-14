import java.util.Arrays;

class N {
    int x, y, minPrice, maxPrice;

    public N(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + "(" + x + ", " + y + "), minPrice=" + minPrice + ", maxPrice=" + maxPrice + '}';
    }
}

public class Difference {

    public static int plane(N[][] mat) {
        int n = mat.length, m = mat[0].length;
        mat[0][0].minPrice = mat[0][0].maxPrice = 0;
        for (int i = 1; i < n; i++) mat[i][0].minPrice = mat[i][0].maxPrice = mat[i - 1][0].maxPrice + mat[i - 1][0].y;
        for (int j = 1; j < m; j++) mat[0][j].minPrice = mat[0][j].maxPrice = mat[0][j - 1].maxPrice + mat[0][j - 1].x;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                mat[i][j].minPrice = Math.min(mat[i - 1][j].minPrice + mat[i - 1][j].y, mat[i][j - 1].minPrice + mat[i][j - 1].x);
                mat[i][j].maxPrice = Math.max(mat[i - 1][j].maxPrice + mat[i - 1][j].y, mat[i][j - 1].maxPrice + mat[i][j - 1].x);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
        return mat[n - 1][m - 1].maxPrice - mat[n - 1][m - 1].minPrice;
    }

    public static void main(String[] args) {
        N[][] mat = {
                {new N(1, 3), new N(8, 4), new N(3, 8), new N(0, 4)},
                {new N(2, 5), new N(5, 11), new N(3, 1), new N(0, 2)},
                {new N(4, 10), new N(3, 1), new N(1, 4), new N(0, 8)},
                {new N(2, 0), new N(3, 0), new N(5, 0), new N(0, 0)},
        };
        System.out.println("plane(mat) = " + plane(mat));
    }
}
