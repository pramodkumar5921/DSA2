class Solution {
public:
    unordered_map<int,vector<int>>mp;
    bool dfs(int node,vector<int>&vis,bool col,vector<int>&color){
        vis[node]=1;
        color[node]=col;
        for(int child:mp[node]){
            if(vis[child]==1){
                if(col==color[child]){
                    return false;
                }
            }
            else{
                if(dfs(child,vis,!col,color)==false){
                    return false;
                }
            }
        }
        return true;
    }
    bool isBipartite(vector<vector<int>>& graph) {
        int n=graph.size();
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].size();j++){
                mp[i].push_back(graph[i][j]);
            }
        }
        vector<int>vis(n,0);
        vector<int>color(n,0);
        for(int i=0;i<graph.size();i++){
            if(vis[i]==0){
                if(dfs(i,vis,0,color)==false){
                    return false;
                }
            }
        }
        return true;
    }
};
