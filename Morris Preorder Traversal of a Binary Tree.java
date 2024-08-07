class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curr=root;
        List<Integer>arr=new ArrayList<>();
        while(curr!=null){
            if(curr.left==null){
                arr.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode leftchild=curr.left;
                while(leftchild.right!=null){
                    leftchild=leftchild.right;
                }
                leftchild.right=curr.right;
                arr.add(curr.val);
                TreeNode temp=curr;
                curr=curr.left;
                temp.left=null;
            }
        }
        return arr;
    }
}
