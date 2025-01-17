class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        int len = nums.length;
        for(int num=0;num<(1<<len);num++){ 
            List<Integer>tempAns = new ArrayList<>();
            for(int k=0;k<len;k++){
                int kthBit = (num>>k)&1;
                if(kthBit==1){
                    tempAns.add(nums[k]);
                }
            }
            ans.add(new ArrayList<>(tempAns));
        }
        return ans;
    }
}
