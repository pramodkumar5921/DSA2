//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n = a.length;
        int m = b.length;
        
        if(n>m){
            return kthElement(b,a,k);
        }
        
        int l=0,h=Math.min(k,n);
        int ans = -1;
        while(l<=h){
            int px = l+(h-l)/2;
            int py = k-px;
            
            int x1 = Integer.MIN_VALUE;
            int x2 = Integer.MIN_VALUE;
            int x3 = Integer.MAX_VALUE;
            int x4 = Integer.MAX_VALUE;
        
            if(px-1>=0 && px-1<n){
                x1 = a[px-1];
            }
            if(py-1>=0 && py-1<m){
                x2 = b[py-1];
            }
            if(px<n){
                x3=a[px];
            }
            if(py<m){
                x4=b[py];
            }
            
            if(x1<=x4 && x2<=x3){
                ans = Math.max(x1,x2);
            }
            if(x1>x4){
                h=px-1;
            }
            else if(x1<=x4){
                l=px+1;
            }
        }
        return ans;
    }
}
