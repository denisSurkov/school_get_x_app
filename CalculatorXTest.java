package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorXTest {

    @Test
    public void getRoots() {
        CalculatorX testCalc = new CalculatorX();

        testCalc.setA(1);

        testCalc.setB(7);
        testCalc.setC(6);
        double[] res = {-1d, -6d};
        assertArrayEquals(testCalc.getRoots(), res, 0.1);

        testCalc.setB(3);
        testCalc.setC(-54);
        double[] res1 = {6d, -9d};
        assertArrayEquals(testCalc.getRoots(), res1, 0.1);

        testCalc.setB(-7);
        testCalc.setC(-18);
        double[] res2 = {9d, -2d};
        assertArrayEquals(testCalc.getRoots(), res2, 0.1);

        testCalc.setB(4);
        testCalc.setC(-45);
        double[] res3 = {5d, -9d};
        assertArrayEquals(testCalc.getRoots(), res3, 0.1);


        testCalc.setB(-4);
        testCalc.setC(-5);
        double[] res4 = {5d, -1d};
        assertArrayEquals(testCalc.getRoots(), res4, 0.1);

        testCalc.setB(3);
        testCalc.setC(2);
        double[] res5 = {-1d, -2d};
        assertArrayEquals(testCalc.getRoots(), res5, 0.1);

        testCalc.setB(3);
        testCalc.setC(-70);
        double[] res6 = {7d, -10d};
        assertArrayEquals(testCalc.getRoots(), res6, 0.1);

        testCalc.setB(-5);
        testCalc.setC(4);
        double[] res7 = {4d, 1d};
        assertArrayEquals(testCalc.getRoots(), res7, 0.1);
    }
}