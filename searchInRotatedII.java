package binarySearch;

public class searchInRotatedII {
    public static void main(String[] args) {
        int[] arr = {1,1,6,1,0,1,1};
        System.out.println(search(arr, 0));
    }

    public static boolean search(int[] nums, int target) {

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (nums[m] == target)
                return true;

            if (nums[s] == nums[m] && nums[m] == nums[e]) { //when elements at all three positions are same
                s = s + 1;

                e = e - 1;
                continue;
            }

            if (nums[s] <= nums[m]) {
                if (nums[s] <= target && target <= nums[m]) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            } else {
                if (nums[m] <= target && target <= nums[e]) {
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
        }
        return false;
    }
}
