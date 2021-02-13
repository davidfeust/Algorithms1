import java.awt.*;

class Node1 {
    int x, y;

    public Node1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Node2 {
    double x, y, price;
    int nPath;

    public Node2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{x=" + x + ", y=" + y + ", price=" + price + ", nPath=" + nPath + '}';
    }
}

public class DeadZone {
    Node2[][] nodes;
    Point p1, p2;
    int n, m;

    public DeadZone(Node1[][] nodes, Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.n = nodes.length;
        this.m = nodes[0].length;
        this.nodes = new Node2[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i >= p1.y && i <= p2.y && j >= p1.x && j <= p2.x)
                    this.nodes[i][j] = new Node2(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
                else
                    this.nodes[i][j] = new Node2(nodes[i][j].x, nodes[i][j].y);
            }
//            System.out.println(Arrays.toString(this.nodes[i]));
        }
        calcMat();
    }

    private void calcMat() {
        nodes[0][0].nPath = 1;
        nodes[0][0].price = 0;
        for (int i = 1; i < n; i++) {
            nodes[i][0].price = nodes[i - 1][0].price + nodes[i - 1][0].y;
            nodes[i][0].nPath = 1;
        }
        for (int j = 1; j < m; j++) {
            nodes[0][j].price = nodes[0][j - 1].price + nodes[0][j - 1].x;
            nodes[0][j].nPath = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                double y = (nodes[i - 1][j].price + nodes[i - 1][j].y);
                double x = (nodes[i][j - 1].price + nodes[i][j - 1].x);
                if (y < x) {
                    nodes[i][j].price = y;
                    nodes[i][j].nPath = nodes[i - 1][j].nPath;
                } else if (y > x) {
                    nodes[i][j].price = x;
                    nodes[i][j].nPath = nodes[i][j - 1].nPath;
                } else {
                    nodes[i][j].price = x;
                    nodes[i][j].nPath = nodes[i][j - 1].nPath + 1;
                }
            }
//            System.out.println(Arrays.toString(nodes[i]));
        }
    }

    public int cheapestPathPrice() {
        double price = nodes[n - 1][m - 1].price;
        if (price == Double.POSITIVE_INFINITY) {
            return -1;
        }
        return (int) price;
    }

    public int numOfCheapestPaths() {
        return nodes[n - 1][m - 1].nPath;
    }

    public static Node1[][] initMatOfNodes() { // n = 4
        int n = 4;
        Node1[][] mat = new Node1[n][n];
        //the 1-st row
        mat[0][0] = new Node1(1, 3);
        mat[0][1] = new Node1(8, 4);
        mat[0][2] = new Node1(3, 8);
        mat[0][3] = new Node1(0, 4);
        //the 2-nd row
        mat[1][0] = new Node1(2, 5);
        mat[1][1] = new Node1(5, 11);
        mat[1][2] = new Node1(3, 1);
        mat[1][3] = new Node1(0, 2);
        //the 3-d row
        mat[2][0] = new Node1(4, 10);
        mat[2][1] = new Node1(3, 1);
        mat[2][2] = new Node1(1, 4);
        mat[2][3] = new Node1(0, 8);
        //the 4-th row
        mat[3][0] = new Node1(2, 0);
        mat[3][1] = new Node1(3, 0);
        mat[3][2] = new Node1(5, 0);
        mat[3][3] = new Node1(0, 0);
        return mat;
    }

    public static void main(String[] args) {
        DeadZone dz = new DeadZone(initMatOfNodes(), new Point(1, 1), new Point(3, 2));
        System.out.println("dz.cheapestPathPrice() = " + dz.cheapestPathPrice());
        System.out.println("dz.numOfCheapestPaths() = " + dz.numOfCheapestPaths());
    }


}
