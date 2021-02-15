import java.util.Arrays;
import java.util.Stack;

public class MaxRectangle {

    public static int maxRectangle(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] h = new int[m];
        int ans = 0;
        Arrays.fill(h, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) h[j]++;
                else h[j] = 0;
            }
            System.out.println(Arrays.toString(h));
            ans = Math.max(ans, getMaxArea(h));
        }
        return ans;
    }

    private static int getMaxArea(int[] h) {
        int n = h.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0, tp = 0, areaWithTop = 0, i = 0;
        while (i < n) {
            if (st.isEmpty() || h[st.peek()] <= h[i]) st.push(i++);
            else {
                tp = st.pop();
                areaWithTop = h[tp] * (st.isEmpty() ? i : i - st.peek() - 1);
                if (maxArea < areaWithTop) maxArea = areaWithTop;
            }
        }
        while (!st.isEmpty()) {
            tp = st.pop();
            areaWithTop = h[tp] * (st.isEmpty() ? i : i - st.peek() - 1);
            if (maxArea < areaWithTop) maxArea = areaWithTop;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0, 1, 1, 1},
                {1, 0, 1, 1, 0, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1},
        };
        System.out.println("maxRectangle(mat) = " + maxRectangle(mat));
    }
}
