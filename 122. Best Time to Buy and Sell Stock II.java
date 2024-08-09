class Solution {
    static int n;
    int[][] dp;
    public int solve(int[] prices,int idx,int buy){
        if(idx>=n){
            return 0;
        }
        if(dp[idx][buy]!=-1){
            return dp[idx][buy];
        }
        int profit=0;
        if(buy==1){
            int include=-prices[idx]+solve(prices,idx+1,0);
            int exclude=0+solve(prices,idx+1,buy);
            profit=Math.max(include,exclude);
        }
        else{
            int include=prices[idx]+solve(prices,idx+1,1);
            int exclude=0+solve(prices,idx+1,buy);

            profit=Math.max(include,exclude);
        }
        return dp[idx][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        n=prices.length;
        dp=new int[n+1][2];
        for(int i=0;i<=n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return solve(prices,0,1);
    }
}
