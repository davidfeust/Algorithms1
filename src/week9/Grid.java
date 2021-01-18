package week9;

/**
 * Grid for Plane Problem
 * the plan can move only on the grid, and only down or right in this implementation.
 */
public class Grid {

    public Node[][] _mat;
    private int _n, _m;

    /**
     * init this Grid
     *
     * @param n
     * @param m
     */
    public Grid(int n, int m) {
        _n = n + 1;
        _m = m + 1;
        _mat = new Node[_n][_m];
        for (int i = 0; i < _n; i++) {
            for (int j = 0; j < _m; j++) {
                _mat[i][j] = new Node();
            }
        }
    }

    public Node[][] mat() {
        return _mat;
    }

    public void printGrid() {
        for (int i = 0; i < _n; i++) {
            for (int j = 0; j < _m; j++) {
                System.out.print(_mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Calculate the number of possible path on the grid,
     * uses dynamic programing.
     *
     * @return number of path
     */
    public int numOfPaths() {
        for (int i = 0; i < _n; i++) {
            _mat[i][0].entry = 1;
        }
        for (int i = 0; i < _m; i++) {
            _mat[0][i].entry = 1;
        }
        for (int i = 1; i < _n; i++) {
            for (int j = 1; j < _m; j++) {
                _mat[i][j].entry = _mat[i - 1][j].entry + _mat[i][j - 1].entry;
            }
        }
        return _mat[_n - 1][_m - 1].entry;
    }

    /**
     * Returns the cheaper path according to the weight (x,y) of every node.
     *
     * @return cheapest path
     */
    public int cheaperPath() {
        for (int i = 1; i < _n; i++) {
            _mat[0][i].val = _mat[0][i - 1].x + _mat[0][i - 1].val;
        }
        for (int i = 1; i < _m; i++) {
            _mat[i][0].val = _mat[i - 1][0].x + _mat[i - 1][0].val;
        }
        for (int i = 1; i < _n; i++) {
            for (int j = 1; j < _m; j++) {
                _mat[i][j].val = Math.min(_mat[i][j - 1].val + _mat[i][j - 1].x, _mat[i - 1][j].val + _mat[i - 1][j].y);
            }
        }


        return 0;
    }

    public static class Node {

        int entry;
        /**
         * wight of this node to x or y direction.
         */
        int x, y;

        int val;

        @Override
        public String toString() {
            return String.format("x=%2d [%d] y=%2d\t", x, val, y);
        }
    }

    public static void main(String[] args) {
        Grid g1 = new Grid(6, 6);
        System.out.println(g1.numOfPaths());
        g1.printGrid();
    }
}
