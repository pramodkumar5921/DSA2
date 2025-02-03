class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        HashMap<Integer,Integer>mp = new HashMap<>();
        TreeSet<Integer>pq = new TreeSet<>();
        int i=0,j=0;
        int n=nums.length;
        int[] ans = new int[n-k+1];
        while(i<n){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            pq.add(nums[i]); 
            if(i-j+1==k){
                ans[j]=pq.last();
                mp.put(nums[j],mp.getOrDefault(nums[j],0)-1);
                if(mp.get(nums[j])<=0){
                    pq.remove(nums[j]);
                }
                j+=1;
            }
            i+=1;
        }
        return ans;
    }
}
