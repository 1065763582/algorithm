package com.example.algorithm.sort;

import com.example.algorithm.array.ArrayFactory;

import java.util.Arrays;

public class QuickSort {

    /**
     * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void sort(int[] arr, int left, int right) {
        int i = left, j = right;
        int tmp;
        if (i < j) {
            tmp = arr[i];
            while (i < j) {
                while (i < j && arr[j] > tmp)
                    j--;
                arr[i] = arr[j];
                while (i < j && arr[i] <= tmp)
                    i++;
                arr[j] = arr[i];
            }
            arr[i] = tmp;
            sort(arr, left, i - 1);
            sort(arr, i + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] array = ArrayFactory.createRandomArray();
        sort(array, 0, array.length - 1);
        ArrayFactory.checkSortResultASC(array);

        int[] array1 = ArrayFactory.createRandomAndEqualArray();
        sort(array1, 0, array1.length - 1);
        ArrayFactory.checkSortResultASC(array);
    }
}
