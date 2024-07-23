class Solution {
public:
    int n,m;
    vector<int>dr={-1,0,1,0};
    vector<int>dc={0,1,0,-1};
    void dfs(vector<vector<int>>&temp,int row,int col,vector<vector<int>>&vis,vector<vector<char>>&mat){
        vis[row][col]=1;
        temp[row][col]=2;
        for(int i=0;i<4;i++){
            int nr=dr[i]+row;
            int nc=dc[i]+col;
            if(nr>=0 and nr<n and nc>=0 and nc<m and vis[nr][nc]==0 and mat[nr][nc]=='O'){
                // temp[nr][nc]=2;
                dfs(temp,nr,nc,vis,mat);
            }
        }
        return;
    }
    void solve(vector<vector<char>>& board) {
        n=board.size();
        m=board[0].size();
        vector<vector<int>>vis(n,vector<int>(m,0));
        vector<vector<int>>temp(n,vector<int>(m,0));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==n-1 || i==0 || j==0 || j==m-1){
                    if(vis[i][j]==0 and board[i][j]=='O'){
                        dfs(temp,i,j,vis,board);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(temp[i][j]==2){
                    board[i][j]='O';
                }
                else{
                    board[i][j]='X';
                }
            }
        }
        return ;
    }
};
