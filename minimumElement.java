package binarySearch;

public class minimumElement {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(findMin(arr));
    }
    public static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int s = 0;
        int e  = nums.length - 1;

        while(s<=e){

            int m = s + (e-s)/2;

            //if left is sorted
            if(nums[s]<=nums[m]){
                min = Math.min(min,nums[s]);//this part is sorted so it is obvious the first element or nums[s] will be lowest
                s = m + 1; //trim down left part
            }
            //if right is sorted
            else{
                min = Math.min(min,nums[m]);//this part is sorted so it is obvious the first element or nums[m] will be lowest
                e = m - 1; //trim down right part
            }
        }
        return min;
    }

}
