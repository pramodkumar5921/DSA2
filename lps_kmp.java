//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String text = sc.next();
            String pat = sc.next();
            Solution obj = new Solution();
            int res = obj.findMatching(text, pat);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends
class Solution {
    public int[] ComputeLps(String pat){
       int m=pat.length();
       int[] lps=new int[m+1];
        int i=1;
        int len=0;
        lps[0]=0;
        while(i<m){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
    public int findMatching(String text, String pat) {
       int n=text.length();
       int m=pat.length();
       int[] lps=ComputeLps(pat);
       int i=0,j=0;
       int ans=10000000;
       while(i<n){
           if(j<m && text.charAt(i)==pat.charAt(j)){
               i++;j++;
           }
           if(j==m){
               ans=Math.min(i-m,ans);
               j=lps[j-1];
               
           }
           else if(i < n && pat.charAt(j) != text.charAt(i)){
               if(j!=0){
                   j=lps[j-1];
               }
               else{
                   i++;
               }
           }
       }
       if(ans==10000000){
           return -1;
       }
       return ans;
    }
}
