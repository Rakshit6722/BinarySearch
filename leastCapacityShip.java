package binarySearch;

public class leastCapacityShip {
    public static void main(String[] args) {
        int[] arr = {3,2,2,4,1,4};
        int days = 3;
        System.out.println(shipWithinDays(arr, days));
    }

    //func to find least capacity
    public static boolean capacity(int[] arr, int days, int mid) {
        int day = 1; //intially day will be 1 and load will be 0
        int load = 0;
        for (int i = 0; i < arr.length; i++) {
            if (load + arr[i] > mid) { //if any point load is greater than the capacity shift load to another day and increment day by 1;
                day += 1;
                load = arr[i];
            } else {//else keep adding the load
                load += arr[i];
            }
        }
        if (day <= days)//if day is equal or smaller to given days return true
            return true;
        return false;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > max) {
                max = weights[i];
            }
            sum += weights[i];
        }
        int s = max;
        int e = sum;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (capacity(weights, days, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;

    }
}
