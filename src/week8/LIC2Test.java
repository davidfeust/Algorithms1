package week8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LIC2Test {

    @Test
    void bestGreedy() {
        int[] arr = new int[]{1, 100, 101, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr));
        System.out.println(LIC2.LISLength(arr));

    }

}