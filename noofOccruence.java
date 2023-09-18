package binarySearch;

public class noofOccruence {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,5,5,5,5};
        System.out.println(count(arr, 9, 5));
    }
    
    public static int count(int arr[], int n, int x) {
        int[] ans = firstAndLast(arr, x);
        if(ans[0]==-1) return 0; //if first element of arr is -1 that mean the element is not present therefore its count will be zero
        return(ans[1] - ans[0] + 1);//otherwise return the count with this formula
    }

    public static int[] firstAndLast(int[] arr, int x){
        int first = countLeft(arr, x);
        if(first==-1) return new int[] {-1,-1}; //if first is still -1 that mean the element is not present in arr so return {-1,-1} as arr
        int last = countRight(arr, x);
        return new int[] {first,last};
    }


    //to find first occurrence of element
    public static int countLeft(int[] arr, int x) {
        int s = 0;
        int e = arr.length - 1;
        int m = s + (e - s) / 2;
        int first = -1;

        while (s <= e) {
            if (arr[m] == x) {
                first = m;
                e = m - 1; //we will look for first occurrence in left party of arr
            } else if (arr[m] > x) {
                e = m - 1;
            } else {
                s = m + 1;
            }
            m = s + (e - s) / 2;
        }
        return first;
    }

    public static int countRight(int[] arr, int x) {
        int s = 0;
        int e = arr.length - 1;
        int m = s + (e - s) / 2;
        int last = -1;

        while (s <= e) {
            if (arr[m] == x) {
                last = m;
                s = m + 1; // look for second occurrence in right part of arr
            } else if (arr[m] > x) {
                e = m - 1;
            } else {
                s = m + 1;
            }
            m = s + (e - s) / 2;
        }
        return last;
    }
}
