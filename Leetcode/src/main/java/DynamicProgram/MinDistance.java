package DynamicProgram;

import org.junit.Test;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        if (n * m == 0) return n + m;
        int[][] dp = new int[n+1][m+1];
        for (int i=0;i<n+1;i++){
            dp[i][0]=i;
        }
        for (int j=0;j<m+1;j++){
            dp[0][j]=j;
        }
        for (int i=1;i<n+1;i++){
            for (int j=1;j<m+1;j++){
                int left = dp[i-1][j]+1;
                int down = dp[i][j-1]+1;
                int le_d = dp[i-1][j-1];
                if (word1.charAt(i-1)!=word2.charAt(j-1)){
                    le_d+=1;
                }
                dp[i][j]=Math.min(le_d,Math.min(left,down));
            }
        }
        return dp[n][m];
    }
    @Test
    public void test(){
        MinDistance md = new MinDistance();
        String s1 = "japan";String s2 = "china";
        int i = md.minDistance(s1, s2);
        System.out.println(i);
    }
}
