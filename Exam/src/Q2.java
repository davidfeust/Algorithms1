

public class Q2 {

    public static int numOfPaths(Node[][] nodes) {
        int n = nodes.length, m = nodes[0].length;
        nodes[0][0].num = 1;
        nodes[0][0].distance = 0;
        for (int i = 1; i < n; i++) {
            nodes[i][0].num = 1;
            nodes[i][0].distance = nodes[i - 1][0].distance + nodes[i - 1][0].y;
        }
        for (int j = 1; j < m; j++) {
            nodes[0][j].num = 1;
            nodes[0][j].distance = nodes[0][j - 1].distance + nodes[0][j - 1].x;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int x = nodes[i][j - 1].distance + nodes[i][j - 1].x;
                int y = nodes[i - 1][j].distance + nodes[i - 1][j].y;
                if (y < x) {
                    nodes[i][j].distance = nodes[i - 1][j].distance + nodes[i - 1][j].y;
                    nodes[i][j].num = nodes[i - 1][j].num;
                } else if (x < y) {
                    nodes[i][j].distance = nodes[i][j - 1].distance + nodes[i][j - 1].x;
                    nodes[i][j].num = nodes[i][j - 1].num;
                } else {
                    nodes[i][j].distance = nodes[i][j - 1].distance + nodes[i][j - 1].x;
                    nodes[i][j].num = Math.max(nodes[i][j - 1].num, nodes[i - 1][j].num) + 1;
                }
            }
        }
        return nodes[n - 1][m - 1].num;
    }

    public static int numOfPathsPQ(NodePQ[][] nodes, int P, int Q) {
        int n = nodes.length, m = nodes[0].length;
        nodes[0][0].numPQ = 1;
        nodes[0][0].distance = 0;
        for (int i = 1; i < n; i++) {
            nodes[i][0].distance = nodes[i - 1][0].distance + nodes[i - 1][0].y;
            if (i <= Q || P == 0) nodes[i][0].numPQ = 1;
            else nodes[i][0].numPQ = 0;
        }
        for (int j = 1; j < m; j++) {
            nodes[0][j].distance = nodes[0][j - 1].distance + nodes[0][j - 1].x;
            if (j <= P || Q == 0) nodes[0][j].numPQ = 1;
            else nodes[0][j].numPQ = 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int x = nodes[i][j - 1].distance + nodes[i][j - 1].x;
                int y = nodes[i - 1][j].distance + nodes[i - 1][j].y;
                boolean flag = (i <= Q && j <= P) || (i >= Q && j >= P);
                if (y < x) {
                    nodes[i][j].distance = nodes[i - 1][j].distance + nodes[i - 1][j].y;
                    if (flag) nodes[i][j].numPQ = nodes[i - 1][j].numPQ;
                    else nodes[i][j].numPQ = 0;
                } else if (x < y) {
                    nodes[i][j].distance = nodes[i][j - 1].distance + nodes[i][j - 1].x;
                    if (flag) nodes[i][j].numPQ = nodes[i][j - 1].numPQ;
                    else nodes[i][j].numPQ = 0;
                } else {
                    nodes[i][j].distance = nodes[i][j - 1].distance + nodes[i][j - 1].x;
                    if (flag) nodes[i][j].numPQ = Math.max(nodes[i][j - 1].numPQ, nodes[i - 1][j].numPQ) + 1;
                    else nodes[i][j].numPQ = 0;
                }
            }
        }
        return nodes[n - 1][m - 1].numPQ;
    }

}
