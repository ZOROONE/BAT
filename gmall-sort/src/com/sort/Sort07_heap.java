package com.sort;

import java.util.Arrays;

/**
 * 优先级队列就是堆排序，
 */
public class Sort07_heap {

    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 10;
        for (int i = 0; i < 100; i++) {
            int[] arr = ArrayUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            heapSort(arr);
            ArrayUtil.duiShuQi(arr2);
            ArrayUtil.isEqual(arr, arr2);
        }

    }

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //1. 建立大根堆
        createBigRootHeap(arr);

        //2. 利用大根堆进行排序
        for (int i = arr.length - 1; i > 0; i--) {
            ArrayUtil.swap(arr, 0, i);
            heapfi(arr, 0, i-1);
        }
    }

    /**
     * 自上而下比较，休整为符合条件的
     * @param arr
     * @param cur
     * @param rightBorder
     */
    private static void heapfi(int[] arr, int cur, int rightBorder) {
        int lc = cur * 2 + 1;
        int rc = cur * 2 + 2;
        while (rc <= rightBorder && (arr[cur] < arr[rc] || arr[cur] < arr[lc])){
            int maxIndex = arr[lc] > arr[rc] ? lc : rc;
            ArrayUtil.swap(arr, cur, maxIndex);
            cur = maxIndex;
            lc = cur*2 + 1;
            rc = cur*2 + 2;
        }

        if(lc == rightBorder && arr[lc] > arr[cur]){
            ArrayUtil.swap(arr, cur, lc);
        }
    }

    //建立大根堆
    public static void createBigRootHeap(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            bigRootHeapInsert(arr, i);
        }
    }
    // heapInsert方法
    private static void bigRootHeapInsert(int[] arr, int index) {
        //1. 当前节点，和父节点比较，若大于父节点，则交换
        while (arr[index] > arr[(index - 1)/2]){
            ArrayUtil.swap(arr, index, (index - 1)/2);
            index = (index - 1)/2;
        }
    }
}
