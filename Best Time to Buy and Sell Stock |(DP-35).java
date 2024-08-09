class Solution {
    public int maxProfit(int[] prices) {
       int ans=0;
       int n=prices.length;
       int sell=10000000;
       for(int i=0;i<n;i++){
          sell=Math.min(sell,prices[i]);
          int profit=prices[i]-sell;
            ans=Math.max(ans,profit);
       } 
       return ans;
    }
}
