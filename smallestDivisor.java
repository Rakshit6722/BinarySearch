package binarySearch;

public class smallestDivisor {
    public static void main(String[] args) {
        int nums[] = {1,2,5,9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold));
    }
    public static boolean smallest(int[] nums, int threshold, int mid){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += Math.ceil((double)nums[i]/(double)mid);
        }
        if(sum<=threshold) return true;
        return false;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int s = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max) max = nums[i];
        }
        int e = max;
        int ans = -1;

        while(s<=e){
            int mid = s + (e-s)/2;

            if(smallest(nums,threshold,mid)==true){
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
