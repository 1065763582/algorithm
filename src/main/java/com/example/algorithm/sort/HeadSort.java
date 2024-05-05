package com.example.algorithm.sort;

import com.example.algorithm.array.ArrayFactory;

import java.util.Arrays;

/**
 * @author lzq
 * @date 2024年05月05日 10:23
 */
public class HeadSort {

    public static void sort(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            buildHeap(arr, i);
            swap(arr, 0, i);
        }
    }

    public static void buildHeap(int[] arr, int end) {
        int len = end + 1;
        for (int i = len / 2 - 1; i >= 0; i--) {
            int l = 2 * i + 1, r = l + 1;
            int p = l;
            if (r < len && arr[l] < arr[r]) {
                p = r;
            }
            if (arr[p] > arr[i]) {
                swap(arr, p, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = ArrayFactory.createRandomArray();
        System.out.println("original:" + Arrays.toString(array));
        sort(array);
        ArrayFactory.checkSortResultASC(array);

        int[] array1 = ArrayFactory.createRandomAndEqualArray();
        System.out.println("original:" + Arrays.toString(array1));
        sort(array1);
        ArrayFactory.checkSortResultASC(array1);
    }
}
