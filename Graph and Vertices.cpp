//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    long long int power(int x,int y){
        if(y==0){
            return 1;
        }
        long long int temp=power(x,y/2);
        if(y%2==0){
            return (long long int)temp*temp;
        }
        else{
            return (long long int)x*temp*temp;
        }
    }
    long long count(int n) {
       int x = ((n)*(n-1))/2;
       return power(2,x);
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution ob;
        cout << ob.count(n) << "\n";
    }

    return 0;
}

// } Driver Code Ends
