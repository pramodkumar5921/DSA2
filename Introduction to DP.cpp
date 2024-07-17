//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    const int mod = 1000000007;
    long long int solve(vector<long long int>&dp,int n){
        if(n==1 || n==0){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=(solve(dp,n-1)%mod+solve(dp,n-2)%mod)%mod;
    }
    long long int topDown(int n) {
        vector<long long int>dp(n+1,-1);
        long long int ans=solve(dp,n);
        return ans;
    }
    long long int bottomUp(int n) {
        vector<long long int>dp(n+1,-1);
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]%mod+dp[i-2]%mod)%mod;
        }
        return dp[n];
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution obj;
        long long int topDownans = obj.topDown(n);
        long long int bottomUpans = obj.bottomUp(n);
        if (topDownans != bottomUpans) cout << -1 << "\n";
        cout << topDownans << "\n";
    }
}
// } Driver Code Ends
