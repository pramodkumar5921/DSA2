class Solution {
    int[][] dp;
    public int isPalindrome(int i,int j,String s){
        if(i>=j){
            return 1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=isPalindrome(i+1,j-1,s);
        }

        return dp[i][j] = 0;
    }
    public boolean checkPartitioning(String s) {
        int n=s.length();
        dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                if(isPalindrome(0,i,s)==1  && isPalindrome(i+1,j,s)==1 && isPalindrome(j+1,n-1,s)==1){
                    return true;
                }
            }
        }
        return false;
    }
}
