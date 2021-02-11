import java.awt.*;

class Vertex {
    int x, y, price;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Between2Points {

    public static int minPrice(Vertex[][] mat) {
        int n = mat.length, m = mat[0].length;
        mat[0][0].price = 0;
        for (int i = 1; i < n; i++) mat[i][0].price = mat[i - 1][0].price + mat[i - 1][0].y;
        for (int j = 1; j < m; j++) mat[0][j].price = mat[0][j - 1].price + mat[0][j - 1].x;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                mat[i][j].price = Math.min(mat[i - 1][j].price + mat[i - 1][j].y, mat[i][j - 1].price + mat[i][j - 1].x);
            }
        }
        return mat[n - 1][m - 1].price;
    }

    public static int minPriceRange(Vertex[][] mat, Point start, Point end) {
        mat[start.y][start.x].price = 0;
        int n = end.y - start.y + 1;
        int m = end.x - start.x + 1;
        for (int i = start.y + 1; i < n + start.y; i++)
            mat[i][start.x].price = mat[i - 1][start.x].price + mat[i - 1][start.x].y;
        for (int j = start.x + 1; j < m + start.x; j++)
            mat[start.y][j].price = mat[start.y][j - 1].price + mat[start.y][j - 1].x;
        for (int i = start.y + 1; i < n + start.y; i++) {
            for (int j = start.x + 1; j < m + start.x; j++) {
                mat[i][j].price = Math.min(mat[i - 1][j].price + mat[i - 1][j].y, mat[i][j - 1].price + mat[i][j - 1].x);
            }
        }
        return mat[end.y][end.x].price;
    }

    public static boolean isPointsOnPath(Vertex[][] mat, Point p, Point q) {
        Point start, end;
        if (p.x <= q.x && p.y <= q.y) {
            start = p;
            end = q;
        } else if (q.x <= p.x && q.y <= p.y) {
            start = q;
            end = p;
        } else return false;

        int all = minPrice(mat);
        int toStart = minPriceRange(mat, new Point(0, 0), start);
        int startToEnd = minPriceRange(mat, start, end);
        int endTo = minPriceRange(mat, end, new Point(mat.length - 1, mat[0].length - 1));
        return all == toStart + startToEnd + endTo;
    }

    public static void main(String[] args) {
        Vertex[][] mat = {
                {new Vertex(1, 5), new Vertex(4, 1), new Vertex(0, 6)},
                {new Vertex(4, 7), new Vertex(2, 5), new Vertex(0, 3)},
                {new Vertex(1, 0), new Vertex(2, 0), new Vertex(0, 0)},
        };
//        System.out.println("minPrice(mat) = " + minPrice(mat));
//        System.out.println("minPricePath(mat) = " + minPricePath(mat));
//        System.out.println("minPriceRange(mat, (0, 0), (3, 3)) = " + minPriceRange(mat, new Point(0, 0), new Point(2, 2)));
        System.out.println("isPointsOnPath(mat, (1 ,0), (1 ,1)) = " + isPointsOnPath(mat, new Point(1, 0), new Point(1, 1)));
        System.out.println("isPointsOnPath(mat, (0 ,1), (2 ,1)) = " + isPointsOnPath(mat, new Point(0, 1), new Point(2, 1)));
    }
}
