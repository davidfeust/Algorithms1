package week9;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TriathlonSimulate {

    /**
     * Run the game multi times.
     *
     * @param times how many times to run
     * @return Array with the winning probabilities of each player, according to their index.
     */
    public static double[] simulate(int times, int strong, int medium, int weak) {
        double[] wins = new double[3];
        for (int i = 0; i < times; i++) {
            Triathlon game = new Triathlon(strong, medium, weak);
            wins[game.playerToIndex(game.play())]++;
        }
        for (int i = 0; i < wins.length; i++) {
            wins[i] /= times;
        }
        return wins;
    }

    /**
     * test how weak the weaker can be
     */
    @Test
    public void test1() {
        int times = 100;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 80; j++) {
                for (int k = 50; k < 100; k++) {
                    double[] t1 = simulate(times, 100 - k, 80 - j, 50 - i);
                    double max = Arrays.stream(t1).max().getAsDouble();
                    if (max == t1[2])
                        System.out.printf("(i, j, k) = (%d, %d, %d) : %s%n", i, j, k, Arrays.toString(t1));
                }
            }
        }
    }


    public static void main(String[] args) {
        int times = 1000000;
        double[] t1 = simulate(times, 100, 80, 50);
        System.out.println(Arrays.toString(t1));
        double[] t2 = simulate(times, 80, 60, 10);
        System.out.println(Arrays.toString(t2));
        double[] t3 = simulate(times, 100, 80, 60);
        System.out.println(Arrays.toString(t3));


    }
}