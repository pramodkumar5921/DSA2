//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int dp[71][71][71];
    int N,M;
    int solve(vector<vector<int>>&grid,int r,int c1,int c2){
        if(r>=N){
            return 0;
        }
        if(dp[r][c1][c2]!=-1){
            return dp[r][c1][c2];
        }
        int chocolate=grid[r][c1];
        if(c1!=c2){
            chocolate+=grid[r][c2];
        }
        int ans=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int nrow=r+1;
                int nc1=c1+i;
                int nc2=c2+j;
                if(nrow<N and nc1>=0 and nc2>=0 and nc1<M and nc2<M){
                    ans=max(ans,solve(grid,nrow,nc1,nc2));
                }
            }
        }
        return dp[r][c1][c2]=ans+chocolate;
    }
    int solve(int n, int m, vector<vector<int>>& grid) {
        memset(dp,-1,sizeof(dp));
        N=grid.size();
        M=grid[0].size();
        return solve(grid,0,0,m-1);
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> grid;
        for (int i = 0; i < n; i++) {
            vector<int> temp;
            for (int j = 0; j < m; j++) {
                int x;
                cin >> x;
                temp.push_back(x);
            }
            grid.push_back(temp);
        }

        Solution obj;
        cout << obj.solve(n, m, grid) << "\n";
    }
    return 0;
}
// } Driver Code Ends
