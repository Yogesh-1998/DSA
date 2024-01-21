package DynamicProgramming.Bounded01Knapsack;

public class EqualSumPartition {
    public static void main(String[] args) {
        int arr[] = {1,5,11, 5};
        int n = arr.length;

        System.out.println(recursion(arr, n-1, 0,0));

        // For equal sum partition find the subsetsum of sum(arr)/2 - use subsetsum technique.
        // here we will just check if the sum is not going greater than sum/2 to fit in dp
        // We will also check if the sum is off or even


    }

    public static boolean recursion(int arr[], int n, int sum1, int sum2){
        if(n==-1 && sum1==sum2){
            return true;
        } else if (n==-1 && sum1 != sum2) {
            return false;
        }
        return recursion(arr,n-1, sum1+arr[n], sum2) || recursion(arr, n-1, sum1, sum2+arr[n]);
    }

    public static int memoization(int [][] dp, int[] arr, int n, int sum, int counter){
        if(sum==0){
            return 1;
        }
        if (counter > n || sum < 0)
            return 0;
        if(dp[counter][sum] != -1)
            return dp[counter][sum];

        if (arr[counter] > sum){
            return dp[counter][sum] = memoization( dp, arr, n , sum, counter + 1);
        }

        if( memoization(dp, arr, n, sum - arr[counter], counter+1 ) !=0 || memoization( dp, arr, n , sum, counter + 1)!=0) {
            return dp[counter][sum] = 1;
        }else {
            return dp[counter][sum] = 0;
        }
    }

}
