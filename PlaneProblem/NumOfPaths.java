import java.util.ArrayList;

public class NumOfPaths {

    MyNode[][] mat;
    int teta, n, m;
    ArrayList<String> paths;

    public NumOfPaths(Node[][] nodes, int teta) {
        this.teta = teta;
        this.n = nodes.length;
        this.m = nodes[0].length;
        this.mat = new MyNode[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.mat[i][j] = new MyNode(nodes[i][j]);
            }
        }
        matCalc(mat);
    }

    private void matCalc(MyNode[][] mat) {
        mat[0][0].price = 0;
        for (int i = 1; i < n; i++) {
            mat[i][0].price = mat[i - 1][0].price + mat[i - 1][0].y;
            mat[i][0].num_of_paths = 1;
        }
        for (int i = 1; i < m; i++) {
            mat[0][i].price = mat[0][i - 1].price + mat[0][i - 1].x;
            mat[0][i].num_of_paths = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int x = mat[i][j - 1].price + mat[i][j - 1].x;
                int y = mat[i - 1][j].price + mat[i - 1][j].y;
                if (y < x) {
                    mat[i][j].price = y;
                    mat[i][j].num_of_paths = mat[i - 1][j].num_of_paths;
                } else if (x < y) {
                    mat[i][j].price = x;
                    mat[i][j].num_of_paths = mat[i][j - 1].num_of_paths;
                } else {
                    mat[i][j].price = x;
                    mat[i][j].num_of_paths = mat[i - 1][j].num_of_paths + mat[i][j - 1].num_of_paths;
                }
            }
//            System.out.println(Arrays.toString(mat[i]));
        }
    }

    private void allPaths() {
        paths = new ArrayList<>();
        buildPaths("", n - 1, m - 1, paths);
//        System.out.println("paths = " + paths);
    }

    private void buildPaths(String path, int i, int j, ArrayList<String> paths) {
        if (i > 0 && j > 0) {
            int x = mat[i][j - 1].price + mat[i][j - 1].x;
            int y = mat[i - 1][j].price + mat[i - 1][j].y;
            if (y < x) {
                buildPaths("1" + path, i - 1, j, paths);
            } else if (x < y) {
                buildPaths("0" + path, i, j - 1, paths);
            } else {
                buildPaths("1" + path, i - 1, j, paths);
                buildPaths("0" + new String(path), i, j - 1, paths);
            }
        } else if (i == 0 && j == 0) {
            paths.add(path);
        } else if (i == 0) {
            String t = "";
            for (int k = 0; k < j; k++) t += "0";
            paths.add(t + path);
        } else if (j == 0) {
            String t = "";
            for (int k = 0; k < i; k++) t += "1";
            paths.add(t + path);
        }
    }

    private int numOfTurns(String p) {
        int ans = 0;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) != p.charAt(i - 1)) ans++;
        }
        return ans;
    }

    public int numOfCheapestPaths() {
        return mat[n - 1][m - 1].num_of_paths;
    }

    public int numOfOptimalPaths() {
        if (mat[n - 1][m - 1].num_of_paths > teta) {
            return -1;
        }
        allPaths();
        int ans = 1, min_turns = Integer.MAX_VALUE;
        for (String i : paths) {
            int t = numOfTurns(i);
            if (t < min_turns) {
                min_turns = t;
                ans = 1;
            } else if (t == min_turns) {
                ans++;
            }
        }
        return ans;
    }


    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class MyNode {
        int x, y, price, num_of_paths;
        ArrayList<String> paths;

        public MyNode(Node n) {
            this.x = n.x;
            this.y = n.y;
            this.paths = new ArrayList<>();
            this.paths.add("");
        }
    }

    public static Node[][] initMatOfNodes() { // n = 4
        int n = 4;
        Node[][] mat = new Node[n][n];
        //the 1-st row
        mat[0][0] = new Node(1, 3);
        mat[0][1] = new Node(8, 4);
        mat[0][2] = new Node(3, 8);
        mat[0][3] = new Node(0, 4);
        //the 2-nd row
        mat[1][0] = new Node(2, 5);
        mat[1][1] = new Node(5, 11);
        mat[1][2] = new Node(3, 1);
        mat[1][3] = new Node(0, 2);
        //the 3-d row
        mat[2][0] = new Node(4, 10);
        mat[2][1] = new Node(3, 1);
        mat[2][2] = new Node(1, 4);
        mat[2][3] = new Node(0, 8);
        //the 4-th row
        mat[3][0] = new Node(2, 0);
        mat[3][1] = new Node(3, 0);
        mat[3][2] = new Node(5, 0);
        mat[3][3] = new Node(0, 0);
        return mat;
    }

    public static void main(String[] args) {
        NumOfPaths nop = new NumOfPaths(initMatOfNodes(), 9);
        System.out.println("nop.numOfCheapestPaths() = " + nop.numOfCheapestPaths());
        System.out.println("nop.numOfOptimalPaths() = " + nop.numOfOptimalPaths());
    }
}
