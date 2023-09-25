package binarySearch;

public class search2Darray {
    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(arr, target));
    }

    //linear search
    // public static boolean searchMatrix(int[][] matrix, int target) {
    //     int n = matrix.length;
    //     int m = matrix[0].length;

    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             if(matrix[i][j]==target) return true;
    //         }
    //     }
    //     return false;
    // }

    //using binary search in each row
    public static boolean searchRow(int[] arr, int target){
        int s = 0;
        int e = arr.length - 1;

        while(s<=e){
            int mid = s + (e-s)/2;

            if(arr[mid]==target) return true;

            else if(arr[mid]>target) e = mid - 1;
            else s = mid + 1;
        }
        return false;
    } 
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0;i<n;i++){
            if(searchRow(matrix[i],target)) return true;  //applying binary search in each row  
        }
        return false;
    }
}
