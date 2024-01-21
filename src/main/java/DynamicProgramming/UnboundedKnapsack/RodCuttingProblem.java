package DynamicProgramming.UnboundedKnapsack;

import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int length[] = {1,2,3,4,5,6,7,8};
        int price[]  = { 1, 5, 8, 9, 10, 17, 17, 20 };

        spaceOptimizedTabular(length, price, price.length);

    }

//    public static int recursion(int[] length, int[] price, int n){
//        if(n==0) return 0;
//        return recursion(length, price, )
//    }

    public static void spaceOptimizedTabular(int[] length, int[] price, int n){
        int dp[] = new int[n+1];
        for (int i=0; i< n; i++){  //i++ and j-- will be inside implementation code
            for (int j=1; j<=n;j++){
                if (j>=length[i]){
                    dp[j] = Math.max(dp[j], price[i] + dp[j-length[i]]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
