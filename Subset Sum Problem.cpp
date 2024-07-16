//{ Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
//User function template for C++

class Solution{   
public:
    int dp[101][10001];
    int CountSet(vector<int>&arr,int target,int idx){
        if(target<0){
            return 0;
        }
        if(idx==arr.size()){
            if(target==0){
                return 1;
            }
            return 0;
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target];
        }
        int include=0,exclude=0;
        include=CountSet(arr,target-arr[idx],idx+1);
        exclude=CountSet(arr,target,idx+1);
        
        return dp[idx][target]=include+exclude;
    }
    bool isSubsetSum(vector<int>arr, int sum){
        memset(dp,-1,sizeof(dp));
       int ans=CountSet(arr,sum,0);
       return ans;
    }
};

//{ Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N, sum;
        cin >> N;
        vector<int> arr(N);
        for(int i = 0; i < N; i++){
            cin >> arr[i];
        }
        cin >> sum;
        
        Solution ob;
        cout << ob.isSubsetSum(arr, sum) << endl;
    }
    return 0; 
} 

// } Driver Code Ends
