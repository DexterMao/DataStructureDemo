package com.sort.demo;

import java.util.Arrays;

/**
 * 最小优先队列
 */
public class MinPriorityQueue {
    private int size = 0;
    private int[] arr;
    private static final int DEFAULT_CAPACITY = 8;

    public MinPriorityQueue() {
        arr = new int[DEFAULT_CAPACITY];
    }

    public MinPriorityQueue(int capacity) {
        arr = new int[capacity];
    }

    /**
     * 入队，根据最小二叉堆的实现原理，新增的元素放数组最后，然后上浮
     *
     * @param val
     */
    public void enqueue(int val) {
        if (size >= arr.length) {
            resize();
        }
        arr[size++] = val;
        //上浮
        upAdjust();
    }

    private void resize() {
        arr = Arrays.copyOf(arr, size * 2);
    }


    /**
     * （最小堆）上浮：跟父节点比较，如果小于父节点，则进行上浮；注意需要判断节点是属于左节点还是右节点
     *
     */
    private void upAdjust() {
        int childIdx = size - 1;
        //如果子节点索引是偶数，则是又节点，否则是左节点
        int parentIdx = getParentIdxByChildIdx(childIdx);
        int temp = arr[childIdx];
        while (childIdx > 0 && temp < arr[parentIdx]) {
            arr[childIdx] = arr[parentIdx];
            childIdx = parentIdx;
            parentIdx = getParentIdxByChildIdx(childIdx);
        }
        arr[childIdx] = temp;
    }

    private int getParentIdxByChildIdx(int childIdx) {
        return childIdx % 2 == 0 ? (childIdx - 2) / 2 : (childIdx - 1) / 2;
    }

    /**
     * 出队：弹出二叉堆顶元素，用最后一个堆元素来替换堆顶，进行下沉操作
     * <p>
     * 如果只有一个元素，则不进行调整；
     *
     * @return
     */
    public int dequeue() {
        if (size == 0) {
            throw new NullPointerException("Array is null");
        }
        int result = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = 0;
        size--;
        if (size > 0) {
            downAdjust();
        }
        return result;
    }

    /**
     * （最小堆）下沉：根节点跟左右节点最小的比较，如果大于最小节点则进行下沉；
     *
     */
    private void downAdjust() {
        int parentIdx = 0;
        int tmp = arr[parentIdx];
        int childIdx = getChildIdx(arr, parentIdx);
        while (childIdx < size && tmp > arr[childIdx]) {
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
    private int getChildIdx(int[] arr, int parentIdx) {
        int childIdx;
        int leftIdx = 2 * parentIdx + 1;
        //判断是否存在左右节点，及左右节点最小的是哪个节点
        if (leftIdx < size) {
            int rightIdx = 2 * parentIdx + 2;
            if (rightIdx >= size) {
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
     * 获取队列长度
     *
     * @return
     */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MinPriorityQueue queue = new MinPriorityQueue();
        System.out.println("队列长度：" + queue.size());
        queue.enqueue(12);
        queue.enqueue(8);
        queue.enqueue(18);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(23);
        queue.enqueue(3);
        queue.enqueue(53);
        queue.enqueue(223);
        queue.enqueue(43);
        System.out.println("入队后元素顺序：");
        System.out.println("队列长度：" + queue.size());
        System.out.println(Arrays.toString(queue.arr));
        System.out.println("出队：" + queue.dequeue());
        System.out.println("出队：" + queue.dequeue());
        System.out.println("出队：" + queue.dequeue());
        System.out.println("出队：" + queue.dequeue());
        System.out.println("出队：" + queue.dequeue());
        System.out.println("出队后元素顺序：");
        System.out.println(Arrays.toString(queue.arr));
        System.out.println("队列长度：" + queue.size());
    }
}
