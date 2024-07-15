class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size()==1){
            return nums[0];
        }
        int n=nums.size();
        vector<int>temp1=nums;
        vector<int>temp2;
        temp1.pop_back();
        for(int i=1;i<n;i++){
            temp2.push_back(nums[i]);
        }
        vector<int>dp1(n+5,0);
        vector<int>dp2(n+5,0);
        for(int i=temp1.size()-1;i>=0;i--){
            dp1[i]=max(dp1[i+2]+temp1[i],dp1[i+1]);
        }
        for(int i=temp2.size()-1;i>=0;i--){
            dp2[i]=max(dp2[i+2]+temp2[i],dp2[i+1]);
        }
        return max(dp1[0],dp2[0]);
    }
};
