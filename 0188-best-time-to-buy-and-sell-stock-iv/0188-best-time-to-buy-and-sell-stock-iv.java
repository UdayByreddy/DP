class Solution {
    public int maxProfit(int k, int[] prices) {
            int n = prices.length;
        int[][][] dp = new int[n][2][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int x=0;x<k;x++)
               dp[i][j][x]=-1;
            }
        }
        return getAns(prices,0,0,k,0,dp,n);
    }
        public int getAns(int[] prices,int index,int buy,int k,int tar,int[][][] dp,int n){
        if(index==n || k==tar) return 0;
        if(dp[index][buy][tar]!=-1) return dp[index][buy][tar];
        int profit=0;
        if(buy==0 ){
            profit = Math.max((0+getAns(prices,index+1,0,k,tar,dp,n)),(-prices[index]+getAns(prices,index+1,1,k,tar,dp,n)));
        }
        else{
            profit = Math.max((0+getAns(prices,index+1,1,k,tar,dp,n)),(prices[index]+getAns(prices,index+1,0,k,tar+1,dp,n)));
        }
         dp[index][buy][tar]=profit;
         return profit;
    }
}