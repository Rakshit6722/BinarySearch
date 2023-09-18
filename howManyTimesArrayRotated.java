package binarySearch;

public class howManyTimesArrayRotated {

    //return the index of min element in the rotated arr that will be your answer
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(findKRotation(arr));
    }
    public static int findKRotation(int []arr){
        // Write your code here.
        int s = 0;
        int e = arr.length - 1;
        int min = Integer.MAX_VALUE;

        while(s<=e){
            int m = s + (e-s)/2;

            //if left part is sorted, high chances min will be in right part so trim left part
            if(arr[s]<=arr[m]){
                min = Math.min(min,arr[s]);//if sorted the first element of left will be minimum
                s = m + 1;
            }
            else{//if right part is sorted, high chance min will be in left part so trim right part
                min = Math.min(min,arr[m]);//if sorted the first element of right part will be minimum
                e = m - 1;
            }
        }

        //for returning the idex of minimum
        for(int i=0;i<arr.length;i++){
            if(min==arr[i]){
                return i;
            }
        }
        return -1; //if nothing is found
        

    }
}
