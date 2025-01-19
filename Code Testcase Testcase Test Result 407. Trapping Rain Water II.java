class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] vis = new int[m][n];

        PriorityQueue<ArrayList<Integer>>pq = new PriorityQueue<>((ArrayList<Integer>arr1,ArrayList<Integer>arr2)->{
            return Integer.compare(arr1.get(0),arr2.get(0));
        });

        for(int i=0;i<m;i++){
            ArrayList<Integer>temp = new ArrayList<>();
            temp.add(heightMap[i][0]);
            temp.add(i);
            temp.add(0);
            vis[i][0]=1;
            pq.add(new ArrayList<>(temp));
        }
        for(int i=0;i<m;i++){
            ArrayList<Integer>temp = new ArrayList<>();
            temp.add(heightMap[i][n-1]);
            temp.add(i);
            temp.add(n-1);
            vis[i][n-1]=1;
            pq.add(new ArrayList<>(temp));
        }
        for(int j=1;j<n-1;j++){
            ArrayList<Integer>temp = new ArrayList<>();
            temp.add(heightMap[0][j]);
            temp.add(0);
            temp.add(j);
            vis[0][j]=1;
            pq.add(new ArrayList<>(temp));
        }
        for(int j=1;j<n-1;j++){
            ArrayList<Integer>temp = new ArrayList<>();
            temp.add(heightMap[m-1][j]);
            temp.add(m-1);
            temp.add(j);
            vis[m-1][j]=1;
            pq.add(new ArrayList<>(temp));
        }
        ArrayList<ArrayList<Integer>>dir = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(-1,0)),
            new ArrayList<>(Arrays.asList(0,1)),
            new ArrayList<>(Arrays.asList(1,0)),
            new ArrayList<>(Arrays.asList(0,-1))

        ));
        
        int ans = 0;
        while(pq.size()>0){
            ArrayList<Integer>alpha = pq.poll();
            int row = alpha.get(1);
            int col = alpha.get(2);
            int val = alpha.get(0);

            for(int i=0;i<4;i++){
                int nrow = row+dir.get(i).get(0);
                int ncol  = col+dir.get(i).get(1);

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]!=1){
                    vis[nrow][ncol]=1;
                    if(val>heightMap[nrow][ncol]){
                        pq.add(new ArrayList<>(Arrays.asList(
                         val,nrow,ncol
                     )));
                     ans=ans+val-heightMap[nrow][ncol];
                    }
                    else{
                         pq.add(new ArrayList<>(Arrays.asList(
                          heightMap[nrow][ncol],nrow,ncol
                     )));
                    }
                    
                }
            }

        }
        return ans;
    }
}
