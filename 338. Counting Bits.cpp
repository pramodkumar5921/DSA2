class Solution {
public:
    int NumberBit(int n){
        int cnt=0;
        for(int i=0;i<=31;i++){
            int ithBit=(n>>i)&1;
            if(ithBit==1){
                cnt++;
            }
        }
        return cnt;
    }
    vector<int> countBits(int n) {
        vector<int>arr;
        for(int i=0;i<=n;i++){
            int temp=NumberBit(i);
            arr.push_back(temp);
        }
        return arr;
    }
};
