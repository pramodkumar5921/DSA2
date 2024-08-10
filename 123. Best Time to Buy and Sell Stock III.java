class Solution {
    int[][][] dp;
    public int solve(int[] prices,int idx,int k,int buy){
        int n=prices.length;
        if(idx>=n || k==0){
            return 0;
        }
        if(dp[idx][buy][k]!=-1){
            return dp[idx][buy][k];
        }
        int profit=0;
        if(buy==1){
            int include=-prices[idx]+solve(prices,idx+1,k-1,0);
            int exclude= 0+         +solve(prices,idx+1,k,1);
            profit=Math.max(include,exclude);
        }
        else{
            int include=prices[idx]+solve(prices,idx+1,k-1,1);
            int exclude= 0         +solve(prices,idx+1,k,0);
            profit=Math.max(include,exclude);
        }
        return dp[idx][buy][k]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n+1][2][5];
        for(int i=0;i<=n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<5;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(prices,0,4,1);
    }
}
