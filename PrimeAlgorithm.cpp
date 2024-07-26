//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	public:
	unordered_map<int,vector<pair<int,int>>>graph;;
	typedef pair<int,int>P;
    int spanningTree(int V, vector<vector<int>> adj[]){
        for(int i=0;i<V;i++){
            for(vector<int>&vec:adj[i]){
                int u=i;
                int v=vec[0];
                int wt=vec[1];
                graph[u].push_back({v,wt});
                graph[v].push_back({u,wt});
            }
        }
        vector<int>vis(V,0);
        priority_queue<P,vector<P>,greater<P>>pq;
        pq.push({0,0});
        int ans=0;
        while(pq.size()>0){
            int node=pq.top().second;
            pq.pop();
            if(vis[node]==1){
                continue;
            }
            else{
                ans+=pq.top().first;
                vis[node]=1;
            }
            for(pair<int,int>&child:graph[node]){
                int neigh=child.first;
                int wt=child.second;
                // if(vis[neigh]==0){
                    pq.push({wt,neigh});
                // }
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.


int main()
{
    int t;
    cin >> t;
    while (t--) {
        int V, E;
        cin >> V >> E;
        vector<vector<int>> adj[V];
        int i=0;
        while (i++<E) {
            int u, v, w;
            cin >> u >> v >> w;
            vector<int> t1,t2;
            t1.push_back(v);
            t1.push_back(w);
            adj[u].push_back(t1);
            t2.push_back(u);
            t2.push_back(w);
            adj[v].push_back(t2);
        }
        
        Solution obj;
    	cout << obj.spanningTree(V, adj) << "\n";
    }

    return 0;
}


// } Driver Code Ends
