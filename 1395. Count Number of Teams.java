class Solution {
    public int solve1(int[] rating ,int prev,int curr,int k,int[][][] dp1){
        int n=rating.length;
        if(curr==n){
            if(k==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp1[prev+1][curr][k]!=0){
            return dp1[prev+1][curr][k];
        }
        int include=0,exclude=0;
        if(prev==-1 || rating[prev]<rating[curr]  && k>0){
            include=solve1(rating,curr,curr+1,k-1,dp1);
        }
        exclude=solve1(rating,prev,curr+1,k,dp1);

        return dp1[prev+1][curr][k]=include+exclude;
    }
     public int solve2(List<Integer>arr ,int prev,int curr,int k,int[][][] dp2){
        int n=arr.size();
        if(curr==n){
            if(k==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp2[prev+1][curr][k]!=0){
            return dp2[prev+1][curr][k];
        }
        int include=0,exclude=0;
        if(prev==-1 || arr.get(prev) < arr.get(curr) && k>0){
            include=solve2(arr,curr,curr+1,k-1,dp2);
        }
        exclude=solve2(arr,prev,curr+1,k,dp2);

        return dp2[prev+1][curr][k]=include+exclude;
    }
    public int numTeams(int[] rating) {
        int n=rating.length+2;
        int[][][] dp1= new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < 4; l++) {
                    dp1[i][j][l] = 0;
                }
            }
        }
        int ans1=solve1(rating,-1,0,3,dp1);
        List<Integer>arr = new ArrayList<>();
        for(int i=0;i<rating.length;i++){
            arr.add(rating[i]);
        }
        Collections.reverse(arr);
        int[][][] dp2= new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                for (int l = 0; l < 4; l++) {
                    dp2[i][j][l] = 0;
                }
            }
        }
        int ans2=solve2(arr,-1,0,3,dp2);
        return ans1+ans2;
    }
}
