package week9;

import java.util.Arrays;
import java.util.Random;

public class Triathlon {

    private Player[] players;
    private Player A, B, C;
    private Random ran;

    /**
     * init new game
     */
    public Triathlon(int strong, int medium, int weak) {
        ran = new Random();
        A = new Player(strong, 'A');
        B = new Player(medium, 'B');
        C = new Player(weak, 'C');
        players = howFirst(new Player[]{A, B, C});
    }

    /**
     * choose random order of playing
     *
     * @param players array with the Players
     * @return arrays with random order
     */
    public Player[] howFirst(Player[] players) {
        int first = ran.nextInt(3);
        int second;
        do {
            second = ran.nextInt(3);
        } while (second == first);
        int third;
        do {
            third = ran.nextInt(3);
        } while (third == first || third == second);
        return new Player[]{players[first], players[second], players[third]};
    }

    private int howManyAlive() {
        int counter = 0;
        for (Player i : players) {
            if (i.isAlive()) counter++;
        }
        return counter;
    }

    /**
     * Returns the survivor in the game
     *
     * @return the winner Player
     */
    private Player getWinner() {
        for (Player i : players) {
            if (i.isAlive()) return i;
        }
        return null;
    }

    /**
     * Run game, by this strategy:
     * C will hit only if somebody already die, otherwise he will hit the air.
     * A and B will hit the stronger player in their turn.
     *
     * @return the winner Player.
     */
    public Player play() {
        int time = 0;
        while (howManyAlive() > 1) {
            Player t = players[time];
            if (!t.isAlive()) {
                time = ++time % 3;
                continue;
            }
//            System.out.println("play now: " + t);
            switch (t.getName()) {
                case 'A':
                    if (t.isHit()) {
                        if (B.isAlive()) {
                            B.kill();
//                            System.out.println("A killed B");
                        } else if (C.isAlive()) {
                            C.kill();
//                            System.out.println("A killed C");
                        }
                    }
                    break;
                case 'B':
                    if (t.isHit()) {
                        if (A.isAlive()) {
                            A.kill();
//                            System.out.println("B killed A");
                        } else if (C.isAlive()) {
                            C.kill();
//                            System.out.println("B killed C");
                        }
                    } else
//                        System.out.println("B missed");
                        break;
                case 'C':
                    if (howManyAlive() == 2) {
                        if (t.isHit()) {
                            if (A.isAlive()) {
                                A.kill();
//                                System.out.println("C killed A");
                            } else if (B.isAlive()) {
                                B.kill();
//                                System.out.println("C killed B");
                            }
                        } else {
//                            System.out.println("C missed");
                        }
                    } else {
//                        System.out.println("C hit the air");
                    }
                    break;
            }
            time = ++time % 3;
        }
//        System.out.println("The winner is: " + getWinner());
        return getWinner();
    }

    /**
     * Return the associate index:
     * {A, B, C} = {0, 1, 2}
     *
     * @param p Player
     * @return index in [0,1]
     */
    int playerToIndex(Player p) {
        if (p == A) return 0;
        if (p == B) return 1;
        return 2;
    }

    @Override
    public String toString() {
        return "Triathlon{" +
                Arrays.toString(players) +
                '}';
    }
}
