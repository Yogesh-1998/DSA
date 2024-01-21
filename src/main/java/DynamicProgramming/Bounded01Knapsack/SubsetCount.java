package DynamicProgramming.Bounded01Knapsack;

public class SubsetCount {
    public static void main(String[] args) {
        int arr[] = {3, 3, 3, 3 };
        int sum =6;
        //Similar to subset sum...instead to using or operator add the values
        spaceOptimizedTabular(arr, arr.length, sum);
    }

    public static void spaceOptimizedTabular(int[] arr, int n, int sum){
        int dp[] = new int[sum+1];
        dp[0] =1;
        for (int i=0; i<n;i++){
            for (int j=sum; j>=0; j--){
                if(j >= arr[i]) {
                    dp[j] = dp[j] + dp[j - arr[i]] ;
                }
            }
        }
        System.out.println("ABC: "+dp[sum]);
    }
}
