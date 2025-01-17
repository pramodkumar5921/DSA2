class Solution {
    public int countPrimes(int n) {
        int[] vis = new int[5000005];

        for(int i=2;i<=n;i++){
            for(int j=i*2;j<=n;j+=i){
                vis[j]=1;
            }
        }

        // for(int i=0;i<=10;i++){
        //     System.out.print(vis[i]+" ");
        // }

        int ans = 0;

        for(int i=2;i<n;i++){
            if(vis[i]==0){
                ans+=1;
            }
        }
        return ans;
    }
}
