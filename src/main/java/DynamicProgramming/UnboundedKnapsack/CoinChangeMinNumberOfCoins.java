package DynamicProgramming.UnboundedKnapsack;

public class CoinChangeMinNumberOfCoins {
    public static void main(String[] args) {
//        int coin[] = {1,2,3};
//        int coin[] = {25,10,5};
        int coin[] = {2,5,3,6};
        int n=coin.length;
//        int sum =5;
//        int sum =30;
        int sum =10;

        int dp[] = new int[sum+1];
        for (int i=1; i<= sum; i++)
            dp[i] = Integer.MAX_VALUE-1;

        for(int i=1; i< n;i++){
            for (int j=0; j<=sum; j++){
                if(j >= coin[i]){
                    int abc = dp[j - coin[i]];
                    if (abc != Integer.MAX_VALUE && abc+1 < dp[j])
                        dp[j]  = abc+1;
                }
            }
        }
        System.out.println(dp[sum]);
    }
}
