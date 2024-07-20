class Solution {
public:
    int dp[10001][13];
    int FindMinCoins(vector<int>&coins,int target,int idx){
        if(target<0){
            return 1e9;
        }
        if(idx==coins.size()){
            if(target==0){
                return 0;
            }
            else{
                return 1e9;
            }
        }
        if(dp[target][idx]!=-1){
            return dp[target][idx];
        }
        int include=0,exclude=0;
        include=1+FindMinCoins(coins,target-coins[idx],idx);
        exclude=0+FindMinCoins(coins,target,idx+1);

        return dp[target][idx]=min(include,exclude);
    }
    int coinChange(vector<int>& coins, int amount) {
        memset(dp,-1,sizeof(dp));
        int ans=FindMinCoins(coins,amount,0);
        if(ans==1e9){
            return -1;
        }
        return ans;
    }
};
