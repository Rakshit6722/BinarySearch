package binarySearch;


//similar to finding out ceil 
public class squareRoot {
    public static void main(String[] args) {
        long n = 7;
        System.out.println(sqrtN(n)); 
    }

    //binary search
    public static int sqrtN(long N) {

		 long s = 1;
		 long e = N;
		 long ans = -1;

		 while(s<=e){
			 long m = s + (e-s)/2;

			 if((m*m)>N){// if square of m if greater than n the eliminte right part and look for it left part
				
				 e = m - 1;
			 }
			 else{// if square of m is lesser than or equal to n store it in ans and further look for it in right part
				 ans = m;
				 s = m + 1;
			 }
		 }
		 return (int)ans;
	}
}
