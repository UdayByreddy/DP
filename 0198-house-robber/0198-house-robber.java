class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return getMoney(nums,n-1,dp);
    }
    public int getMoney(int[] nums,int house,int[] dp){
        if(house<0) return 0;
        if(house==0) return nums[house];
        if(dp[house]!=-1) return dp[house];
        int pick = nums[house]+getMoney(nums,house-2,dp);
        int notPick=getMoney(nums,house-1,dp);
       return dp[house]=Math.max(pick,notPick);
    }
}