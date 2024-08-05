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
    void solve(TreeNode root, List<List<Integer>> arr, int v, int l) {
        if (root == null) {
            return;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(v);
        temp.add(l);
        temp.add(root.val);
        arr.add(temp);

        solve(root.left, arr, v - 1, l + 1);
        solve(root.right, arr, v + 1, l + 1);
    }

    boolean cmp(List<Integer> arr1, List<Integer> arr2) {
        if (!arr1.get(0).equals(arr2.get(0))) {
            return arr1.get(0) < arr2.get(0);
        } else if (!arr1.get(1).equals(arr2.get(1))) {
            return arr1.get(1) < arr2.get(1);
        } else {
            return arr1.get(2) < arr2.get(2);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        solve(root, arr, 0, 0);
        Collections.sort(arr,new Comparator<List<Integer>>(){
            public int compare(List<Integer>arr1,List<Integer>arr2){
                if(!arr1.get(0).equals(arr2.get(0))){
                return arr1.get(0)-arr2.get(0);
            }
            else if(!arr1.get(1).equals(arr2.get(1))){
                return arr1.get(1)-arr2.get(1);
            }
            else{
                return arr1.get(2)-arr2.get(2);
            }
            }
        });
        List<Integer>temp=new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int col=Integer.MIN_VALUE;
        for(int i=0;i<arr.size();i++){
            int ver=arr.get(i).get(0);
            int node=arr.get(i).get(2);
            if(col!=ver){
                if(!temp.isEmpty()){
                    res.add(new ArrayList<>(temp));
                }
                temp.clear();
                temp.add(node);
            }
            else{
                temp.add(node);
            }
            col=ver;
        }
        res.add(temp);
        return res;
    }
}
