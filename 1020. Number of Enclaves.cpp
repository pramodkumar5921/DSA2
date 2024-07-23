class Solution {
public:
    int n,m;
    vector<int>dr={-1,0,1,0};
    vector<int>dc={0,1,0,-1};
    void dfs(vector<vector<int>>&grid,vector<vector<int>>&vis,int row,int col,int &cnt){
        cnt++;
        vis[row][col]=1;
        for(int i=0;i<4;i++){
            int nr=row+dr[i];
            int nc=col+dc[i];
            if(nr>=0 and nr<n and nc>=0 and nc<m and vis[nr][nc]==0 and grid[nr][nc]==1){
                dfs(grid,vis,nr,nc,cnt);
            }
        }
        return;
    }
    int numEnclaves(vector<vector<int>>& grid) {
        n=grid.size();
        m=grid[0].size();
        int total=0;
        int ans=0;
        vector<vector<int>>vis(n+1,vector<int>(m+1,0));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 ||  i==n-1 || j==m-1){
                    if(vis[i][j]==0 and grid[i][j]==1){
                        int cnt=0;
                        // return 0;
                        dfs(grid,vis,i,j,cnt);
                        // return 0;
                        ans+=cnt;
                    }
                }
                if(grid[i][j]==1){
                    total+=1;
                }
            }
        }
        return total-ans;
    }
};
