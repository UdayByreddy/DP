class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] parents = new int[n];
        Arrays.fill(dp,1);
       // Arrays.fill(parents,-1);
        int lastIndex=0;
        int maxLen =0;
        for(int i=0;i<n;i++){
            parents[i]=i;
            for(int pre=0;pre<i;pre++){
                if(nums[i]%nums[pre]==0 && dp[i]<dp[pre]+1){
                    dp[i]=dp[pre]+1;
                    parents[i]=pre;
                }
            }
            if(dp[i]>maxLen){
                maxLen=dp[i];
                lastIndex=i;
            }
        }
        int i= lastIndex;
        List<Integer> arr = new ArrayList<>();
        while(parents[i]!=i){
            arr.add(nums[i]);
            i=parents[i];
        }
        arr.add(nums[i]);
        return arr;
        
    }
}