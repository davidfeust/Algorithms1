package week13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubMatrixTest {

    @Test
    void isOnesMat() {
        int[][] a = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        assertTrue(MaxSubMatrix.isOnesMat(a, 0, 3, 0, 3));
        a = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        assertFalse(MaxSubMatrix.isOnesMat(a, 0, 3, 0, 3));
        a = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 1, 1}};
        assertFalse(MaxSubMatrix.isOnesMat(a, 0, 3, 0, 3));
        assertTrue(MaxSubMatrix.isOnesMat(a, 0, 2, 0, 2));
    }

    @Test
    void greedy() {
        int[][] a = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        assertEquals(3, MaxSubMatrix.greedy(a));
        a = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        assertEquals(1, MaxSubMatrix.greedy(a));
        a = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 1, 1}};
        assertEquals(2, MaxSubMatrix.greedy(a));
    }

    @Test
    void improvedGreedy() {
        int[][] a = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        assertEquals(3, MaxSubMatrix.improvedGreedy(a));
        a = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        assertEquals(1, MaxSubMatrix.improvedGreedy(a));
        a = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 1, 1}};
        assertEquals(2, MaxSubMatrix.improvedGreedy(a));
    }

    @Test
    void exhaustiveSearch() {
        int[][] a = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        assertEquals(3, MaxSubMatrix.exhaustiveSearch(a));
        a = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        assertEquals(1, MaxSubMatrix.exhaustiveSearch(a));
        a = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 1, 1}};
        assertEquals(2, MaxSubMatrix.exhaustiveSearch(a));
    }
}