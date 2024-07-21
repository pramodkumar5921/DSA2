class Solution {
public:
    int minChanges(vector<int>& nums, int k) {
        int n=nums.size();
        vector<pair<int,int>>arr;
        for(int i=0;i<n/2;i++){
            int maxi=max(nums[i],nums[n-i-1]);
            int mini=min(nums[i],nums[n-i-1]);
            arr.push_back({maxi,mini});
        }
        unordered_map<int,int>mp;
        for(int i=0;i<arr.size();i++){
            int maxi=arr[i].first;
            int mini=arr[i].second;
            mp[maxi-mini]++;
        }
        vector<int>Limit;
        for(int i=0;i<arr.size();i++){
            int maxi=arr[i].first;
            int mini=arr[i].second;
            Limit.push_back(max(maxi,k-mini));
        }
        sort(Limit.begin(),Limit.end());
        int ans=INT_MAX;
        for(auto it:mp){
            int diff=it.first;
            int cnt=it.second;
            int remain=lower_bound(Limit.begin(),Limit.end(),diff)-Limit.begin();
            int temp=remain+(arr.size()-cnt);
            ans=min(ans,temp);
        }
        return ans;
    }
};
