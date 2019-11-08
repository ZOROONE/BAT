package com.question;

public class Q3_ZhuanQuanPrintMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 6, 7, 8};
        matrix[2] = new int[]{9, 10, 11, 12};
        matrix[3] = new int[]{13, 14, 15, 16};

        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix){
        int leftRow = 0; //左上角 行
        int leftCol = 0; //左上角 列
        int rightRow = matrix.length - 1; //右下角行
        int rightCol = matrix[0].length - 1; //右下角列

        while(leftRow < rightRow && leftCol < rightCol){
            quan(matrix, leftRow, leftCol, rightRow, rightCol);
            leftRow++;
            leftCol++;
            rightRow--;
            rightCol--;
        }

        //只剩下一行
        if(leftRow == rightRow){
            for (int i = leftCol; i <= rightCol; i++) {
                System.out.println(matrix[leftRow][i]);
            }
        } else {
            //只剩下一列
            for (int i = leftRow; i <= rightRow; i++) {
                System.out.println(matrix[leftCol][i]);
            }
        }
    }

    private static void quan(int[][] matrix, int leftRow, int leftCol, int rightRow, int rightCol) {

        for (int i = leftCol; i < rightCol; i++) {
            System.out.println(matrix[leftRow][i]);
        }
        for (int i = leftRow; i < rightRow ; i++) {
            System.out.println(matrix[i][rightCol]);
        }
        for (int i = rightCol; i > leftCol ; i--) {
            System.out.println(matrix[rightRow][i]);
        }
        for (int i = rightRow; i > leftRow ; i--) {
            System.out.println(matrix[i][leftCol]);
        }
    }
}
