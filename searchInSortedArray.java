package binarySearch;

public class searchInSortedArray {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(search(arr, target));
    }

    // linear search/brute force
    // public static int search(int[] nums, int target) {
    // int s = 0;
    // int e = nums.length - 1;

    // while (s <= e) {
    // int m = s + (e - s) / 2;
    // if (nums[m] == target)
    // return m;

    // //search for which part is sorted - left/right
    // // left part
    // if (nums[s] <= nums[m]) {
    // if (nums[s] <= target && target <= nums[m]) {//if ans lies in left part
    // eliminate right part
    // e = m - 1;
    // } else {
    // s = m + 1;
    // }
    // }
    // // right part
    // else {
    // if (nums[m] <= target && target <= nums[e]) {//if ans lies in right part
    // eliminate left part
    // s = m + 1;
    // } else {
    // e = m - 1;
    // }
    // }
    // }
    // return -1;
    // }

    //binary search
    public static int search(int[] nums) {

        int n = nums.length;
        if (n == 1)
            return 0;
        if (nums[0] > nums[1]) //first element
            return 0;
        if (nums[n - 1] > nums[n - 2])//last element
            return n - 1;

        int s = 1; //from second element
        int e = n - 2; //to second last element

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (nums[m] > nums[m + 1] && nums[m] > nums[m - 1]) { //check if nums[m] is peak element
                return m;
            }

            if (nums[m] > nums[m + 1]) { //if nums[m] is on decreasing curve peak will be one left part so trim right part
                e = m - 1;
            } else { //if nums[m] is on increasing curve peak will be on right part so trim left part
                s = m + 1;
            }
        }
        return -1;//if nothing is found
    }
}
