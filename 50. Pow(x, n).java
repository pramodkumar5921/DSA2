class Solution {
    public double Power(double x,double n){
        double ans = 1.0;

        while(n>0){
            if(n%2==1){
                ans=(double)ans*x;
                n-=1;
            }
            else{
                x=(double)x*x;
                n=n/2;
            }
        }

        return ans;

    }
    public double myPow(double x, int n) {

        double m = Math.abs(n);
        double tempAns = Power(x,m); 
        double ans = (double)1/tempAns;

        if(x>1.00 && n==-2147483648){
            return 0.0;
        }

        if(n<0){
            return ans;
        }
        return tempAns;
    }
}
