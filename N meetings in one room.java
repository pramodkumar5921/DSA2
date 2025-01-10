//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int maxMeetings(int start[], int end[]) {
       ArrayList<ArrayList<Integer>>tempArray = new ArrayList<ArrayList<Integer>>();
       for(int i=0;i<start.length;i++){
           ArrayList<Integer>arr=new ArrayList<Integer>();
           arr.add(start[i]);
           arr.add(end[i]);
           
          tempArray.add(new ArrayList<Integer>(arr));
          
       }
       
         Collections.sort(tempArray,(ArrayList<Integer>arr1,ArrayList<Integer>arr2)->{
              return Integer.compare(arr1.get(1),arr2.get(1));
          });
        
         int ans=1;
         
         int last1 = tempArray.get(0).get(1);
         int start1 = tempArray.get(0).get(0);
          for(int i=1;i<start.length;i++){
              int startEle = tempArray.get(i).get(0);
              int endEle   = tempArray.get(i).get(1);
              
             if(startEle>last1){
                 ans++;
                 last1=endEle;
                 start1=startEle;
             }
             else{
                 continue;
             }
          }
          
          return ans;
    }
}
