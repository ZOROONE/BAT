package com.sort;

import java.util.Arrays;

public class Sort03_insert {
    public static void main(String[] args) {
        int maxSize = 8;
        int maxValue = 10;
        for (int i = 0; i < 100; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            insertSort(arr);
            insertDuiShuQi(arr2);
            isEqual(arr, arr2);
        }
    }

    /**
     * 联想扑克牌，先有第一张，看第二张，如果比前面一张小就往前插，直到前面比他小
     * 然后再看下一张
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr != null && arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    arr[j] = arr[j] ^ arr[j - 1];
                    arr[j - 1] = arr[j] ^ arr[j - 1];
                    arr[j] = arr[j] ^ arr[j - 1];
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 对数器，验证贪心算法是否正确
     *
     * @param arr
     */
    public static void insertDuiShuQi(int[] arr) {
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

}
