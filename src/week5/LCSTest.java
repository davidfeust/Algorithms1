package week5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCSTest {

    @Test
    void greedy1() {
        assertEquals(LCS.greedy1("bdcaba", "abcbdab"), "bdab");
        assertEquals(LCS.greedy1("abcbdab", "bdcaba"), "bdab");
    }

    @Test
    void greedy2() {
        assertEquals(LCS.greedy2("abcabbde", "bdfe"), "bde");
        assertEquals(LCS.greedy2("bdfe", "abcabbde"), "bde");
    }
    @Test
    void plus1() {
        int[] a = {0, 0, 0, 1, 1, 1, 1};
        LCS.plus1(a);
//        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, new int[] {0, 0, 1, 0, 0, 0, 0});
    }

    @Test
    void allSubStrings() {
        String[] a = LCS.allSubStrings("abc");
//        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, new String[] {"c", "b", "bc", "a", "ac", "ab", "abc"});
        a = LCS.allSubStrings("4321");
//        System.out.println(Arrays.toString(a));
        assertArrayEquals(a, new String[]
                {"1", "2", "21", "3", "31", "32", "321", "4", "41", "42", "421", "43", "431", "432", "4321"});
    }

    @Test
    void checkCommon() {
        assertEquals(LCS.checkCommon("bdaba", "abcbdab"), "");
        assertEquals(LCS.checkCommon("bdab", "abcbdab"), "bdab");
    }

    @Test
    void fullSearch() {
        assertTrue(LCS.fullSearch("AGGTAB", "GXTXAYB").contains("GTAB"));
    }
}