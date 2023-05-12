/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj.algorithms;


import java.math.BigInteger;

class Factorial {
    static long countUpToNineteen(int number) {
        if (number == 1 || number == 0) {
            return 1;
        }
        return number * countUpToNineteen(number - 1);
    }

    static BigInteger countBigInteger(int number) {
        BigInteger convNum = BigInteger.valueOf(number);
        return countFactorialBigInteger(convNum);
    }


    private static BigInteger countFactorialBigInteger(BigInteger num) {
        if (num.equals(BigInteger.ONE) || num.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return num.multiply(countFactorialBigInteger(num.subtract(BigInteger.ONE)));
    }

    static Object countFactorial(int num) {
        if (num <= 19) {
            return countUpToNineteen(num);
        }
        return countBigInteger(num);
    }
}
