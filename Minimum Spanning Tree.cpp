//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	public:
	int findparent(int x,vector<int>&parent){
	    if(x==parent[x]){
	        return x;
	    }
	    return parent[x]=findparent(parent[x],parent);
	}
	void combine(int u,int v,vector<int>&parent,vector<int>&subtree){
	    int ru=findparent(u,parent);
	    int rv=findparent(v,parent);
	    if(ru==rv){
	        return;
	    }
	    if(subtree[ru]>subtree[rv]){
	        subtree[ru]+=subtree[rv];
	        parent[rv]=ru;
	    }
	    else{
	        parent[ru]=rv;
	        subtree[rv]+=subtree[ru];
	    }
	}
    int spanningTree(int V, vector<vector<int>> adj[]){
      vector<pair<int,pair<int,int>>>temp;
      for(int u=0; u<V; u++){
          for(auto& vec : adj[u]){
              int v = vec[0];
              int wt = vec[1];
            //   if(u < v) { // To avoid adding the same edge twice
                  temp.push_back({wt, {u, v}});
            //   }
          }
      }
    //   for(int i=0;i<temp.size();i++){
    //       cout<<temp[i].first<<" ";
    //     //   cout<<endl;
    //   }
      sort(temp.begin(),temp.end());
      vector<int>parent(V,0);
      for(int i=0;i<V;i++){
          parent[i]=i;
      }
      vector<int>subtree(V,1);
      int res=0;
      for(int i=0;i<temp.size();i++){
          int wt=temp[i].first;
          int u=temp[i].second.first;
          int v=temp[i].second.second;
          if(findparent(u,parent)==findparent(v,parent)){
              continue;
          }
          else{
              res+=wt;
              combine(u,v,parent,subtree);
          }
      }
      return res;
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
