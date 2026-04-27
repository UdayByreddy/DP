class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        if((totalSum-target)<0 || (totalSum-target)%2!=0) return 0;
        int k = (totalSum-target)/2;
        int n = nums.length;
        int[][] dp = new int[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return countSubArray(nums,n-1,k,dp);
    }
    public int countSubArray(int[] nums,int index,int target,int[][] dp){
       if(index==0){
        if(target==0 && nums[0]==0) return 2;
        if(target==nums[0] || target==0) return 1;
        return 0;
       }
       if(dp[index][target]!=-1) return dp[index][target];
       int notPick = countSubArray(nums,index-1,target,dp);
       int pick=0;
       if(nums[index]<=target){
        pick = countSubArray(nums,index-1,target-nums[index],dp);
       }
      return dp[index][target]=pick+notPick;
    }
}