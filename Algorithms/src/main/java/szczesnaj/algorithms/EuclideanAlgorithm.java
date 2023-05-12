/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj.algorithms;


class EuclideanAlgorithm {

    static int countGreatestCommonDivisor(int first, int second) {
        if (first == 0) {
            return second;
        }
        if (second == 0) {
            return first;
        }

        return recursiveCaseEuclidean(first, second);
    }

    private static int recursiveCaseEuclidean(int first, int second) {

        if (first == second) {
            return first;
        }

        int result = first % second;
        if (result == 0) {
            return second;
        }
        return recursiveCaseEuclidean(second, result);
    }
}
