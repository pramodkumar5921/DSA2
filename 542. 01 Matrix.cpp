class Solution {
public:
    vector<int>dr={-1,0,1,0};
    vector<int>dc={0,1,0,-1};
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int n=mat.size();
        int m=mat[0].size();
        queue<pair<int,int>>que;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    que.push({i,j});
                }
            }
        }
        vector<vector<int>>vis(n,vector<int>(m,0));
        int cnt=1;
        while(que.size()>0){
            int x=que.size();
            while(x--){
                int row=que.front().first;
                int col=que.front().second;
                que.pop();
                for(int i=0;i<4;i++){
                    int nr=row+dr[i];
                    int nc=col+dc[i];
                    if(nr>=0 and nr<n and nc>=0 and nc<m and vis[nr][nc]==0 and mat[nr][nc]==1){
                        vis[nr][nc]=1;
                        mat[nr][nc]=cnt;
                        que.push({nr,nc});
                    }
                }
            }
            cnt++;
        }
        return mat;
    }
};
