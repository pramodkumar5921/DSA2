//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());      // Number of vertices
            String[] arrInput = br.readLine().trim().split(" "); // Input for edges

            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < arrInput.length; i += 2) {
                int u = Integer.parseInt(arrInput[i]);
                int v = Integer.parseInt(arrInput[i + 1]);
                edges.add(new int[] {u, v});
            }

            int m = Integer.parseInt(br.readLine().trim()); // Number of colors

            Solution sol = new Solution();
            System.out.println(sol.graphColoring(n, edges, m) ? "true" : "false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    boolean isPlaced(int node,HashMap<Integer,ArrayList<Integer>>graph,int[] color,int val){
        
        if(graph.get(node)==null){
            return true;
        }
        
        for(int child:graph.get(node)){
                if(color[child]==val){
                    return false;
                }
               
        }
        return true;
    }
    boolean isPossible(int node,int n,int m,HashMap<Integer,ArrayList<Integer>>graph,int[] color){
        if(node==n){
            return true;
        }
        
        for(int i=1;i<=m;i++){
           if(isPlaced(node,graph,color,i)==true){
               color[node]=i;
               boolean restNode = isPossible(node+1,n,m,graph,color);
               if(restNode==true){
                   return true;
               }
               color[node]=0;
           } 
        }
        return false;
    }
    boolean graphColoring(int v, List<int[]> edges, int m) {
        HashMap<Integer,ArrayList<Integer>>graph = new HashMap<>();
          //int[] vis = new int[v];
        //int mini = Integer.MAX_VALUE;
        for(int i=0;i<edges.size();i++){
            int u1 = edges.get(i)[0];
            int v1 = edges.get(i)[1];
            
            // mini=Math.min(u1,mini);
            // mini=Math.min(v1,mini);
            
            if(graph.get(u1)==null){
                graph.put(u1,new ArrayList<>());
            }
            if(graph.get(v1)==null){
                graph.put(v1,new ArrayList<>());
            }
            // vis[u1]=1;
            // vis[v1]=1;
            graph.get(u1).add(v1);
            graph.get(v1).add(u1);
        }
        
        int[] color = new int[v];
        
     
        // Arrays.fill(color,-1);
        
        
         return isPossible(0,v,m,graph,color);
       
    }
}
