package week13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubArrayTest {

    @Test
    void greedy() {
        int[] a = {1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1};
        assertEquals(2, MaxSubArray.greedy(a));
        a = new int[]{1, 0, 1, 0, 1, 0, 1, 1, 1};
        assertEquals(1, MaxSubArray.greedy(a));
    }

    @Test
    void improvedGreedy() {
        int[] a = {1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1};
        assertEquals(4, MaxSubArray.improvesGreedy(a));
        a = new int[]{1, 0, 1, 0, 1, 0, 1, 1, 1};
        assertEquals(3, MaxSubArray.improvesGreedy(a));
    }

    @Test
    void dynamic() {
        int[] a = {1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1};
        assertEquals(4, MaxSubArray.dynamic(a));
        a = new int[]{1, 0, 1, 0, 1, 0, 1, 1, 1};
        assertEquals(3, MaxSubArray.dynamic(a));
    }


}