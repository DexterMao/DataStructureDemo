package com.sort.demo;

import java.util.Arrays;

/**
 * 鸡尾酒排序：第一次从左到右，第二次从右到左，第三次从左到右，依次进行.....
 * <p>
 * 如果存在 2，3，4，5，6，7，1，8 这种顺序，如果按照正常的冒泡排序，则需要进行很多次比较
 * <p>
 * 而采用鸡尾酒排序，则：
 * <p>
 * 第一轮，从左到右比较，最后是2，3，4，5，6，7，8，1
 * <p>
 * 第二轮，从右到左，则是1，2，3，4，5，6，7，8
 * <p>
 * 第三轮，从左到右，发现已经有序来，则比较结束
 */
public class CocktailSortDemo {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        boolean hasSwaped = true;
        for (int i = 0; i < arr.length / 2; i++) {
            if (!hasSwaped) {
                break;
            } else {
                hasSwaped = false;
            }
            //从左到右遍历
            for (int left = 0; left < arr.length - 1; left++) {
                if (arr[left] > arr[left + 1]) {
                    int tmp = arr[left];
                    arr[left] = arr[left + 1];
                    arr[left + 1] = tmp;
                    hasSwaped = true;
                }
            }
            if (!hasSwaped) {
                break;
            } else {
                hasSwaped = false;
            }
            //从右到左遍历
            for (int right = arr.length - 1; right > 0; right--) {
                if (arr[right - 1] > arr[right]) {
                    int tmp = arr[right];
                    arr[right] = arr[right - 1];
                    arr[right - 1] = tmp;
                    hasSwaped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 5, 6, 7, 1, 8};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
