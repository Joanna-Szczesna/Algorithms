/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj;

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
}
