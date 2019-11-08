package com.question;

import java.util.Arrays;

public class Q4_XuanZhuanMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 6, 7, 8};
        matrix[2] = new int[]{9, 10, 11, 12};
        matrix[3] = new int[]{13, 14, 15, 16};

        xuanZhuan(matrix);
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
        System.out.println(Arrays.toString(matrix[3]));
    }

    public static void xuanZhuan(int[][] matrix){
        int leftUp = 0;
        int rightDown = matrix.length -1;
        while (leftUp < rightDown){
            for (int i = 0; i < (rightDown - leftUp); i++) {
                int tmp = matrix[leftUp][leftUp+i];// 用tmp保存左上角值
                matrix[leftUp][leftUp+i] = matrix[rightDown-i][leftUp]; //左上角位置由左下角覆盖
                matrix[rightDown-i][leftUp] = matrix[rightDown][rightDown - i]; //左下角由右下角覆盖
                matrix[rightDown][rightDown - i] = matrix[leftUp + i][rightDown]; //右下角由右上角覆盖
                matrix[leftUp + i][rightDown] = tmp; //右上角由最开始临时值覆盖
            }
            leftUp++;
            rightDown--;
        }
    }
}
