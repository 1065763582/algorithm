package com.example.algorithm.array;

import java.util.Arrays;
import java.util.Random;

public class ArrayFactory {

    private static Random random = new Random();

    private static final int[] NO_SEQUENCE_ARRAY = {8364, 7832, 1424, 9962, 5210, 2247, 4105, 4764, 3307, 8146, 6248, 8660, 9324};

    private static final int[] NO_SEQUENCE_BUT_EQUAL_ARRAY = {8364, 7832, 1424, 9962, 1210, 8364, 4105, 4764, 3307, 8146, 1424, 8660, 9324};

    /**
     * 生成随机的N位整数
     *
     * @return 整数数组
     */
    public static int[] createRandomArray() {

        return NO_SEQUENCE_ARRAY;
    }

    /**
     * 生成随机的N位整数, 其中M个重复值
     *
     * @return
     */
    public static int[] createRandomAndEqualArray() {

        return NO_SEQUENCE_BUT_EQUAL_ARRAY;
    }

    /**
     * 检查排序结果
     *
     * @param arr 数组
     */
    public static void checkSortResultASC(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            if (arr[j] >= arr[i]) {
                System.out.println("pass (i, j) (" + i + ", " + j + ")");
            } else {
                throw new RuntimeException("pass error (i, j) (" + i + ", " + j + ")(" + arr[i] + ", " + arr[j] + ")");
            }
        }
        System.out.println("sort result:");
        System.out.println(Arrays.toString(arr));
    }
}
