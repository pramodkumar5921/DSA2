class Solution {
    public int countNum(int[] arr,int mid,int k){
        return arr[mid]-1-mid;
    }    
    public int findKthPositive(int[] arr, int k) {
        int l=0,h=arr.length-1;
        int ans = h+1;
        int n = arr.length;
        int count = 0;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(countNum(arr,mid,k)>=k){
                ans=mid;
                h=mid-1;
            }
            else{
                count=countNum(arr,mid,k);
                l=mid+1;
            }
        }
        if(ans==arr.length){
            return arr[n-1]+k-count;
        }
        int cnt = countNum(arr,ans,k);
        // if(cnt<k){
        //     return k+arr[ans];
        // }
        return arr[ans]-1+k-cnt;
    }
}
