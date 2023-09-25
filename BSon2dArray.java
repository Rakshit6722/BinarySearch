package binarySearch;

public class BSon2dArray {
    public static void main(String[] args) {
        int[][] arr = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        System.out.println(searchMatrix(arr, target));
    }

    //binary search
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int r = 0; //start from first row
        int c = m - 1; //start from end col

        while(r<n && c >=0){
            if(matrix[r][c]==target) return true; //if target found

            if(matrix[r][c]<target) r++; //if target is greater than current element move to next row
            else c--;//if element is greater than target move to previous col
        }
        return false;
    }
}
