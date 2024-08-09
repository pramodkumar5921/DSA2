class Solution {
    static int n,m;
    int[][] dp;
    public int solve(int row,int col,int[][] obstacleGrid){
        // base case
        if(row>=n || col>=m || obstacleGrid[row][col]==1){
            return 0;
        }
        if(row==n-1 && col==m-1){
            return 1;
        }
        if(dp[row][col]!=0){
            return dp[row][col];
        }
        // recusrive case
        int down=solve(row+1,col,obstacleGrid);
        int right=solve(row,col+1,obstacleGrid);

        return dp[row][col]=down+right;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        n=obstacleGrid.length;
        m=obstacleGrid[0].length;
        dp=new int[n][m];
        return solve(0,0,obstacleGrid);
    }
}
