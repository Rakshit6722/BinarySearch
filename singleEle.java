package binarySearch;

public class singleEle {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,4,5,5};
        System.out.println(singleNum(arr));
        System.out.println(singleNonDuplicate(arr));
    }

    //brute force
    public static int singleNum(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(i==0){//first element
                if(arr[i]!=arr[i+1]) return arr[i];
            } 
            if(i==n-1){//last element
                if(arr[i]!=arr[i-1]) return arr[i];
            }
            else{//rest elements
                if(arr[i]!=arr[i+1] && arr[i]!=arr[i-1]){
                    return arr[i];
                }
            }
        
        }
        return -1;
    }

    //method - 1 (XOR)
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            ans ^= nums[i];
        }
        return ans;
    }
}
