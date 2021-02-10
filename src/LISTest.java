import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LISTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void lengthLIS() {
        int[] arr = {2, 4, 90, -3, -2, -1, -10, -9, -8};
        LISAsg lis = new LISAsg(arr, 1);
        assertEquals(lis.lengthLIS(), 3);
        arr = new int[]{2, -3, 4, 90, -2, -1, -10, -9, -8};
        lis = new LISAsg(arr, 1);
        assertEquals(lis.lengthLIS(), 3);
        arr = new int[]{5, 2, 9, 7, 8, 5, 3, 2, 1, 10, 6};
        lis = new LISAsg(arr, 1);
        assertEquals(lis.lengthLIS(), 4);

    }


    @Test
    void numOfLIS() {
    }

    @Test
    void allLIS() {
    }
}