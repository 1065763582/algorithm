package com.example.algorithm.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author jitwxs
 * @date 2024年05月04日 16:20
 */
public class TowSum {


    public static int[] towSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[]{map.get(target - arr[i]), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(towSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
