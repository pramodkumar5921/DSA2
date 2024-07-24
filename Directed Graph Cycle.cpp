//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    unordered_map<int,vector<int>>graph;
    bool dfs(vector<int>&vis,vector<int>&pathVis,int node){
        vis[node]=1;
        pathVis[node]=1;
        for(int child:graph[node]){
            if(vis[child]==0){
                if(dfs(vis,pathVis,child)==true){
                    return true;
                }
            }
            else if(pathVis[child]==true){
                return true;
            }
        }
        pathVis[node]=0;
        return false;
    }
    bool isCyclic(int V, vector<int> adj[]) {
       for(int i=0;i<V;i++){
           for(int j=0;j<adj[i].size();j++){
               graph[i].push_back(adj[i][j]);
           }
       }
       vector<int>vis(V,0);
       vector<int>pathVis(V,0);
       for(int i=0;i<V;i++){
           if(vis[i]==0){
               if(dfs(vis,pathVis,i)==true){
                   return true;
               }
           }
       }
       return false;
    }
};

//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        int V, E;
        cin >> V >> E;

        vector<int> adj[V];

        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
        }

        Solution obj;
        cout << obj.isCyclic(V, adj) << "\n";
    }

    return 0;
}

// } Driver Code Ends
