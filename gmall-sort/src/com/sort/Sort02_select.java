package com.sort;

import java.util.Arrays;

public class Sort02_select {
    public static void main(String[] args) {
        int maxSize = 8;
        int maxValue = 10;
        for (int i = 0; i < 100; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            selectSort(arr);
            selectDuiShuQi(arr2);
            isEqual(arr, arr2);
        }
    }

    /**
     * 每次选择最少的数放在最前面
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                arr[i] = arr[i] ^ arr[minIndex];
                arr[minIndex] = arr[i] ^ arr[minIndex];
                arr[i] = arr[i] ^ arr[minIndex];
            }
        }
    }

    /**
     * 对数器，验证贪心算法是否正确
     *
     * @param arr
     */
    public static void selectDuiShuQi(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Arrays.sort(arr);
    }

    /**
     * 样本产生器，产生模拟数据
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random() - maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 测试两个是否相等
     *
     * @param arr1
     * @param arr2
     */
    public static void isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return;
        }
        boolean flag = Arrays.equals(arr1, arr2);

        if (!flag) {
            System.out.println("arr1 = " + Arrays.toString(arr1));
            System.out.println("arr2 = " + Arrays.toString(arr2));
        }
        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));
    }
}
