class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int last = derived[n-1];
        int[] ans1 = new int[n];
        int[] ans2 = new int[n];

        if(last==0 && n==1){
            return true;
        }

        if(last==1 && n==1){
            return false;
        }

        for(int i=0;i<n;i++){
            ans1[i]=-1;
        }
        for(int i=0;i<n;i++){
            ans2[i]=-1;
        }
        if(last==0){
            ans1[0]=0;
            ans1[n-1]=0;

            ans2[0]=1;
            ans2[n-1]=1;
        }
        else{
            ans1[0]=1;
            ans1[n-1]=0;

            ans2[0]=0;
            ans2[n-1]=1;
        }

        boolean ans = false;

        for(int i=n-2;i>=0;i--){
           if(ans1[i]==-1){
            ans1[i]=ans1[i+1] ^ derived[i];
           }
           else{
             if(ans1[i] == (ans1[i+1] ^ derived[i])){
                ans=true;
             }
           }
        }
         for(int i=n-2;i>=0;i--){
           if(ans2[i]==-1){
             ans2[i]=ans2[i+1] ^ derived[i];
           }
           else{
             if(ans2[i] == (ans2[i+1] ^ derived[i])){
                ans=true;
             }
           }
        }
        return ans;
    }
}
