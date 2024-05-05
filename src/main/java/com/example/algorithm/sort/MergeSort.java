package com.example.algorithm.sort;

import com.example.algorithm.array.ArrayFactory;

import java.util.Arrays;

/**
 * @author jitwxs
 * @date 2024年05月04日 15:37
 */
public class MergeSort {

    public static int[] sort(int[] arr) {
        if (arr != null && arr.length > 1) {
            int[] left = slice(arr, 0, arr.length / 2);
            int[] right = slice(arr, arr.length / 2, arr.length);
            arr = merge(sort(left), sort(right));
        }
        return arr;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] tmp = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0;
        int i = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            tmp[i++] = left[leftIndex] > right[rightIndex]
                    ? right[rightIndex++] : left[leftIndex++];
        }

        while (leftIndex < left.length) {
            tmp[i++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            tmp[i++] = right[rightIndex++];
        }
        return tmp;
    }

    private static int[] slice(int[] arr, int start, int end) {
        int[] tmp = new int[end - start];
        for (int i = 0; i < end - start; i++) {
            tmp[i] = arr[i + start];
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] array = ArrayFactory.createRandomArray();
        System.out.println("original:" + Arrays.toString(array));
        array = sort(array);
        ArrayFactory.checkSortResultASC(array);

        int[] array1 = ArrayFactory.createRandomAndEqualArray();
        System.out.println("original:" + Arrays.toString(array1));
        array1 = sort(array1);
        ArrayFactory.checkSortResultASC(array1);
    }
}
