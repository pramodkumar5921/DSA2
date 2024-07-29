class Solution {
public:
    unordered_map<int,vector<int>>graph;
    #define P pair<int,int>
    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
        for(int i=0;i<edges.size();i++){
            int u=edges[i][0];
            int v=edges[i][1];
            graph[u].push_back(v);
            graph[v].push_back(u);
        }
        vector<int>d1(n+1,INT_MAX);
        vector<int>d2(n+1,INT_MAX);

        priority_queue<P,vector<P>,greater<P>>pq;
        pq.push({0,1});
        while(pq.size()>0){
            int timePassed=pq.top().first;
            int node=pq.top().second;
            pq.pop();
            if(node==n && d2[n]!=INT_MAX){
                return d2[n];
            }
            int div=timePassed/change;
            if(div%2==1){
                timePassed=change*(div+1);
            }
            for(auto nbr:graph[node]){
               if(d1[nbr]>timePassed+time){
                d2[nbr]=d1[nbr];
                d1[nbr]=timePassed+time;
                pq.push({d1[nbr],nbr});
               }
               else if(d2[nbr]>timePassed+time && d1[nbr]!=timePassed+time){
                d2[nbr]=timePassed+time;
                pq.push({d2[nbr],nbr});
               }
            }
        }
        return -1;
    }
};
