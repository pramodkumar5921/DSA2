import java.util.*;
public class Solution {
    public static int FindParent(int x,int[] parent){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=FindParent(parent[x], parent);
    }
    public static void Combine(int u,int v,int[] subtree,int[] parent){
        int ru=FindParent(u, parent);
        int rv=FindParent(v, parent);
        if(ru==rv){
            return;
        }
        else if(subtree[ru]>subtree[rv]){
            subtree[ru]+=subtree[rv];
            parent[rv]=ru;
        }
        else{
            subtree[rv]+=subtree[ru];
            parent[ru]=rv;
        }
    }
    public static int[] numberOfIslandII(int n, int m, int [][]queries, int q) {
       int[][] vis=new int[n][m];
       int Node=n*m+5;
       int[] parent=new int[Node];
       int[] subtree=new int[Node];
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               vis[i][j]=0;
           }
       }
       for(int i=0;i<Node;i++){
           parent[i]=i;
       }
       for(int i=0;i<Node;i++){
           subtree[i]=1;
       }
       int cnt=0;
       int len=queries.length;
       int[] ans=new int[len];
       int[] dr={-1,0,1,0};
       int[] dc={0,1,0,-1};
       for(int i=0;i<queries.length;i++){
           cnt++;
           int row=queries[i][0];
           int col=queries[i][1];
           if(vis[row][col]==0){
               for(int k=0;k<4;k++){
                   int nr=row+dr[k];
                   int nc=col+dc[k];
                   if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]!=0){
                      int numRow=row*m+col;
                      int numNew=nr*m+nc;
                      if(FindParent(numRow,parent)==FindParent(numNew,parent)){
                          continue;
                      } 
                      else{
                          cnt--;
                          Combine(numRow,numNew,subtree,parent);
                      }
                   }
               }
               vis[row][col]=1;
           }
           ans[i]=cnt;
       }
       return ans;
    }
}
