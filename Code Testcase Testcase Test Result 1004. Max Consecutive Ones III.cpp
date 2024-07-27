class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int i=0,j=0;
        int ans=0;
        unordered_map<int,int>mp;
        while(i<nums.size()){
            mp[nums[i]]++;
            while(mp[0]>k && j<=i){
                mp[nums[j]]--;
                if(mp[nums[j]]==0){
                    mp.erase(nums[j]);
                }
                j++;
            }
            ans=max(ans,i-j+1);
            i++;
        }
        return ans;
    }
};
