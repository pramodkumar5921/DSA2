
//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	public:
	 static bool cmp(vector<int>&a,vector<int>&b){
	    if(a[0]<b[0]){
	        return true;
	    }
	    return false;
	}
	int findparent(int x,vector<int>&parent){
	    if(x==parent[x]){
	        return x;
	    }
	    return parent[x]=findparent(parent[x],parent);
	}
	void combine(int u,int v,vector<int>&subtree,vector<int>&parent){
	    int ru=findparent(u,parent);
	    int rv=findparent(v,parent);
	    if(ru==rv){
	        return;
	    }
	    else if(subtree[ru]>subtree[rv]){
	        subtree[ru]+=subtree[rv];
	        parent[rv]=ru;
	    }
	    else{
	        parent[ru]=rv;
	        subtree[rv]+=subtree[ru];
	    }
	    return;
	}
    int spanningTree(int V, vector<vector<int>> adj[]){
       vector<vector<int>>graph;
       vector<int>parent(V,0);
       for(int i=0;i<V;i++){
           parent[i]=i;
       }
       vector<int>subtree(V,1);
        
        for (int i = 0; i < V; i++) {
            for (auto& vec : adj[i]) {
                int u = i;
                int v = vec[0];
                int wt = vec[1];
                graph.push_back({wt, u, v});
            }
        }
       sort(graph.begin(),graph.end(),cmp);
    //   for(int i=0;i<graph.size();i++){
    //       for(int j=0;j<graph[i].size();j++){
    //           cout<<graph[i][j]<<" ";
    //       }
    //       cout<<endl;
    //   }
       int ans=0;
       for(int i=0;i<graph.size();i++){
           int u=graph[i][1];
           int v=graph[i][2];
           int wt=graph[i][0];
           if(findparent(u,parent)==findparent(v,parent)){
               continue;
           }
           else{
               combine(u,v,subtree,parent);
               ans+=wt;
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
