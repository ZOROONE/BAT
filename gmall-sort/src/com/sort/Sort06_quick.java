package com.sort;

import java.util.Arrays;

public class Sort06_quick {

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 3, 4, 2, 3, 9};
        heLanGuoQiQuickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 经典快排，每次选最后一个数作为partition数，利用辅助指针small,开始指针前一个
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void jingDianQuickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;
        int mid = jingDianPartition(arr, startIndex, endIndex);
        jingDianQuickSort(arr, startIndex, mid - 1);
        jingDianQuickSort(arr, mid + 1, endIndex);
    }

    private static int jingDianPartition(int[] arr, int startIndex, int endIndex) {
        int small = startIndex - 1;
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] < arr[endIndex]) {
                ArrayUtil.swap(arr, ++small, i);
            }
        }
        ArrayUtil.swap(arr, ++small, endIndex);
        return small;
    }

    /**
     * 利用荷兰国旗改进版的快排，每次可以搞定多个数
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void heLanGuoQiQuickSort(int[] arr, int startIndex, int endIndex){
        if(startIndex >= endIndex) return;
        int[] res = heLanGuoQiPartition(arr, startIndex, endIndex);
        heLanGuoQiQuickSort(arr, startIndex, res[0]);
        heLanGuoQiQuickSort(arr, res[1], endIndex);
    }

    private static int[] heLanGuoQiPartition(int[] arr, int startIndex, int endIndex) {
        int l = startIndex - 1;
        int r = endIndex + 1;
        int num = arr[endIndex];
        int index = startIndex;
        while (index < r){
            if(arr[index] < num){
                ArrayUtil.swap(arr, index++, ++l);
            } else if(arr[index] > num){
                ArrayUtil.swap(arr, index, --r);
            } else {
                index++;
            }
        }
        // l代表小于num
        return new int[]{l, r};

    }

    /**
     * 随机快排
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void randomHeLanGuoQiQuickSort(int[] arr, int startIndex, int endIndex){
        if (startIndex >= endIndex) {
            return;
        }
        int[] res = randomHeLanGuoQiPartition(arr, startIndex, endIndex);
        randomHeLanGuoQiPartition(arr, startIndex, res[0]);
        randomHeLanGuoQiPartition(arr, res[1], endIndex);
    }

    private static int[] randomHeLanGuoQiPartition(int[] arr, int startIndex, int endIndex) {
        int num = arr[startIndex + ((int) ((endIndex - startIndex + 1) * Math.random()))];
        int l = startIndex - 1;
        int r = endIndex + 1;
        int index = startIndex;
        while (index < r){
            if(arr[index] < num){
                ArrayUtil.swap(arr, ++l, index++);
            } else if(arr[index] > num){
                ArrayUtil.swap(arr, --r, index);
            } else {
                index++;
            }
        }
        return new int[]{l, r};
    }

}
