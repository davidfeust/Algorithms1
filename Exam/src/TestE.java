import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestE {

    @Test
    public void lcsIncrease() {
        int times = 10;
        for (int i = 0; i < times; i++) {
            int[] x = createArr(3);
            int[] y = createArr(6);
            System.out.println("Q1.lcsIncrease(x,y) = " + Q1.lcsIncrease(x, y));
//            fail("Not Implemented");
        }
    }

    private int[] createArr(long seed) {
        Random ran = new Random(seed);
        int n = ran.nextInt(100) + 2;
        System.out.println(n);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = ran.nextInt(400) - 100;
        }
        return ans;
    }

}
