class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n=nums.size();
        long long total=((long long)(n)*(n+1))/2;
        long long sum=0;
        for(int i=0;i<nums.size();i++){
            sum+=nums[i];
        }
        return (int)(total-sum);
    }
};
