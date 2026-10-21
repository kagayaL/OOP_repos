package ru.nsu.kagaya.Task_1_1_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    void sort_simple() {
        int[] array = new int []{1, 3, 5, 2};
        var result = Sort.sort(array);
        assertArrayEquals(new int []{1, 2, 3, 5}, result);
    }

    @Test
    void sort_empty() {
        int[]array = new int[]{};
        var res = Sort.sort(array);
        assertArrayEquals(new int[]{}, res);
    }

    @Test
    void sort_expensive() {
        int[]arr = new int []{Integer.MAX_VALUE, -5, 10, Integer.MIN_VALUE};
        var res = Sort.sort(arr);
        assertArrayEquals(new int[]{Integer.MIN_VALUE, -5, 10, Integer.MAX_VALUE}, res);
    }

    @Test
    void sort_sorted() {
        int[]arr = new int []{-3, -1, 10, 17};
        var res = Sort.sort(arr);
        assertArrayEquals(new int []{-3, -1, 10, 17}, res);
    }
}