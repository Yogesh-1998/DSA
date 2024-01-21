package DynamicProgramming.SubstringAndSubsequence;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";

        int l1 = s1.length();
        int l2 = s2.length();

        int dp[][] = new int[2][l2+1];
        int max=0;
        for (int i=1; i<=l1; i++){
            for (int j=0; j<=l2; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1) ){
                    dp[i%2][j] = dp[(i-1)%2][j-1]+1;
                    if (dp[i%2][j] > max)
                        max = dp[i%2][j];
                }else {
                    dp[i%2][j]=0;
                }
            }
        }
        System.out.println(max);
    }

}
