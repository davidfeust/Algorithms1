package week9;

import java.util.Random;

public class Player {

    private final int prob;
    private final char name;
    private boolean isAlive;

    public Player(int prob, char c) {
        this.prob = prob;
        name = c;
        isAlive = true;
    }

    public boolean isHit() {
        Random r = new Random();
        return r.nextInt(100) <= prob;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void kill() {
        isAlive = false;
    }

    public char getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player " + name + '{' +
                "prob=" + prob +
                "isAlive=" + isAlive +
                '}';
    }
}
