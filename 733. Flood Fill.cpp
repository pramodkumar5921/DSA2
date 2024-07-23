class Solution {
public:
    int n,m;
    vector<int>dr={-1,0,1,0};
    vector<int>dc={0,1,0,-1};
    void dfs(int row,int col,vector<vector<int>>&image,int color,vector<vector<int>>&vis,
    vector<vector<int>>&ans){
        vis[row][col]=1;
        ans[row][col]=color;
        for(int i=0;i<4;i++){
            int nr=row+dr[i];
            int nc=col+dc[i];
            if(nr>=0 and nr<n and nc>=0 and nc<m and image[nr][nc]==image[row][col] and vis[nr][nc]==0){
                dfs(nr,nc,image,color,vis,ans);
            }
        }
        return;
    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        n=image.size();
        m=image[0].size();
        vector<vector<int>>ans=image;
        vector<vector<int>>vis(n,vector<int>(m,0));
        dfs(sr,sc,image,color,vis,ans);
        return ans;
    }
};
