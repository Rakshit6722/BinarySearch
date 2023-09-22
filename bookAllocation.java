import java.util.*;

public class bookAllocation {
    public static void main(String[] args) {
        ArrayList<Integer> books = new ArrayList<>();//arr[i] is no of pages in ith book
        books.add(12);
        books.add(34);
        books.add(67);
        books.add(90);
        int n = books.size();
        int m = 2; //no of students
        System.out.println();
    }

    //func to count students
    public static boolean countStudents(ArrayList<Integer> arr, int mid, int m){
        int students = 1;//initally student will be one 
        int studPages = 0;

        for(int i=0;i<arr.size();i++){
            if(studPages+arr.get(i)<=mid){//if no of pages + next book pages is less than or equal to mid(limit)
                studPages+=arr.get(i);
            }
            else{//otherwise allot book to new student and put studPages = curr arr[i];
                students++;
                studPages=arr.get(i);
            }
        }
        if(students<=m){
            return true;
        }
        return false;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        
        if(m>arr.size()) return -1;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<arr.size();i++){
            if(arr.get(i)>max) max = arr.get(i);
            sum+=arr.get(i);
        }
        int s = max;
        int e = sum;
        int ans = -1;

        while(s<=e){
            int mid = s + (e-s)/2;

            if(countStudents(arr, mid, m)){
                ans = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return ans;
    }
}
