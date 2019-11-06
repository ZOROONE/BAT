package com.sort;

import java.util.Arrays;

public class Sort01_maopao {

    public static void main(String[] args) {
        
        int maxValue = 100;
        int maxSize = 10;
        for (int i = 0; i < 100 ; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            maoPaoDuiShuQi(arr);
            maopaoSort(arr2);
            isEqual(arr, arr2);
        }
    }

    /**
     * 冒泡排序算法，自己实现
     * @param arr
     */
    public static void maopaoSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if(arr[j] > arr[j+1]){
                    arr[j] = arr[j]^arr[j+1];
                    arr[j+1] = arr[j]^arr[j+1];
                    arr[j] = arr[j]^arr[j+1];
                }
            }
        }
    }

    /**
     * 对数器，验证贪心算法是否正确
     * @param arr
     */
    public static void maoPaoDuiShuQi(int[] arr){
        if (arr == null || arr.length < 1) {
            return;
        }
        Arrays.sort(arr);
    }

    /**
     * 样本产生器，产生模拟数据
     */
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random() - maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 测试两个是否相等
     * @param arr1
     * @param arr2
     */
    public static void isEqual(int[] arr1, int[] arr2){
        if(arr1 == null && arr2 == null){
            return;
        }
        boolean flag = Arrays.equals(arr1, arr2);

        if (!flag) {
            System.out.println("arr1 = " + Arrays.toString(arr1));
            System.out.println("arr2 = " + Arrays.toString(arr2));
        }
    }
}
