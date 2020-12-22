package week1.moodel;

public class MCoins {

    /**
     * method returns 0 or 1 randomly
     */
    public static int CoinFlips() {
        long result = 0;
        result = Math.round(Math.random());
        return (int) result;
    }

    /**
     * method returns result of Alice
     */
    public static int AliceGame() {
        return CoinFlips();
    }

    /**
     * method returns result of Bob
     */
    public static int BobGame() {
        return CoinFlips();
    }

    /**
     * game strategy 1:
     * Alice calls a random number
     *
     * @return true if won
     */
    public static boolean GameStrategy1() {
        boolean result = false;
        int AliceResult = AliceGame();
        if (AliceResult > 0)
            result = true;
        return result;
    }

    /**
     * game strategy 2:
     * Alice calls 1 and Bob calls 1
     *
     * @return true if won
     */
    public static boolean GameStrategy2() {
        boolean result = false;
        int AliceResult = AliceGame();
        int BobResult = BobGame();
        if ((AliceResult == 1) || (BobResult == 1))
            result = true;
        return result;
    }

    /**
     * game strategy 2a:
     * Alice calls 0 and Bob calls 0
     *
     * @return true if won
     */
    public static boolean GameStrategy2A() {
        boolean result = false;
        int AliceResult = AliceGame();
        int BobResult = BobGame();
        if ((AliceResult == 0) || (BobResult == 0))
            result = true;
        return result;
    }

    /**
     * game strategy 3:
     * Everyone says that he (she) received
     *
     * @return true if won
     */
    public static boolean GameStrategy3() {
        boolean result = false;
        int AliceResult = AliceGame();
        int BobResult = BobGame();
        if (AliceResult == BobResult)
            result = true;
        return result;
    }

    /**
     * game strategy 4:
     * Alice calls that she got, and Bob calls the opposite
     * of what he received
     *
     * @return true if won
     */
    public static boolean GameStrategy4() {
        boolean result = false;
        int AliceResult = AliceGame();
        int BobResult = BobGame();
        if ((AliceResult == BobResult) || (BobResult == 1 - AliceResult))
            result = true;
        return result;
    }

    public static void main(String[] args) {
        int count = 10000000;
        int GameStrategy1 = 0;
        int GameStrategy2 = 0;
        int GameStrategy2A = 0;
        int GameStrategy3 = 0;
        int GameStrategy4 = 0;
        boolean result1 = false;
        boolean result2 = false;
        boolean result2A = false;
        boolean result3 = false;
        boolean result4 = false;
        for (int i = 0; i < count; i++) {
            result1 = GameStrategy1();
            if (result1)
                GameStrategy1++;
            result2 = GameStrategy2();
            if (result2)
                GameStrategy2++;
            result2A = GameStrategy2A();
            if (result2A)
                GameStrategy2A++;
            result3 = GameStrategy3();
            if (result3)
                GameStrategy3++;
            result4 = GameStrategy4();
            if (result4)
                GameStrategy4++;
        }
        System.out.println("Alice & Bob game : Strategy1 probability = " +
                (double) GameStrategy1 / (double) count);
        System.out.println("Alice & Bob game : Strategy2 probability = " +
                (double) GameStrategy2 / (double) count);
        System.out.println("Alice & Bob game : Strategy2A probability = " +
                (double) GameStrategy2A / (double) count);
        System.out.println("Alice & Bob game : Strategy3 probability = " +
                (double) GameStrategy3 / (double) count);
        System.out.println("Alice & Bob game : Strategy4 probability = " +
                (double) GameStrategy4 / (double) count);
    }
}
