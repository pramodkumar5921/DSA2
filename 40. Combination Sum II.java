class Solution {
    public void solve(int i,int[] arr,int target, List<List<Integer>>ans,List<Integer>tempAns){
        if(target<0){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<>(tempAns));
            return;
        }

        for(int j=i;j<arr.length;j++){
            if(j>i && arr[j-1]==arr[j]){
                continue;
            }
            tempAns.add(arr[j]);
            solve(j+1,arr,target-arr[j],ans,tempAns);
            tempAns.remove(tempAns.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>>ans = new ArrayList<>();
        Arrays.sort(arr);
        List<Integer>tempAns = new ArrayList<>();
        solve(0,arr,target,ans,tempAns);
        return ans;
    }
}
