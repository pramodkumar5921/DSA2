class Solution {
    class TrieNode{
        TrieNode left,right;

        TrieNode(){
            left=null;
            right=null;
        }
    }

    public TrieNode getNode(){
        return new TrieNode();
    }

    public void insert(TrieNode root,int num){
        TrieNode crawl = root;

        for(int i=31;i>=0;i--){
            int ith = (num>>i &1);

            if(ith==1){
                if(crawl.right==null){
                    crawl.right = getNode();
                    crawl=crawl.right;
                }
                else{
                    crawl=crawl.right;
                }
            }
            else{
                if(crawl.left==null){
                    crawl.left=getNode();
                    crawl=crawl.left;
                }
                else{
                    crawl=crawl.left;
                }
            }
        }
    }

    public int maxVal(TrieNode root,int num){
        TrieNode crawl = root;

        // int cnt=1;

        int ans=0;

        for(int i=31;i>=0;i--){
            int ith = (num>>i &1);

            if(ith==1){
                if(crawl.left!=null){
                    crawl=crawl.left;
                    ans=ans+ (int)Math.pow(2,i);
                }
                else{
                    crawl=crawl.right;
                }
            }
            else{
                if(crawl.right!=null){
                    crawl=crawl.right;
                    ans=ans+(int)Math.pow(2,i);
                }
                else{
                    crawl=crawl.left;
                }
            }
            // cnt = cnt*2;
        }
        return ans;
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();

        for(int i=0;i<nums.length;i++){
            insert(root,nums[i]);
        }

        int ans=0;

        for(int i=0;i<nums.length;i++){
            int tempAns = maxVal(root,nums[i]);
            ans=Math.max(tempAns,ans); 
        }

        return ans;
    }
}
