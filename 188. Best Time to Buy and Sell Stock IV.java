class Solution {
    int[][][] dp;
    public int solve(int[] prices,int idx,int k,int buy){
        // base case
        int n=prices.length;
        if(idx>=n || k<=0){
            return 0;
        }
        if(dp[idx][k][buy]!=-1){
            return dp[idx][k][buy];
        }
        // recursive case
        int profit=0;
        if(buy==1){
            int include=-prices[idx]+solve(prices,idx+1,k-1,0);
            int exclude= 0          +solve(prices,idx+1,k,1);
            profit=Math.max(include,exclude);
        }
        else{
            int include=prices[idx]+solve(prices,idx+1,k-1,1);
            int exclude=0          +solve(prices,idx+1,k,0);
            profit=Math.max(include,exclude);
        }
        return dp[idx][k][buy]=profit;

    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        dp=new int[1001][2*k+1][2];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=2*k;j++){
                for(int m=0;m<2;m++){
                    dp[i][j][m]=-1;
                }
            }
        }
        return solve(prices,0,2*k,1);
    }
}
