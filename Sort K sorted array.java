//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		
System.out.println("~");
}
	}
}


// } Driver Code Ends
class Solution{
    public static void merge(ArrayList<Integer>ans,int[] arr,int K){
        int i=0,j=0;
        int n=ans.size();
        int m=K;
        
        ArrayList<Integer>tempAns = new ArrayList<>();
        
        while(i<n && j<m){
          if(ans.get(i) <= arr[j]){
              tempAns.add(ans.get(i));
              i+=1;
          } 
          else{
              tempAns.add(arr[j]);
              j+=1;
          }
        }
        while(i<n){
            tempAns.add(ans.get(i));
            i+=1;
        }
        while(j<m){
            tempAns.add(arr[j]);
            j+=1;
        }
        ans.clear();
        ans.addAll(tempAns);
        //ans = tempAns;
    } 
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) {
        ArrayList<Integer>ans = new ArrayList<Integer>();
        for(int i=0;i<K;i++){
            ans.add(arr[0][i]);
        }
        Collections.sort(ans);
        // System.out.print(ans);
        for(int i=1;i<K;i++){
            merge(ans,arr[i],K);
        }
        return ans;
    }
}
