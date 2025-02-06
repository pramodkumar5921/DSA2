class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int temp = nums[i]*nums[j];
                mp.put(temp,mp.getOrDefault(temp,0)+1);
            }
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer>entry:mp.entrySet()){
            int val = entry.getValue();
            int numOfWays = (val*(val-1)) / 2;
            ans=ans+numOfWays*8;
        }
        return ans;

    }
}
