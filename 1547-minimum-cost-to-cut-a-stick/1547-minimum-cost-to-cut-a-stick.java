class Solution {
    public int minCost(int n, int[] cuts) {
int[] newCuts = new int[cuts.length + 2];
newCuts[0] = 0;
newCuts[newCuts.length - 1] = n;

for (int i = 0; i < cuts.length; i++) {
    newCuts[i + 1] = cuts[i];
}

Arrays.sort(newCuts);
    cuts = newCuts;
        int c = cuts.length-2;
        int[][] dp = new int[c+2][c+2];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return calCuts(cuts,1,c,dp);
    }
    public int calCuts(int[] cuts,int i,int j,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++){
            int ans = cuts[j+1]-cuts[i-1]+calCuts(cuts,i,ind-1,dp)+calCuts(cuts,ind+1,j,dp);
            mini = Math.min(mini,ans);
        }
        return dp[i][j]=mini;
    }
}