/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static void InorderTraversal(TreeNode root,List<Integer>Inorder){
        if(root==null){
            return;
        }
        InorderTraversal(root.left,Inorder);
        Inorder.add(root.data);
        InorderTraversal(root.right,Inorder);
        return;
    }
    public static void PreorderTraversal(TreeNode root,List<Integer>Preorder){
        if(root==null){
            return;
        }
        Preorder.add(root.data);
        PreorderTraversal(root.left,Preorder);
        PreorderTraversal(root.right,Preorder);
        return;
    }
    public static void PostorderTraversal(TreeNode root,List<Integer>Postorder){
        if(root==null){
            return;
        }
        PostorderTraversal(root.left,Postorder);
        PostorderTraversal(root.right,Postorder);
        Postorder.add(root.data);
        return;
        
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>>arr=new ArrayList<>();
        List<Integer>Inorder=new ArrayList<>();
        List<Integer>Preorder=new ArrayList<>();
        List<Integer>Postorder=new ArrayList<>();
        InorderTraversal(root,Inorder);
        PreorderTraversal(root,Preorder);
        PostorderTraversal(root,Postorder);

        arr.add(Inorder);
        arr.add(Preorder);
        arr.add(Postorder);

        return arr;
    }
}
