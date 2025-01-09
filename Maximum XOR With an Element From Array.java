//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.ArrayList; 

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N=sc.nextInt();
            int Q=sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int [][]queries=new int[Q][2];
            for(int i=0;i<Q;i++){
                queries[i][0]=sc.nextInt();
                queries[i][1]=sc.nextInt();
            }
            
            Solution obj = new Solution();
            int ans[]= obj.maximumXor(N, Q, arr, queries);
            for(int i=0;i<ans.length;i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static class TrieNode{
        TrieNode left;TrieNode right;

        TrieNode(){
            left=null;
            right=null;
        }
    }

    static public TrieNode getNode(){
        return new TrieNode();
    }
    static public void insert(TrieNode root,int num){
        TrieNode crawl = root;

        for(int i=31;i>=0;i--){
            int ithBitVal = (num>>i)&1;

            if(ithBitVal == 1){
                if(crawl.right==null){
                    crawl.right=getNode();
                    crawl=crawl.right;
                }
                else{
                    crawl=crawl.right;
                }
            }
            else{
                if(crawl.left==null){
                    crawl.left=getNode();
                    crawl=crawl.left;
                }
                else{
                    crawl=crawl.left;
                }
            }
        }
    }

    static public int maxXor(TrieNode root,int num){
        TrieNode crawl = root;

        int ans=0;

        for(int i=31;i>=0;i--){
            int ithBitVal = (num>>i)&1;

            if(ithBitVal==1){
                if(crawl.left!=null){
                    ans+= (int)(Math.pow(2,i));
                    crawl=crawl.left;
                }
                else{
                    crawl=crawl.right;
                }
            }
            else{
                if(crawl.right!=null){
                    ans+=(int)(Math.pow(2,i));
                    crawl=crawl.right;
                }
                else{
                    crawl=crawl.left;
                }
            }
        }

        if(ans==0){
            return -1;
        }

        return ans;
    }
    static int[] maximumXor(int N, int Q, int nums[],int queries[][]) {
         TrieNode root = new TrieNode();

        int n=queries.length;
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>>offlineQueries=new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<queries.length;i++){
            int x=queries[i][0];
            int m=queries[i][1];
            int idx=i;

            ArrayList<Integer>temp=new ArrayList<>();
            temp.add(m);
            temp.add(x);
            temp.add(idx);

            offlineQueries.add(new ArrayList<Integer>(temp));
        }

        Collections.sort(offlineQueries,(ArrayList<Integer>arr1,ArrayList<Integer>arr2)->{
            return Integer.compare(arr1.get(0),arr2.get(0));
        });

        int[] ans = new int[n];

        int j=0;
        int len=nums.length;

        int cnt=0;

        for(int i=0;i<n;i++){
            int m=offlineQueries.get(i).get(0);
            int x=offlineQueries.get(i).get(1);
            int idx=offlineQueries.get(i).get(2);

            while(j<len && nums[j]<=m){
                cnt++;
                insert(root,nums[j]);
                j++;
            }

            if(cnt!=0){
                int tempAns =  maxXor(root,x);
                ans[idx]=tempAns;
            }

            else if(cnt==0){
                ans[idx]=-1;
            }
           
            
        }

        return ans;
        
    }
}
