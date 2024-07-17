class Solution {
public:
    int n,m;
    int solve(int row,int col,vector<vector<int>>&grid){
        int ele1=INT_MAX;
        int ele2=INT_MAX;
        int ele3=INT_MAX;
        if(col-1>=0){
            ele1=grid[row-1][col-1];
        }
        if(col>=0){
            ele2=grid[row-1][col];
        }
        if(col+1<m){
            ele3=grid[row-1][col+1];
        }
        return min({ele1,ele2,ele3});

    }
    int minFallingPathSum(vector<vector<int>>& matrix) {
        n=matrix.size();
        m=matrix[0].size();
        vector<vector<int>>grid=matrix;
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]+=solve(i,j,grid);
            }
        }
        int mini=INT_MAX;
        for(int i=0;i<m;i++){
            mini=min(mini,grid[n-1][i]);
        }
        return mini;
    }
};
