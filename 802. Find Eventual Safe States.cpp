class Solution {
public:
    unordered_map<int,vector<int>>mp;
    bool dfs(int node,vector<int>&vis,vector<int>&inrecursion){
        vis[node]=true;
        inrecursion[node]=true;
        for(int child:mp[node]){
            if(vis[child]==false){
                if(dfs(child,vis,inrecursion)==true){
                    return true;
                }
            }
            else{
                if(inrecursion[child]==true){
                    return true;
                }
            }
        }
        inrecursion[node]=false;
        return false;
    }
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int V=graph.size();
        vector<int>vis(V,0);
        vector<int>inrecursion(V,0);
        for(int i=0;i<graph.size();i++){
            for(int j=0;j<graph[i].size();j++){
                mp[i].push_back(graph[i][j]);
            }
        }
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                dfs(i,vis,inrecursion);
            }
        }
        vector<int>ans;
        for(int i=0;i<V;i++){
            if(inrecursion[i]==false){
                ans.push_back(i);
            }
        }
        return ans;
    }
};
