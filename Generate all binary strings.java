//{ Driver Code Starts
//Initial Template for Java

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
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends
class Solution {
  public static void allBinaryString(int n,int idx,int[] arr,List<String>ans){
      if(idx==n){
          String tempAns="";
          for(int i=0;i<arr.length;i++){
              tempAns+= Integer.toString(arr[i]);
          }
          ans.add(tempAns);
          return;
      }
      if(arr[idx-1]==1){
          arr[idx]=0;
          allBinaryString(n,idx+1,arr,ans);
          arr[idx]=0;
      }
      else{
          arr[idx]=0;
          allBinaryString(n,idx+1,arr,ans);
          arr[idx]=0;
          arr[idx]=1;
          allBinaryString(n,idx+1,arr,ans);
          arr[idx]=1;
      }
  }
  public static List<String> generateBinaryStrings(int n) {
      int[] arr = new int[n];
      arr[0]=1;
      List<String>ans = new ArrayList<>();
      allBinaryString(n,1,arr,ans);
      arr[0]=0;
      allBinaryString(n,1,arr,ans);
      Collections.sort(ans);
      return ans;
  }
}
     
     
