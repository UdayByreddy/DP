class Solution {
    public int maxProfit(int[] prices) {
        // int n = prices.length;
        // int[][][] dp = new int[n][2][3];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<2;j++){
        //         Arrays.fill(dp[i][j],-1);
        //     }
        // }
        // return getAns(prices,0,0,2,dp,n);
        int holdTwo=Integer.MIN_VALUE;
        int sellTwo=0;
        int holdOne = Integer.MIN_VALUE;
        int sellOne =0;
        for(int price:prices){
            sellTwo = Math.max(sellTwo,holdTwo+price);
            holdTwo = Math.max(holdTwo,sellOne-price);
            sellOne = Math.max(sellOne,holdOne+price);
            holdOne = Math.max(holdOne,-price);
        }
        return sellTwo;
    }
    // public int getAns(int[] prices,int index,int buy,int k,int[][][] dp,int n){
    //     if(index==n || k==0) return 0;
    //     if(dp[index][buy][k]!=-1) return dp[index][buy][k];
    //     int profit=0;
    //     if(buy==0 ){
    //         profit = Math.max((0+getAns(prices,index+1,0,k,dp,n)),(-prices[index]+getAns(prices,index+1,1,k,dp,n)));
    //     }
    //     else{
    //         profit = Math.max((0+getAns(prices,index+1,1,k,dp,n)),(prices[index]+getAns(prices,index+1,0,k-1,dp,n)));
    //     }
    //      dp[index][buy][k]=profit;
    //      return profit;
    // }
}