//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int minimumMultiplications(vector<int>& arr, int start, int end) {
        // sort(arr.begin(),arr.end());
        queue<int>que;
        que.push(start);
        int level=0;
        int mod=1e5;
        vector<int>vis(1e5,0);
        vis[start]=1;
        while(!que.empty()){
            int x=que.size();
            while(x--){
                int first=que.front();
                if(first==end){
                    return level;
                }
                que.pop();
                for(auto it:arr){
                    int temp=(first%mod*it%mod)%mod;
                    if(vis[temp]==0){
                        vis[temp]=1;
                        que.push(temp);
                    }
                }
            }
            level++;
        }
        return -1;
    }
};


//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        int start, end;
        cin >> start >> end;
        Solution obj;
        cout << obj.minimumMultiplications(arr, start, end) << endl;
    }
}

// } Driver Code Ends
