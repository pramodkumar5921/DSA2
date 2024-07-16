class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t cnt=1;
        uint32_t ans=0;
        for(int i=31;i>=0;i--){
            uint32_t ithBit=(uint32_t)((uint32_t)(n>>i)&1);
            if(ithBit==1){
                ans+= cnt;
            }
            cnt = (uint32_t)cnt*2;
        }
        return ans;
    }
};
