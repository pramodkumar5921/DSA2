class Solution {
    public int findPivotElement(int[]arr){
        int l=0,h=arr.length-1;
        while(l<h){
            // skip the duplicate Element;
            while(l<h && arr[l]==arr[l+1]){
                l+=1;
            }
            while(l<h && arr[h]==arr[h-1]){
                h-=1;
            }
            int mid = l+(h-l)/2;
            if(arr[mid]>arr[h]){
                l=mid+1;
            }
            else{
                h=mid;
            }
        }
        return h;
    }
    public int findTarget(int l,int h,int[] nums,int target){
        int ans = -1;
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
        return ans;
    }
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        int pivotIdx = findPivotElement(nums);

        //System.out.print(pivotIdx);
        int idx1 = findTarget(0,pivotIdx-1,nums,target);
        int idx2 = findTarget(pivotIdx,n-1,nums,target);

        if(idx1==-1 && idx2==-1){
            return false;
        }
        if(idx1!=-1){
            return true;
        }
        if(idx2!=-1){
            return true;
        }
        return false;
    }
}
