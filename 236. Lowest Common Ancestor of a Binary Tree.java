/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void path(TreeNode root,TreeNode p,ArrayList<Integer>arr1,ArrayList<ArrayList<Integer>>arr){
        if(root==null){
            return;
        }
        arr1.add(root.val);
        if(root.val == p.val){
            arr.add( new ArrayList<>(arr1));
            return;
        }
            path(root.left,p,arr1,arr);
            path(root.right,p,arr1,arr);
        arr1.remove(arr1.size()-1);
        return;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       ArrayList<Integer>arr1=new ArrayList<>();
       ArrayList<Integer>arr2=new ArrayList<>();
       ArrayList<ArrayList<Integer>>arr=new ArrayList<>();
       TreeNode ans=new TreeNode(-1);
       path(root,p,arr1,arr);
       path(root,q,arr2,arr);
       HashMap<Integer,Integer>mp=new HashMap<>();
       for(int i=0;i<arr.get(0).size();i++){
          mp.put(arr.get(0).get(i),1);
       }
       for(int i=0;i<arr.get(1).size();i++){
         int temp=arr.get(1).get(i);
         if(mp.containsKey(temp)==true){
            ans.val=temp;
         }
       }
       return ans;
    }
}
