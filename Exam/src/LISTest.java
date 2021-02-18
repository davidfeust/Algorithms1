import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LISTest {

    @Test
    void lengthLIS() {
        for (int i = 0; i < 200; i++) {
            int[] a = createArr(1);
            LIS lis = new LIS(a, 20);
            assertEquals(lis.lengthLIS(), GFGLIS.lis(a));
//            System.out.println("i = " + i);
        }
    }

    @Test
    void big() {
        int n = 100000000;
        int[] a = new int[n];
        Random ran = new Random(0);
        for (int i = 0; i < n; i++) {
            a[i] = ran.nextInt();
        }
        LIS lis = new LIS(a, 10);
        long st = System.currentTimeMillis();
        lis.lengthLIS();
        long et = System.currentTimeMillis();
        System.out.println("et - st = " + (et - st));
    }

    @Test
    void numOfLIS() {
    }

    @Test
    void allLIS() {
    }

    private int[] createArr() {
        Random ran = new Random();
        return createArr(ran);
    }

    private int[] createArr(long seed) {
        Random ran = new Random(seed);
        return createArr(ran);
    }

    private int[] createArr(Random ran) {
        int bound = 100000;
        int n = ran.nextInt(bound) + 2;
//        System.out.println(n);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = ran.nextInt(bound * 2);// - 100;
        }
        return ans;
    }

}