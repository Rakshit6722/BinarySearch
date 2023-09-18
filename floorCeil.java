package binarySearch;

import java.util.Arrays;

public class floorCeil {
    public static void main(String[] args) {
        int[] arr = {4,3,8,4,7,10};
        System.out.println(floor(arr, 8));
        System.out.println(ceil(arr, 8));
    }

    //floor -> largest element <= x
    static int floor(int[] arr, int x){
        Arrays.sort(arr);
        int s = 0;
        int e = arr.length - 1;
        int m  = s + (e-s)/2;
        int ans = -1;

        while(s<=e){
            if(arr[m]<=x){
                ans = arr[m];
                s = m + 1;
            }
            else{
                e = m - 1;
            }
            m = s + (e-s)/2;
        }
        return ans;
    }

    //ceil -> smallest element >= x
    static int ceil(int[] arr, int x){
        Arrays.sort(arr);
        int s = 0;
        int e = arr.length - 1;
        int m  = s + (e-s)/2;
        int ans = -1;

        while(s<=e){
            if(arr[m]>=x){
                ans = arr[m];
                e = m - 1;
            }
            else{
                s = m + 1;
            }
            m = s + (e-s)/2;
        }
        return ans;
    }
}
