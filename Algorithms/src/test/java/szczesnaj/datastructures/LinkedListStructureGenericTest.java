/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListStructureGenericTest {
    private LinkedListStructureGeneric<Integer> listStructure;

    @BeforeEach
    void setUp() {
        listStructure = new LinkedListStructureGeneric<>();
    }

    @Test
    void givenListIsEmpty_whenUserAddFirstElement_newElementExistOnList() {
        Integer expectedNumber = 5;
        listStructure.addOnStart(expectedNumber);
        String number = listStructure.getAllNumbers();

        assertEquals("5", number);
    }

    @Test
    void givenListHasOneElement_whenUserAddElementOnStart_addedElementIsNewHead() {
        listStructure.addOnStart(1);
        Integer newHead = 2;
        listStructure.addOnStart(newHead);
        String number = listStructure.getAllNumbers();

        assertEquals("2, 1", number);
    }

    @Test
    void whenUserAddElementOnEnd_addedElementExistAsLast() {
        listStructure.addOnEnd(1);
        Integer expectedNumber = 2;
        listStructure.addOnEnd(expectedNumber);
        String number = listStructure.getAllNumbers();

        assertEquals("1, 2", number);
    }

    @Test
    void whenUserShowAllElement_addedElementsExist() {
        int[] numbers = {1, 2, 3, 4};
        for (int n : numbers) {
            listStructure.addOnEnd(n);
        }
        String elements = listStructure.getAllNumbers();

        assertThat(elements).contains("1");
        assertThat(elements).contains("2");
        assertThat(elements).contains("3");
        assertThat(elements).contains("4");
    }

    @Test
    void whenUserRemoveHead_previousNextIsNewHead() {
        int[] numbers = {1, 2, 3, 4};
        for (int n : numbers) {
            listStructure.addOnEnd(n);
        }
        listStructure.removeHead();
        String elements = listStructure.getAllNumbers();

        assertEquals("2, 3, 4", elements);
    }

    @Test
    void givenListHasOneElement_whenUserRemoveTailRecursion_noElementsInList() {
        int[] numbers = {1};
        for (int n : numbers) {
            listStructure.addOnEnd(n);
        }
        listStructure.removeTailRecursion();
        String elements = listStructure.getAllNumbers();

        assertThat(elements).doesNotContain("1");
    }

    @Test
    void whenUserRemoveTailRecursion_listDoesNotContainLastNumber() {
        int[] numbers = {1, 2, 3};
        for (int n : numbers) {
            listStructure.addOnEnd(n);
        }
        listStructure.removeTailRecursion();
        String elements = listStructure.getAllNumbers();

        assertThat(elements).contains("1");
        assertThat(elements).contains("2");
        assertThat(elements).doesNotContain("3");
        assertEquals("1, 2", elements);
    }

    @Test
    void givenListHasOneElement_whenUserRemoveTail_noElementsInList() {
        int[] numbers = {1};
        for (int n : numbers) {
            listStructure.addOnEnd(n);
        }
        listStructure.removeTail();
        String elements = listStructure.getAllNumbers();

        assertThat(elements).doesNotContain("1");
    }

    @Test
    void whenUserRemoveTail_listDoesNotContainLastNumber() {
        int[] numbers = {1, 2, 3};
        for (int n : numbers) {
            listStructure.addOnEnd(n);
        }
        listStructure.removeTail();
        String elements = listStructure.getAllNumbers();

        assertThat(elements).contains("1");
        assertThat(elements).contains("2");
        assertThat(elements).doesNotContain("3");
        assertEquals("1, 2", elements);
    }

    @Test
    void givenListIsEmpty_whenUserRemoveTail_noElementsInList() {
        listStructure.removeTail();
        String elements = listStructure.getAllNumbers();

        assertEquals("", elements);
    }
}