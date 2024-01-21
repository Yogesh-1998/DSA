package GFGTop100InterviewQuestions.Arrays;


//https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
public class DuplicateElements {

    public static void main(String[] args) {
        int arr[] ={1, 2, 3, 6, 3, 6, 1};
        int n=7;
        int temp = -1;
        for (int i=0; i< n; i++){
            temp = arr[i]%n;
            arr[temp] = arr[temp] + n;
            arr[i] = arr[i] - 2*n;
        }
        for (int i=0; i< n ; i++){
            if (arr[i] >=0) System.out.println(i);
        }
    }



}
