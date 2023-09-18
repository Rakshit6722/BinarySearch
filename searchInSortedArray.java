package binarySearch;

public class searchInSortedArray {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target)
                return m;

            //search for which part is sorted - left/right
            // left part
            if (nums[s] <= nums[m]) {
                if (nums[s] <= target && target <= nums[m]) {//if ans lies in left part eliminate right part
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }
            // right part
            else {
                if (nums[m] <= target && target <= nums[e]) {//if ans lies in right part eliminate left part
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
        }
        return -1;
    }
}
