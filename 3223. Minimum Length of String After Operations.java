class Solution {
    public int minimumLength(String s) {
        int n=s.length();
        int[] freq = new int[26];
        for(int i=0;i<n;i++){
            int idx = (int)s.charAt(i)-'a';
            freq[idx]+=1;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            if(freq[i]<3){
                ans+=freq[i];
                continue;
            }
            else{
                if(freq[i]%2==1){
                    ans+=1;
                }
                else{
                    ans+=2;
                }
            }
        }
        return ans;
    }
}
