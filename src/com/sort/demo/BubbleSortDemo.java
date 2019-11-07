package com.sort.demo;

import java.util.Arrays;

public class BubbleSortDemo {

    /**
     * 冒泡排序：如果该元素大于右侧相邻元素，则交换，否则不变；
     *
     * 优化：如果发现后面几次都没有交换位置，则不用循环比较；所以增加一个标志来判断是否产生来交换，如果没有则后面不循环比较
     * @param arr
     */
    public static void sort(int[] arr) {
        int cnt = 0;
        boolean hasChanged = true;
        int lastSort = arr.length-1;
        int sortBorder = lastSort;
        for (int i = 0; i < arr.length && hasChanged; i++) {
            hasChanged = false;
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = tmp;
                    lastSort = j;
                    hasChanged = true;
                }
                cnt++;
            }
            sortBorder = lastSort;
        }
        System.out.println("Loop times:" + cnt);
    }

    private static void sort2(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            int sortBorder = arr.length -1;
            for (int j = 0; j < sortBorder; j++) {
                int tmp = 0;
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = tmp;
                    isSorted = false;
                    sortBorder = j;
                }
                cnt++;
            }
            if (isSorted) {
                break;
            }
        }
        System.out.println("Loop times:" + cnt);
    }

    public static void main(String[] args) {
       // int[] arr = new int[]{54, 12, 3, 88, 10, 2, 100, 8};
        int[] arr = new int[]{3, 2, 10, 18, 12, 54, 88, 100};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{3, 2, 10, 18, 12, 54, 88, 100};
        sort2(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{54, 12, 3, 88, 10, 2, 100, 8};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
