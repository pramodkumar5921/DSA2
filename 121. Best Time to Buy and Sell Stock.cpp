class Solution {
public:
    int maxProfit(vector<int>& prices) {
       int buy=prices[0];
       int sell=prices[0];
       int ans=0;
       for(int i=0;i<prices.size();i++){
          buy=min(buy,prices[i]);
          sell=prices[i];
          int profit=sell-buy;
          ans=max(ans,profit);
       }
       return ans; 
    }
};
