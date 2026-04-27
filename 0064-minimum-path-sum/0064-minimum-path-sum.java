class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return calculatePath(n-1,m-1,grid,dp);
    }
    public int calculatePath(int i,int j,int[][] grid,int[][] dp){
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0)  return (int) 1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = grid[i][j]+calculatePath(i-1,j,grid,dp);
        int left = grid[i][j]+calculatePath(i,j-1,grid,dp);
        return dp[i][j]=Math.min(up,left);
    }
}