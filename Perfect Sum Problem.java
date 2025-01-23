//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        // Loop for each test case
        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution(); // Create an object of Solution class
            System.out.println(
                ob.perfectSum(nums, target)); // Call perfectSum and print the result
            System.out.println("~");          // Call perfectSum and print the result
        }
    }
}
// } Driver Code Ends
class Solution {
    int[][] dp;
    public int subsetSum(int[] nums,int target,int sum,int idx){
        if(sum>target){
            return 0;
        }
        if(idx==nums.length){
            if(sum==target){
                return 1;
            }
            return 0;
        }
        
        if(dp[idx][sum]!=-1){
            return dp[idx][sum];
        }
        
        int include = subsetSum(nums,target,sum+nums[idx],idx+1);
        int exclude = subsetSum(nums,target,sum,idx+1);
        
        return dp[idx][sum]=include+exclude;
    }
    public int perfectSum(int[] nums, int target) {
        int n=nums.length+2;
       dp=new int[n][target+3];
       int sum=0;
       for(int i=0;i<=nums.length;i++){
           for(int j=0;j<=target;j++){
               dp[i][j]=-1;
           }
       }
       return subsetSum(nums,target,sum,0);
    }
}
