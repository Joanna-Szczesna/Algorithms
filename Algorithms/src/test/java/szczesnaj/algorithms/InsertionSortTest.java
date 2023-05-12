/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj.algorithms;

import org.junit.jupiter.api.Test;
import szczesnaj.algorithms.InsertionSort;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {


    @Test
    void oneElementArray_returnArray() {
        int[] arr = {1};
        int[] expectedArr = {1};
        int[] sortedArr = InsertionSort.sort(arr);

        assertArrayEquals(expectedArr, sortedArr);
    }

    @Test
    void unsortedTwoElementsArray_returnSortedArray() {
        int[] unsortedArr = {2, 1};
        int[] expectedArr = {1, 2};
        int[] sortedArr = InsertionSort.sort(unsortedArr);

        assertArrayEquals(expectedArr, sortedArr);
    }

    @Test
    void nullableArray_returnNull() {
        int[] arr = null;
        int[] sortedArr = InsertionSort.sort(arr);

        assertArrayEquals(null, sortedArr);
    }

    @Test
    void unsortedFourElementsArray_returnSortedArray() {
        int[] unsortedArr = {2, 1, 5, -6};
        int[] expectedArr = {-6, 1, 2, 5};

        int[] sortedArr = InsertionSort.sort(unsortedArr);

        assertArrayEquals(expectedArr, sortedArr);
    }
}