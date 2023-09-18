package binarySearch;
//similar to lower bound
public class searchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1,2,5,6};
        int target = 4;
        System.out.println(searchInsert(arr, target));
    }
    public static  int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int m = s + (e-s)/2;
        int ans = nums.length;

        while(s<=e){
            m = s + (e-s)/2;
            if(nums[m]>=target){
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
