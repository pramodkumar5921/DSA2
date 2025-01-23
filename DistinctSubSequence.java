//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public static void DistinctSubsequence(String str,long[] dp,int n){
        dp[0]=1;
        HashMap<Character,Integer>mp = new HashMap<>();
        for(int i=1;i<=n;i++){
            dp[i]=2*dp[i-1];
            char tempChar = str.charAt(i-1);
            if(mp.containsKey(tempChar)==true){
                int j=mp.get(tempChar);
               dp[i]=dp[i]-dp[j-1];
            }
            
            mp.put(tempChar,i);
            
        }
    }
    public static String betterString(String str1, String str2) {
       int n=str1.length();
       long[] dp1 = new long[n+1];
       long[] dp2 = new long[n+1];
       
       DistinctSubsequence(str1,dp1,n);
       DistinctSubsequence(str2,dp2,n);
       
       if(dp1[n]>=dp2[n]){
           return str1;
       }
       return str2;
    }
}
