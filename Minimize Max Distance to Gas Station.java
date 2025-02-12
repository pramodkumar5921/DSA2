//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Solution {
     public static boolean isPossible(double mid,ArrayList<Integer>diff,int k){
       // int n=arr.length;
        int cnt=0;
        for(int i=0;i<diff.size();i++){
           if(diff.get(i)>mid){
               cnt += (int)Math.ceil(diff.get(i)/mid)-1;
           }
        }
        if(cnt>k){
            return false;
        }
        return true;
    }
    public static double findSmallestMaxDist(int arr[], int K) {
         ArrayList<Integer>diff = new ArrayList<>();
        int first = arr[0];
        for(int i=1;i<arr.length;i++){
            diff.add(arr[i]-first);
            first=arr[i];
        }
        double l=0.000000;
        double h=arr[arr.length-1]-arr[0];
        double ans = 1.000000;
        
        while(l<=h){
            double mid = (double)(l+(double)(h-l)/2);
            if(isPossible(mid,diff,K)==true){
                ans=mid;
                h=mid-0.000001;
               
            }
            else{
                l=mid+0.000001;
            }
        }
        //System.out.print(ans);
        return ans;
    }
}
