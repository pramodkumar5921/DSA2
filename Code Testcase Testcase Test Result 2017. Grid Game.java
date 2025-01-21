class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long ans = Long.MAX_VALUE;
        long firstRowSum = 0;
        for(int i=0;i<n;i++){
            firstRowSum+= grid[0][i];
        }
        long sum = 0;
        long colSum = 0;

        for(int i=0;i<n;i++){
            sum+=grid[0][i];
            long remainSum = firstRowSum-sum;
            long temp = Math.max(remainSum,colSum);
            ans=Math.min(ans,temp);
            colSum+=grid[1][i];
        }

        return ans;


    }
}
