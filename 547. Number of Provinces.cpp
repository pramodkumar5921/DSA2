class Solution {
public:
    unordered_map<int,vector<int>>graph;
    void dfs(vector<int>&vis,int node){
        vis[node]=1;
        for(int child:graph[node]){
            if(vis[child]==0){
                dfs(vis,child);
            }
        }
        return;
    }
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n=isConnected.size();
        int m=isConnected[0].size();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j]==1){
                    graph[i].push_back(j);
                }
            }
        }
        vector<int>vis(n,0);
        int ans=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(vis,i);
                ans+=1;
            }
        }
        return ans;
    }
};
