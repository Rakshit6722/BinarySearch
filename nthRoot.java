package binarySearch;

public class nthRoot {
    public static void main(String[] args) {
        System.out.println(NthRoot(3, 27));
        System.out.println(Root(3, 27));
    }

    //binary search - using Math func
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int s = 1;
        int e = m;
        int ans = -1;

        while(s<=e){
            int mid = s + (e-s)/2;
            if(Math.pow(mid,n)==m){
                ans = mid;
                return ans;
            }
            if(Math.pow(mid,n)>m){
                e = mid - 1;
            }
            else{
                
                s = mid + 1;
            }
    }
    return ans;
    }

    //binary search - using manual func to cal powers

    public static int power(int n, int m, int mid){
        int ans = 1;
        for(int i=1;i<=n;i++){
            ans *= mid;
        }
        if(ans==m) return 1;
        if(ans>m) return 2;
        return 0;
    }

    public static int Root(int n, int m){
        int s = 1;
        int e = m;

        while(s<=e){
            int mid = s + (e-s)/2;
            int val =  power(n, m, mid);

            if(val==1){
                return mid;
            }
            else if(val == 2){
                e = mid - 1;
            }
            else{
                s = m + 1;
            }

        }
        return -1;
    }
}
