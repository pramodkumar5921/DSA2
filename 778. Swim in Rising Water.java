class Solution {
    static int n;
    int[] dr={-1,0,1,0};
    int[] dc={0,1,0,-1};
    public void solve(int row,int col,int time,int[][] vis,int[][] grid){
        vis[row][col]=1;
        for(int i=0;i<4;i++){
            int nr=row+dr[i];
            int nc=col+dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]<=time && vis[nr][nc]==0){
                solve(nr,nc,time,vis,grid);
            }
        }
        return;
    }
    public void DFS(int mid,int[][] vis,int[][] grid){
        if(grid[0][0]<=mid){
             solve(0,0,mid,vis,grid);
        }
    }
    public boolean check(int mid,int[][] grid){
        int[][] vis=new int[n][n];
        
        DFS(mid,vis,grid);

        if(vis[n-1][n-1]==1){
            return true;
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        n=grid.length;
        int left=0;
        int right=n*n;
        int ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(check(mid,grid)==true){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
}
