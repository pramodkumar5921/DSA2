class Solution {
public:
    int lengthOfLongestSubstring(string s) {
      int i=0,j=0;
      unordered_map<char,int>mp;
      int ans=0;
      while(i<s.size()){
        mp[s[i]]++;
        while(mp[s[i]]>1 and j<i){
            mp[s[j]]--;
            if(mp[s[j]]==0){
                mp.erase(s[j]);
            }
            j++;
        }
        ans=max(ans,i-j+1);
        i++;
      }
      return ans;
    }
};
