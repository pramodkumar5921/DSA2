class Solution {
    public int findPivot(int[] nums){
        int l=0,h=nums.length-1;
        while(l<h){
            while(l<h && nums[l]==nums[l+1]){
                l+=1;
            }
            while(l<h && nums[h]==nums[h-1]){
                h-=1;
            }
            int mid = l+(h-l)/2;
            if(nums[mid]>nums[h]){
                l=mid+1;
            }
            else{
                h=mid;
            }
        }
        return h;
    }
    public int findMin(int[] nums) {
        int pivotIdx = findPivot(nums);
        return nums[pivotIdx];
    }
}
