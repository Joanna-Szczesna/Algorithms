/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj.algorithms;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Nested
    class Loop {
        @Test
        void emptyArray_returnMinusOne() {
            int[] emptyArray = {};
            int searchedValue = 5;
            int index = BinarySearch.findIndex(emptyArray, searchedValue);

            assertEquals(-1, index);
        }

        @Test
        void arrayWithOneElementEqualSearchedValue_returnZero() {
            int value = 5;
            int[] oneElementArray = {value};
            int index = BinarySearch.findIndex(oneElementArray, value);

            assertEquals(0, index);
        }

        @Test
        void arrayWithOneElementNotEqualSearchedValue_returnMinusOne() {
            int[] oneElementArray = {1};
            int index = BinarySearch.findIndex(oneElementArray, 5);

            assertEquals(-1, index);
        }

        @Test
        void arrayNotInitialized_returnMinusOne() {
            int[] nullableArray = null;
            int index = BinarySearch.findIndex(nullableArray, 5);

            assertEquals(-1, index);
        }

        @Test
        void arrayWithSeveralElementOneElementMiddleEqualSearchedValue_returnIndexSearchedElement() {
            int searchedValue = 5;
            int[] array = {1, 3, searchedValue, 6, 12, 15};
            int index = BinarySearch.findIndex(array, searchedValue);

            assertEquals(2, index);
        }

        @Test
        void arrayWithSeveralElementOneElementNoOnMiddleEqualSearchedValue_returnIndexSearchedElement() {
            int searchedValue = 5;
            int[] array = {1, 3, 4, searchedValue, 6, 12, 15, 25, 26, 27, 29, 37};
            int index = BinarySearch.findIndex(array, searchedValue);

            assertEquals(3, index);
        }
    }

    @Nested
    class Recursive {
        @Test
        void emptyArray_returnMinusOne() {
            int[] emptyArray = {};
            int searchedValue = 5;
            int index = BinarySearch.recursiveFindIndex(emptyArray, searchedValue);

            assertEquals(-1, index);
        }

        @Test
        void arrayWithOneElementEqualSearchedValue_returnZero() {
            int value = 5;
            int[] oneElementArray = {value};
            int index = BinarySearch.recursiveFindIndex(oneElementArray, value);

            assertEquals(0, index);
        }

        @Test
        void arrayWithOneElementNotEqualSearchedValue_returnMinusOne() {
            int[] oneElementArray = {1};
            int index = BinarySearch.recursiveFindIndex(oneElementArray, 5);

            assertEquals(-1, index);
        }

        @Test
        void arrayNotInitialized_returnMinusOne() {
            int[] nullableArray = null;
            int index = BinarySearch.recursiveFindIndex(nullableArray, 5);

            assertEquals(-1, index);
        }

        @Test
        void arrayWithSeveralElementOneElementMiddleEqualSearchedValue_returnIndexSearchedElement() {
            int searchedValue = 5;
            int[] array = {1, 3, searchedValue, 6, 12, 15};
            int index = BinarySearch.recursiveFindIndex(array, searchedValue);

            assertEquals(2, index);
        }
        @Test
        void arrayWithSeveralElementOneElementNoOnMiddleEqualSearchedValue_returnIndexSearchedElement() {
            int searchedValue = 5;
            int[] array = {1, 3, 4, searchedValue, 6, 12, 15, 25, 26, 27, 29, 37};
            int index = BinarySearch.recursiveFindIndex(array, searchedValue);

            assertEquals(3, index);
        }
    }
}