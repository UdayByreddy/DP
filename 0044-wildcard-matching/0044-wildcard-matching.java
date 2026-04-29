class Solution {
    public boolean isAllStar(String s,int i){
        for(int j=1;j<=i;j++){
            if(s.charAt(j-1)!='*') return false;
        }
        return true;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        for(int i=1;i<=m;i++){
            dp[0][i]=isAllStar(p,i);
        }
        for(int i=1;i<=n;i++){
            dp[i][0]=false;
        }
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    dp[i][j]= dp[i-1][j] || dp[i][j-1];
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }
}