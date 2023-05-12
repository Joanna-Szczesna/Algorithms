/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj.algorithms;

class BubbleSort {

    static int[] sort(int[] arr) {
        if (arr == null) {
            return arr;
        }
        for (int j = 0; j <= arr.length - 2; j++) {
            for (int i = 0; i <= arr.length - 2; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr;
    }
}
