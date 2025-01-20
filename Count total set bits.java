//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


// } Driver Code Ends
//User function Template for Java

class Solution{
    public static int msbBitLessThanN(int n){
        int x = 0;
        while((1<<x)<=n){
            x+=1;
        }
        return x-1;
    }
    public static int countSetBits(int n){
       if(n==0){
           return 0;
       }
       int x = msbBitLessThanN(n);
       int bitTillx = x*(1<<(x-1));
       int msbBitN  = n-(1<<x)+1;
       int rest     = n-(1<<x);
       
       return bitTillx + msbBitN + countSetBits(rest);
    }
}

//{ Driver Code Starts.

// Driver code
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		
System.out.println("~");
}
	}
}

// } Driver Code Ends
