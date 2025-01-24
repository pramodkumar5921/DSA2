class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int v=graph.length;
       HashMap<Integer,ArrayList<Integer>>mp = new HashMap<>();
       int[] Indegree = new int[v];
       for(int i=0;i<v;i++){
         mp.put(i,new ArrayList<Integer>());
       } 
       for(int i=0;i<graph.length;i++){
         for(int j=0;j<graph[i].length;j++){
            Indegree[i]+=1;
            mp.get(graph[i][j]).add(i);
         }
       }
       Queue<Integer>que = new LinkedList<>();
       for(int i=0;i<v;i++){
         if(Indegree[i]==0){
            que.add(i);
         }
       }
       List<Integer>ans = new ArrayList<>();
       while(que.size()>0){
         int node=que.poll();
         ans.add(node);

         for(int child:mp.get(node)){
            Indegree[child]-=1;
            if(Indegree[child]==0){
                que.add(child);
            }
         }
       }
       Collections.sort(ans);
       return ans;
    }
}
