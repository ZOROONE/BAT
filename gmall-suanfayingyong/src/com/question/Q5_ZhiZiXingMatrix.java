package com.question;

import org.omg.PortableServer.ForwardRequest;

import java.util.Arrays;

public class Q5_ZhiZiXingMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 6, 7, 8};
        matrix[2] = new int[]{9, 10, 11, 12};
//        matrix[3] = new int[]{13, 14, 15, 16};

        zhiZiXingPrint(matrix);
    }

    public static void zhiZiXingPrint(int[][] matrix){

        int upRow = 0;
        int upCol = 0;
        int downRow = 0;
        int downCol = 0;
        boolean upDown = false; //代表从上往下打印


        int r;
        int c;
        while (upCol != matrix[0].length -1 || upRow != matrix.length - 1){
            if(upDown){//从上往下打印
                r = upRow;
                c = upCol;
                while (r <= downRow){
                    System.out.println(matrix[r++][c--]);
                }

            } else{//从下往上打印
                r = downRow;
                c = downCol;
                while (r >= upRow){
                    System.out.println(matrix[r--][c++]);
                }
            }
            upDown = !upDown;
            if(upCol < matrix[0].length -1){
                upCol++;
            }else {
                upRow++;
            }

            if(downRow < matrix.length -1){
                downRow++;
            } else{
                downCol++;
            }
        }
        System.out.println(matrix[upRow][upCol]);
    }
}
