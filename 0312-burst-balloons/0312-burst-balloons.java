class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0]=1;
        newNums[newNums.length-1]=1;
        for(int i=0;i<n;i++){
            newNums[i+1]=nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return calCoins(1,n,newNums,dp);
    }
    public int calCoins(int i,int j,int[] nums,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mini=0;
        for(int ind=i;ind<=j;ind++){
            int ans= nums[i-1]*nums[ind]*nums[j+1]+calCoins(i,ind-1,nums,dp)+calCoins(ind+1,j,nums,dp);
            mini = Math.max(mini,ans);

        }
        return dp[i][j]=mini;
    }
}