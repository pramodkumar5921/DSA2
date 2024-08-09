class Solution {
    public static void DFS(int node,int[] vis,HashMap<Integer,ArrayList<Integer>>graph,int[] temp){
        vis[node]=1;
        temp[0]+=1;
         ArrayList<Integer> neighbors = graph.get(node);
         if(neighbors!=null){
             for(int it:graph.get(node)){
            if(vis[it]==0){
                DFS(it,vis,graph,temp);
            }
        }
         }
       
        return;
    }
    public int removeStones(int[][] stones) {
        HashMap<Integer,ArrayList<Integer>>graph=new HashMap<>();
        for(int i=0;i<stones.length;i++){
            int u1=stones[i][0];
            int v1=stones[i][1];
            for(int j=0;j<stones.length;j++){
                int u2=stones[j][0];
                int v2=stones[j][1];
                if(i!=j){
                    if(u1==u2 || v1==v2){
                        graph.putIfAbsent(i,new ArrayList<>());
                        // graph.putIfAbsent(j,new ArrayList<>());
                        graph.get(i).add(j);
                        // graph.get(j).add(i);
                    }
                }
            }
        }
        if(graph.size()==0){
            return 0;
        }
        int n=stones.length;
        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            vis[i]=0;
        }
        int ans=0;
        for(int i=0;i<n;i++){
                int[] temp=new int[1];
                DFS(i,vis,graph,temp);
                ans+= temp[0]-1; 
        }
        return ans;
    }
}
