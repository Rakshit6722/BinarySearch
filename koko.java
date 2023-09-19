package binarySearch;

public class koko {
    public static void main(String[] args) {

    }

    //to calculate total time if koko eat x bananas per houro
    public static int time(int[] v, int mid) {
        int sum = 0;
        for (int i = 0; i < v.length; i++) {
            sum += Math.ceil((double) v[i] / (double) mid);
        }
        return sum;
    }

    public static int minimumRateToEatBananas(int[] v, int h) {
        
        int s = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < v.length; i++) {
            if (v[i] > max) {
                max = v[i];
            }
        }
        int e = max;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int sum = time(v, mid);

            if (sum <= h) { //if time is equal to or less than given time we'll store that in ans and look in left part to find if we can eat less banans within given time 
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;

    }
}
