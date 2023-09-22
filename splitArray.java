package binarySearch;

public class splitArray {
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        int k = 2;//no of ways to break the array
        System.out.println(splitArray(arr, k));
    }
    public static boolean countSum(int[] arr, int mid, int k){
        int s = 1;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(sum+arr[i]<=mid){//keep adding arr[i] in sum till it becomes greater than mid
                sum+=arr[i];
            }
            else{
                s++;
                sum = arr[i];
            }
        }
        if(s<=k) return true; //if s is lesser or equal to k return true
        return false;
    }
    public static int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max) max = nums[i];
            sum += nums[i];
        }
        int s = max;
        int e = sum;
        int ans = -1;

        while(s<=e){
            int mid = s + (e-s)/2;

            if(countSum(nums,mid,k)){
                ans = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return ans;
    }


}
