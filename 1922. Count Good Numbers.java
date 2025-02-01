class Solution {
    public long MOD(long x,long m){
        return (x%m)%m;
    }
    public long Power(long x,long n,long m){
        long ans = 1;
        while(n>0){
            if(n%2==0){
                x=MOD((long)x*x,m);
                n=n/2;
            }
            else{
                ans=MOD((long)ans*x,m);
                n-=1;
            }
        }
        return ans;
    }
    public int countGoodNumbers(long n) {
        long ans = 1;
        long m = 1000000007;
        long left = 0;
        long right = 0;

        if(n%2==1){
            left = n/2+1;
            right = n/2;
        }

        else if(n%2==0){
            left = n/2;
            right = n/2;
        }

        long ans1 = Power(5,left,m);
        long ans2 = Power(4,right,m);

        ans = MOD((long)ans1*ans2,m);
        return (int)ans;
    }
}
