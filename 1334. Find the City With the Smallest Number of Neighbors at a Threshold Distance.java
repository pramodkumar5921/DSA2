import java.util.*;
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph=new int[n][n];
          for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], 1_000_000_000);
            graph[i][i] = 0;  // Distance to self is 0
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    graph[i][j]=0;
                }
            }
        }
        for(int i=0;i<edges.length;i++){
           int u=edges[i][0];
           int v=edges[i][1];
           int wt=edges[i][2];
           graph[u][v]=Math.min(graph[u][v],wt);
           graph[v][u]=Math.min(graph[v][u],wt);
        }
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    graph[i][j]=Math.min(graph[i][j],graph[i][via]+graph[via][j]);
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(graph[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int ans=-1;
       int mini = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(graph[i][j]<=distanceThreshold){
                    cnt++;
                }
            }
            if(cnt<=mini){
                mini=cnt;
                ans=Math.max(ans,i);
            }
        }
        return ans;
    }
}
