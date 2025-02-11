class Solution {
    public int peakIndex(int[] nums){
       int l=0,h=nums.length-1;
       while(l<h){
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
    public int findTarget(int[] nums,int l,int h,int target){
        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
       int n=nums.length;
       int peakIdx = peakIndex(nums);
       System.out.print(peakIdx);
       int idx1 = findTarget(nums,0,peakIdx-1,target);
       int idx2 = findTarget(nums,peakIdx,n-1,target);

       if(idx1==-1 && idx2==-1){
         return -1;
       }
       if(idx1>=0){
        return idx1;
       }
       return idx2;

    }
}
