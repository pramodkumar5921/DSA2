
class Solution {
    public class NodeIndex{
        TreeNode node;
        long idx;
        NodeIndex(TreeNode node,long idx){
            this.idx=idx;
            this.node=node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<NodeIndex>queue=new LinkedList<>();
        queue.add(new NodeIndex(root,0));
        long ans=0;
        while(queue.size()>0){
            long first=queue.peekFirst().idx;
            long sec=queue.peekLast().idx;
            ans=Math.max(ans,sec-first+1);
            int x=queue.size();
            while(x>0){
                TreeNode temp=queue.peekFirst().node;
                long i        = queue.peekFirst().idx;
                queue.poll();
                if(temp.left!=null){
                    queue.add(new NodeIndex(temp.left,2*i+1));
                }
                if(temp.right!=null){
                    queue.add(new NodeIndex(temp.right,2*i+2));
                }
                x--;
            }
        }
        return (int)ans;
    }
}
