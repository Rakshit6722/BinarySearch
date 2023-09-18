package binarySearch;

//lower bound - smallest index such that arr[idx]>=x
//if all elements are smaller than arr return size of array

public class lowerBound {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3};
        System.out.println(lowerbound(arr, 0));
    }
    static int lowerbound(int[] arr, int x){
        int n = arr.length;
        int s = 0;
        int e = n - 1;
        int m = s + (e-s)/2;
        int ans = n;

        while(s<=e){
            m = s + (e-s)/2;

            //if you find the element greater than x then update it in ans and reduce the search space to e = m - 1
            //as elements on right side of that element obviously be greater and we have to found the minimum index
            if(arr[m]>=x){
                ans = m;
                e = m - 1;
            }
            else{
                s = m + 1;
            }
        }
        return ans;

    }
}
