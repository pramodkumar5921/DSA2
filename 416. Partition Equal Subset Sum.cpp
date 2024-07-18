class Solution {
public:
   int dp[201][10001];
    bool solve(vector<int>&nums,int idx,int target){
        if(target<0){
            return false;
        }
        if(idx==nums.size()){
            if(target==0){
                return true;
            }
            return false;
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target];
        }
        int include=0;
        int exclude=0;
        include=solve(nums,idx+1,target-nums[idx]);
        exclude=solve(nums,idx+1,target);

        return dp[idx][target]=max(include,exclude);
    }
    bool canPartition(vector<int>& nums) {
        memset(dp,-1,sizeof(dp));
        int sum=0;
        for(int i=0;i<nums.size();i++){
            sum+=nums[i];
        }
        if(sum%2==1){
            return false;
        }
        int target=sum/2;
        return solve(nums,0,target);
    }
};
