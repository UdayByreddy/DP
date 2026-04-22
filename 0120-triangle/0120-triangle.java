class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            dp[n-1][i]=triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int left = triangle.get(i).get(j)+dp[i+1][j];
                int down = triangle.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]=Math.min(left,down);
            }

        }
        return dp[0][0];
        // return slove(0,0,dp,triangle);
    }
    // public int slove(int i,int j,int[][] dp,List<List<Integer>> triangle){
    //     if(i==triangle.size()-1){
    //         return triangle.get(i).get(j);
    //     }
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int left= slove(i+1,j,dp,triangle);
    //     int down = slove(i+1,j+1,dp,triangle);
    //     return dp[i][j] =triangle.get(i).get(j)+ Math.min(left,down);
    // }
}