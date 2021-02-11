package TestPractice;

import java.util.Arrays;
import java.util.Comparator;

public class HorseCompetition {

    public static int fiveFastest(int[] horse) {
        int count = 0;
        int[][] mat = new int[5][5];
        for (int i = 0; i < 25; i += 5) {
            mat[count] = Arrays.copyOfRange(horse, i, i + 5);
            count = competition(count, mat[count]);
        }
        int[][] winners = {mat[0], mat[1], mat[2], mat[3], mat[4]};
        count = competition(count, winners);
        int[] winners2 = {winners[0][2], winners[0][1], winners[1][0], winners[2][0], winners[3][0]};
        count = competition(count, winners2);

        System.out.printf("1st = %d\n2nd = %d\n3rd = %d\n", winners[0][0], winners2[0], winners2[1]);
        return count;
    }

    private static int competition(int count, int[] h) {
        Arrays.sort(h);
        count++;
        return count;
    }

    private static int competition(int count, int[][] winners) {
        Arrays.sort(winners, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        count++;
        return count;
    }


    public static void main(String[] args) {
        int[] h = {4, 10, 1, 22, 15, 5, 14, 17, 13, 7, 6, 11, 20, 19, 18, 3, 16, 0, 12, 21, 23, 9, 8, 24, 2};
        System.out.println("fiveFastest(h) = " + fiveFastest(h));
    }


}
