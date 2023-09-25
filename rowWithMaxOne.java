package binarySearch;

import java.util.ArrayList;

public class rowWithMaxOne {
    public static void main(String[] args) {

        //if you want to use arraylist as a 2D matrix
        ArrayList<ArrayList<Integer>> arr1 = new ArrayList<>();
        for(int i=0;i<3;i++){
            ArrayList<Integer> arr2 = new ArrayList<>();//creating arraylist for each row 
            arr1.add(arr2);//adding them in main arraylist
        }
        //1st row
        arr1.get(0).add(0);
        arr1.get(0).add(0);
        arr1.get(0).add(1);
        arr1.get(0).add(1);
        arr1.get(0).add(1);

        //2nd row
        arr1.get(1).add(0);
        arr1.get(1).add(0);
        arr1.get(1).add(0);
        arr1.get(1).add(0);
        arr1.get(1).add(0);

        //3rd row
        arr1.get(2).add(1);
        arr1.get(2).add(1);
        arr1.get(2).add(1);
        arr1.get(2).add(1);
        arr1.get(2).add(1);
       
        System.out.println(maximumOnesRow(arr1, 3, 5));
    }


    //brute force
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        
        int idx = -1;
        int max_cnt = -1;

        for (int i = 0; i < n; i++) {//iterating from 1st row to last
            int cnt_one = 0;
            for (int j = 0; j < m; j++) {//iterating from 1st col to last
                cnt_one += matrix.get(i).get(j);//finding total no of one's in the row
            }
            if (cnt_one > max_cnt) {
                max_cnt = cnt_one;
                idx = i;
            }
        }
        return idx;
    }
}
