class Solution {
public:
    bool iscyclic(int k,vector<vector<int>>&temp,vector<int>&row){
        unordered_map<int,vector<int>>graph;
        vector<int>indegree(k+1,0);
        for(int i=0;i<temp.size();i++){
            int u=temp[i][0];
            int v=temp[i][1];
            graph[u].push_back(v);
            indegree[v]++;
        }
        queue<int>que;
        int ans=0;
        for(int i=1;i<=k;i++){
            if(indegree[i]==0){
                que.push(i);
                row.push_back(i);
                ans++;
            }
        }
        while(que.size()>0){
            int ele=que.front();
            que.pop();
            for(int neigh:graph[ele]){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    que.push(neigh);
                    row.push_back(neigh);
                    ans++;
                }
            }
        }
        return !(ans==k);
    }
    vector<vector<int>> buildMatrix(int k, vector<vector<int>>& rowConditions, vector<vector<int>>& colConditions) {
        vector<int>row;
        vector<int>col;
        if(iscyclic(k,rowConditions,row)==true){
            return {};
        }
        if(iscyclic(k,colConditions,col)==true){
            return {};
        }
        vector<vector<int>>grid(k,vector<int>(k,0));
        unordered_map<int,vector<int>>mp;
        for(int i=0;i<row.size();i++){
            mp[row[i]].push_back(i);
          
        }
        for(int i=0;i<col.size();i++){
              mp[col[i]].push_back(i);
        }
        for(auto it:mp){
            int r1=it.second[0];
            int c1=it.second[1];
            grid[r1][c1]=it.first;
        }
        return grid;
    }
};
