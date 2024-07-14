class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
          vector<int>distance(n,INT_MAX);
          unordered_map<int,vector<pair<int,int>>>graph;
          for(int i=0;i<flights.size();i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int cost=flights[i][2];
            graph[u].push_back({v,cost});
          }
          queue<pair<int,int>>que;
          que.push({src,0});
          distance[src]=0;
          int steps=0;
          while(que.size()>0 && steps<=k){
            int x=que.size();
            while(x--){
                int u=que.front().first;
                int cost=que.front().second;
                que.pop();
                for(pair<int,int>&child:graph[u]){
                    int v=child.first;
                    int d=child.second;
                    if(distance[v]> d+cost ){
                        distance[v]= d+cost ;
                        que.push({v,d+cost});
                    }
                }
            }
            steps++;
          }
          if(distance[dst]==INT_MAX){
            return -1;
          }
          return distance[dst];
    }
};
