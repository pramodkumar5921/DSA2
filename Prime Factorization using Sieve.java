//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            obj.sieve();
            List<Integer> ans = obj.findPrimeFactors(n);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static void sieve() {}
    static void calFactor(int N,int num,List<Integer>ans){
        boolean flag = true;
        while(N>0){
            if(N%num==0 && flag==true){
                ans.add(num);
            }
            if(N%num!=0){
                flag=false;
            }
            N=N/num;
        }
    }
    static List<Integer> findPrimeFactors(int N) {
       int[] vis = new int[N+5];
       
       for(int i=2;i<=N;i++){
           
           for(int j=i*2;j<=N;j+=i){
               vis[j]=1;
           }
       }
       
       int tempN = N;
       
       List<Integer>ans = new ArrayList<>();
       for(int i=2;i<=N/2;i++){
           if(vis[i]==0 && N%i==0){
              calFactor(tempN,i,ans); 
           }
       }
       if(vis[N]==0){
           ans.add(N);
       }
       return ans;
    }
}
