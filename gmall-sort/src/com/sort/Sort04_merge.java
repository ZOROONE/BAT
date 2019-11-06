package com.sort;

import java.util.Arrays;

public class Sort04_merge {

    public static void main(String[] args) {

        int maxSize = 10;
        int maxValue = 10;
        for (int i = 0; i < 100; i++) {
            int[] arr = ArrayUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            mergeSort(arr, 0, arr.length - 1);
            ArrayUtil.duiShuQi(arr2);
            ArrayUtil.isEqual(arr, arr2);
        }
    }

    public static void mergeSort(int[] arr, int left, int right){
        if (left >= right || arr == null || arr.length < 2) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int helpIndex = 0;
        while(l <= mid && r <= right){
            help[helpIndex++] = arr[l] < arr[r] ? arr[l++] : arr[r++];
        }
        while(l <= mid){
            help[helpIndex++] = arr[l++];
        }
        while(r <= right){
            help[helpIndex++] = arr[r++];
        }

        //从help数组，复制回原数组
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }
}
