package binarySearch;

public class peakElement {

    //peak element = arr[i-1] < arr[i] > arr[i+1]
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,2};
        System.out.println(findPeakElement(arr));
    }

    //brute force
    public static int findPeakElement(int[] nums) {

        int n = nums.length;

        if(n==1) return 0;

        for(int i=0;i<n;i++){
            if(i==0){ //first element
                if(nums[i]>nums[i+1]) return i;
            }
            if(i==n-1){ //last element
                if(nums[n-1]>nums[n-2]) return n-1;
            }
            else{ //rest elements
                if(nums[i]>nums[i+1] && nums[i]>nums[i-1]){
                    return i;
                }
            }
        }
        return -1;
    }
}
