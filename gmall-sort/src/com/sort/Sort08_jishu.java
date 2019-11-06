package com.sort;

import java.util.Arrays;

public class Sort08_jishu {

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 4, 3, 3, 2, 4};
        jishuSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void jishuSort(int[] arr){
        //假设，知道该数组的范围为 2 - 10
        int[] help = new int[11];
        for (int i = 0; i < arr.length; i++) {
            help[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i < help.length; i++) {
            while (help[i] > 0){
                arr[index++] = i;
                help[i]--;
            }
        }
    }
}
