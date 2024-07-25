import java.util.*;
class Solution {
    public void Merge(int start,int end,int[] nums){
        int mid=start+(end-start)/2;
        int leftLen=mid+1-start;
        int rightLen=end-mid;
        List<Integer>left=new ArrayList<>();
        List<Integer>right=new ArrayList<>();
        int k=start;
        for(int i=0;i<leftLen;i++){
            left.add(nums[k++]);
        }
        k=mid+1;
        for(int i=0;i<rightLen;i++){
            right.add(nums[k++]);
        }
        int i=0,j=0;
         k=start;
        while(i<left.size() && j<right.size()){
            if(left.get(i)<right.get(j)){
                nums[k]=left.get(i);
                i++;k++;
            }
            else{
                nums[k]=right.get(j);
                j++;k++;
            }
        }
        while(i<left.size()){
            nums[k]=left.get(i);
            i++;k++;
        }
        while(j<right.size()){
            nums[k]=right.get(j);
            j++;k++;
        }
        return;
    }
     public void MergeSort(int start,int end,int[] nums){
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        MergeSort(start,mid,nums);
        MergeSort(mid+1,end,nums);
        Merge(start,end,nums);
        return;
    }
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        MergeSort(0,n-1,nums);
        return nums;
    }
}
