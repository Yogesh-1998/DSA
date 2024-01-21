package DynamicProgramming.Bounded01Knapsack;

public class SubsetSum {
    public static void main(String[] args) {
        int arr[] = {2,3,7,8,10};
        int n = arr.length;
        int sum =4;
        int [][]dp = new int[n+1][sum+1];
        for ( int i = 0; i<=n; i++){
            for( int j=0; j<=sum; j++){
                dp[i][j]=-1;
            }
        }
//        System.out.println(memoization(dp,arr, n-1 , sum, 0));
        boolean [][]dp1 = new boolean[n+1][sum+1];
        for (int i=0; i<= n; i++){
            for (int j=0; j<= sum; j++){
                if (i==0){
                    dp1[i][j]=false;
                } else if (j==0) {
                    dp1[i][j]= true;
                } else {
                    if (arr[i-1] <= j){
                        dp1[i][j] = (dp1[i-1][j] || dp1[i-1][j-arr[i-1]]);
                    }else {
                        dp1[i][j] = dp1[i-1][j];
                    }
                }
            }
        }

        for ( int i = 0; i<=n; i++){
            for( int j=0; j<=sum; j++){
                System.out.print(dp1[i][j] + " ");
            }
            System.out.println();
        }

        spaceOptimizedTabular(arr, n,sum);
    }

    public static boolean recursion(int[] arr, int n, int sum, int counter){
        if(sum==0){
            return true;
        }
        if (counter > n || sum < 0)
            return false;

        return recursion(arr, n, sum - arr[counter], counter+1) || recursion(arr, n , sum, counter + 1);
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

    public static void spaceOptimizedTabular(int[] arr, int n, int sum){
        boolean dp[] = new boolean[sum+1];
        dp[0] = true;
        for (int i=0; i<n;i++){
            for (int j=sum; j>=0; j--){
                if(j>= arr[i]) {
                    dp[j] = dp[j] || dp[j - arr[i]] ;
                }
            }
        }
        System.out.println("ABC: "+dp[sum]);
    }

}
