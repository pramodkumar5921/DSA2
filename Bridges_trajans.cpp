class Solution {
public:
    unordered_map<int,vector<int>>graph;
    void tarjansDFS(int node,int parent,vector<int>&disTime,vector<int>&lowTime,int &time,vector<vector<int>>&answer){
        disTime[node]=time;
        lowTime[node]=time;
        time+=1;

        for(int neigh : graph[node]){
            if(neigh==parent){
                continue;
            }
            if(disTime[neigh]!=-1){
                lowTime[node]=min(lowTime[node],disTime[neigh]);
                continue;
            }
            tarjansDFS(neigh,node,disTime,lowTime,time,answer);
            lowTime[node]=min(lowTime[node],lowTime[neigh]);
            if(disTime[node]<lowTime[neigh]){
                vector<int>temp;
                temp.push_back(node);
                temp.push_back(neigh);
                answer.push_back(temp);
            }
        }
        return;
    }
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        for(vector<int>&edge:connections){
            int u=edge[0];
            int v=edge[1];
            graph[u].push_back(v);
            graph[v].push_back(u);
        }
        vector<int>disTime(n,-1);
        vector<int>lowTime(n,-1);

        int time=0;
        vector<vector<int>>answer;
        tarjansDFS(0,-1,disTime,lowTime,time,answer);
        return answer;
    }
};
