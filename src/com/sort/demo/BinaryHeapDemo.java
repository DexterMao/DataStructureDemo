package com.sort.demo;

import java.util.Arrays;

/**
 * 最小二叉堆构建、上浮、下沉的实现Demo
 */
public class BinaryHeapDemo {

    /**
     * （最小堆）上浮：跟父节点比较，如果小于父节点，则进行上浮；注意需要判断节点是属于左节点还是右节点
     *
     * @param arr
     */
    public static void upAdjust(int[] arr) {
        int childIdx = arr.length - 1;
        //如果子节点索引是偶数，则是又节点，否则是左节点
        int parentIdx = (childIdx % 2 == 0 ? (childIdx - 2) / 2 : (childIdx - 1) / 2);
        int temp = arr[childIdx];
        while (childIdx > 0 && temp < arr[parentIdx]) {
            arr[childIdx] = arr[parentIdx];
            childIdx = parentIdx;
            parentIdx = (childIdx % 2 == 0 ? (childIdx - 2) / 2 : (childIdx - 1) / 2);
        }
        arr[childIdx] = temp;
    }

    /**
     * （最小堆）下沉：根节点跟左右节点最小的比较，如果大于最小节点则进行下沉；
     *
     * @param arr
     */
    public static void downAdjust(int[] arr, int parentIdx) {
        int tmp = arr[parentIdx];
        int childIdx = getChildIdx(arr, parentIdx);
        while (childIdx < arr.length && tmp > arr[childIdx]) {
            arr[parentIdx] = arr[childIdx];
            parentIdx = childIdx;
            childIdx = getChildIdx(arr, parentIdx);
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
    private static int getChildIdx(int[] arr, int parentIdx) {
        int childIdx;
        int leftIdx = 2 * parentIdx + 1;
        //判断是否存在左右节点，及左右节点最小的是哪个节点
        if (leftIdx < arr.length) {
            int rightIdx = 2 * parentIdx + 2;
            if (rightIdx >= arr.length) {
                childIdx = leftIdx;
            }
            if (arr[rightIdx] > arr[leftIdx]) {
                childIdx = leftIdx;
            } else {
                childIdx = rightIdx;
            }
        } else {
            childIdx = leftIdx;
        }
        return childIdx;
    }

    /**
     * 构建最小二叉堆：让所有非叶子节点依次下沉，从最后一个非叶子节点开始
     *
     * @param arr
     */
    public static void buildBinaryHeap(int[] arr) {
        int idx = (arr.length - 1) % 2 == 0 ? (arr.length - 3) / 2 : (arr.length - 2) / 2;
        for (int i = idx; i >= 0; i--) {
            downAdjust(arr, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 9, 6, 5};
        System.out.println("上浮前数组：");
        System.out.println(Arrays.toString(arr));
        upAdjust(arr);
        System.out.println("上浮后数组：");
        System.out.println(Arrays.toString(arr));
        arr = new int[]{10, 3, 2, 6, 5, 7, 8, 9};
        System.out.println("下沉前数组：");
        System.out.println(Arrays.toString(arr));
        downAdjust(arr, 0);
        System.out.println("下沉后数组：");
        System.out.println(Arrays.toString(arr));
        arr = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        System.out.println("构建前数组：");
        System.out.println(Arrays.toString(arr));
        buildBinaryHeap(arr);
        System.out.println("构建后数组：");
        System.out.println(Arrays.toString(arr));
    }

}
