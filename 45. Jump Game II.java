class Solution {
    int[] dp;
    public int minStepJump(int[] nums,int i){
        int n=nums.length;
        if(i==n-1){
            return 0;
        }

        if(i>=n){
            return 1000000;
        }

        if(nums[i]==0){
            return 1000000;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int ans = Integer.MAX_VALUE;

        for(int j=1;j<=Math.min(nums[i],n-1);j++){
            int tempAns = 1+minStepJump(nums,i+j);
            ans = Math.min(tempAns,ans);
        }

        return dp[i]=ans;
    }
    public int jump(int[] nums) {
        int n=nums.length;
        dp=new int[n+5];

        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }

        int ans = minStepJump(nums,0);
        return ans;
    }
}
