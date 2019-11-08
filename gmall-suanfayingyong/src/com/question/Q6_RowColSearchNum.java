package com.question;

import javax.sound.midi.Soundbank;

public class Q6_RowColSearchNum {

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1, 3, 5, 7};
        matrix[1] = new int[]{2, 4, 6, 9};
        matrix[2] = new int[]{5, 7, 9, 16};

        rowColSearchNum(matrix, 2);
    }


    public static void rowColSearchNum(int[][] matrix, int num){
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length || col >= 0){
            if(matrix[row][col] > num){
                if(col > 0){
                    col--;
                } else {
                    System.out.println("noNum");
                    break;
                }
            } else if(matrix[row][col] < num){
                if(row < matrix.length -1){
                    row++;
                } else{
                    System.out.println("noNum");
                    break;
                }
            } else{
                System.out.println("row " + row + ", col " + col);
                break;
            }
        }
    }
}
