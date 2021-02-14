package TestPractice;

import java.util.Arrays;

public class GlassBall {

    public static int glass(int balls, int floors) { // O(floors^2 *balls)
        int[][] matrix = new int[balls + 1][floors + 1];
        if (floors == 0 || balls == 0) return 0;

        for (int i = 0; i < balls + 1; i++) { // when i have zero floors
            matrix[i][0] = 0;
            matrix[i][1] = 1;
        }
        for (int i = 0; i < floors + 1; i++) { // when i have zero balls
            matrix[0][i] = 0;
            matrix[1][i] = i;
        }

        int res;
        for (int i = 2; i < balls + 1; i++) {
            for (int j = 2; j < floors + 1; j++) {
                matrix[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    /* case one - one ball break so i should choose floor until this floor(until j)
                     case two - ball did not break so we are looking where to start from this floor
                     to the top in the range(floors - curr floor) */
                    res = 1 + Math.max(matrix[i][k - 1], matrix[i - 1][j - k]);
                    matrix[i][j] = Math.min(res, matrix[i][j]); // take the minimum to choose the optimal
                }
            }
        }
        for (int[] ints : matrix) System.out.println(Arrays.toString(ints));
        return matrix[balls][floors];
    }

    public static void main(String[] args) {
        System.out.println(glass(15, 20));
    }
}
