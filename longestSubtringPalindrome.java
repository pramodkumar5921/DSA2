class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for(int gap=0;gap<n;gap++){
            for(int i=0;i<n;i++){
                int j = i+gap;
                if(j>=n){
                    break;
                }
                if(gap==0){
                    dp[i][j]=1;
                }
                else if(gap==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=2;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]!=0){
                        dp[i][j]=dp[i+1][j-1]+2;
                    }
                }
            }
        }

        int ans = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
              if(dp[i][j]>0){
                ans+=1;
              }
            }
        }

        return ans;

     
    }
}
