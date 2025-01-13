class Solution {
    HashMap<String,Integer>dp=new HashMap<>();
    public int minCoins(int[] coins,int amount,int i,int target){
        if(target>amount){
            return 1000000;
        }
        if(i>=coins.length){
            return 1000000;
        }

        if(target==amount){
            return 0;
        }

       String str = Integer.toString(i)+"#"+Integer.toString(target);

       if(dp.containsKey(str)==true){
        return dp.get(str);
       }

        int includeCoins = 1+minCoins(coins,amount,i,target+coins[i]);
        int excludeCoins =   minCoins(coins,amount,i+1,target);

        int tempAns=Math.min(includeCoins,excludeCoins);
        dp.put(str,tempAns);

        return tempAns;
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int ans = minCoins(coins,amount,0,0);
        if(ans==1000000){
            return -1;
        }
        return ans;
    }
}
