/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuclideanAlgorithmTest {


    @Test
    void forZeroAndZero_returnZero() {
        int gcd = EuclideanAlgorithm.countGreatestCommonDivisor(0, 0);

        assertEquals(0, gcd);
    }

    @Test
    void whenOnlyFirstNumberIsZero_returnNoneZeroValue() {
        int gcd = EuclideanAlgorithm.countGreatestCommonDivisor(0, 5);

        assertEquals(5, gcd);
    }

    @Test
    void whenSecondNumberIsZero_returnNoneZeroValue() {
        int gcd = EuclideanAlgorithm.countGreatestCommonDivisor(6, 0);

        assertEquals(6, gcd);
    }

    @Test
    void forHundredAndForEight_returnFour() {
        int gcd = EuclideanAlgorithm.countGreatestCommonDivisor(100, 8);

        assertEquals(4, gcd);
    }

    @Test
    void forSeventyTwoAndForTwoHundredSeventyFour_returnTwo() {
        int gcd = EuclideanAlgorithm.countGreatestCommonDivisor(72, 274);

        assertEquals(2, gcd);
    }
}