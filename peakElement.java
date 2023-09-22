package binarySearch;

//peak element - arr[i-1]<arr[i]>arr[i+1]

public class peakElement {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,2,1};
        System.out.println(findPeakElement(arr));
    }
    public static int findPeakElement(int[] nums) {

        int n = nums.length;
        if(n==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;

        int s = 1;
        int e = n-2;

        while(s<=e){
            int m = s + (e-s)/2;

            if(nums[m]>nums[m+1] && nums[m]>nums[m-1]){
                return m;
            }

            if(nums[m]>nums[m+1]){ //mid is on decreasing curve so peak will be at left so trim right
                e = m - 1;
            }
            else{ //mid is on increasing curve so peak will be at right so trim left
                s = m + 1;
            }
        }
        return -1;
    }
}
