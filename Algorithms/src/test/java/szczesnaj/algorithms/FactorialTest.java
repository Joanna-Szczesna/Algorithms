/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import szczesnaj.algorithms.Factorial;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    @DisplayName("0! = 1")
    void factorialForOne_isOne() {
        long countedFactorial = Factorial.countUpToNineteen(1);

        assertEquals(1, countedFactorial);
    }

    @Test
    @DisplayName("2! = 2")
    void factorialForTwo_isTwo() {
        long countedFactorial = Factorial.countUpToNineteen(2);

        assertEquals(2, countedFactorial);
    }

    @Test
    @DisplayName("0! = 1")
    void factorialForZero_isOne() {
        long countedFactorial = Factorial.countUpToNineteen(0);

        assertEquals(1, countedFactorial);
    }

    @Test
    @DisplayName("6! = 720")
    void factorialForSix_isSevenHundredAndTwenty() {
        long countedFactorial = Factorial.countUpToNineteen(6);

        assertEquals(720, countedFactorial);
    }

    @Test
    @DisplayName("13! = 6227020800")
    void factorialForThirteen_returnCountedValues() {
        long countedFactorial = Factorial.countUpToNineteen(13);

        assertEquals(6227020800L, countedFactorial);
    }

    @Test
    @DisplayName("20! = 2432902008176640000")
    void factorialForTwenty_returnCountedValues() {
        BigInteger countedFactorial = Factorial.countBigInteger(20);

        assertEquals(new BigInteger("2432902008176640000"), countedFactorial);
    }

    @Test
    @DisplayName("5! = 120L")
    void forFiveUsingSwitcherFunction_returnOneHundredAndTwentyLongType() {
        Object countedFactorial = Factorial.countFactorial(5);

        assertEquals(120L, countedFactorial);
        assertTrue(countedFactorial instanceof Long);
    }

    @Test
    @DisplayName("20! = 2432902008176640000 BigInteger")
    void forTwentyUsingSwitcherFunction_returnCountedResultBigIntegerType() {
        Object countedFactorial = Factorial.countFactorial(20);

        assertEquals(new BigInteger("2432902008176640000"), countedFactorial);
        assertTrue(countedFactorial instanceof BigInteger);
    }
}