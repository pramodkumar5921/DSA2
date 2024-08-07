class Solution {
    public int countNodes(TreeNode root) {
        int ans=0;
        if(root==null){
            return ans;
        }
        // if(root.left==null && root.right==null){
        //     return root.val;
        // }
        Queue<TreeNode>que=new LinkedList<>();
        que.add(root);
        while(que.size()>0){
            int x=que.size();
            while(x-- >0){
                TreeNode temp=que.poll();
                ans+=1;
                if(temp.left!=null){
                    que.add(temp.left);
                }
                if(temp.right!=null){
                    que.add(temp.right);
                }
            }
        }
        return ans;
    }
}
