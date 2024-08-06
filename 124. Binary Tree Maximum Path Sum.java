
class Solution {
    public static int maxCost(TreeNode root,int []arr){
         if(root==null){
            return 0;
         }
         int left= maxCost(root.left,arr);
         int right= maxCost(root.right,arr);

         int case1=left+right+root.val;
         int case2=Math.max(left,right)+root.val;
         int case3=root.val;

         arr[0]=Math.max(Math.max(case1,case2),Math.max(case3,arr[0]));

         return Math.max(case2,case3);
    }
    public int maxPathSum(TreeNode root) {
        int[] arr=new int[1];
        arr[0]=Integer.MIN_VALUE;
        maxCost(root,arr);
        return arr[0];
    }
}
