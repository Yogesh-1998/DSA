package GFGTop100InterviewQuestions.Arrays;

import java.util.Arrays;
import java.util.HashSet;

//https://www.geeksforgeeks.org/check-if-pair-with-given-sum-exists-in-array/

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {0, -1, 2, 3,1};
        int x= -2;
        int n = arr.length;

        System.out.println(nsquare(arr, x, n));
        System.out.println(hash(arr, x, n));
        System.out.println(twoPointer(arr, x, n));
        System.out.println(usingBinarySearch(arr, x, n));
        System.out.println(usingBinarySearch(arr, x, n));
    }

    private static boolean binarySearch(int[] arr, int x, int i, int j){
        int mid;
        while (i<=j){
            mid = (i+j)/2;
            if (arr[mid] < x){
                i = mid;
            } else if (arr[mid] == x) {
                return true;
            }else {
                j = mid-1;
            }
        }
        return false;
    }

    private static boolean usingBinarySearch(int[] arr, int x, int n) {
        Arrays.sort(arr);
        for (int i=0; i < n-1; i++){
            if (binarySearch(arr, x-arr[i], i+1, n-1)) return true;
        }
        return false;
    }

    private static boolean twoPointer(int[] arr, int x, int n) {
        Arrays.sort(arr);
        int j=n-1;
        for (int i=0; i<j; ){
            if (arr[i]+ arr[j] == x){
                return true;
            }else if (arr[i]+arr[j] < x){
                i++;
            }else j-- ;
        }
        return false;
    }

    public static boolean nsquare(int[] arr, int x, int n){
        for (int i=0; i < n-1 ; i++){
            int ans = x - arr[i];
            for (int j = i+1 ; j < n ; j++){
                if (ans - arr[j] == 0)
                    return true;
            }
        }
        return false;
    }

    public static boolean hash(int[] arr, int x, int n){
        HashSet<Integer> hashSet = new HashSet<>();
        int ans=0;
        for (int i=0; i<n;i++){
            ans = x - arr[i];
            if (hashSet.contains(arr[i])) return true;
            else hashSet.add(ans);
        }
        return false;
    }


}
