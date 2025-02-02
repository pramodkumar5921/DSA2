class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
       ArrayList<Integer>arr1 = new ArrayList<>();
       int n = endTime.length;
       arr1.add(startTime[0]-0);
       for(int i=1;i<startTime.length;i++){
         arr1.add(startTime[i]-endTime[i-1]);
       }
       arr1.add(eventTime-endTime[n-1]);

      int i=0,j=0;
      int sum=0;
      int ans = 0;
      while(i<arr1.size()){
        sum+=arr1.get(i);
        if(i-j+1==k+1){
            ans=Math.max(ans,sum);
            sum-=arr1.get(j);
            j+=1;
        }
        i+=1;
      }

       return ans;
    }
}
