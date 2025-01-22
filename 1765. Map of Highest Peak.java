class Solution {
    class Pair {
        int row, col,val;

        Pair(int row, int col,int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        int[][] vis = new int[n][m];
        int[][] ans = new int[n][m];

        Queue<Pair> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    que.add(new Pair(i, j,0));
                }
            }
        }
        ArrayList<ArrayList<Integer>> dir = new ArrayList<>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(-1, 0)),
                new ArrayList<Integer>(Arrays.asList(0, 1)),
                new ArrayList<Integer>(Arrays.asList(1, 0)),
                new ArrayList<Integer>(Arrays.asList(0, -1))));
        while (que.size() > 0) {
            int x = que.size();
            while (x-- > 0) {
                Pair temp = que.poll();
                int row = temp.row;
                int col = temp.col;
                int val = temp.val;

                if(vis[row][col]==1){
                    continue;
                }

                if(vis[row][col]==0){
                    ans[row][col]=val;
                }
                  vis[row][col]=1;
                for (int i = 0; i < 4; i++) {
                    int nr = row + dir.get(i).get(0);
                    int nc = col + dir.get(i).get(1);

                    if (nr >= 0 && nc >= 0 && nr < n && nc < m && vis[nr][nc] == 0) {
                        que.add(new Pair(nr,nc,val+1));
                    }
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         if (ans[i][j] == -1) {
        //             ans[i][j] = 0;
        //         } else if (ans[i][j] == 0) {
        //             ans[i][j] = 2;
        //         }
        //     }
        // }
        return ans;
    }
}
