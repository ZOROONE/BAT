package com.question;

import java.util.PriorityQueue;

public class Q1_SmallSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 5};
        System.out.println(smallSum(arr, 0, arr.length - 1));
    }

    /**
     * 利用归并排序解决小和问题
     *
     * 逆序对问题和这个一样
     *
     * @return smallSum
     */
    public static int smallSum(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return 0;
        }
        int mid = startIndex + ((endIndex - startIndex) >> 1);
        int leftSum = smallSum(arr, startIndex, mid);
        int rightSum = smallSum(arr, mid + 1, endIndex);
        int mergeSum = mergeSum(arr, startIndex, mid, endIndex);
        return leftSum + rightSum + mergeSum;
    }

    private static int mergeSum(int[] arr, int startIndex, int mid, int endIndex) {
        int[] help = new int[endIndex - startIndex + 1];
        int l = startIndex;
        int r = mid + 1;
        int index = 0;
        int smallSum = 0;
        while (l <= mid && r <= endIndex) {
            if (arr[l] < arr[r]) {
                smallSum += (endIndex - r + 1) * arr[l];
                help[index++] = arr[l++];
            } else {
                help[index++] = arr[r++];
            }
        }
        while (l <= mid) {
            help[index++] = arr[l++];
        }
        while (r <= endIndex) {
            help[index++] = arr[r++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[startIndex + i] = help[i];
        }
        return smallSum;
    }
}
