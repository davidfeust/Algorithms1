package week9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for Plane Problem
 * Uses {@link Grid} ad data structure.
 */
class PlanProblem {

    @Test
    void numOfPaths() {
        Grid g1 = new Grid(5,5);
        assertEquals(252, g1.numOfPaths());
        g1.printGrid();
    }

    @Test
    void text() {
        Grid g = new Grid(3,3);
        g.mat()[0][0].x = 1;
        g.mat()[0][0].y = 10;
        g.mat()[1][0].x = 7;
        g.mat()[1][0].y = 2;
        g.mat()[2][0].x = 3;
        g.mat()[2][0].y = 2;

        g.mat()[0][1].x = 1;
        g.mat()[0][1].y = 3;
        g.mat()[1][1].x = 5;
        g.mat()[1][1].y = 4;
        g.mat()[2][1].x = 1;
        g.mat()[2][1].y = 2;

        g.mat()[0][2].x = 2;
        g.mat()[0][2].y = 2;
        g.mat()[1][2].x = 6;
        g.mat()[1][2].y = 7;
        g.mat()[2][2].x = 4;
        g.mat()[2][2].y = 8;

        g.mat()[0][3].y = 0;
        g.mat()[1][3].y = 5;
        g.mat()[2][3].y = 1;
        g.mat()[3][0].y = 4;
        g.mat()[3][1].x = 2;
        g.mat()[3][2].y = 5;

        g.cheaperPath();
        g.printGrid();
    }


}