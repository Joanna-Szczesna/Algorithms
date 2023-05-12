/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj.algorithms;

final class BinarySearch {

    static int findIndex(int[] array, int searchedValue) {
        if (array == null) {
            return -1;
        }
        int low = 0;
        int height = array.length - 1;
        while (low <= height) {
            int middle = (low + height) / 2;
            if (array[middle] == searchedValue) {
                return middle;
            }
            if (array[middle] > searchedValue) {
                height = middle - 1;

            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    static int recursiveFindIndex(int[] array, int searchedValue) {
        if (array == null) {
            return -1;
        }
        if (array.length == 0) {
            return -1;
        }
        return recursiveCase(array, searchedValue, 0, array.length - 1);
    }

    private static int recursiveCase(int[] array, int searchedValue,
                                     int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return array[startIndex] == searchedValue ? startIndex : -1;
        }
        int midIndex = (startIndex + endIndex) / 2;

        if(array[midIndex] == searchedValue){
            return midIndex;
        }
        else if(array[midIndex] > searchedValue){
            return recursiveCase(array, searchedValue, startIndex, midIndex-1);
        }
        else{
            return recursiveCase(array, searchedValue, midIndex+1, endIndex );
        }
    }
    
}
