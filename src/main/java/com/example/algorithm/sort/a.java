package com.example.algorithm.sort;

import com.example.algorithm.array.ArrayFactory;

import java.util.Arrays;

/**
 * @author jitwxs
 * @date 2024年05月05日 09:15
 */
public class a {


    public static int[] sort(int[] arr) {
        if (arr != null && arr.length > 1) {
            int[] left = slice(arr, 0, arr.length / 2);
            int[] right = slice(arr, arr.length / 2, arr.length);
            arr = merge(sort(left), sort(right));
        }
        return arr;
    }

    public static int[] merge(int[] left, int[] right) {
        int leftIndex = 0, rightIndex = 0;
        int i = 0;
        int[] result = new int[left.length + right.length];
        while (leftIndex < left.length && rightIndex < right.length) {
            result[i++] = left[leftIndex] < right[rightIndex] ?
                    left[leftIndex++] : right[rightIndex++];
        }

        while (leftIndex < left.length) {
            result[i++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            result[i++] = right[rightIndex++];
        }

        return result;
    }

    public static int[] slice(int[] arr, int start, int end) {
        int[] tmp = new int[end - start];
        for (int i = 0; i < end - start; i++) {
            tmp[i] = arr[start + i];
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
