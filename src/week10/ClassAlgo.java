package week10;

public class ClassAlgo {

    /**
     * Returns binary String equal to n value
     * only for positive integer
     *
     * @param n positive number
     * @return binary String
     */
    public static String int2bin(int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i > 0; i /= 2) {
            res.insert(0, i % 2);
        }
        return res.toString();
    }

    // O(log(n))

    /**
     * Compute x**n (x^n)
     * @param x value
     * @param n pow
     * @return x^n
     */
    public static int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res *= x;
            }
            x *= x;
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
//        for (int i = -18; i < 18; i++) {
//            System.out.println(int2bin(i) + "\t" + Integer.toBinaryString(i));
//
//        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(pow(i, j) == Math.pow(i, j));
            }
        }
    }
}
