import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LISTest {

    @Test
    void lengthLIS() {
        double me_avg = 0, gfg_avg = 0;
        int times = 2000;
        for (int i = 0; i < times; i++) {
            int[] a = createArr(1);
            LIS lis = new LIS(a, 20);

            long st = System.currentTimeMillis();
            int me = lis.lengthLIS();
            long et = System.currentTimeMillis();
            long me_time = et - st;
            me_avg += me_time;

            st = System.currentTimeMillis();
            int gfg = GFGLIS.lis(a);
            et = System.currentTimeMillis();
            long gfg_time = et - st;
            gfg_avg += gfg_time;

            assertEquals(gfg, me);
//            System.out.println("i = " + i + (me_time > gfg_time));
        }
        me_avg /= times;
        gfg_avg /= times;
        System.out.println("me_avg = " + me_avg);
        System.out.println("gfg_avg = " + gfg_avg);
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
    public void basicTest() {
        int[] arr = {2, 4, 90, -3, -2, -1, -10, -9, -8};
        LIS lis = new LIS(arr, 5);
//        assertEquals(3, lis.lengthLIS());
//        assertEquals(3, lis.numOfLIS());
        int[][] excepted = {{2, 4, 90}, {-3, -2, -1}, {-10, -9, -8}};
//        assertArrayEquals(excepted, lis.allLIS());

        arr = new int[]{2, -3, 4, 90, -2, -1, -10, -9, -8};
        lis = new LIS(arr, 5);
        System.out.println("lis.numOfLIS() = " + lis.numOfLIS());
        assertEquals(3, lis.lengthLIS());
        excepted = new int[][]{{-3, 4, 90}, {2, 4, 90}, {-3, -2, -1}, {-10, -9, -8}};
//        System.out.println("excepted = " + Arrays.deepToString(lis.allLIS()));
//        assertArrayEquals(excepted, lis.allLIS());
        assertEquals(4, lis.numOfLIS());
        lis.allLIS();
    }

    @Test
    void numOfLIS() {
        int n = 100000;
        Random ran = new Random(3);
        int[] a = new int[n];
        int k = 1000;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5 && i < n; j++, i++) {
                a[i] = ran.nextInt(k) + (k + 20);
            }
            int m = 900;
            for (int j = 0; j < 15 && i < n; j++, i++) {
                a[i] = ran.nextInt(m - 20) + m;
                m -= 30;
            }
        }
//        System.out.println("a = " + Arrays.toString(a));
        LIS lis = new LIS(a, 500);
//        System.out.println(Arrays.deepToString(lis.allLIS()));
        int[][] ints = lis.allLIS();
        for (int[] i : ints) System.out.println(Arrays.toString(i));
    }

    @Test
    void allLIS() {
    }

    @Test
    public void testName() {
        int[] arr5 = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 3, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 3};
        LIS lis = new LIS(arr5, 4);
        System.out.println("lis.lengthLIS() = " + lis.lengthLIS());
        System.out.println("lis.numOfLIS() = " + lis.numOfLIS());
        int[][] ints = lis.allLIS();
        System.out.println("ints = " + Arrays.deepToString(ints));

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