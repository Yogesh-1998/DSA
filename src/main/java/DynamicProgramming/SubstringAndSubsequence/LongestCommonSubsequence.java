package DynamicProgramming.SubstringAndSubsequence;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";

        int l1 = s1.length();
        int l2 = s2.length();

        int curr[] = new int[l2+1];
        int prev[] = new int[l2+1];

        for(int i=1; i<=l1; i++){
            for (int j=1; j<=l2;j++ ){
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = prev[j - 1] + 1;
                }
                else {
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
                prev= Arrays.copyOf(curr, l2+1);
            }
        }
        System.out.println(curr[l2]);
    }

}
