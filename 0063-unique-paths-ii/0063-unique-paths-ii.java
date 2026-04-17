class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return slove(n-1,m-1,dp,obstacleGrid);
    }
    public int slove(int i,int j,int[][] dp,int[][] obstacleGrid){
        if(i<0||j<0) return 0;
        if(obstacleGrid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = slove(i-1,j,dp,obstacleGrid);
        int down = slove(i,j-1,dp,obstacleGrid);
        return dp[i][j]=up+down;
    }
}