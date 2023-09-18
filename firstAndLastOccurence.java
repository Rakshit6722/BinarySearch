package binarySearch;

import java.util.Arrays;

public class firstAndLastOccurence {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,4};
        int[] ans = searchRange(arr, 4);
        for(int i = 0;i<ans.length;i++){
            System.out.println(ans);
        }

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = firstOccurence(nums, target);
        ans[1] = lastOccurence(nums, target);
        return ans;
    }

    public static int firstOccurence(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int m = s + (e - s) / 2;
        int ans = -1;

        while (s <= e) {
            if (nums[m] == target) {
                ans = m;
                e = m - 1;
            } else if (nums[m] > target) {
                e = m - 1;

            } else {
                s = m + 1;

            }
            m = s + (e - s) / 2;
        }
        return ans;
    }

    public static int lastOccurence(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int m = s + (e - s) / 2;
        int ans = -1;

        while (s <= e) {
            if (nums[m] == target) {
                ans = m;
                s = m + 1;
            } else if (nums[m] > target) {
                e = m - 1;

            } else {
                s = m + 1;

            }
            m = s + (e - s) / 2;
        }
        return ans;
    }
}
