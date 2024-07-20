class Solution {
public:
    int dp[301][5001];
    int FindCombination(vector<int>&coins,int amount,int idx){
        if(amount<0){
            return 0;
        }
        if(idx==coins.size()){
            if(amount==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }
        int include=0,exclude=0;
        include=FindCombination(coins,amount-coins[idx],idx);
        exclude=FindCombination(coins,amount,idx+1);

        return dp[idx][amount]=include+exclude;
    }
    int change(int amount, vector<int>& coins) {
        memset(dp,-1,sizeof(dp));
        return FindCombination(coins,amount,0);
    }
};
