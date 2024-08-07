class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
           List<Integer> ans = new ArrayList<>();
         if(root.left==null && root.right==null){
            return ans;
        }
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int x = que.size();
            while (x-- > 0) {
                TreeNode temp = que.poll();
                if (temp.left != null) {
                    mp.putIfAbsent(temp.val,new ArrayList<>());
                    mp.putIfAbsent(temp.left.val,new ArrayList<>());
                    mp.get(temp.val).add(temp.left.val);
                    mp.get(temp.left.val).add(temp.val);
                    que.add(temp.left);
                }
                if (temp.right != null) {
                    mp.putIfAbsent(temp.val, new ArrayList<>());
                    mp.putIfAbsent(temp.right.val, new ArrayList<>());
                    mp.get(temp.val).add(temp.right.val);
                    mp.get(temp.right.val).add(temp.val);
                    que.add(temp.right);
                }
            }
        }
        int[] vis = new int[501];
        Queue<Integer> q = new LinkedList<>();
        q.add(target.val);
     
        int cnt = 0;
        while (!q.isEmpty()) {
            int x = q.size();
            while (x-- > 0) {
                int temp = q.poll();
                if (vis[temp] == 1) {
                    continue;
                }
                if (cnt == k) {
                    ans.add(temp);
                }
                vis[temp] = 1;
                for (int it : mp.get(temp)) {
                    if (vis[it] == 0) {
                        q.add(it);
                    }
                }
            }
            if(cnt==k){
                break;
            }
            cnt++;
        }
        return ans;
    }
}
