package binarySearch;

public class KthpositiveMissingInteger {
    public static void main(String[] args) {
        int[] arr ={2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }

    //brute force
    // public static int findKthPositive(int[] arr, int k) {
    //     for(int i=0;i<arr.length;i++){
    //         if(arr[i]<k) k++; //keep inceremeting k till arr[i]<=k otherwise break the loop
    //         else break;
    //     }
    //     return k;
    // }

    //optimal approach
    public static int findKthPositive(int[] arr, int k) {
        int s = 0;
        int e = arr.length-1;
        
        while(s<=e){
            int mid = s + (e-s)/2;
            int missing = arr[mid] - (mid+1); //finding the missing element on that index

            if(missing<k){//if missing element is smaller than k search on the right side
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return s + k;
    }
}
