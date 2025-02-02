class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
       ArrayList<Integer>arr1 = new ArrayList<>();
       ArrayList<Integer>arr2 = new ArrayList<>();
       int n = endTime.length;
       arr1.add(startTime[0]-0);
       for(int i=1;i<startTime.length;i++){
         arr1.add(startTime[i]-endTime[i-1]);
       }
       arr1.add(eventTime-endTime[n-1]);

       for(int i=0;i<n;i++){
        arr2.add(endTime[i]-startTime[i]);
       }

       System.out.println(arr1);
       System.out.println(arr2);

       int m = arr1.size();

       int []prefix = new int[m];
       int []suffix = new int[m];

       for(int i=2;i<arr1.size();i++){
         prefix[i]=Math.max(prefix[i-1],arr1.get(i-2));
       }
       for(int i=arr1.size()-2;i>=0;i--){
         suffix[i]=Math.max(suffix[i+1],arr1.get(i+1));
       }
       int ans = 0;

       for(int i=1;i<arr1.size();i++){
         int meetTime = arr2.get(i-1);

         if(meetTime<=Math.max(prefix[i],suffix[i])){
            ans=Math.max(ans,meetTime+arr1.get(i-1)+arr1.get(i));
         }
         ans=Math.max(ans,arr1.get(i-1)+arr1.get(i)); 
       }
       return ans;
    }
}
