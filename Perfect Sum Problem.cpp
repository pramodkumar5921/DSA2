//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
    
	public:
	const int mod=1000000007;
	int solve(int arr[],int n,int target,int idx,vector<vector<int>>&dp){
	    if(target<0){
	        return 0;
	    }
	    if(idx==n){
	        if(target==0){
	            return 1;
	        }
	        return 0;
	    }
	    if(dp[idx][target]!=-1){
	        return dp[idx][target];
	    }
	    int include=0,exclude=0;
	    include=solve(arr,n,target-arr[idx],idx+1,dp);
	    exclude=solve(arr,n,target,idx+1,dp);
	    
	    return dp[idx][target]=(include%mod+exclude%mod)%mod;
	}
	int perfectSum(int arr[], int n, int sum){
	    vector<vector<int>>dp(n+1,vector<int>(sum+1,-1));
        return solve(arr,n,sum,0,dp);
	}
	  
};

//{ Driver Code Starts.
int main() 
{
   	
   
   	int t;
    cin >> t;
    while (t--)
    {
        int n, sum;

        cin >> n >> sum;

        int a[n];
        for(int i = 0; i < n; i++)
        	cin >> a[i];

       

	    Solution ob;
	    cout << ob.perfectSum(a, n, sum) << "\n";
	     
    }
    return 0;
}

// } Driver Code Ends
