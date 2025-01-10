class Solution {

    int[] dp;

    public int lowerBound(int val,ArrayList<ArrayList<Integer>>tempArray){
        int l=0,h=tempArray.size()-1;

        int ans = h+1;
        while(l<=h){
            int mid  = l+(h-l)/2;

            if(tempArray.get(mid).get(0)>=val){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }

    public int maxProfit(ArrayList<ArrayList<Integer>>tempArray,int idx){
        int n=tempArray.size();
        if(idx>=n){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }

        int nextIdx = lowerBound(tempArray.get(idx).get(1),tempArray);
        int include = tempArray.get(idx).get(2)+ maxProfit(tempArray,nextIdx);

        int exclude = maxProfit(tempArray,idx+1);

        return dp[idx] =  Math.max(include,exclude);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int  n = startTime.length;

        dp = new int[n+1];

        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
        ArrayList<ArrayList<Integer>>tempArray = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<startTime.length;i++){
            int start = startTime[i];
            int end   = endTime[i];
            int profit1  = profit[i];

            ArrayList<Integer>tempArr = new ArrayList<Integer>();
            tempArr.add(start);
            tempArr.add(end);
            tempArr.add(profit1);

            tempArray.add(new ArrayList<Integer>(tempArr));
        }

        Collections.sort(tempArray,(ArrayList<Integer>arr1,ArrayList<Integer>arr2)->{
            return Integer.compare(arr1.get(0),arr2.get(0));
        });

      //  System.out.print(tempArray + " ");

        int ans = maxProfit(tempArray,0);

        return ans;
    }
}
