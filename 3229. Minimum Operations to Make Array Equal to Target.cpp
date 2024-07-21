class Solution {
public:
    long long minimumOperations(vector<int>& nums, vector<int>& target) {
        int n=nums.size();
        vector<int>diff(n,0);
        for(int i=0;i<n;i++){
            diff[i]=target[i]-nums[i];
        }
        int incBar=0,decBar=0;
        long long ans=0;
        for(int i=0;i<n;i++){
            if(diff[i]>0){
                if(diff[i]>incBar){
                    int extra=diff[i]-incBar;
                    ans+=extra;
                }
                incBar=diff[i];
                decBar=0;
            }
            else if(diff[i]<0){
                if(-diff[i]>decBar){
                    int extra=-diff[i]-decBar;
                    ans+=extra;
                }
                incBar=0;
                decBar=-diff[i];
            }
            else{
                incBar=0;
                decBar=0;
            }
        }
        return ans;
    }
};
