package com.sort;

import java.util.Arrays;

public final class ArrayUtil {


    /**
     * 对数器，验证贪心算法是否正确
     *
     * @param arr
     */
    public static void duiShuQi(int[] arr) {
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
            System.err.println("arr1 = " + Arrays.toString(arr1));
            System.err.println("arr1 = " + Arrays.toString(arr1));
        }
        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));
    }

    public static void swap(int[] arr, int index, int index2){
        if(index == index2) return;
        arr[index] = arr[index] ^ arr[index2];
        arr[index2] = arr[index] ^ arr[index2];
        arr[index] = arr[index] ^ arr[index2];
    }
}
