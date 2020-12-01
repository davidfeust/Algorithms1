package week7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LISTest {

    public static int[] arrays_creator(int seed) {
        Random _ran = new Random(seed);
        int n = 10;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = _ran.nextInt(15);
        }
        return res;
    }

    @Test
    public void greedy() {
        int[] arr1 = arrays_creator(1);
        System.out.println(Arrays.toString(arr1));
        assertArrayEquals(new int[] {0,13,14,14}, LIS.greedy(arr1));
    }


}