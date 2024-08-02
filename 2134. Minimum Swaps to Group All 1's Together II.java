import java.util.*;
class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int total=0;
        int[] arr= new int[2*n];
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
            if(arr[i]==1){
                total++;
            }
        }
        int k=0;
        for(int i=n;i<2*n;i++){
            arr[i]=nums[k];
            k++;
        }
         int i=0,j=0;
         HashMap<Integer,Integer>mp=new HashMap<>();
         int ans=100000000;
         int count=0;
        while(i<arr.length){
            if(mp.containsKey(arr[i])==true){
                int cnt=mp.get(arr[i]);
                mp.put(arr[i],cnt+1);
            }
            else{
                mp.put(arr[i],1);
            }
            count++;
            while(count==total && j<i){
                if(mp.containsKey(0)==false){
                    return 0;
                }
                ans=Math.min(ans,mp.get(0));
                int cnt=mp.get(arr[j]);
                mp.put(arr[j],cnt-1);
                if(mp.get(arr[j])==0){
                    mp.remove(arr[j]);
                }
                count--;
                j++;
            }
            i++;
        }
        if(ans==100000000){
            return 0;
        }
        return ans;
    }
}
