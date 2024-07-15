class Solution {
public:
    static bool cmp(string &a,string &b){
        return a<=b;
    }
    int FindParent(int x,vector<int>&parent){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=FindParent(parent[x],parent);
    }
    void Combine(int u,int v,vector<int>&parent,vector<int>&subtree){
        int ru=FindParent(u,parent);
        int rv=FindParent(v,parent);

        if(ru==rv){
            return;
        }
        else if(subtree[rv]>subtree[ru]){
            parent[ru]=rv;
            subtree[rv]+=subtree[ru];
        }
        else{
            parent[rv]=ru;
            subtree[ru]+=subtree[rv];
        }
    }
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        int n=accounts.size();
        vector<int>parent(n,0);
        vector<int>subtree(n,1);
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        unordered_map<string,int>mapMail;
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts[i].size();j++){
                string mail=accounts[i][j];
                if(mapMail.find(mail)==mapMail.end()){
                    mapMail[mail]=i;
                }
                else{
                    // mapMail[mail]=i;
                    Combine(i,mapMail[mail],parent,subtree);
                }
            }
        }
        vector<vector<string>>ans;
        unordered_map<int,vector<string>>mp;
        for(auto temp:mapMail){
            string str=temp.first;
            int idx=temp.second;
            int p=FindParent(idx,parent);
            mp[p].push_back(str);
        }
        for(auto it:mp){
            int idx=it.first;
            vector<string>res;
            res.push_back(accounts[idx][0]);
            vector<string>temp=it.second;
            sort(temp.begin(),temp.end(),cmp);
            for(auto it:temp){
                res.push_back(it);
            }
            ans.push_back(res);
        }
        return ans;
    }
};
