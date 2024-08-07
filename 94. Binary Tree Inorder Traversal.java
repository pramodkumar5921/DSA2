/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>arr=new ArrayList<>();
        TreeNode curr=root;

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
                leftchild.right=curr;
                TreeNode alpha=curr;
                curr=curr.left;
                alpha.left=null;
            }
        }
        return arr;
    }
}
