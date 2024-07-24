//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    bool isCyclic(int V, vector<int> adj[]) {
       unordered_map<int,vector<int>>graph;
       vector<int>Indegree(V,0);
       for(int i=0;i<V;i++){
           for(int j=0;j<adj[i].size();j++){
               graph[i].push_back(adj[i][j]);
               Indegree[adj[i][j]]++;
           }
       }
       queue<int>que;
       for(int i=0;i<V;i++){
           if(Indegree[i]==0){
               que.push(i);
           }
       }
       vector<int>ans;
       while(que.size()>0){
           int node=que.front();
           que.pop();
           ans.push_back(node);
           for(int child:graph[node]){
               Indegree[child]--;
               if(Indegree[child]==0){
                   que.push(child);
               }
           }
       }
       if(ans.size()==V){
           return false;
       }
       return true;
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
