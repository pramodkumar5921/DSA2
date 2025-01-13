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
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Solution {
    static class Element{
        public int sum;
        public int ith;
        public int jth;
        
        Element(int sum,int ith,int jth){
            this.sum=sum;
            this.ith=ith;
            this.jth=jth;
        }
    }
    static List<Integer> maxCombinations(int N, int k, int arr1[], int arr2[]) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        int[] A = new int[N];
        int[] B = new int[N];
        
        int cnt=0;
        
        for(int i=N-1;i>=0;i--){
            A[cnt]=arr1[i];
            B[cnt]=arr2[i];
            cnt+=1;
        }
        
        
        
        PriorityQueue<Element>pq = new PriorityQueue<>(
            (Element e1,Element e2)->{
                return Integer.compare(e2.sum,e1.sum);
            }
        );
        
        pq.add(new Element(A[0]+B[0],0,0));
        
        List<Integer>ans = new ArrayList<>();
        
        HashMap<String,Integer>mp = new HashMap<>();
        
        while(k>0){
            Element temp = pq.poll();
            int ith = temp.ith;
            int jth = temp.jth;
            int sum = temp.sum;
            String str = Integer.toString(sum) + "#" + Integer.toString(ith) + "#" + Integer.toString(jth);
            
            if(mp.containsKey(str)==true){
                continue;
            }
            ans.add(temp.sum);
            mp.put(str,sum);
            if(ith+1<A.length){
                pq.add(new Element(A[ith+1]+B[jth],ith+1,jth));
            }
            if(jth+1<B.length){
                pq.add(new Element(A[ith]+B[jth+1],ith,jth+1));
            }
            k-=1;
        }
        Collections.sort(ans,Collections.reverseOrder());
        return ans;
    }
}
