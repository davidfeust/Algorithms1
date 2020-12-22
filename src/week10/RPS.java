package week10;

import java.util.Random;

/**
 * Algo for Rock, Paper, Scissors game
 * Rock: 0
 * Paper: 1
 * Scissors: 2
 */
public class RPS {

    /**
     * Returns the number of the winner player
     *
     * @param p1 player 1 choice
     * @param p2 player 2 choice
     * @return the number of the winner or -1 for tie
     */
    public static int win(int p1, int p2) {
        if ((p1 + 1) % 3 == p2) {
            return 2;
        } else if (p1 == p2) {
            return -1;
        }
        return 1;
    }

    /**
     * Both of the players choose randomly
     *
     * @param times times to run the game
     * @return how many time player 2 won
     */
    public static int random(int times) {
        Random ran = new Random();
        int counter = 0;
        for (int i = 0; i < times; i++) {
            int p1 = ran.nextInt(3);
            int p2 = ran.nextInt(3);
            if (win(p1, p2) == 2) {
                counter++;
            }
        }
        return counter;
    }

    public static int chooseTheLast(int times) {
        Random ran = new Random();
        int counter = 0;

        int p1 = ran.nextInt(3);
        int p2 = ran.nextInt(3);
        if (win(p1, p2) == 2) {
            counter++;
        }

        for (int i = 1; i < times; i++) {
            int lastP1 = p1;
            p1 = ran.nextInt(3);
            p2 = lastP1;
            if (win(p1, p2) == 2) {
                counter++;
            }
        }
        return counter;
    }

    public static int constChoose(int times) {
        Random ran = new Random();
        int counter = 0;

        for (int i = 1; i < times; i++) {
            int p1 = ran.nextInt(3);
            int p2 = 0;
            if (win(p1, p2) == 2) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int times = 10000000;
        System.out.println((double) random(times)/times);
        System.out.println((double) chooseTheLast(times)/times);
        System.out.println((double) constChoose(times)/times);

    }
}
