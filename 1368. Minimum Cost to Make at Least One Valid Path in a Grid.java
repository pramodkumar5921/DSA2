class Solution {
    public int minCostPath(int[][] grid, ArrayList<ArrayList<Integer>> dir) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(
                (ArrayList<Integer> arr1, ArrayList<Integer> arr2) -> {
                    return Integer.compare(arr1.get(0), arr2.get(0));
                });

        ArrayList<Integer> temp1 = new ArrayList<>();
        temp1.add(0);
        temp1.add(0);
        temp1.add(0);

        pq.add(new ArrayList<>(temp1));

        int[][] result = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                result[i][j]=1000000;
            }
        }
        result[0][0]=0;
        while (pq.size() > 0) {
            ArrayList<Integer> temp = pq.poll();
            int currCost = temp.get(0);
            int row = temp.get(1);
            int col = temp.get(2);

            for (int i = 0; i <= 3; i++) {
                int nrow = dir.get(i).get(0) + row;
                int ncol = dir.get(i).get(1) + col;

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    int dirCost = (grid[row][col] - 1 == i) ? 0 : 1;
                    int newCost = dirCost + currCost;
                    if (result[nrow][ncol] > newCost) {
                        result[nrow][ncol]=newCost;
                        ArrayList<Integer> temp2 = new ArrayList<>();
                        temp2.add(newCost);
                        temp2.add(nrow);
                        temp2.add(ncol);

                        pq.add(new ArrayList<>(temp2));
                    }
                }
            }
        }

        return result[n - 1][m - 1];

    }

    public int minCost(int[][] grid) {
        ArrayList<ArrayList<Integer>> dir = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0) {
                temp.add(0);
                temp.add(1);
            }
            if (i == 1) {
                temp.add(0);
                temp.add(-1);
            }
            if (i == 2) {
                temp.add(1);
                temp.add(0);
            }
            if (i == 3) {
                temp.add(-1);
                temp.add(0);
            }
            dir.add(new ArrayList<>(temp));
        }
        int ans = minCostPath(grid, dir);
        return ans;
    }
}
