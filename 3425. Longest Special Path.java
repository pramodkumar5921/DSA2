// igraphort java.util.*;

class Solution {
    class Pair {
        public int v, wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public void dfs(int node,int parent,HashMap<Integer,ArrayList<Pair>>graph,int[] nums,int pathSum,int start,int end,ArrayList<Integer>pathArr,int[]ans,HashMap<Integer,Integer>mp){
        int prevIdx = -1;
        if(mp.containsKey(nums[node]) == true){
            prevIdx = mp.get(nums[node]);
        }
        while(start<=prevIdx){
            pathSum-=pathArr.get(start);
            start+=1;
        }
        if(pathSum>ans[0]){
            ans[0]=pathSum;
            ans[1]=end-start+1;
        }
        else if(pathSum==ans[0]){
            ans[1]=Math.min(ans[1],end-start+1);
        }
        mp.put(nums[node],end);

        for(Pair p1:graph.get(node)){
            int nextNode = p1.v;
            int val = p1.wt;
            if(nextNode == parent){
                continue;
            }
            pathArr.add(val);
            dfs(nextNode,node,graph,nums,pathSum+val,start,end+1,pathArr,ans,mp);
            pathArr.remove(pathArr.size()-1);
        }
        mp.put(nums[node],prevIdx);
    }

    public int[] longestSpecialPath(int[][] edges, int[] nums) {
        HashMap<Integer, ArrayList<Pair>> graph = new HashMap<>();
       

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            

            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<Pair>());
            }

            if(!graph.containsKey(v)){
                graph.put(v,new ArrayList<Pair>());
            }

            graph.get(u).add(new Pair(v,wt));
            graph.get(v).add(new Pair(u,wt));
    
        }

        int[] ans = new int[2];
        ans[0]=0;
        ans[1]=100000;

        ArrayList<Integer>pathArr = new ArrayList<>();

        HashMap<Integer,Integer>mp = new HashMap<>();

        dfs(0,-1,graph,nums,0,0,0,pathArr,ans,mp);

        return ans;
    }
}
