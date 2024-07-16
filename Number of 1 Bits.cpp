class Solution {
public:
    int hammingWeight(int n) {
        int cnt=0;
        for(int i=0;i<32;i++){
            int ithBit = (n>>i)&1;
            if(ithBit==1){
                cnt++;
            }
        }
        return cnt;
    }
};
