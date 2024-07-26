class Solution {
public:
    int n,m;
    vector<int>dr={-1,0,1,0};
    vector<int>dc={0,1,0,-1};
    void dfs(int row,int col,vector<vector<int>>&vis,int &cnt,vector<pair<int,int>>&temp,vector<vector<int>>&grid){
        vis[row][col]=1;
        cnt++;
        temp.push_back({row,col});
        for(int i=0;i<4;i++){
            int nr=row+dr[i];
            int nc=col+dc[i];
            if(nr>=0 and nr<n and nc>=0 and nc<m and vis[nr][nc]==0 and grid[nr][nc]==1){
                dfs(nr,nc,vis,cnt,temp,grid);
            }
        }
        return;
    }
    int largestIsland(vector<vector<int>>& grid) {
        n=grid.size();
        m=grid[0].size();
        vector<vector<int>>vis(n,vector<int>(m,0));
        vector<vector<pair<int,int>>>dist(n,vector<pair<int,int>>(m,{0,0}));
        int ans=0;
        int cnt1=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 and grid[i][j]==1){
                    int cnt=0;
                    cnt1++;
                    vector<pair<int,int>>temp;
                    dfs(i,j,vis,cnt,temp,grid);
                    ans=max(ans,cnt);
                    for(int k=0;k<temp.size();k++){
                        dist[temp[k].first][temp[k].second]={cnt,cnt1};
                    }
                }
            }
        }
        for(int i=0;i<dist.size();i++){
            for(int j=0;j<dist[i].size();j++){
                priority_queue<int>pq;
                unordered_set<int>st;
                if(dist[i][j].first==0){
                    for(int k=0;k<4;k++){
                        int nr=i+dr[k];
                        int nc=j+dc[k];
                        if(nr>=0 and nr<n and nc>=0 and nc<m and dist[nr][nc].first!=0 ){
                            int dir=dist[nr][nc].second;
                            if(st.find(dir)==st.end()){
                                pq.push(dist[nr][nc].first);
                            }
                            st.insert(dir);
                        }
                    }
                    int temp=0;
                    int cnt=0;
                    while(pq.size()>0){
                        temp+=pq.top();
                        pq.pop();
                        cnt++;
                        // if(cnt==2){
                        //     break;
                        // }
                    }
                    ans=max(ans,temp+1);
                }
            }
        }
        return ans;
    }
};
