package com.sort;

import java.util.Arrays;

public class Sort05_HeLanGuoQi {

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 3, 3, 7, 8, 4, 3};
        int[] res = heLanGuoQiSort(arr, 3, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(res));


    }

    /**
     * 荷兰国旗问题，
     * 中间相等，左边小于num, 右边大于num
     *
     * 创建两个指针，l, r
     * l 在开始索引左边，r在结束指针右边
     * 从开始索引开始遍历，终止条件是index等于r
     *  若该索引数小于num,则将l加一，然后交换该索引与l索引数据，该索引加1
     *  若该索引数大于num,则将r减一，然后交换该索引与r索引数据，该索引数据不变
     *  若该索引数等于num,则将index加一
     *
     * @param arr
     * @param num
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int[] heLanGuoQiSort(int[] arr, int num, int startIndex, int endIndex){
        int l = startIndex -1;
        int r = endIndex + 1;
        int index = startIndex;
        while(index < r){
            if(arr[index] < num){
                ArrayUtil.swap(arr, index++, ++l);
            } else if(arr[index] > num){
                ArrayUtil.swap(arr, index, --r);
            } else {
                index++;
            }
        }
        //相等的中间段
        return new int[]{l+1, r-1};
    }
}
