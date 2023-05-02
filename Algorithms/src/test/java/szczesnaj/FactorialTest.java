/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void factorialForOne_isOne() {
        long countedFactorial = Factorial.countUpToNineteen(1);

        assertEquals(1, countedFactorial);
    }

    @Test
    void factorialForTwo_isTwo() {
        long countedFactorial = Factorial.countUpToNineteen(2);

        assertEquals(2, countedFactorial);
    }

    @Test
    void factorialForZero_isOne() {
        long countedFactorial = Factorial.countUpToNineteen(0);

        assertEquals(1, countedFactorial);
    }

    @Test
    void factorialForSix_isSevenHundredAndTwenty() {
        long countedFactorial = Factorial.countUpToNineteen(6);

        assertEquals(720, countedFactorial);
    }

    @Test
    void factorialForThirteen_returnCountedValues() {
        long countedFactorial = Factorial.countUpToNineteen(13);

        assertEquals(6227020800L, countedFactorial);
    }

    @Test
    void factorialForTwenty_returnCountedValues() {
        BigInteger countedFactorial = Factorial.countBigInteger(20);

        assertEquals(new BigInteger("2432902008176640000"), countedFactorial);
    }

    @Test
    void forFiveUsingSwitcherFunction_returnOneHundredAndTwentyLongType() {
        Object countedFactorial = Factorial.countFactorial(5);

        assertEquals(120L, countedFactorial);
        assertTrue(countedFactorial instanceof Long);
    }

    @Test
    void forTwentyUsingSwitcherFunction_returnCountedResultBigIntegerType() {
        Object countedFactorial = Factorial.countFactorial(20);

        assertEquals(new BigInteger("2432902008176640000"), countedFactorial);
        assertTrue(countedFactorial instanceof BigInteger);
    }
}