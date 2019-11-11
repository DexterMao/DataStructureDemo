package com.sort.demo;

import java.util.Arrays;

/**
 * 堆排序
 * <p>
 * 利用二叉堆堆基础实现
 */
public class HeapSortDemo {

    /**
     * （最大堆）下沉：根节点跟左右节点最大的比较，如果小于最大节点则进行下沉；
     *
     * @param arr
     */
    public static void downAdjust(int[] arr, int parentIdx, int arrlength) {
        int tmp = arr[parentIdx];
        int childIdx = getChildIdx(arr, parentIdx, arrlength);
        while (childIdx < arrlength && tmp < arr[childIdx]) {
            arr[parentIdx] = arr[childIdx];
            parentIdx = childIdx;
            childIdx = getChildIdx(arr, parentIdx, arrlength);
        }
        arr[parentIdx] = tmp;
    }

    /**
     * 根据数组及父节点的索引获取对应的子节点索引
     *
     * @param arr
     * @param parentIdx
     * @return
     */
    private static int getChildIdx(int[] arr, int parentIdx, int arrlength) {
        int childIdx;
        int leftIdx = 2 * parentIdx + 1;
        //判断是否存在左右节点，及左右节点最大的是哪个节点
        if (leftIdx < arrlength) {
            int rightIdx = 2 * parentIdx + 2;
            if (rightIdx >= arrlength) {
                childIdx = leftIdx;
            } else if (arr[rightIdx] > arr[leftIdx]) {
                childIdx = rightIdx;
            } else {
                childIdx = leftIdx;
            }
        } else {
            childIdx = leftIdx;
        }
        return childIdx;
    }

    /**
     * 构建最大二叉堆
     *
     * @param arr
     */
    private static void buildBigBinaryHeap(int[] arr) {
        int idx = (arr.length - 1) % 2 == 0 ? (arr.length - 3) / 2 : (arr.length - 2) / 2;
        for (int i = idx; i >= 0; i--) {
            downAdjust(arr, i, arr.length);
        }
    }

    /**
     * 进行删除
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        buildBigBinaryHeap(arr);
        System.out.println("最大二叉堆：");
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[0];
            arr[0] = arr[arr.length - i];
            arr[arr.length - i] = tmp;
            downAdjust(arr, 0, arr.length - i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{23, 33, 4, 5, 9, 21, 39, 20, 10};
        sort(arr);
        System.out.println("排序结果：");
        System.out.println(Arrays.toString(arr));

    }

}
