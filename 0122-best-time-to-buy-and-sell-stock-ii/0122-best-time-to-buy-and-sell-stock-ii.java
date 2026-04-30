class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return getAns(prices,0,0,dp,n);
    }
    public int getAns(int[] prices,int index,int buy,int[][] dp,int n){
        if(index==n) return 0;
        if(dp[index][buy]!=-1) return dp[index][buy];
        int profit=0;
        if(buy==0){
            profit = Math.max((0+getAns(prices,index+1,0,dp,n)),(-prices[index]+getAns(prices,index+1,1,dp,n)));
        }
        else{
            profit = Math.max((0+getAns(prices,index+1,1,dp,n)),(prices[index]+getAns(prices,index+1,0,dp,n)));
        }
        dp[index][buy]=profit;
        return profit;
    }
}