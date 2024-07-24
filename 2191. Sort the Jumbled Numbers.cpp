class Solution {
public:
    unordered_map<int,int>mp;
    int MapValue(int val){
        string str=to_string(val);
        int n=str.size();
        vector<int>arr(n,0);
        for(int i=0;i<str.size();i++){
            int ch=str[i]-'0';
            arr[i]=mp[ch];
        }
        int temp=0;
        for(int i=0;i<arr.size();i++){
            temp=temp*10+arr[i];
        }
        return temp;
    }
    static bool cmp(vector<int>&a,vector<int>&b){
        if(a[0]!=b[0]){
            return a[0]<b[0];
        }
        else if(a[0]==b[0]){
            return a[1]<b[1];
        }
        return false;
    }
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        for(int i=0;i<mapping.size();i++){
            mp[i]=mapping[i];
        }
        vector<vector<int>>temp;
        for(int i=0;i<nums.size();i++){
            int value=MapValue(nums[i]);
            vector<int>dummy;
            dummy.push_back(value);
            dummy.push_back(i);
            dummy.push_back(nums[i]);
            temp.push_back(dummy);
        }
        sort(temp.begin(),temp.end(),cmp);
        vector<int>ans;
        for(int i=0;i<temp.size();i++){
            ans.push_back(temp[i][2]);
        }
        return ans;
    }
};
