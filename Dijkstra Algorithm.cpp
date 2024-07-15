
class Solution
{
	public:
	unordered_map<int,vector<pair<int,int>>>graph;
    vector <int> dijkstra(int V, vector<vector<int>> adj[], int S){
      for(int i=0;i<V;i++){
         for(auto edge:adj[i]){
             graph[edge[0]].push_back({i,edge[1]});
             graph[i].push_back({edge[0],edge[1]});
         }
      }
      vector<int>dist(V,INT_MAX);
      dist[S]=0;
      priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>>pq;
      pq.push({0,S});
      while(pq.size()>0){
          int cost=pq.top().first;
          int node=pq.top().second;
          pq.pop();
          for(auto child:graph[node]){
              int child_node=child.first;
              int child_cost=child.second;
              if(dist[child_node]>cost+child_cost){
                  dist[child_node]=cost+child_cost;
                  pq.push({child_cost+cost,child_node});
              }
          }
      }
      
      return dist;
    }
};
