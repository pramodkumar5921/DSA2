class Solution {
public:
    set<vector<int>>st;
    void Combination(vector<int>&can,int target,int idx,vector<int>&temp){
        if(target<0){
            return;
        }
        if(idx==can.size()){
            if(target==0){
                st.insert(temp);
                return;
            }
            return;
        }
        temp.push_back(can[idx]);
        Combination(can,target-can[idx],idx,temp);
        if(temp.size()>=1){
            temp.pop_back();
        }
        Combination(can,target,idx+1,temp);
        return;
    }
    vector<vector<int>> combinationSum(vector<int>& can, int target) {
        vector<vector<int>>ans;
        vector<int>temp;
        Combination(can,target,0,temp);
        for(auto it:st){
            ans.push_back(it);
        }
        return ans;
    }
};
