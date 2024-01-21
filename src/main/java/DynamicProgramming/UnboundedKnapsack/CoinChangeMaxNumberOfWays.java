package DynamicProgramming.UnboundedKnapsack;

public class CoinChangeMaxNumberOfWays {

    public static void main(String[] args) {
//        int coin[] = {1,2,3};
        int coin[] = {2,5,3,6};
        int n=coin.length;
//        int sum =5;
        int sum =10;

        int dp[] = new int[sum+1];

        for(int i=0; i<n;i++){
            for (int j=0; j<=sum; j++){
                if(j == coin[i]) {
                    dp[j] = dp[j] + 1;
                }else if(j>coin[i]){
                    dp[j] = dp[j] + dp[j - coin[i]];
                }
            }
        }
        System.out.println(dp[sum]);
    }
}
