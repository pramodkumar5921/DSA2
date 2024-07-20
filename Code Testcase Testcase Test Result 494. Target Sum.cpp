class Solution {
public:
    unordered_map<string,int>mp;
    int DifferentExp(vector<int>&nums,int target,int idx,int sum){
        if(idx==nums.size()){
            if(sum==target){
                return 1;
            }
            else{
                return 0;
            }
        }
        string str=to_string(idx)+'+'+to_string(sum);
        if(mp.find(str)!=mp.end()){
            return mp[str];
        }
        int plus=0,minus=0;
        plus=DifferentExp(nums,target,idx+1,sum+nums[idx]);
        minus=DifferentExp(nums,target,idx+1,sum-nums[idx]);

        return mp[str]=(plus+minus);
    }
    int findTargetSumWays(vector<int>& nums, int target) {
        return DifferentExp(nums,target,0,0);
    }
};
