class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        if(n>m){
            return findMedianSortedArrays(nums2,nums1);
        }

        int l=0,h=nums1.length;
        int len = (m+n+1)/2;

        double ans = 0.0;
        while(l<=h){
            int px = l+(h-l)/2;
            int py = len-px;
            int x1=Integer.MIN_VALUE;
            int x2=Integer.MIN_VALUE;
            int x3=Integer.MAX_VALUE;
            int x4=Integer.MAX_VALUE;
            if(px-1>=0){
                x1=nums1[px-1];
            }
            if(py-1>=0){
                x2=nums2[py-1];
            }
            if(px<n){
                x3=nums1[px];
            }
            if(py<m){
                x4=nums2[py];
            }

            if(x1<=x4 && x2<=x3){
                int ans1 = Math.max(x1,x2);
                int ans2 = Math.min(x3,x4);

                if((n+m) % 2 ==0){
                    ans = (double)((double)(ans1+ans2)/2.0);
                }
                else{
                    ans = (double)ans1*(1.00000);
                }
            }

            if(x1>x4){
                h=px-1;
            }
            else{
                l=px+1;
            }

            
        }

        return ans;


    }
}
