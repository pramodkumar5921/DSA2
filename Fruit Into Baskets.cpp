//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int totalFruits(vector<int> &arr) {
        int i=0,j=0;
        int n=arr.size();
        unordered_map<int,int>mp;
        int ans=0;
        while(i<n){
            mp[arr[i]]++;
            while(mp.size()>2 and j<=i){
                mp[arr[j]]--;
                if(mp[arr[j]]==0){
                    mp.erase(arr[j]);
                }
                j++;
            }
            ans=max(ans,i-j+1);
            i++;
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore(); // To ignore any newline character left in the buffer
    while (t--) {
        string line;
        getline(cin, line); // Read the entire line of input
        stringstream ss(line);
        vector<int> arr;
        int num;

        // Parse the input line into integers and add to the vector
        while (ss >> num) {
            arr.push_back(num);
        }
        Solution ob;
        int ans = ob.totalFruits(arr);

        cout << ans << endl;
    }
    return 0;
}

// } Driver Code Ends
