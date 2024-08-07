class Solution {
    public TreeNode solve(int[] preorder, int[] inorder,int start,int end,int[] index){
        if(start>end){
            return null;
        }
        int rootval=preorder[index[0]];
        TreeNode root=new TreeNode(rootval);
        index[0]+=1;
        int i=start;
        for(;i<=end;i++){
            if(inorder[i]==rootval){
                break;
            }
        }
        root.left=solve(preorder,inorder,start,i-1,index);
        root.right=solve(preorder,inorder,i+1,end,index);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] index= new int[1];
        index[0]=0;
        return solve(preorder,inorder,0,inorder.length-1,index);
    }
}
