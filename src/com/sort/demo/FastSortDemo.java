package com.sort.demo;

import java.util.Arrays;

/**
 * 快速排序
 */
public class FastSortDemo {

    /**
     * 双边循环递归
     *
     * @param arr
     */
    public static void sort(int[] arr, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }
        int baseIdx = getBaseIdxForDoubleLoop(arr, startIdx, endIdx);
        sort(arr, startIdx, baseIdx - 1);
        sort(arr, baseIdx + 1, endIdx);
    }

    /**
     * 获取下一次到基准下标
     *
     * @param arr
     * @param startIdx
     * @param endIdx
     * @return
     */
    private static int getBaseIdxForDoubleLoop(int[] arr, int startIdx, int endIdx) {
        int base = arr[startIdx];
        int leftIdx = startIdx;
        int rightIdx = endIdx;
        //指针重合停止
        while (leftIdx != rightIdx) {
            //如果右边指针指向到值大于基准值且下标小于左下标，则往左移
            while (arr[rightIdx] > base && rightIdx > leftIdx) {
                rightIdx--;
            }
            //与右指针相反，小于等于基准值则往右移动一次
            while (arr[leftIdx] <= base && leftIdx < rightIdx) {
                leftIdx++;
            }
            //交换左右指针指向动值
            if (rightIdx > leftIdx) {
                int tmp = arr[leftIdx];
                arr[leftIdx] = arr[rightIdx];
                arr[rightIdx] = tmp;
            }
        }
        //与基准值交换
        arr[startIdx] = arr[leftIdx];
        arr[leftIdx] = base;
        return leftIdx;
    }

    /**
     * 单边循环获取基准值
     * @param arr
     * @param startIdx
     * @param endIdx
     * @return
     */
    public static int getBaseIdxForSingleLoop(int[] arr, int startIdx, int endIdx) {
        int base = arr[startIdx];
        int mark = startIdx;
        for (int i = startIdx + 1; i <= endIdx && mark < endIdx; i++) {
            if (arr[i] < base) {
                mark++;
                int tmp = arr[i];
                arr[i] = arr[mark];
                arr[mark] = tmp;
            }
        }
        arr[startIdx] = arr[mark];
        arr[mark] = base;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 23, 22, 1, 9, 0, 26, 98, 100, 3, 6};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
