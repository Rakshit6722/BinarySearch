package binarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class KthElementTwoSortedArr {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(4);
        arr1.add(5);
        arr1.add(6);
        
        int k = 4;//4th element of merged array if k start from 1

        System.out.println(kthElement(arr1, arr2, k));

    }

    //brute force
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int k) {

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr1.size(); i++) {
            ans.add(arr1.get(i));
        }

        for (int i = 0; i < arr2.size(); i++) {
            ans.add(arr2.get(i));

        }
        Collections.sort(ans);
        int s = 0;
        int e = ans.size() - 1;
        int res = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (mid == k) {
                res = ans.get(mid - 1);
            }
            if (mid > k) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;

    }
}
