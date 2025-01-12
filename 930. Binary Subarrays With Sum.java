class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer>mp = new HashMap<>();
        mp.put(0,1);

        int currSum = 0;

        int ans = 0;

        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];

            int remain = currSum-goal;

            if(mp.containsKey(remain)==true){
                ans=ans+mp.get(remain);
            }

            mp.put(currSum,mp.getOrDefault(currSum,0)+1);
        }

        return ans;
    }
}
