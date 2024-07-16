class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        priority_queue<int,vector<int>,greater<int>>g1,s1;
        for(int i=0;i<g.size();i++){
            g1.push(g[i]);
        }
        for(int i=0;i<s.size();i++){
            s1.push(s[i]);
        }
        int cnt=0;
        while(g1.size()>0 and s1.size()>0){
            if(s1.top()>=g1.top()){
                s1.pop();
                g1.pop();
                cnt++;
            }
            else{
                s1.pop();
            }
        }
        return cnt;
    }
};
