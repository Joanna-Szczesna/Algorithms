/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    @Test
    void emptyArray_returnArray() {
        int[] arr = {};
        int[] expectedArr = new int[]{};
        int[] sortedArr = BubbleSort.sort(arr);

        assertArrayEquals(expectedArr, sortedArr);
    }

    @Test
    void twoElementArray_returnSortedArray() {
        int[] unsortedArr = {2, 1};
        int[] expectedArr = {1, 2};
        int[] sortedArr = BubbleSort.sort(unsortedArr);

        assertArrayEquals(expectedArr, sortedArr);
    }

    @Test
    void nullableArray_returnNull() {
        int[] arr = null;
        int[] sortedArr = BubbleSort.sort(arr);

        assertArrayEquals(null, sortedArr);
    }

    @Test
    void sevenElementsArray_returnSortedArray() {
        int[] unsortedArr = {7, 6, 5, 4, 3, 2, 1};
        int[] expectedArr = {1, 2, 3, 4, 5, 6, 7};
        int[] sortedArr = BubbleSort.sort(unsortedArr);

        assertArrayEquals(expectedArr, sortedArr);
    }
}