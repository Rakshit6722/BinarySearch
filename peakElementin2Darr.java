package binarySearch;

import java.util.Arrays;


//peak element in 2D matrix => element should be greater than its right, left, bottom and top element;
//if there is no element in the  right or left or top or bottom of some element assume -1

public class peakElementin2Darr {
    public static void main(String[] args) {
        int[][] arr = {{10,20,15},{21,30,14},{7,16,32}};
        int[] ans = findPeakGrid(arr);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
        }

    public static int row(int[][] arr, int n, int mid) {
        int idx = -1;
        int max = -1;
        for (int i = 0; i < n; i++) { //iterating through mid col
            if (arr[i][mid] > max) { //if ele greater than max, max = that element
                max = arr[i][mid];
                idx = i; //idx = max element row no
            }
        }
        return idx;
    }

    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length; //row-wise length 
        int m = mat[0].length; //col-wise length

        int low = 0; //intial 
        int high = m - 1; // end 

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxRowIdx = row(mat, n, mid); //find out the row no of max element in mid col
            int left = mid - 1 >= 0 ? mat[maxRowIdx][mid - 1] : -1; //if left of mid is no element assume -1
            int right = mid + 1 < m ? mat[maxRowIdx][mid + 1] : -1; //if right of mid is no element assume -1

            if (mat[maxRowIdx][mid] > left && mat[maxRowIdx][mid] > right) { //if found return idx values
                return new int[] { maxRowIdx, mid };
            } else if (mat[maxRowIdx][mid] > left) { //if mid is on increasing curve peak will be on right part eliminate left part
                low = mid + 1;
            } else {//if mid on decreasing curve peak will be on left peak will be on left eliminate right part 
                high = mid - 1;
            }
        }
        return new int[] { -1, -1 };
    }
}
