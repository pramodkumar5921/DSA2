class Solution {
    public boolean canConstruct(String s, int k) {
        int n=s.length();
        int[] vis = new int[26];

        for(int i=0;i<s.length();i++){
            int idx = s.charAt(i)-'a';
            vis[idx]+=1;
        }

        int even = 0;
        int odd = 0;

        for(int i=0;i<26;i++){
            if(vis[i]==0){
                continue;
            }
            else if(vis[i]%2==0){
                even++;
            }
            else if(vis[i]%2==1){
                odd++;
            }
        }

        if(odd>k){
            return false;
        }

        if(k>n){
            return false;
        }

        return true;
    }
}
