package binarySearch;

import java.util.Arrays;
//code
public class aggressiveCows {
    public static void main(String[] args) {
        int[] arr = {0,3,4,7,10,9};
        int k = 4;
        System.out.println(aggressiveCows(arr, k));
    }
    
    static boolean cows(int[] arr, int k, int mid){
        int cows = 1;//initially there will be one cow at first index of array
        int last = arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i]-last>=mid){//check if distance between current stall and last stall is greater than or equal to min distance
                cows++;//if yes place a cow there
                last = arr[i];//and make that the last stall
            }
        }
        if(cows>=k) return true;//if now of cows placed are equal or higher than given cows return true
        return false;
    }
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int s = 1;
        int n = stalls.length;
        int e = stalls[n-1] - stalls[0];
        int ans = -1;

        while(s<=e){
            int mid = s + (e-s)/2;

            if(cows(stalls,k,mid)){
                ans = mid;
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return ans;
    }
}
