import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class TestE {

    @Test
    public void lcsIncrease() {
        int times = 100;
        for (int i = 0; i < times; i++) {
            int[] x = createArr(i);
            int[] y = createArr(i * 2);
//            fail("Not Implemented");
            int lcsIncrease = Q1.lcsIncrease(x, y);
            int lcis = LcsLisGFG.LCIS(x, y);
            System.out.println(Arrays.toString(x) + "\n" + Arrays.toString(y));
            System.out.print("Q1.lcsIncrease(x,y) = " + lcsIncrease);
            System.out.println("\tlcis = " + lcis);
            Assertions.assertEquals(lcsIncrease, lcis);
        }
    }

    private int[] createArr(long seed) {
        Random ran = new Random();
        int n = ran.nextInt(50) + 2;
//        System.out.println(n);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = ran.nextInt(100);// - 100;
        }
        return ans;
    }

}
