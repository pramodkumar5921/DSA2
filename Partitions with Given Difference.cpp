//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    const int mod=1000000007;
    int PossibleParition(vector<int>&arr,int d,int idx,int total,
    vector<vector<int>>&dp){
        if(total<0){
            return 0;
        }
        if(idx==arr.size()){
            if(total==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[idx][total]!=-1){
            return dp[idx][total];
        }
        int include=0,exclude=0;
        include=PossibleParition(arr,d,idx+1,total-arr[idx],dp);
        exclude=PossibleParition(arr,d,idx+1,total,dp);
        
        return dp[idx][total]=(include+exclude)%mod;
    }
    int countPartitions(int n, int d, vector<int>& arr) {
       int total=0;
       for(auto it:arr){
           total+=it;
       }
       int reqSum=(total+d);
       if(reqSum%2==1){
           return 0;
       }
       reqSum=reqSum/2;
       vector<vector<int>>dp(n+1,vector<int>(reqSum+1,-1));
       return PossibleParition(arr,d,0,reqSum,dp);
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, d;
        cin >> n >> d;
        vector<int> arr;

        for (int i = 0; i < n; ++i) {
            int x;
            cin >> x;
            arr.push_back(x);
        }

        Solution obj;
        cout << obj.countPartitions(n, d, arr) << "\n";
    }
    return 0;
}
// } Driver Code Ends
