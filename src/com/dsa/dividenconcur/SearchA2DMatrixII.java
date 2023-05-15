package com.dsa.dividenconcur;

public class SearchA2DMatrixII {
    public static void main(String... s){
        SearchA2DMatrixII searchA2DMatrixII = new SearchA2DMatrixII();
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        searchA2DMatrixII.searchMatrix(matrix,5);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean ans = false;
        if (matrix!=null && matrix.length!=0 && (search(0, matrix.length - 1, 0, matrix[0].length - 1, matrix, target) == 0) ){
            return true;
        }
        return false;
    }

    public int search(int i_low, int i_high, int j_low, int j_high, int[][] a, int n) {
        int mid_i = (i_low + i_high) / 2;
        int mid_j = (j_low + j_high) / 2;

        if (a[mid_i][mid_j] == n) {
            return 0;
        } else if (a[mid_i][mid_j] > n) {
            int r1 = mid_j == j_low ? -1 : search(i_low, i_high, j_low, mid_j - 1, a, n);
            int r2 = mid_i == i_low ? -1 : search(i_low, mid_i - 1, mid_j, j_high, a, n);
            return Math.max(r1, r2);
        } else {
            int r1 = mid_i == i_high ? -1 : search(mid_i + 1, i_high, j_low, j_high, a, n);
            int r2 = mid_j == j_high ? -1 : search(i_low, mid_i, mid_j + 1, j_high, a, n);
            return Math.max(r1, r2);
        }
    }
}