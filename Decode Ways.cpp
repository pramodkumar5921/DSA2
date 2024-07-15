class Solution {
public:
    int dp[101];
    int solve(string &s,int idx){
        if(idx==s.size()){
            return 1;
        }
        if(s[idx]=='0'){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int result=0;
        result=solve(s,idx+1);
        if(idx+1<s.size()){
            if(s[idx]=='1' || s[idx]=='2' and s[idx+1]<='6'){
                result+=solve(s,idx+2);
            }
        }
        return dp[idx]=result;
    }
    int numDecodings(string s) {
        memset(dp,-1,sizeof(dp));
        int ans=solve(s,0);
        return ans;
    }
};
