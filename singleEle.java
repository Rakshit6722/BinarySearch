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

    //binary search
    public int single(int[] nums) {
        int n = nums.length;

        //edge testcases
        if(n==1) return nums[0]; // if length is 1
        if(nums[0]!=nums[1]) return nums[0]; // for first element
        if(nums[n-1]!=nums[n-2]) return nums[n-1]; // for last element

        //binary search starts
        int s = 1; //from second element
        int e = n - 2; //till second last element
        int ans = -1;
        while(s<=e){
            int m = s + (e-s)/2;

            //checking if element is single element
            if(nums[m]!=nums[m+1] && nums[m]!=nums[m-1]) ans = nums[m];

            //we are on left part, element will be on right part so trim left part
            if(m%2!=0 && nums[m-1]==nums[m] || m%2==0 && nums[m] == nums[m+1]){
                s = m + 1;
            }

            //we are on right part, element will be on left part so trim righ part
            else{
                e = m - 1;
            }
        }
        return ans;

    }
}
