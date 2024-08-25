 long long Power(long long a,long long n){
        long long res=1;
        while(n>0){
            if(n%2==1){
                res=(res%mod*a%mod)%mod;
                n--;
            }
            else{
                a=(a%mod*a%mod)%mod;
                n=n/2;
            }
        }
        return res;
    }
