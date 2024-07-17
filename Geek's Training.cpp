//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    int maximumPoints(vector<vector<int>>& points, int n) {
        vector<vector<int>>grid(n,vector<int>(3,0));
        for(int i=0;i<3;i++){
            grid[0][i]=points[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                if(j==0){
                    grid[i][j]=max(grid[i-1][j+1],grid[i-1][j+2])+points[i][j];
                }
                else if(j==1){
                     grid[i][j]=max(grid[i-1][j+1],grid[i-1][j-1])+points[i][j];
                }
                else{
                     grid[i][j]=max(grid[i-1][j-1],grid[i-1][j-2])+points[i][j];
                }
            }
        }
        int maxi=INT_MIN;
        for(int i=0;i<3;i++){
            maxi=max(grid[n-1][i],maxi);
        }
        return maxi;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<int>> points;
        for (int i = 0; i < n; ++i) {
            vector<int> temp;
            for (int j = 0; j < 3; ++j) {
                int x;
                cin >> x;
                temp.push_back(x);
            }
            points.push_back(temp);
        }

        Solution obj;
        cout << obj.maximumPoints(points, n) << endl;
    }
    return 0;
}
// } Driver Code Ends
