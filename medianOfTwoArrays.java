package binarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class medianOfTwoArrays {
    public static void main(String[] args) {

    }

    //brute force --->
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            res.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            res.add(nums2[i]);
        }
        Collections.sort(res);
        
        int n = res.size();
        double ans = 0;
        double mid = 0;
        double mid1 = 0;
        if (n % 2 != 0) {//if array is of odd length the simply return n/2 element(mid element)
            ans = res.get(res.size() / 2);
            // return ans;
        }

        else { //in case of even length of array
            mid = res.get(res.size() / 2);
            mid1 = res.get(res.size() / 2 - 1);
            ans = (mid + mid1) / 2;
        }
        return ans;
    }
}
