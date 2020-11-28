package week6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCS2Test {

    @Test
    void dynamicProgramming() {
        DP_LCS dp = new DP_LCS();
        dp.setStrings("abcbdab", "bdcaba");
        System.out.println(dp.length());
        System.out.println(dp.getOneOf());
        System.out.println(dp.getAllOf());
        System.out.println(dp.amountOfAllOf());
    }
}