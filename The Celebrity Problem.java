//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        
System.out.println("~");
}
    }
}
// } Driver Code Ends
class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int ans = -1;
        TreeSet<Integer>st = new TreeSet<>();
        for(int i=0;i<n;i++){
            int[] vis = new int[n];
            for(int j=0;j<n;j++){
                 if(st.contains(j) && mat[j][i]==1){
                    st.remove(j);
                 }
                if(ans != j && mat[j][i]==1){
                    vis[i]+=1;
                }
            }
            if(vis[i]>=n-1 && ans==-1){
                st.add(i);
            }
        }
        TreeSet<Integer>st1 = new TreeSet<>();
        for(int i=n-1;i>=0;i--){
            int[] vis = new int[n];
            for(int j=0;j<n;j++){
                 if(st1.contains(j) && mat[j][i]==1){
                    st1.remove(j);
                 }
                if(ans != j && mat[j][i]==1){
                    vis[i]+=1;
                }
            }
            if(vis[i]>=n-1 && ans==-1){
                st1.add(i);
            }
        }
        if(st1.size()==0){
            return -1;
        }
        if(st.size()==0){
            return -1;
        }
        
        return st.first();
    }
}
