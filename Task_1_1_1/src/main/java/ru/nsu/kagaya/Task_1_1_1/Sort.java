package ru.nsu.kagaya.Task_1_1_1;

/**
 * Class for HeapSort
 */
public class Sort {

    private static void sift_down(int[] array, int ind, int len) {
        int left = ind * 2 + 1; //левый сын
        int right = ind * 2 + 2; //правый сын
        int newind = ind;
        if (left < len && array[newind] < array[left]) {
            newind = left;
        }
        if (right < len && array[newind] < array[right]) {
            newind = right;
        }
        if (ind != newind) {
            swap(ind, newind, array);
            sift_down(array, newind, len);
        }

    }

    private static void swap(int ind1, int ind2, int[] array) { //function for swap
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }

    /**
     * Sort array using HeapSort
     * @param array the array to be sorted
     * @return the sorted array
     */
    public static int[] sort(int[] array) {
        int len = array.length;
        for (int i = len - 1; i >= 0; i--) {
            sift_down(array, i, len); //create heap
        }
        for (int i = 0; i < len; i++) {
            swap(0, len - i - 1, array);
            sift_down(array, 0, len - i - 1);
        }
        return array;
    }
}
