class Solution {
    public int solve(int[][] books,int shelfWidth,int idx,int total,int heights,int[][] dp){
        int n=books.length;
        if(idx>=n){
            return heights;
        }
        if(dp[shelfWidth][idx]!=-1){
            return dp[shelfWidth][idx];
        }
        int include=100000000;
        if(shelfWidth >= books[idx][0]){
            int temp=Math.max(heights,books[idx][1]);
            include=solve(books,shelfWidth-books[idx][0],idx+1,total,temp,dp);
        }
        int exclude=heights+solve(books,total-books[idx][0],idx+1,total,books[idx][1],dp);

        return dp[shelfWidth][idx]=Math.min(include,exclude);
    }
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[][] dp = new int[1001][1001];
        for(int i=0;i<=1000;i++){
            for(int j=0;j<=1000;j++){
                dp[i][j]=-1;
            }
        }
        return solve(books,shelfWidth,0,shelfWidth,0,dp);
    }
}
