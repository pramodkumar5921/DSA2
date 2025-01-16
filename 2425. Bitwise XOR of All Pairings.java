class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
     int ans1 = 0,ans2 = 0;
     for(int i=0;i<nums1.length;i++){
        ans1 = ans1^nums1[i];
     }
     for(int i=0;i<nums2.length;i++){
        ans2 = ans2^nums2[i];
     }

     if(nums1.length%2==0){
        ans2 = 0;
     }

     if(nums2.length%2==0){
        ans1 = 0;
     }

     return ans1^ans2;

    }
}
