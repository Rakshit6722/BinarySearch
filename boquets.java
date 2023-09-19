package binarySearch;

//return min no of days to make m boquets using k flowers i which will bloom on arr[i] days
public class boquets {
    public static void main(String[] args) {
        int[] arr = {7,7,7,7,12,7,7};
        int m = 2; //no of boquest we have to make
        int k = 3; //adjacent flowers required to make a boquet
        System.out.println(minDays(arr, m, k));
    }

    public static boolean boquet(int[] arr, int mid, int m, int k) {
        int count = 0;
        int nob = 0;

        for (int i = 0; i < arr.length; i++) {
            if (mid >= arr[i]) {//if mid is greater than or equal to arr[i] we will keep increasing count
                count++;
            } else {//the moment arr[i] > mid we will divide the count by k(no of flowers) to find out noOfBoquest formet by adjacent flowers and set count to 0 again
                nob += (count / k);
                count = 0;
            }
        }
        nob += count / k;//this is for last value of count after count was set to zero
        if (nob >= m)//if nob >= m then return true 
            return true;
        return false;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        if ((m * k) > bloomDay.length) //edge case - when flowers required are more than the flowers we have
            return -1;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] > max)
                max = bloomDay[i];
            else if (bloomDay[i] < min)
                min = bloomDay[i];
        }
        int s = min;//min day on which first flower will bloom will be min element of array
        int e = max;//max day on which all flowers will bloom will be max element of array
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (boquet(bloomDay, mid, m, k) == true) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
}
