package binarySearch;

public class singleEle {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,4,5,5};
        System.out.println(singleNonDuplicate(arr));
    }

    //method - 1 (XOR)
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            ans ^= nums[i];
        }
        return ans;
    }
}
