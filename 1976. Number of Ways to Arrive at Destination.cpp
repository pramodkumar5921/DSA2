class Solution {
public:
    unordered_map<int,vector<pair<int,int>>>graph;
    int countPaths(int n, vector<vector<int>>& roads) {
        for(int i=0;i<roads.size();i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int wt=roads[i][2];
            graph[u].push_back({v,wt});
            graph[v].push_back({u,wt});
        }
        vector<long long>dist(n,1e16);
        vector<long long>ways(n,0);
        ways[0]=1;
        dist[0]=0;
        priority_queue<pair<long long,long long>,vector<pair<long long,long long>>,greater<pair<long long,long long>>>pq;
        pq.push({0,0});
        long long mod=(long long)(1e9+7);
        while(!pq.empty()){
            long long dis=pq.top().first;
            long long node=pq.top().second;
            pq.pop();
            for(auto child:graph[node]){
                long long adjdis=child.second;
                long long adjnode=child.first;
                if(dist[adjnode]>adjdis+dis){
                    dist[adjnode]=adjdis+dis;
                    ways[adjnode]=ways[node];
                    pq.push({adjdis+dis,adjnode});
                }
                else if(dist[adjnode]==adjdis+dis){
                    ways[adjnode]=(ways[node]%mod+ways[adjnode]%mod)%mod;
                }
            }
        }
        return ways[n-1];
    }
};
