class Solution {
public:
    int FindParent(int x,vector<int>&parent){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=FindParent(parent[x],parent);
    }
    void combine(int u,int v,vector<int>&subtree,vector<int>&parent){
        int ru=FindParent(u,parent);
        int rv=FindParent(v,parent);

        if(ru==rv){
            return;
        }
        else if(subtree[ru]>subtree[rv]){
            subtree[ru]+=subtree[rv];
            parent[rv]=ru;
        }
        else{
            subtree[rv]+=subtree[ru];
            parent[ru]=rv;
        }
        return;
    }
    int makeConnected(int n, vector<vector<int>>& connections) {
        vector<int>parent(n,0);
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        vector<int>subtree(n,1);
        unordered_set<int>st;
        for(int i=0;i<connections.size();i++){
            int u=connections[i][0];
            int v=connections[i][1];
            if(FindParent(u,parent)==FindParent(v,parent)){
                continue;
            }
            else{
                combine(u,v,subtree,parent);
            }
        }
        for(int i=0;i<n;i++){
            int ru=FindParent(i,parent);
            st.insert(ru);
        }
        if(connections.size()<n-1){
            return -1;
        }
        return st.size()-1;
    }

};
