//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class Solution{
    public int[] twoOddNum(int Arr[], int N){
       int xorSum = 0;
       for(int i=0;i<Arr.length;i++){
           xorSum=xorSum^Arr[i];
       }
       
       int rightMostBit = (xorSum)&(-xorSum);
       
       int num1=0,num2=0;
       
       for(int i=0;i<Arr.length;i++){
           if((Arr[i] & rightMostBit)!=0){
               num1^=Arr[i];
           }
           else{
               num2^=Arr[i];
           }
       }
       if(num1<num2){
           int temp=num2;
           num2=num1;
           num1=temp;
       }
       
       int[] ans = new int[2];
       ans[0]=num1;
       ans[1]=num2;
       
       return ans;
    }
}
