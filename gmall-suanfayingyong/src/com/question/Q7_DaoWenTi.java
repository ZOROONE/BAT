package com.question;

public class Q7_DaoWenTi {

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1, 0, 1};
        matrix[1] = new int[]{0, 1, 0};
        matrix[2] = new int[]{1, 1, 1};
        System.out.println(getDaoNums(matrix));
    }

    public static int getDaoNums(int[][] matrix){
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1){
                    res++;
                    ganRan(matrix, i, j);
                }
            }
        }
        return res;
    }

    private static void ganRan(int[][] matrix, int row, int col) {
        if(row > matrix.length - 1 || row < 0 || col > matrix[0].length -1 || col < 0 || matrix[row][col] != 1){
            return;
        }
        matrix[row][col] = 2;
        ganRan(matrix, row - 1, col);//上
        ganRan(matrix, row + 1, col);//下
        ganRan(matrix, row, col -1); // 左
        ganRan(matrix, row, col + 1); //右
    }
}
