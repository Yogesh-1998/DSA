package DynamicProgramming.Bounded01Knapsack;

public class maxProfit {
    static int dp[][];

    public static void main(String[] args) {
        int weight[] = {1,3,4,5};
        int value [] = {1,4,5,7};
        int n= weight.length;
        int bagweight =6;

        dp = new int[n+1][bagweight+1];
        for ( int i = 0; i<=n; i++){
            for( int j=0; j<=bagweight; j++){
                dp[i][j]=-1;
            }
        }

        System.out.println(calcRecursion(bagweight, weight, value,0 ,n-1 ));

//        System.out.println(calcMemoization(bagweight, weight, value,0 ,n-1 ));

        //Tabular
        for ( int i = 0; i<=n; i++){
            for( int j=0; j<=bagweight; j++){
                if (i==0 || j==0){
                    dp[i][j] = 0;
                }else {
                    if(weight[i-1] <= j){
                        dp[i][j] = Math.max( value[i-1] + dp[i-1][j-weight[i-1]] , dp[i-1][j] );
                    }else{
                        dp[i][j]= dp[i-1][j];
                    }
                }
            }
        }
        for ( int i = 0; i<=n; i++){
            for( int j=0; j<=bagweight; j++){
                System.out.print( dp[i][j] +  " ");
            }
            System.out.println();
        }

        spaceOptimizedTabular(weight, value, n,bagweight);

    }

    public static int calcRecursion(int bagWeight, int[] weight, int[] value, int prof,  int n ){
        if(n == 0) return prof;
        if(bagWeight >= weight[n]){
            return Math.max(calcRecursion(bagWeight, weight , value, prof, n-1 ),
                    calcRecursion(bagWeight-weight[n], weight, value, prof+value[n], n-1));
        }else {
            return calcRecursion( bagWeight, weight , value, prof , n-1 ) ;
        }
    }

    public static int calcMemoization(int bagWeight, int[] weight, int[] value, int prof,  int n ){
        if(n == 0 || bagWeight==0) return prof;
        if (dp[bagWeight][n+1] != -1){
            return dp[bagWeight][n+1];
        }
        if(bagWeight >= weight[n]){
            return dp[bagWeight][n+1] = Math.max(calcRecursion(bagWeight, weight , value, prof, n-1 ),
                    calcRecursion(bagWeight-weight[n], weight, value, prof+value[n], n-1));
        }else {
            return dp[bagWeight][n+1] = calcRecursion( bagWeight, weight , value, prof , n-1 ) ;
        }
    }

    public static void spaceOptimizedTabular(int[] weight, int[] values,int n, int bagweight){
        int dp[] = new int[bagweight+1];
        for (int i=0; i < n; i++){
            for (int j=bagweight;j>=0; j--){
                if(j >= weight[i]){
                    dp[j] = Math.max(dp[j] , values[i] + dp[j-weight[i]]);
                }
            }
        }
        System.out.println("ABC: "+dp[bagweight]);
    }
}
