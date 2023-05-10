/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj.dataStructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListStructureTest {
    private LinkedListStructure listStructure;

    @BeforeEach
    void setUp() {
        listStructure = new LinkedListStructure();
    }

    @Test
    void whenUserAddElementOnStart_newElementExistAsHead() {
        Integer expectedNumber = 5;
        listStructure.addOnStart(expectedNumber);
        Integer number = listStructure.getList().getNumber();

        assertEquals(expectedNumber, number);
    }

    @Test
    void whenUserAddElementOnEndAnHeadNotExist_addedElementIsNewHead() {
        Integer expectedNumber = 5;
        listStructure.addOnEnd(expectedNumber);
        Integer number = listStructure.getList().getNumber();

        assertEquals(expectedNumber, number);
    }

    @Test
    void whenUserAddElementOnEndHeadExist_addedElementExistAsLatestNext() {
        Integer expectedNumber = 5;
        listStructure.addOnEnd(1);
        listStructure.addOnEnd(expectedNumber);
        Integer number = listStructure
                .getList()
                .getNext().getNumber();

        assertEquals(expectedNumber, number);
    }

    @Test
    void whenUserShowAllElement_addedElementExist() {
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
        Integer newHeadNum = listStructure.getList().getNumber();

        assertEquals(2, newHeadNum);
    }

    @Test
    void whenUserRemoveTailThatIsAlsoHeadRecursion_noElements() {
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
    }

    @Test
    void whenUserRemoveTailThatIsAlsoHead_nextNumIsNull() {
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
    }
}
