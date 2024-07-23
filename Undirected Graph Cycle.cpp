//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    unordered_map<int,vector<int>>graph;
    bool bfs(int node,int par,vector<int>&vis){
        vis[node]=1;
        queue<pair<int,int>>que;
        que.push({node,-1});
        while(!que.empty()){
            int temp=que.front().first;
            int parent=que.front().second;
            que.pop();
            
            for(auto child:graph[temp]){
                if(vis[child]==0){
                    vis[child]=1;
                    que.push({child,temp});
                }
                else if(parent!=child){
                    return true;
                }
            }
        }
        return false;
    }
    bool isCycle(int V, vector<int> adj[]) {
        for(int i=0;i<V;i++){
            for(int j=0;j<adj[i].size();j++){
                graph[i].push_back(adj[i][j]);
            }
        }
        vector<int>vis(V,0);
        for(int i=0;i<V;i++){
           if(vis[i]==0){
               if(bfs(i,-1,vis)==true){
                return true;
            }
           }
        }
        return false;
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int V, E;
        cin >> V >> E;
        vector<int> adj[V];
        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        Solution obj;
        bool ans = obj.isCycle(V, adj);
        if (ans)
            cout << "1\n";
        else
            cout << "0\n";
    }
    return 0;
}
// } Driver Code Ends
