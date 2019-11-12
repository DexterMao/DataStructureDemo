package com.sort.demo;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountSortDemo {

    public static void sort(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        int shift = max - min;
        int[] sortArr = new int[shift + 1];
        for (int i = 0; i < arr.length; i++) {
            sortArr[arr[i] - min] ++;
        }
        int idx = 0;
        for (int i = 0; i < sortArr.length; i++) {
            if (sortArr[i] == 0) {
                continue;
            }
            for (int j = 0; j < sortArr[i]; j++) {
                arr[idx++] = i +min;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{90,99,92,93,98,97,96};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
