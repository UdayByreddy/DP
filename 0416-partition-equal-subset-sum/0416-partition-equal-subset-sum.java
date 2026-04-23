class Solution {
    public boolean canPartition(int[] nums) {
        int max =0;
        for(int num:nums){
            max+=num;
        }
        if(max%2==1) return false;
        int k = max/2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][k+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(nums[0]<=k) dp[0][nums[0]]=true;

        return slove(nums,dp,k,n);
    }
    public boolean slove(int[] nums,boolean[][] dp,int k,int n){
        for(int i=1;i<n;i++){
            for(int j=1;j<=k;j++){
                boolean notTaken = dp[i-1][j];
                boolean taken = false;
                if(nums[i]<=j){
                    taken = dp[i-1][j-nums[i]];
                }
                dp[i][j]=taken || notTaken;
            }
        }
        return dp[n-1][k];
    }
}