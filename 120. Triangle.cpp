class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n=triangle.size();
        int m=triangle[n-1].size();
        vector<vector<int>>grid(n,vector<int>(2*m+3,1000000));
        int i=0,j=m;
        while(i<n){
            int pos=j;
            for(int k=0;k<triangle[i].size();k++){
                int temp=triangle[i][k];
                grid[i][pos]=temp;
                pos=pos+2;
            }
            j=j-1;
            i++;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<2*m+2;j++){
                if(grid[i][j]!=1000000){
                    grid[i][j]+= min(grid[i-1][j-1],grid[i-1][j+1]);
                }
            }
        }
        int mini=INT_MAX;
        for(int i=0;i<2*m+2;i++){
            mini=min(grid[n-1][i],mini);
        }
        return mini;
    }
};
